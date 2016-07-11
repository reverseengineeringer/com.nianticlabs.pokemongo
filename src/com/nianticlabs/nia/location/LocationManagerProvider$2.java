package com.nianticlabs.nia.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.LocationManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LocationManagerProvider$2
  implements GpsStatus.Listener
{
  LocationManagerProvider$2(LocationManagerProvider paramLocationManagerProvider) {}
  
  private GpsSatellite[] getSatellites(GpsStatus paramGpsStatus)
  {
    ArrayList localArrayList = new ArrayList();
    paramGpsStatus = paramGpsStatus.getSatellites().iterator();
    while (paramGpsStatus.hasNext()) {
      localArrayList.add((GpsSatellite)paramGpsStatus.next());
    }
    return (GpsSatellite[])localArrayList.toArray(new GpsSatellite[localArrayList.size()]);
  }
  
  public void onGpsStatusChanged(int paramInt)
  {
    if (LocationManagerProvider.access$000(this$0))
    {
      GpsStatus localGpsStatus = LocationManagerProvider.access$300(this$0).getGpsStatus(null);
      LocationManagerProvider.access$400(this$0, localGpsStatus.getTimeToFirstFix(), getSatellites(localGpsStatus));
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.LocationManagerProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */