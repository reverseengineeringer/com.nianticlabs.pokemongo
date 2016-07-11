package com.nianticproject.holoholo.sfida.service;

import android.util.Log;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.CertificationState;
import java.util.UUID;

class Certificator$CertificateRunnable$1
  implements SfidaWatchDog.OnTimeoutListener
{
  Certificator$CertificateRunnable$1(Certificator.CertificateRunnable paramCertificateRunnable) {}
  
  public void onTimeout(UUID paramUUID)
  {
    if (this$1.this$0.getCertificationState() == SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY)
    {
      Certificator.access$000(this$1.this$0, SfidaConstants.CertificationState.ENABLE_SECURITY_SERVICE_NOTIFY);
      return;
    }
    Log.d(this$1.this$0.TAG, "Ignoring timeout event.");
  }
  
  public void reachedRetryCountMax()
  {
    Log.d(this$1.this$0.TAG, "reachedRetryCountMax()");
    this$1.this$0.sfidaService.disconnectBluetooth();
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.Certificator.CertificateRunnable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */