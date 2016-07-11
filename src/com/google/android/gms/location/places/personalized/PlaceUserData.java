package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.List;

public class PlaceUserData
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  final int mVersionCode;
  private final String zzRs;
  private final String zzaGt;
  private final List<TestDataImpl> zzaIb;
  private final List<PlaceAlias> zzaIc;
  private final List<HereContent> zzaId;
  
  PlaceUserData(int paramInt, String paramString1, String paramString2, List<TestDataImpl> paramList, List<PlaceAlias> paramList1, List<HereContent> paramList2)
  {
    mVersionCode = paramInt;
    zzRs = paramString1;
    zzaGt = paramString2;
    zzaIb = paramList;
    zzaIc = paramList1;
    zzaId = paramList2;
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceUserData)) {
        return false;
      }
      paramObject = (PlaceUserData)paramObject;
    } while ((zzRs.equals(zzRs)) && (zzaGt.equals(zzaGt)) && (zzaIb.equals(zzaIb)) && (zzaIc.equals(zzaIc)) && (zzaId.equals(zzaId)));
    return false;
  }
  
  public String getPlaceId()
  {
    return zzaGt;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzRs, zzaGt, zzaIb, zzaIc, zzaId });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("accountName", zzRs).zzg("placeId", zzaGt).zzg("testDataImpls", zzaIb).zzg("placeAliases", zzaIc).zzg("hereContents", zzaId).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public String zzxr()
  {
    return zzRs;
  }
  
  public List<PlaceAlias> zzxs()
  {
    return zzaIc;
  }
  
  public List<HereContent> zzxt()
  {
    return zzaId;
  }
  
  public List<TestDataImpl> zzxu()
  {
    return zzaIb;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.PlaceUserData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */