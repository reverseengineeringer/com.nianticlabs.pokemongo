package com.upsight.android.analytics.internal.dispatcher.delivery;

import android.text.TextUtils;
import android.util.Base64;
import com.upsight.android.UpsightContext;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

class BouncySignatureVerifier
  implements SignatureVerifier
{
  private static final String CHARSET_NAME = "UTF-8";
  private static final String CRYPTO_ALGORITHM_KEY = "RSA";
  private static final String CRYPTO_ALGORITHM_SIGNATURE = "SHA512WITHRSA";
  private static final String CRYPTO_PROVIDER = "BC";
  private UpsightLogger mLogger;
  private Signature mSigner;
  
  BouncySignatureVerifier(UpsightContext paramUpsightContext)
  {
    mLogger = paramUpsightContext.getLogger();
    paramUpsightContext = paramUpsightContext.getPublicKey();
    try
    {
      if (!TextUtils.isEmpty(paramUpsightContext))
      {
        paramUpsightContext = Base64.decode(paramUpsightContext.getBytes("UTF-8"), 0);
        paramUpsightContext = KeyFactory.getInstance("RSA", "BC").generatePublic(new X509EncodedKeySpec(paramUpsightContext));
        Signature localSignature = Signature.getInstance("SHA512WITHRSA", "BC");
        localSignature.initVerify(paramUpsightContext);
        mSigner = localSignature;
        mLogger.d("Upsight", "Public key: " + paramUpsightContext, new Object[0]);
        return;
      }
      mLogger.e("Upsight", "Please check your public key.", new Object[0]);
      return;
    }
    catch (IOException paramUpsightContext)
    {
      mLogger.e("Upsight", paramUpsightContext, "Failed to initialize " + BouncySignatureVerifier.class.getSimpleName(), new Object[0]);
      return;
    }
    catch (NoSuchAlgorithmException paramUpsightContext)
    {
      for (;;) {}
    }
    catch (NoSuchProviderException paramUpsightContext)
    {
      for (;;) {}
    }
    catch (InvalidKeyException paramUpsightContext)
    {
      for (;;) {}
    }
    catch (InvalidKeySpecException paramUpsightContext)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public boolean verify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: getfield 94	com/upsight/android/analytics/internal/dispatcher/delivery/BouncySignatureVerifier:mSigner	Ljava/security/Signature;
    //   9: astore 5
    //   11: iload 4
    //   13: istore_3
    //   14: aload 5
    //   16: ifnull +20 -> 36
    //   19: aload_0
    //   20: getfield 94	com/upsight/android/analytics/internal/dispatcher/delivery/BouncySignatureVerifier:mSigner	Ljava/security/Signature;
    //   23: aload_1
    //   24: invokevirtual 140	java/security/Signature:update	([B)V
    //   27: aload_0
    //   28: getfield 94	com/upsight/android/analytics/internal/dispatcher/delivery/BouncySignatureVerifier:mSigner	Ljava/security/Signature;
    //   31: aload_2
    //   32: invokevirtual 143	java/security/Signature:verify	([B)Z
    //   35: istore_3
    //   36: iload_3
    //   37: ifne +20 -> 57
    //   40: aload_0
    //   41: getfield 46	com/upsight/android/analytics/internal/dispatcher/delivery/BouncySignatureVerifier:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   44: ldc 96
    //   46: ldc -111
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokeinterface 122 4 0
    //   57: aload_0
    //   58: monitorexit
    //   59: iload_3
    //   60: ireturn
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 46	com/upsight/android/analytics/internal/dispatcher/delivery/BouncySignatureVerifier:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   66: ldc 96
    //   68: aload_1
    //   69: new 98	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   76: ldc -109
    //   78: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 2
    //   83: invokevirtual 129	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokeinterface 132 5 0
    //   101: iload 4
    //   103: istore_3
    //   104: goto -68 -> 36
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	BouncySignatureVerifier
    //   0	112	1	paramArrayOfByte1	byte[]
    //   0	112	2	paramArrayOfByte2	byte[]
    //   13	91	3	bool1	boolean
    //   3	99	4	bool2	boolean
    //   9	6	5	localSignature	Signature
    // Exception table:
    //   from	to	target	type
    //   19	36	61	java/security/SignatureException
    //   5	11	107	finally
    //   19	36	107	finally
    //   40	57	107	finally
    //   62	101	107	finally
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.BouncySignatureVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */