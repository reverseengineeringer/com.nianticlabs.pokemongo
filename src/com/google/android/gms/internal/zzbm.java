package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class zzbm
{
  private final int zzsp;
  private final int zzsq;
  private final int zzsr;
  private final zzbl zzss = new zzbo();
  
  public zzbm(int paramInt)
  {
    zzsq = paramInt;
    zzsp = 6;
    zzsr = 0;
  }
  
  private String zzA(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    if (arrayOfString.length == 0) {
      return "";
    }
    paramString = zzcz();
    Arrays.sort(arrayOfString, new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    });
    int i = 0;
    if ((i < arrayOfString.length) && (i < zzsq))
    {
      if (arrayOfString[i].trim().length() == 0) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramString.write(zzss.zzz(arrayOfString[i]));
        }
        catch (IOException localIOException)
        {
          zzb.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  String zzB(String paramString)
  {
    Object localObject1 = paramString.split("\n");
    if (localObject1.length == 0) {
      return "";
    }
    paramString = zzcz();
    Object localObject2 = new PriorityQueue(zzsq, new Comparator()
    {
      public int zza(zzbp.zza paramAnonymouszza1, zzbp.zza paramAnonymouszza2)
      {
        return (int)(value - value);
      }
    });
    int i = 0;
    if (i < localObject1.length)
    {
      String[] arrayOfString = zzbn.zzD(localObject1[i]);
      if (arrayOfString.length < zzsp) {}
      for (;;)
      {
        i += 1;
        break;
        zzbp.zza(arrayOfString, zzsq, zzsp, (PriorityQueue)localObject2);
      }
    }
    localObject1 = ((PriorityQueue)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzbp.zza)((Iterator)localObject1).next();
        try
        {
          paramString.write(zzss.zzz(zzsx));
        }
        catch (IOException localIOException)
        {
          zzb.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  public String zza(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuffer.append(((String)paramArrayList.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    switch (zzsr)
    {
    default: 
      return "";
    case 0: 
      return zzB(localStringBuffer.toString());
    }
    return zzA(localStringBuffer.toString());
  }
  
  zza zzcz()
  {
    return new zza();
  }
  
  static class zza
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */