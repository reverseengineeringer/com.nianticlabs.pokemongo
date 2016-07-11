package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class zzbm$zza
{
  ByteArrayOutputStream zzsu = new ByteArrayOutputStream(4096);
  Base64OutputStream zzsv = new Base64OutputStream(zzsu, 10);
  
  public String toString()
  {
    try
    {
      zzsv.close();
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          zzsu.close();
          String str = zzsu.toString();
          return str;
        }
        catch (IOException localIOException2)
        {
          zzb.zzb("HashManager: Unable to convert to Base64.", localIOException2);
          return "";
        }
        finally
        {
          zzsu = null;
          zzsv = null;
        }
        localIOException1 = localIOException1;
        zzb.zzb("HashManager: Unable to convert to Base64.", localIOException1);
      }
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    zzsv.write(paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbm.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */