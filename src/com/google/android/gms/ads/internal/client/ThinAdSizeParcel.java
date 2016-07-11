package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzgr;

@zzgr
public class ThinAdSizeParcel
  extends AdSizeParcel
{
  public ThinAdSizeParcel(AdSizeParcel paramAdSizeParcel)
  {
    super(versionCode, zzte, height, heightPixels, zztf, width, widthPixels, zztg, zzth, zzti);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzte, false);
    zzb.zzc(paramParcel, 3, height);
    zzb.zzc(paramParcel, 6, width);
    zzb.zzI(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.ThinAdSizeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */