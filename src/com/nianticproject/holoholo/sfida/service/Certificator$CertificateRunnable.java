package com.nianticproject.holoholo.sfida.service;

import android.os.Handler;
import android.util.Log;
import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.CertificationState;
import java.util.UUID;

class Certificator$CertificateRunnable
  implements Runnable
{
  Handler delayHandler;
  SfidaConstants.CertificationState executeCertificationState;
  
  public Certificator$CertificateRunnable(Certificator paramCertificator, Handler paramHandler, SfidaConstants.CertificationState paramCertificationState)
  {
    delayHandler = paramHandler;
    executeCertificationState = paramCertificationState;
  }
  
  private void onReceivedCertificationComplete()
  {
    Log.d(this$0.TAG, "Certification Complete!");
    this$0.sfidaService.onCertificationComplete();
  }
  
  private void onReceivedDummyCertificationChallenge1()
  {
    Log.d(this$0.TAG, "Dummy Certification Challenge 1");
    if (this$0.sfidaService.getIsReceivedNotifyCallback())
    {
      this$0.sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug());
      return;
    }
    retry();
  }
  
  private void onReceivedDummyCertificationChallenge2()
  {
    Log.d(this$0.TAG, "Dummy Certification Challenge 2");
    if (this$0.sfidaService.getIsReceivedWriteCallback())
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
            this$0.sfidaService.onCertificationComplete();
          }
        }, 500L);
        return;
      }
      this$0.sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug2());
      return;
    }
    retry();
  }
  
  private void onReceivedDummyCertificationChallenge3()
  {
    Log.d(this$0.TAG, "Dummy Certification Challenge 3");
    if (this$0.sfidaService.getIsReceivedWriteCallback())
    {
      switch (Certificator.1.$SwitchMap$com$nianticproject$holoholo$sfida$constants$SfidaConstants$SfidaVersion[com.nianticproject.holoholo.sfida.constants.SfidaConstants.SFIDA_VERSION.ordinal()])
      {
      case 1: 
      case 2: 
      default: 
        return;
      case 3: 
        this$0.sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug3());
        delayHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            this$0.sfidaService.onCertificationComplete();
          }
        }, 500L);
        return;
      }
      this$0.sfidaService.sendCertificateMessage(SfidaMessage.getSecurityResponseForDebug3());
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
      this$0.sfidaService.enableDeviceControlServiceNotify();
      return;
    } while (this$0.sfidaService.enableSecurityServiceNotify(new SfidaWatchDog.OnTimeoutListener()
    {
      public void onTimeout(UUID paramAnonymousUUID)
      {
        if (this$0.getCertificationState() == SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY)
        {
          Certificator.access$000(this$0, SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY);
          return;
        }
        Log.d(this$0.TAG, "Ignoring timeout event.");
      }
      
      public void reachedRetryCountMax()
      {
        Log.d(this$0.TAG, "reachedRetryCountMax()");
        this$0.sfidaService.disconnectBluetooth();
      }
    }));
    this$0.sfidaService.disconnectBluetooth();
  }
  
  private void retry()
  {
    if (delayHandler != null)
    {
      Log.d(this$0.TAG, "Callback was not received. Retry after.");
      delayHandler.postDelayed(this, 1000L);
    }
  }
  
  public void run()
  {
    this$0.setCertificationState(executeCertificationState);
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

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.Certificator.CertificateRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */