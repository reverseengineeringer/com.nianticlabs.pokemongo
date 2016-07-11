package android.support.v4.hardware.fingerprint;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class FingerprintManagerCompat$CryptoObject
{
  private final Cipher mCipher;
  private final Mac mMac;
  private final Signature mSignature;
  
  public FingerprintManagerCompat$CryptoObject(Signature paramSignature)
  {
    mSignature = paramSignature;
    mCipher = null;
    mMac = null;
  }
  
  public FingerprintManagerCompat$CryptoObject(Cipher paramCipher)
  {
    mCipher = paramCipher;
    mSignature = null;
    mMac = null;
  }
  
  public FingerprintManagerCompat$CryptoObject(Mac paramMac)
  {
    mMac = paramMac;
    mCipher = null;
    mSignature = null;
  }
  
  public Cipher getCipher()
  {
    return mCipher;
  }
  
  public Mac getMac()
  {
    return mMac;
  }
  
  public Signature getSignature()
  {
    return mSignature;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */