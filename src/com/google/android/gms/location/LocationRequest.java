package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  int mPriority;
  private final int mVersionCode;
  long zzaEE;
  long zzaEF;
  int zzaEG;
  float zzaEH;
  long zzaEI;
  long zzaEj;
  boolean zzasP;
  
  public LocationRequest()
  {
    mVersionCode = 1;
    mPriority = 102;
    zzaEE = 3600000L;
    zzaEF = 600000L;
    zzasP = false;
    zzaEj = Long.MAX_VALUE;
    zzaEG = Integer.MAX_VALUE;
    zzaEH = 0.0F;
    zzaEI = 0L;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    mVersionCode = paramInt1;
    mPriority = paramInt2;
    zzaEE = paramLong1;
    zzaEF = paramLong2;
    zzasP = paramBoolean;
    zzaEj = paramLong3;
    zzaEG = paramInt3;
    zzaEH = paramFloat;
    zzaEI = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void zzK(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("invalid interval: " + paramLong);
    }
  }
  
  private static void zzd(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("invalid displacement: " + paramFloat);
    }
  }
  
  private static void zzgP(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String zzgQ(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      return "???";
    case 100: 
      return "PRIORITY_HIGH_ACCURACY";
    case 102: 
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104: 
      return "PRIORITY_LOW_POWER";
    }
    return "PRIORITY_NO_POWER";
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
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      paramObject = (LocationRequest)paramObject;
    } while ((mPriority == mPriority) && (zzaEE == zzaEE) && (zzaEF == zzaEF) && (zzasP == zzasP) && (zzaEj == zzaEj) && (zzaEG == zzaEG) && (zzaEH == zzaEH));
    return false;
  }
  
  public long getExpirationTime()
  {
    return zzaEj;
  }
  
  public long getFastestInterval()
  {
    return zzaEF;
  }
  
  public long getInterval()
  {
    return zzaEE;
  }
  
  public long getMaxWaitTime()
  {
    long l2 = zzaEI;
    long l1 = l2;
    if (l2 < zzaEE) {
      l1 = zzaEE;
    }
    return l1;
  }
  
  public int getNumUpdates()
  {
    return zzaEG;
  }
  
  public int getPriority()
  {
    return mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return zzaEH;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(mPriority), Long.valueOf(zzaEE), Long.valueOf(zzaEF), Boolean.valueOf(zzasP), Long.valueOf(zzaEj), Integer.valueOf(zzaEG), Float.valueOf(zzaEH) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (zzaEj = Long.MAX_VALUE;; zzaEj = (l + paramLong))
    {
      if (zzaEj < 0L) {
        zzaEj = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    zzaEj = paramLong;
    if (zzaEj < 0L) {
      zzaEj = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    zzK(paramLong);
    zzasP = true;
    zzaEF = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    zzK(paramLong);
    zzaEE = paramLong;
    if (!zzasP) {
      zzaEF = ((zzaEE / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setMaxWaitTime(long paramLong)
  {
    zzK(paramLong);
    zzaEI = paramLong;
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    zzaEG = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    zzgP(paramInt);
    mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    zzd(paramFloat);
    zzaEH = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(zzgQ(mPriority));
    if (mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(zzaEE).append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(zzaEF).append("ms");
    if (zzaEI > zzaEE)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(zzaEI).append("ms");
    }
    if (zzaEj != Long.MAX_VALUE)
    {
      long l1 = zzaEj;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2).append("ms");
    }
    if (zzaEG != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(zzaEG);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */