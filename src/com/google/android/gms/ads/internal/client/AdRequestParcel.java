package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public final class AdRequestParcel
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Bundle extras;
  public final int versionCode;
  public final long zzsB;
  public final int zzsC;
  public final List<String> zzsD;
  public final boolean zzsE;
  public final int zzsF;
  public final boolean zzsG;
  public final String zzsH;
  public final SearchAdRequestParcel zzsI;
  public final Location zzsJ;
  public final String zzsK;
  public final Bundle zzsL;
  public final Bundle zzsM;
  public final List<String> zzsN;
  public final String zzsO;
  public final String zzsP;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4)
  {
    versionCode = paramInt1;
    zzsB = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    extras = localBundle;
    zzsC = paramInt2;
    zzsD = paramList1;
    zzsE = paramBoolean1;
    zzsF = paramInt3;
    zzsG = paramBoolean2;
    zzsH = paramString1;
    zzsI = paramSearchAdRequestParcel;
    zzsJ = paramLocation;
    zzsK = paramString2;
    zzsL = paramBundle2;
    zzsM = paramBundle3;
    zzsN = paramList2;
    zzsO = paramString3;
    zzsP = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel)) {}
    do
    {
      return false;
      paramObject = (AdRequestParcel)paramObject;
    } while ((versionCode != versionCode) || (zzsB != zzsB) || (!zzw.equal(extras, extras)) || (zzsC != zzsC) || (!zzw.equal(zzsD, zzsD)) || (zzsE != zzsE) || (zzsF != zzsF) || (zzsG != zzsG) || (!zzw.equal(zzsH, zzsH)) || (!zzw.equal(zzsI, zzsI)) || (!zzw.equal(zzsJ, zzsJ)) || (!zzw.equal(zzsK, zzsK)) || (!zzw.equal(zzsL, zzsL)) || (!zzw.equal(zzsM, zzsM)) || (!zzw.equal(zzsN, zzsN)) || (!zzw.equal(zzsO, zzsO)) || (!zzw.equal(zzsP, zzsP)));
    return true;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(versionCode), Long.valueOf(zzsB), extras, Integer.valueOf(zzsC), zzsD, Boolean.valueOf(zzsE), Integer.valueOf(zzsF), Boolean.valueOf(zzsG), zzsH, zzsI, zzsJ, zzsK, zzsL, zzsM, zzsN, zzsO, zzsP });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdRequestParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */