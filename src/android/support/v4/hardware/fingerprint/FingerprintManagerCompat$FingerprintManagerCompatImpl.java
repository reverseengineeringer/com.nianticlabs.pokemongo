package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Handler;
import android.support.v4.os.CancellationSignal;

abstract interface FingerprintManagerCompat$FingerprintManagerCompatImpl
{
  public abstract void authenticate(Context paramContext, FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler);
  
  public abstract boolean hasEnrolledFingerprints(Context paramContext);
  
  public abstract boolean isHardwareDetected(Context paramContext);
}

/* Location:
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */