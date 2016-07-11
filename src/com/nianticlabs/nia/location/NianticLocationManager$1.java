package com.nianticlabs.nia.location;

import android.location.GpsSatellite;
import android.location.Location;
import com.nianticlabs.nia.contextservice.ServiceStatus;
import java.util.Map;

class NianticLocationManager$1
  implements GpsProvider.GpsProviderListener
{
  NianticLocationManager$1(NianticLocationManager paramNianticLocationManager, String paramString) {}
  
  public void onGpsStatusUpdate(int paramInt, GpsSatellite[] paramArrayOfGpsSatellite)
  {
    NianticLocationManager.access$000(this$0, paramInt, paramArrayOfGpsSatellite);
  }
  
  public void onProviderLocation(Location paramLocation)
  {
    NianticLocationManager.access$300(this$0, paramLocation, NianticLocationManager.access$200(this$0));
  }
  
  public void onProviderStatus(ServiceStatus paramServiceStatus)
  {
    NianticLocationManager.access$100(this$0).put(val$name, paramServiceStatus);
    NianticLocationManager.access$300(this$0, null, NianticLocationManager.access$200(this$0));
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.NianticLocationManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */