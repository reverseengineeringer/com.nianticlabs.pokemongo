package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;

final class zzc$1
  implements zzc.zzb
{
  zzc$1(Context paramContext) {}
  
  public boolean zzd(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return (zzqj.zzJx) || ((GooglePlayServicesUtil.zzag(zzry)) && (!((Boolean)zzby.zzuL.get()).booleanValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */