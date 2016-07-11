package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcu.zza;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzmi;
import java.util.Arrays;
import java.util.List;

@zzgr
public class zzf
  extends zzcu.zza
  implements zzh.zza
{
  private final Object zzpd = new Object();
  private final String zzwA;
  private final zzmi<String, zzc> zzwB;
  private final zzmi<String, String> zzwC;
  private final zza zzww;
  private zzh zzwx;
  
  public zzf(String paramString, zzmi<String, zzc> paramzzmi, zzmi<String, String> paramzzmi1, zza paramzza)
  {
    zzwA = paramString;
    zzwB = paramzzmi;
    zzwC = paramzzmi1;
    zzww = paramzza;
  }
  
  public List<String> getAvailableAssetNames()
  {
    int n = 0;
    String[] arrayOfString = new String[zzwB.size() + zzwC.size()];
    int j = 0;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= zzwB.size()) {
        break;
      }
      arrayOfString[i] = ((String)zzwB.keyAt(j));
      i += 1;
      j += 1;
    }
    while (k < zzwC.size())
    {
      arrayOfString[m] = ((String)zzwC.keyAt(k));
      k += 1;
      m += 1;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public String getCustomTemplateId()
  {
    return zzwA;
  }
  
  public void performClick(String paramString)
  {
    synchronized (zzpd)
    {
      if (zzwx == null)
      {
        zzb.e("Attempt to call performClick before ad initialized.");
        return;
      }
      zzwx.zza(paramString, null, null);
      return;
    }
  }
  
  public void recordImpression()
  {
    synchronized (zzpd)
    {
      if (zzwx == null)
      {
        zzb.e("Attempt to perform recordImpression before ad initialized.");
        return;
      }
      zzwx.recordImpression();
      return;
    }
  }
  
  public String zzU(String paramString)
  {
    return (String)zzwC.get(paramString);
  }
  
  public zzcm zzV(String paramString)
  {
    return (zzcm)zzwB.get(paramString);
  }
  
  public void zza(zzh paramzzh)
  {
    synchronized (zzpd)
    {
      zzwx = paramzzh;
      return;
    }
  }
  
  public String zzdy()
  {
    return "3";
  }
  
  public zza zzdz()
  {
    return zzww;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */