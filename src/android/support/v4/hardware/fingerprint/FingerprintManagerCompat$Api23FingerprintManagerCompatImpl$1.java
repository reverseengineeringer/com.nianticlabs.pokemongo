package android.support.v4.hardware.fingerprint;

final class FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1
  extends FingerprintManagerCompatApi23.AuthenticationCallback
{
  FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1(FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback) {}
  
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
  
  public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal paramAuthenticationResultInternal)
  {
    val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.access$000(paramAuthenticationResultInternal.getCryptoObject())));
  }
}

/* Location:
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */