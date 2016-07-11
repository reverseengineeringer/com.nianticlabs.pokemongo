package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcs.zza;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public class zze
  extends zzcs.zza
  implements zzh.zza
{
  private final Bundle mExtras;
  private final Object zzpd = new Object();
  private final String zzwo;
  private final List<zzc> zzwp;
  private final String zzwq;
  private final String zzws;
  private final zza zzww;
  private zzh zzwx;
  private final zzcm zzwy;
  private final String zzwz;
  
  public zze(String paramString1, List paramList, String paramString2, zzcm paramzzcm, String paramString3, String paramString4, zza paramzza, Bundle paramBundle)
  {
    zzwo = paramString1;
    zzwp = paramList;
    zzwq = paramString2;
    zzwy = paramzzcm;
    zzws = paramString3;
    zzwz = paramString4;
    zzww = paramzza;
    mExtras = paramBundle;
  }
  
  public String getAdvertiser()
  {
    return zzwz;
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
  
  public void zza(zzh paramzzh)
  {
    synchronized (zzpd)
    {
      zzwx = paramzzh;
      return;
    }
  }
  
  public zzcm zzdA()
  {
    return zzwy;
  }
  
  public zzd zzdx()
  {
    return com.google.android.gms.dynamic.zze.zzy(zzwx);
  }
  
  public String zzdy()
  {
    return "1";
  }
  
  public zza zzdz()
  {
    return zzww;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */