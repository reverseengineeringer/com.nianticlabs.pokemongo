package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzjb
{
  public zziz zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel)
  {
    return zza(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, null, null);
  }
  
  public zziz zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzcg paramzzcg, zzd paramzzd)
  {
    paramContext = new zzjc(zzjd.zzb(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, paramzzcg, paramzzd));
    paramContext.setWebViewClient(zzp.zzbx().zzb(paramContext, paramBoolean2));
    paramContext.setWebChromeClient(zzp.zzbx().zzf(paramContext));
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */