package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope
  implements SafeParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzc();
  final int mVersionCode;
  private final String zzaba;
  
  Scope(int paramInt, String paramString)
  {
    zzx.zzh(paramString, "scopeUri must not be null or empty");
    mVersionCode = paramInt;
    zzaba = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return zzaba.equals(zzaba);
  }
  
  public int hashCode()
  {
    return zzaba.hashCode();
  }
  
  public String toString()
  {
    return zzaba;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public String zznG()
  {
    return zzaba;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */