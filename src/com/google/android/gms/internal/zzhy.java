package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.math.BigInteger;
import java.util.Locale;

@zzgr
public final class zzhy
{
  private static String zzIk;
  private static final Object zzpy = new Object();
  
  public static String zza(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (zzpy)
    {
      if ((zzIk == null) && (!TextUtils.isEmpty(paramString1))) {
        zzb(paramContext, paramString1, paramString2);
      }
      paramContext = zzIk;
      return paramContext;
    }
  }
  
  private static void zzb(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramContext.createPackageContext(paramString2, 3).getClassLoader();
      Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, paramString2);
      paramContext = new BigInteger(new byte[1]);
      String[] arrayOfString = paramString1.split(",");
      int i = 0;
      while (i < arrayOfString.length)
      {
        paramString1 = paramContext;
        if (zzp.zzbv().zza(paramString2, localClass, arrayOfString[i])) {
          paramString1 = paramContext.setBit(i);
        }
        i += 1;
        paramContext = paramString1;
      }
    }
    catch (Throwable paramContext)
    {
      zzIk = "err";
      return;
    }
    tmp96_93[0] = paramContext;
    zzIk = String.format(Locale.US, "%X", tmp96_93);
  }
  
  public static String zzgy()
  {
    synchronized (zzpy)
    {
      String str = zzIk;
      return str;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */