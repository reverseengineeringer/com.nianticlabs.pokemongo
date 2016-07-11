package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgr;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@zzgr
public class zzl
{
  public static boolean zza(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      if (!localSignature.verify(Base64.decode(paramString2, 0)))
      {
        zzb.e("Signature verification failed.");
        return false;
      }
      return true;
    }
    catch (NoSuchAlgorithmException paramPublicKey)
    {
      zzb.e("NoSuchAlgorithmException.");
      return false;
    }
    catch (InvalidKeyException paramPublicKey)
    {
      zzb.e("Invalid key specification.");
      return false;
    }
    catch (SignatureException paramPublicKey)
    {
      zzb.e("Signature exception.");
    }
    return false;
  }
  
  public static PublicKey zzaq(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (InvalidKeySpecException paramString)
    {
      zzb.e("Invalid key specification.");
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static boolean zzc(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      zzb.e("Purchase verification failed: missing data.");
      return false;
    }
    return zza(zzaq(paramString1), paramString2, paramString3);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */