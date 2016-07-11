package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;
import java.util.Collections;
import java.util.List;

@zzgr
public final class AdResponseParcel
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  public String body;
  public final int errorCode;
  public final int orientation;
  public final int versionCode;
  public final String zzBF;
  public final long zzEJ;
  public final boolean zzEK;
  public final long zzEL;
  public final List<String> zzEM;
  public final String zzEN;
  public final long zzEO;
  public final String zzEP;
  public final boolean zzEQ;
  public final String zzER;
  public final String zzES;
  public final boolean zzET;
  public final boolean zzEU;
  public final boolean zzEV;
  public final int zzEW;
  public LargeParcelTeleporter zzEX;
  public String zzEY;
  public String zzEZ;
  public final boolean zzEv;
  public final boolean zzth;
  public boolean zzti;
  public final List<String> zzyY;
  public final List<String> zzyZ;
  public final long zzzc;
  private AdRequestInfoParcel zzzz;
  
  public AdResponseParcel(int paramInt)
  {
    this(14, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null, null, null, false);
  }
  
  public AdResponseParcel(int paramInt, long paramLong)
  {
    this(14, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null, null, null, false);
  }
  
  AdResponseParcel(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt4, LargeParcelTeleporter paramLargeParcelTeleporter, String paramString7, String paramString8, boolean paramBoolean8)
  {
    versionCode = paramInt1;
    zzBF = paramString1;
    body = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      zzyY = paramString1;
      errorCode = paramInt2;
      if (paramList2 == null) {
        break label255;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      zzyZ = paramString1;
      zzEJ = paramLong1;
      zzEK = paramBoolean1;
      zzEL = paramLong2;
      if (paramList3 == null) {
        break label260;
      }
    }
    label255:
    label260:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      zzEM = paramString1;
      zzzc = paramLong3;
      orientation = paramInt3;
      zzEN = paramString3;
      zzEO = paramLong4;
      zzEP = paramString4;
      zzEQ = paramBoolean2;
      zzER = paramString5;
      zzES = paramString6;
      zzET = paramBoolean3;
      zzth = paramBoolean4;
      zzEv = paramBoolean5;
      zzEU = paramBoolean6;
      zzEV = paramBoolean7;
      zzEW = paramInt4;
      zzEX = paramLargeParcelTeleporter;
      zzEY = paramString7;
      zzEZ = paramString8;
      if ((body == null) && (zzEX != null))
      {
        paramString1 = (StringParcel)zzEX.zza(StringParcel.CREATOR);
        if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.zzfP()))) {
          body = paramString1.zzfP();
        }
      }
      zzti = paramBoolean8;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt1, String paramString3, long paramLong4, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, String paramString6, boolean paramBoolean7)
  {
    this(14, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt1, paramString3, paramLong4, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramInt2, null, null, paramString6, paramBoolean7);
    zzzz = paramAdRequestInfoParcel;
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt1, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt2, String paramString7, boolean paramBoolean8)
  {
    this(14, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt1, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramInt2, null, null, paramString7, paramBoolean8);
    zzzz = paramAdRequestInfoParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((zzzz != null) && (zzzz.versionCode >= 9) && (!TextUtils.isEmpty(body)))
    {
      zzEX = new LargeParcelTeleporter(new StringParcel(body));
      body = null;
    }
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdResponseParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */