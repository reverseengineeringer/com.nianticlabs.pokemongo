package com.nianticlabs.nia.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.Location;
import com.nianticlabs.nia.contextservice.ContextService;
import com.nianticlabs.nia.contextservice.ServiceStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NianticLocationManager
  extends ContextService
{
  static final boolean ENABLE_VERBOSE_LOGS = false;
  private static final String FUSED_PROVIDER_NAME = "fused";
  private static final float GPS_UPDATE_DISTANCE_M = 0.0F;
  private static final int GPS_UPDATE_TIME_MSEC = 1000;
  private static final long INITIALIZATION_WAIT_TIME_MS = 2000L;
  private static final float NET_UPDATE_DISTANCE_M = 0.0F;
  private static final int NET_UPDATE_TIME_MSEC = 5000;
  private static final String TAG = "NianticLocationManager";
  private float gpsUpdateDistanceM = 0.0F;
  private int gpsUpdateTimeMs = 1000;
  private float netUpdateDistanceM = 0.0F;
  private int netUpdateTimeMs = 5000;
  private final List<Provider> providers;
  private boolean started = false;
  private final Map<String, ServiceStatus> statusMap = new HashMap();
  
  public NianticLocationManager(Context paramContext, long paramLong)
  {
    super(paramContext, paramLong);
    statusMap.put("gps", ServiceStatus.UNDEFINED);
    statusMap.put("network", ServiceStatus.UNDEFINED);
    statusMap.put("fused", ServiceStatus.UNDEFINED);
    providers = new ArrayList(3);
  }
  
  private void addProvider(final String paramString, Provider paramProvider)
  {
    providers.add(paramProvider);
    if ((paramProvider instanceof GpsProvider))
    {
      paramProvider.setListener(new GpsProvider.GpsProviderListener()
      {
        public void onGpsStatusUpdate(int paramAnonymousInt, GpsSatellite[] paramAnonymousArrayOfGpsSatellite)
        {
          NianticLocationManager.this.gpsStatusUpdate(paramAnonymousInt, paramAnonymousArrayOfGpsSatellite);
        }
        
        public void onProviderLocation(Location paramAnonymousLocation)
        {
          NianticLocationManager.this.locationUpdate(paramAnonymousLocation, NianticLocationManager.access$200(NianticLocationManager.this));
        }
        
        public void onProviderStatus(ServiceStatus paramAnonymousServiceStatus)
        {
          statusMap.put(paramString, paramAnonymousServiceStatus);
          NianticLocationManager.this.locationUpdate(null, NianticLocationManager.access$200(NianticLocationManager.this));
        }
      });
      return;
    }
    paramProvider.setListener(new Provider.ProviderListener()
    {
      public void onProviderLocation(Location paramAnonymousLocation)
      {
        NianticLocationManager.this.locationUpdate(paramAnonymousLocation, NianticLocationManager.access$200(NianticLocationManager.this));
      }
      
      public void onProviderStatus(ServiceStatus paramAnonymousServiceStatus)
      {
        statusMap.put(paramString, paramAnonymousServiceStatus);
      }
    });
  }
  
  private void createProviders()
  {
    if (providers.size() == 3) {
      return;
    }
    addProvider("fused", new FusedLocationProvider(context, gpsUpdateTimeMs, gpsUpdateDistanceM));
    addProvider("gps", new LocationManagerProvider(context, "gps", gpsUpdateTimeMs, gpsUpdateDistanceM));
    addProvider("network", new LocationManagerProvider(context, "network", netUpdateTimeMs, netUpdateDistanceM));
  }
  
  private void doStart()
  {
    if (!started)
    {
      createProviders();
      locationUpdate(null, statusArray());
      Iterator localIterator = providers.iterator();
      while (localIterator.hasNext()) {
        ((Provider)localIterator.next()).onStart();
      }
      started = true;
    }
  }
  
  private void gpsStatusUpdate(int paramInt, GpsSatellite[] paramArrayOfGpsSatellite)
  {
    synchronized (callbackLock)
    {
      nativeGpsStatusUpdate(paramInt, paramArrayOfGpsSatellite);
      return;
    }
  }
  
  private void locationUpdate(Location paramLocation, int[] paramArrayOfInt)
  {
    synchronized (callbackLock)
    {
      nativeLocationUpdate(paramLocation, paramArrayOfInt, context);
      return;
    }
  }
  
  private native void nativeGpsStatusUpdate(int paramInt, GpsSatellite[] paramArrayOfGpsSatellite);
  
  private native void nativeLocationUpdate(Location paramLocation, int[] paramArrayOfInt, Context paramContext);
  
  private int[] statusArray()
  {
    return new int[] { ((ServiceStatus)statusMap.get("gps")).ordinal(), ((ServiceStatus)statusMap.get("network")).ordinal(), ((ServiceStatus)statusMap.get("fused")).ordinal() };
  }
  
  public void configureLocationParameters(final double paramDouble, final int paramInt1, int paramInt2)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        if (started) {
          throw new IllegalStateException("Already started.");
        }
        NianticLocationManager.access$502(NianticLocationManager.this, paramInt1);
        NianticLocationManager.access$602(NianticLocationManager.this, (float)paramDouble);
        NianticLocationManager.access$702(NianticLocationManager.this, val$net_update_time_ms);
        NianticLocationManager.access$802(NianticLocationManager.this, (float)paramDouble);
        NianticLocationManager.this.doStart();
      }
    });
  }
  
  public void onPause()
  {
    Iterator localIterator = providers.iterator();
    while (localIterator.hasNext()) {
      ((Provider)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    if (!started) {
      doStart();
    }
    Iterator localIterator = providers.iterator();
    while (localIterator.hasNext()) {
      ((Provider)localIterator.next()).onResume();
    }
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    Iterator localIterator = providers.iterator();
    while (localIterator.hasNext()) {
      ((Provider)localIterator.next()).onStop();
    }
    started = false;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.NianticLocationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */