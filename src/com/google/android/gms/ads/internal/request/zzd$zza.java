package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;

@zzgr
public final class zzd$zza
  extends zzd
{
  private final Context mContext;
  
  public zzd$zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzc.zza paramzza)
  {
    super(paramAdRequestInfoParcel, paramzza);
    mContext = paramContext;
  }
  
  public void zzfH() {}
  
  public zzj zzfI()
  {
    zzbr localzzbr = new zzbr((String)zzby.zzul.get());
    return zzgt.zza(mContext, localzzbr, zzgs.zzfQ());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */