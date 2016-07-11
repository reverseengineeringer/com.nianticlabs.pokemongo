package com.nianticlabs.nia.location;

import android.location.Location;
import com.google.android.gms.location.LocationListener;

class FusedLocationProvider$4
  implements LocationListener
{
  FusedLocationProvider$4(FusedLocationProvider paramFusedLocationProvider) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    Provider.ProviderListener localProviderListener = FusedLocationProvider.access$400(this$0);
    if (localProviderListener != null) {
      localProviderListener.onProviderLocation(paramLocation);
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.FusedLocationProvider.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */