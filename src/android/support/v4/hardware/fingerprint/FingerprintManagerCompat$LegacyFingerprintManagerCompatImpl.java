package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Handler;
import android.support.v4.os.CancellationSignal;

class FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl
  implements FingerprintManagerCompat.FingerprintManagerCompatImpl
{
  public void authenticate(Context paramContext, FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler) {}
  
  public boolean hasEnrolledFingerprints(Context paramContext)
  {
    return false;
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompat.LegacyFingerprintManagerCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */