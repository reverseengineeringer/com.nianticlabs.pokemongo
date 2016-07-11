package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgr
public class zzhs
{
  public final int errorCode;
  public final int orientation;
  public final zziz zzBD;
  public final long zzEJ;
  public final boolean zzEK;
  public final long zzEL;
  public final List<String> zzEM;
  public final String zzEP;
  public final AdRequestParcel zzEn;
  public final String zzEq;
  public final long zzHA;
  public final zzh.zza zzHB;
  public final JSONObject zzHw;
  public final zzee zzHx;
  public final AdSizeParcel zzHy;
  public final long zzHz;
  public final List<String> zzyY;
  public final List<String> zzyZ;
  public final long zzzc;
  public final zzed zzzu;
  public final zzen zzzv;
  public final String zzzw;
  public final zzeg zzzx;
  
  public zzhs(AdRequestParcel paramAdRequestParcel, zziz paramzziz, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, zzed paramzzed, zzen paramzzen, String paramString2, zzee paramzzee, zzeg paramzzeg, long paramLong2, AdSizeParcel paramAdSizeParcel, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, zzh.zza paramzza)
  {
    zzEn = paramAdRequestParcel;
    zzBD = paramzziz;
    if (paramList1 != null)
    {
      paramAdRequestParcel = Collections.unmodifiableList(paramList1);
      zzyY = paramAdRequestParcel;
      errorCode = paramInt1;
      if (paramList2 == null) {
        break label174;
      }
      paramAdRequestParcel = Collections.unmodifiableList(paramList2);
      label45:
      zzyZ = paramAdRequestParcel;
      if (paramList3 == null) {
        break label179;
      }
    }
    label174:
    label179:
    for (paramAdRequestParcel = Collections.unmodifiableList(paramList3);; paramAdRequestParcel = null)
    {
      zzEM = paramAdRequestParcel;
      orientation = paramInt2;
      zzzc = paramLong1;
      zzEq = paramString1;
      zzEK = paramBoolean;
      zzzu = paramzzed;
      zzzv = paramzzen;
      zzzw = paramString2;
      zzHx = paramzzee;
      zzzx = paramzzeg;
      zzEL = paramLong2;
      zzHy = paramAdSizeParcel;
      zzEJ = paramLong3;
      zzHz = paramLong4;
      zzHA = paramLong5;
      zzEP = paramString3;
      zzHw = paramJSONObject;
      zzHB = paramzza;
      return;
      paramAdRequestParcel = null;
      break;
      paramAdRequestParcel = null;
      break label45;
    }
  }
  
  public zzhs(zza paramzza, zziz paramzziz, zzed paramzzed, zzen paramzzen, String paramString, zzeg paramzzeg, zzh.zza paramzza1)
  {
    this(zzHC.zzEn, paramzziz, zzHD.zzyY, errorCode, zzHD.zzyZ, zzHD.zzEM, zzHD.orientation, zzHD.zzzc, zzHC.zzEq, zzHD.zzEK, paramzzed, paramzzen, paramString, zzHx, paramzzeg, zzHD.zzEL, zzqn, zzHD.zzEJ, zzHz, zzHA, zzHD.zzEP, zzHw, paramzza1);
  }
  
  public boolean zzbY()
  {
    if ((zzBD == null) || (zzBD.zzhe() == null)) {
      return false;
    }
    return zzBD.zzhe().zzbY();
  }
  
  @zzgr
  public static final class zza
  {
    public final int errorCode;
    public final long zzHA;
    public final AdRequestInfoParcel zzHC;
    public final AdResponseParcel zzHD;
    public final JSONObject zzHw;
    public final zzee zzHx;
    public final long zzHz;
    public final AdSizeParcel zzqn;
    
    public zza(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, zzee paramzzee, AdSizeParcel paramAdSizeParcel, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */