package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import org.json.JSONObject;

@zzgr
public final class zzhs$zza
{
  public final int errorCode;
  public final long zzHA;
  public final AdRequestInfoParcel zzHC;
  public final AdResponseParcel zzHD;
  public final JSONObject zzHw;
  public final zzee zzHx;
  public final long zzHz;
  public final AdSizeParcel zzqn;
  
  public zzhs$zza(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, zzee paramzzee, AdSizeParcel paramAdSizeParcel, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    zzHC = paramAdRequestInfoParcel;
    zzHD = paramAdResponseParcel;
    zzHx = paramzzee;
    zzqn = paramAdSizeParcel;
    errorCode = paramInt;
    zzHz = paramLong1;
    zzHA = paramLong2;
    zzHw = paramJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhs.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */