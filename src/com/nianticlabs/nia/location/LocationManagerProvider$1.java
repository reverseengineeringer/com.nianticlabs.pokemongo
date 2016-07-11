package com.nianticlabs.nia.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.nianticlabs.nia.contextservice.ServiceStatus;

class LocationManagerProvider$1
  implements LocationListener
{
  LocationManagerProvider$1(LocationManagerProvider paramLocationManagerProvider) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (LocationManagerProvider.access$000(this$0)) {
      LocationManagerProvider.access$100(this$0, paramLocation);
    }
  }
  
  public void onProviderDisabled(String paramString)
  {
    LocationManagerProvider.access$200(this$0, ServiceStatus.PERMISSION_DENIED);
  }
  
  public void onProviderEnabled(String paramString)
  {
    LocationManagerProvider.access$200(this$0, ServiceStatus.RUNNING);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.LocationManagerProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */