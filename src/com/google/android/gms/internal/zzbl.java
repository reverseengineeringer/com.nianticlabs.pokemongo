package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbl
{
  private static MessageDigest zzso = null;
  protected Object zzpd = new Object();
  
  protected MessageDigest zzcy()
  {
    for (;;)
    {
      MessageDigest localMessageDigest;
      int i;
      synchronized (zzpd)
      {
        if (zzso != null)
        {
          localMessageDigest = zzso;
          return localMessageDigest;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        zzso = MessageDigest.getInstance("MD5");
        i += 1;
        continue;
        localMessageDigest = zzso;
        return localMessageDigest;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
  
  abstract byte[] zzz(String paramString);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */