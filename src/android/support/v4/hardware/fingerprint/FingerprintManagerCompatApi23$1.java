package android.support.v4.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;

final class FingerprintManagerCompatApi23$1
  extends FingerprintManager.AuthenticationCallback
{
  FingerprintManagerCompatApi23$1(FingerprintManagerCompatApi23.AuthenticationCallback paramAuthenticationCallback) {}
  
  public void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    val$callback.onAuthenticationError(paramInt, paramCharSequence);
  }
  
  public void onAuthenticationFailed()
  {
    val$callback.onAuthenticationFailed();
  }
  
  public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
  }
  
  public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
  {
    val$callback.onAuthenticationSucceeded(new FingerprintManagerCompatApi23.AuthenticationResultInternal(FingerprintManagerCompatApi23.access$000(paramAuthenticationResult.getCryptoObject())));
  }
}

/* Location:
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */