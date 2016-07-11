package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public final class Geofence$Builder
{
  private String zzBY = null;
  private int zzaEi = 0;
  private long zzaEj = Long.MIN_VALUE;
  private short zzaEk = -1;
  private double zzaEl;
  private double zzaEm;
  private float zzaEn;
  private int zzaEo = 0;
  private int zzaEp = -1;
  
  public Geofence build()
  {
    if (zzBY == null) {
      throw new IllegalArgumentException("Request ID not set.");
    }
    if (zzaEi == 0) {
      throw new IllegalArgumentException("Transitions types not set.");
    }
    if (((zzaEi & 0x4) != 0) && (zzaEp < 0)) {
      throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
    }
    if (zzaEj == Long.MIN_VALUE) {
      throw new IllegalArgumentException("Expiration not set.");
    }
    if (zzaEk == -1) {
      throw new IllegalArgumentException("Geofence region not set.");
    }
    if (zzaEo < 0) {
      throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
    }
    return new ParcelableGeofence(zzBY, zzaEi, (short)1, zzaEl, zzaEm, zzaEn, zzaEj, zzaEo, zzaEp);
  }
  
  public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
  {
    zzaEk = 1;
    zzaEl = paramDouble1;
    zzaEm = paramDouble2;
    zzaEn = paramFloat;
    return this;
  }
  
  public Builder setExpirationDuration(long paramLong)
  {
    if (paramLong < 0L)
    {
      zzaEj = -1L;
      return this;
    }
    zzaEj = (SystemClock.elapsedRealtime() + paramLong);
    return this;
  }
  
  public Builder setLoiteringDelay(int paramInt)
  {
    zzaEp = paramInt;
    return this;
  }
  
  public Builder setNotificationResponsiveness(int paramInt)
  {
    zzaEo = paramInt;
    return this;
  }
  
  public Builder setRequestId(String paramString)
  {
    zzBY = paramString;
    return this;
  }
  
  public Builder setTransitionTypes(int paramInt)
  {
    zzaEi = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.Geofence.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */