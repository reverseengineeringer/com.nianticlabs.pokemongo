package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;

@zzgr
public final class zzc
{
  public static zzhz zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zza paramzza)
  {
    zza(paramContext, paramAdRequestInfoParcel, paramzza, new zzb()
    {
      public boolean zzd(AdRequestInfoParcel paramAnonymousAdRequestInfoParcel)
      {
        return (zzqj.zzJx) || ((GooglePlayServicesUtil.zzag(zzry)) && (!((Boolean)zzby.zzuL.get()).booleanValue()));
      }
    });
  }
  
  static zzhz zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zza paramzza, zzb paramzzb)
  {
    if (paramzzb.zzd(paramAdRequestInfoParcel)) {
      return zzb(paramContext, paramAdRequestInfoParcel, paramzza);
    }
    return zzc(paramContext, paramAdRequestInfoParcel, paramzza);
  }
  
  private static zzhz zzb(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zza paramzza)
  {
    zzb.zzaF("Fetching ad response from local ad request service.");
    paramContext = new zzd.zza(paramContext, paramAdRequestInfoParcel, paramzza);
    paramContext.zzgz();
    return paramContext;
  }
  
  private static zzhz zzc(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zza paramzza)
  {
    zzb.zzaF("Fetching ad response from remote ad request service.");
    if (!zzl.zzcF().zzR(paramContext))
    {
      zzb.zzaH("Failed to connect to remote ad request service.");
      return null;
    }
    return new zzd.zzb(paramContext, paramAdRequestInfoParcel, paramzza);
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(AdResponseParcel paramAdResponseParcel);
  }
  
  static abstract interface zzb
  {
    public abstract boolean zzd(AdRequestInfoParcel paramAdRequestInfoParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */