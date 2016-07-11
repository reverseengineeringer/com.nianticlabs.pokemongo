package com.nianticproject.holoholo.sfida.service;

import android.os.Handler;
import android.util.Log;
import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.CertificationState;
import java.util.UUID;

public class Certificator
{
  private static final int DELAY_TIME = 1000;
  public final String TAG = Certificator.class.getSimpleName();
  private volatile SfidaConstants.CertificationState certificationState = SfidaConstants.CertificationState.NO_CERTIFICATION;
  Handler delayHandler = new Handler();
  public SfidaService sfidaService;
  
  public Certificator(SfidaService paramSfidaService)
  {
    sfidaService = paramSfidaService;
  }
  
  private void executeCertificateSequence(SfidaConstants.CertificationState paramCertificationState)
  {
    if (delayHandler != null) {
      delayHandler.postDelayed(new CertificateRunnable(delayHandler, paramCertificationState), 1000L);
    }
  }
  
  public SfidaConstants.CertificationState getCertificationState()
  {
    return certificationState;
  }
  
  public void onSfidaUpdated(String paramString)
  {
    if ("3000".equals(paramString))
    {
      executeCertificateSequence(SfidaConstants.CertificationState.DUMMY_CERTIFICATION_CHALLENGE_1);
      return;
    }
    if ("4010".equals(paramString))
    {
      executeCertificateSequence(SfidaConstants.CertificationState.DUMMY_CERTIFICATION_CHALLENGE_2);
      return;
    }
    if ("5000".equals(paramString))
    {
      executeCertificateSequence(SfidaConstants.CertificationState.DUMMY_CERTIFICATION_CHALLENGE_3);
      return;
    }
    if ("4020".equals(paramString))
    {
      executeCertificateSequence(SfidaConstants.CertificationState.CERTIFICATION_COMPLETE);
      return;
    }
    if (paramString == null)
    {
      Log.d(TAG, "onSfidaUpdated() rawString was null.");
      return;
    }
    Log.d(TAG, "onSfidaUpdated() Unhandled raw data : " + paramString);
  }
  
  public void setCertificationState(SfidaConstants.CertificationState paramCertificationState)
  {
    Log.d(TAG, "CertificationState [" + certificationState + "] → [" + paramCertificationState + "]");
    certificationState = paramCertificationState;
  }
  
  public void startCertification()
  {
    if (delayHandler != null) {
      delayHandler.postDelayed(new CertificateRunnable(delayHandler, SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY), 1000L);
    }
  }
  
  private class CertificateRunnable
    implements Runnable
  {
    Handler delayHandler;
    SfidaConstants.CertificationState executeCertificationState;
    
    public CertificateRunnable(Handler paramHandler, SfidaConstants.CertificationState paramCertificationState)
    {
      delayHandler = paramHandler;
      executeCertificationState = paramCertificationState;
    }
    
    private void onReceivedCertificationComplete()
    {
      Log.d(TAG, "Certification Complete!");
      sfidaService.onCertificationComplete();
    }
    
    private void onReceivedDummyCertificationChallenge1()
    {
      Log.d(TAG, "Dummy Certification Challenge 1");
      if (sfidaService.getIsReceivedNotifyCallback())
      {
        sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug());
        return;
      }
      retry();
    }
    
    private void onReceivedDummyCertificationChallenge2()
    {
      Log.d(TAG, "Dummy Certification Challenge 2");
      if (sfidaService.getIsReceivedWriteCallback())
      {
        switch (Certificator.1.$SwitchMap$com$nianticproject$holoholo$sfida$constants$SfidaConstants$SfidaVersion[com.nianticproject.holoholo.sfida.constants.SfidaConstants.SFIDA_VERSION.ordinal()])
        {
        case 1: 
        default: 
          return;
        case 2: 
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              sfidaService.onCertificationComplete();
            }
          }, 500L);
          return;
        }
        sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug2());
        return;
      }
      retry();
    }
    
    private void onReceivedDummyCertificationChallenge3()
    {
      Log.d(TAG, "Dummy Certification Challenge 3");
      if (sfidaService.getIsReceivedWriteCallback())
      {
        switch (Certificator.1.$SwitchMap$com$nianticproject$holoholo$sfida$constants$SfidaConstants$SfidaVersion[com.nianticproject.holoholo.sfida.constants.SfidaConstants.SFIDA_VERSION.ordinal()])
        {
        case 1: 
        case 2: 
        default: 
          return;
        case 3: 
          sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug3());
          delayHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              sfidaService.onCertificationComplete();
            }
          }, 500L);
          return;
        }
        sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug3());
        return;
      }
      retry();
    }
    
    private void onReceivedSecurityServiceNotify()
    {
      switch (Certificator.1.$SwitchMap$com$nianticproject$holoholo$sfida$constants$SfidaConstants$SfidaVersion[com.nianticproject.holoholo.sfida.constants.SfidaConstants.SFIDA_VERSION.ordinal()])
      {
      }
      do
      {
        return;
        sfidaService.enableDeviceControlServiceNotify();
        return;
      } while (sfidaService.enableSecurityServiceNotify(new SfidaWatchDog.OnTimeoutListener()
      {
        public void onTimeout(UUID paramAnonymousUUID)
        {
          if (getCertificationState() == SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY)
          {
            Certificator.this.executeCertificateSequence(SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY);
            return;
          }
          Log.d(TAG, "Ignoring timeout event.");
        }
        
        public void reachedRetryCountMax()
        {
          Log.d(TAG, "reachedRetryCountMax()");
          sfidaService.disconnectBluetooth();
        }
      }));
      sfidaService.disconnectBluetooth();
    }
    
    private void retry()
    {
      if (delayHandler != null)
      {
        Log.d(TAG, "Callback was not received. Retry after.");
        delayHandler.postDelayed(this, 1000L);
      }
    }
    
    public void run()
    {
      setCertificationState(executeCertificationState);
      switch (Certificator.1.$SwitchMap$com$nianticproject$holoholo$sfida$constants$SfidaConstants$CertificationState[executeCertificationState.ordinal()])
      {
      default: 
        return;
      case 1: 
        onReceivedSecurityServiceNotify();
        return;
      case 2: 
        onReceivedDummyCertificationChallenge1();
        return;
      case 3: 
        onReceivedDummyCertificationChallenge2();
        return;
      case 4: 
        onReceivedDummyCertificationChallenge3();
        return;
      }
      onReceivedCertificationComplete();
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.Certificator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */