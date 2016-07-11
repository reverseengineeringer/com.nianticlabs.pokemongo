package com.nianticlabs.nia.location;

import android.location.GpsSatellite;

public abstract interface GpsProvider
  extends Provider
{
  public static abstract interface GpsProviderListener
    extends Provider.ProviderListener
  {
    public abstract void onGpsStatusUpdate(int paramInt, GpsSatellite[] paramArrayOfGpsSatellite);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.GpsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */