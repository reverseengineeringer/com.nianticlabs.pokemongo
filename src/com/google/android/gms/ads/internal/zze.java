package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
public class zze
{
  private zza zzoI;
  private boolean zzoJ;
  private boolean zzoK;
  
  public zze()
  {
    zzoK = ((Boolean)zzby.zzus.get()).booleanValue();
  }
  
  public zze(boolean paramBoolean)
  {
    zzoK = paramBoolean;
  }
  
  public void recordClick()
  {
    zzoJ = true;
  }
  
  public void zza(zza paramzza)
  {
    zzoI = paramzza;
  }
  
  public boolean zzbe()
  {
    return (!zzoK) || (zzoJ);
  }
  
  public void zzp(String paramString)
  {
    zzb.zzaF("Action was blocked because no click was detected.");
    if (zzoI != null) {
      zzoI.zzq(paramString);
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzq(String paramString);
  }
  
  @zzgr
  public static class zzb
    implements zze.zza
  {
    private final zzhs.zza zzoL;
    private final zziz zzoM;
    
    public zzb(zzhs.zza paramzza, zziz paramzziz)
    {
      zzoL = paramzza;
      zzoM = paramzziz;
    }
    
    public void zzq(String paramString)
    {
      zzb.zzaF("An auto-clicking creative is blocked");
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https");
      localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
      localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(paramString)) {
        localBuilder.appendQueryParameter("navigationURL", paramString);
      }
      if ((zzoL != null) && (zzoL.zzHD != null) && (!TextUtils.isEmpty(zzoL.zzHD.zzEP))) {
        localBuilder.appendQueryParameter("debugDialog", zzoL.zzHD.zzEP);
      }
      zzp.zzbv().zzc(zzoM.getContext(), zzoM.zzhh().zzJu, localBuilder.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */