package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  static final List<ClientIdentity> zzaFD = ;
  String mTag;
  private final int mVersionCode;
  boolean zzaFE;
  boolean zzaFF;
  boolean zzaFG;
  List<ClientIdentity> zzaFH;
  boolean zzaFI;
  LocationRequest zzasN;
  
  LocationRequestInternal(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ClientIdentity> paramList, String paramString, boolean paramBoolean4)
  {
    mVersionCode = paramInt;
    zzasN = paramLocationRequest;
    zzaFE = paramBoolean1;
    zzaFF = paramBoolean2;
    zzaFG = paramBoolean3;
    zzaFH = paramList;
    mTag = paramString;
    zzaFI = paramBoolean4;
  }
  
  public static LocationRequestInternal zza(String paramString, LocationRequest paramLocationRequest)
  {
    return new LocationRequestInternal(1, paramLocationRequest, false, true, true, zzaFD, paramString, false);
  }
  
  @Deprecated
  public static LocationRequestInternal zzb(LocationRequest paramLocationRequest)
  {
    return zza(null, paramLocationRequest);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationRequestInternal)) {}
    do
    {
      return false;
      paramObject = (LocationRequestInternal)paramObject;
    } while ((!zzw.equal(zzasN, zzasN)) || (zzaFE != zzaFE) || (zzaFF != zzaFF) || (zzaFG != zzaFG) || (zzaFI != zzaFI) || (!zzw.equal(zzaFH, zzaFH)));
    return true;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzasN.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(zzasN.toString());
    if (mTag != null) {
      localStringBuilder.append(" tag=").append(mTag);
    }
    localStringBuilder.append(" nlpDebug=").append(zzaFE);
    localStringBuilder.append(" trigger=").append(zzaFG);
    localStringBuilder.append(" restorePIListeners=").append(zzaFF);
    localStringBuilder.append(" hideAppOps=").append(zzaFI);
    localStringBuilder.append(" clients=").append(zzaFH);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.LocationRequestInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */