package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Comparator;

public class DetectedActivity
  implements SafeParcelable
{
  public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  public static final Comparator<DetectedActivity> zzaEf = new Comparator()
  {
    public int zza(DetectedActivity paramAnonymousDetectedActivity1, DetectedActivity paramAnonymousDetectedActivity2)
    {
      int j = Integer.valueOf(paramAnonymousDetectedActivity2.getConfidence()).compareTo(Integer.valueOf(paramAnonymousDetectedActivity1.getConfidence()));
      int i = j;
      if (j == 0) {
        i = Integer.valueOf(paramAnonymousDetectedActivity1.getType()).compareTo(Integer.valueOf(paramAnonymousDetectedActivity2.getType()));
      }
      return i;
    }
  };
  private final int mVersionCode;
  int zzaEg;
  int zzaEh;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    mVersionCode = 1;
    zzaEg = paramInt1;
    zzaEh = paramInt2;
  }
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaEg = paramInt2;
    zzaEh = paramInt3;
  }
  
  private int zzgK(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 15) {
      i = 4;
    }
    return i;
  }
  
  public static String zzgL(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "IN_VEHICLE";
    case 1: 
      return "ON_BICYCLE";
    case 2: 
      return "ON_FOOT";
    case 3: 
      return "STILL";
    case 4: 
      return "UNKNOWN";
    case 5: 
      return "TILTING";
    case 7: 
      return "WALKING";
    }
    return "RUNNING";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DetectedActivity)paramObject;
    } while ((zzaEg == zzaEg) && (zzaEh == zzaEh));
    return false;
  }
  
  public int getConfidence()
  {
    return zzaEh;
  }
  
  public int getType()
  {
    return zzgK(zzaEg);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(zzaEg), Integer.valueOf(zzaEh) });
  }
  
  public String toString()
  {
    return "DetectedActivity [type=" + zzgL(getType()) + ", confidence=" + zzaEh + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DetectedActivityCreator.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.DetectedActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */