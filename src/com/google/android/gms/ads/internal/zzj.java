package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzmi;

@zzgr
public class zzj
  extends zzq.zza
{
  private final Context mContext;
  private zzo zzoT;
  private NativeAdOptionsParcel zzoY;
  private final zzem zzox;
  private final String zzpa;
  private final VersionInfoParcel zzpb;
  private zzcw zzpg;
  private zzcx zzph;
  private zzmi<String, zzcy> zzpi;
  private zzmi<String, zzcz> zzpj;
  
  public zzj(Context paramContext, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzpa = paramString;
    zzox = paramzzem;
    zzpb = paramVersionInfoParcel;
    zzpj = new zzmi();
    zzpi = new zzmi();
  }
  
  public void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    zzoY = paramNativeAdOptionsParcel;
  }
  
  public void zza(zzcw paramzzcw)
  {
    zzpg = paramzzcw;
  }
  
  public void zza(zzcx paramzzcx)
  {
    zzph = paramzzcx;
  }
  
  public void zza(String paramString, zzcz paramzzcz, zzcy paramzzcy)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }
    zzpj.put(paramString, paramzzcz);
    zzpi.put(paramString, paramzzcy);
  }
  
  public void zzb(zzo paramzzo)
  {
    zzoT = paramzzo;
  }
  
  public zzp zzbk()
  {
    return new zzi(mContext, zzpa, zzox, zzpb, zzoT, zzpg, zzph, zzpj, zzpi, zzoY);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */