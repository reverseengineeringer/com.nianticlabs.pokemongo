package com.nianticlabs.nia.location;

import android.location.Location;
import com.nianticlabs.nia.contextservice.ServiceStatus;
import java.util.Map;

class NianticLocationManager$2
  implements Provider.ProviderListener
{
  NianticLocationManager$2(NianticLocationManager paramNianticLocationManager, String paramString) {}
  
  public void onProviderLocation(Location paramLocation)
  {
    NianticLocationManager.access$300(this$0, paramLocation, NianticLocationManager.access$200(this$0));
  }
  
  public void onProviderStatus(ServiceStatus paramServiceStatus)
  {
    NianticLocationManager.access$100(this$0).put(val$name, paramServiceStatus);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.NianticLocationManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */