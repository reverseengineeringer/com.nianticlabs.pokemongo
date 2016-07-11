package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.personalized.zzf;

public class TestDataImpl
  extends zzf
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  private final String zzaIe;
  
  TestDataImpl(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzaIe = paramString;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TestDataImpl)) {
      return false;
    }
    paramObject = (TestDataImpl)paramObject;
    return zzaIe.equals(zzaIe);
  }
  
  public int hashCode()
  {
    return zzaIe.hashCode();
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("testName", zzaIe).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzxv()
  {
    return zzaIe;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.internal.TestDataImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */