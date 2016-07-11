package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcq.zza;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public class zzd
  extends zzcq.zza
  implements zzh.zza
{
  private final Bundle mExtras;
  private final Object zzpd = new Object();
  private final String zzwo;
  private final List<zzc> zzwp;
  private final String zzwq;
  private final zzcm zzwr;
  private final String zzws;
  private final double zzwt;
  private final String zzwu;
  private final String zzwv;
  private final zza zzww;
  private zzh zzwx;
  
  public zzd(String paramString1, List paramList, String paramString2, zzcm paramzzcm, String paramString3, double paramDouble, String paramString4, String paramString5, zza paramzza, Bundle paramBundle)
  {
    zzwo = paramString1;
    zzwp = paramList;
    zzwq = paramString2;
    zzwr = paramzzcm;
    zzws = paramString3;
    zzwt = paramDouble;
    zzwu = paramString4;
    zzwv = paramString5;
    zzww = paramzza;
    mExtras = paramBundle;
  }
  
  public String getBody()
  {
    return zzwq;
  }
  
  public String getCallToAction()
  {
    return zzws;
  }
  
  public String getCustomTemplateId()
  {
    return "";
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public String getHeadline()
  {
    return zzwo;
  }
  
  public List getImages()
  {
    return zzwp;
  }
  
  public String getPrice()
  {
    return zzwv;
  }
  
  public double getStarRating()
  {
    return zzwt;
  }
  
  public String getStore()
  {
    return zzwu;
  }
  
  public void zza(zzh paramzzh)
  {
    synchronized (zzpd)
    {
      zzwx = paramzzh;
      return;
    }
  }
  
  public zzcm zzdw()
  {
    return zzwr;
  }
  
  public com.google.android.gms.dynamic.zzd zzdx()
  {
    return zze.zzy(zzwx);
  }
  
  public String zzdy()
  {
    return "2";
  }
  
  public zza zzdz()
  {
    return zzww;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */