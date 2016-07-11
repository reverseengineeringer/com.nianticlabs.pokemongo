package com.nianticlabs.nia.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.nianticlabs.nia.contextservice.ServiceStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocationManagerProvider
  implements GpsProvider
{
  private static final boolean ENABLE_VERBOSE_LOGS = false;
  private static final String TAG = "LocationManagerProvider";
  private final Context context;
  private boolean firstLocationUpdate = false;
  private final GpsStatus.Listener gpsStatusListener = new GpsStatus.Listener()
  {
    private GpsSatellite[] getSatellites(GpsStatus paramAnonymousGpsStatus)
    {
      ArrayList localArrayList = new ArrayList();
      paramAnonymousGpsStatus = paramAnonymousGpsStatus.getSatellites().iterator();
      while (paramAnonymousGpsStatus.hasNext()) {
        localArrayList.add((GpsSatellite)paramAnonymousGpsStatus.next());
      }
      return (GpsSatellite[])localArrayList.toArray(new GpsSatellite[localArrayList.size()]);
    }
    
    public void onGpsStatusChanged(int paramAnonymousInt)
    {
      if (running)
      {
        GpsStatus localGpsStatus = locationManager.getGpsStatus(null);
        LocationManagerProvider.this.updateGpsStatus(localGpsStatus.getTimeToFirstFix(), getSatellites(localGpsStatus));
      }
    }
  };
  private LocationListener listener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      if (running) {
        LocationManagerProvider.this.updateLocation(paramAnonymousLocation);
      }
    }
    
    public void onProviderDisabled(String paramAnonymousString)
    {
      LocationManagerProvider.this.updateStatus(ServiceStatus.PERMISSION_DENIED);
    }
    
    public void onProviderEnabled(String paramAnonymousString)
    {
      LocationManagerProvider.this.updateStatus(ServiceStatus.RUNNING);
    }
    
    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
  };
  private LocationManager locationManager;
  private final String provider;
  private Provider.ProviderListener providerListener = null;
  private boolean running = false;
  private final float updateDistance;
  private final int updateTime;
  
  public LocationManagerProvider(Context paramContext, String paramString, int paramInt, float paramFloat)
  {
    context = paramContext;
    provider = paramString;
    updateTime = paramInt;
    updateDistance = paramFloat;
  }
  
  private void updateGpsStatus(int paramInt, GpsSatellite[] paramArrayOfGpsSatellite)
  {
    Provider.ProviderListener localProviderListener = providerListener;
    if ((localProviderListener != null) && ((localProviderListener instanceof GpsProvider.GpsProviderListener))) {
      ((GpsProvider.GpsProviderListener)localProviderListener).onGpsStatusUpdate(paramInt, paramArrayOfGpsSatellite);
    }
  }
  
  private void updateLocation(Location paramLocation)
  {
    Provider.ProviderListener localProviderListener = providerListener;
    if (localProviderListener != null)
    {
      if (firstLocationUpdate)
      {
        firstLocationUpdate = false;
        updateStatus(ServiceStatus.RUNNING);
      }
      localProviderListener.onProviderLocation(paramLocation);
    }
  }
  
  private void updateStatus(ServiceStatus paramServiceStatus)
  {
    Provider.ProviderListener localProviderListener = providerListener;
    if (localProviderListener != null) {
      localProviderListener.onProviderStatus(paramServiceStatus);
    }
  }
  
  public void onPause()
  {
    if (running) {}
    try
    {
      locationManager.removeUpdates(listener);
      running = false;
      updateStatus(ServiceStatus.STOPPED);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Log.e("LocationManagerProvider", "Not allowed to access " + provider + " for updates", localSecurityException);
      }
    }
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 43	com/nianticlabs/nia/location/LocationManagerProvider:firstLocationUpdate	Z
    //   5: getstatic 144	com/nianticlabs/nia/contextservice/ServiceStatus:FAILED	Lcom/nianticlabs/nia/contextservice/ServiceStatus;
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 80	com/nianticlabs/nia/location/LocationManagerProvider:locationManager	Landroid/location/LocationManager;
    //   13: aload_0
    //   14: getfield 57	com/nianticlabs/nia/location/LocationManagerProvider:provider	Ljava/lang/String;
    //   17: aload_0
    //   18: getfield 59	com/nianticlabs/nia/location/LocationManagerProvider:updateTime	I
    //   21: i2l
    //   22: aload_0
    //   23: getfield 61	com/nianticlabs/nia/location/LocationManagerProvider:updateDistance	F
    //   26: aload_0
    //   27: getfield 48	com/nianticlabs/nia/location/LocationManagerProvider:listener	Landroid/location/LocationListener;
    //   30: invokestatic 150	com/nianticlabs/nia/contextservice/ContextService:getServiceLooper	()Landroid/os/Looper;
    //   33: invokevirtual 154	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   36: ldc 17
    //   38: ldc -100
    //   40: invokestatic 160	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   43: pop
    //   44: aload_0
    //   45: getfield 57	com/nianticlabs/nia/location/LocationManagerProvider:provider	Ljava/lang/String;
    //   48: ldc -94
    //   50: if_acmpne +15 -> 65
    //   53: aload_0
    //   54: getfield 80	com/nianticlabs/nia/location/LocationManagerProvider:locationManager	Landroid/location/LocationManager;
    //   57: aload_0
    //   58: getfield 51	com/nianticlabs/nia/location/LocationManagerProvider:gpsStatusListener	Landroid/location/GpsStatus$Listener;
    //   61: invokevirtual 166	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   64: pop
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 41	com/nianticlabs/nia/location/LocationManagerProvider:running	Z
    //   70: aload_0
    //   71: getfield 41	com/nianticlabs/nia/location/LocationManagerProvider:running	Z
    //   74: ifeq +106 -> 180
    //   77: aload_0
    //   78: getstatic 169	com/nianticlabs/nia/contextservice/ServiceStatus:INITIALIZED	Lcom/nianticlabs/nia/contextservice/ServiceStatus;
    //   81: invokespecial 76	com/nianticlabs/nia/location/LocationManagerProvider:updateStatus	(Lcom/nianticlabs/nia/contextservice/ServiceStatus;)V
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 80	com/nianticlabs/nia/location/LocationManagerProvider:locationManager	Landroid/location/LocationManager;
    //   89: aload_0
    //   90: getfield 57	com/nianticlabs/nia/location/LocationManagerProvider:provider	Ljava/lang/String;
    //   93: invokevirtual 173	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
    //   96: invokespecial 70	com/nianticlabs/nia/location/LocationManagerProvider:updateLocation	(Landroid/location/Location;)V
    //   99: return
    //   100: astore_2
    //   101: ldc 17
    //   103: new 119	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   110: ldc -81
    //   112: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_0
    //   116: getfield 57	com/nianticlabs/nia/location/LocationManagerProvider:provider	Ljava/lang/String;
    //   119: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc -79
    //   124: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: aload_2
    //   131: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   134: pop
    //   135: goto -65 -> 70
    //   138: astore_1
    //   139: ldc 17
    //   141: new 119	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   148: ldc 122
    //   150: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 57	com/nianticlabs/nia/location/LocationManagerProvider:provider	Ljava/lang/String;
    //   157: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc -128
    //   162: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload_1
    //   169: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   172: pop
    //   173: getstatic 180	com/nianticlabs/nia/contextservice/ServiceStatus:PERMISSION_DENIED	Lcom/nianticlabs/nia/contextservice/ServiceStatus;
    //   176: astore_1
    //   177: goto -107 -> 70
    //   180: aload_0
    //   181: aload_1
    //   182: invokespecial 76	com/nianticlabs/nia/location/LocationManagerProvider:updateStatus	(Lcom/nianticlabs/nia/contextservice/ServiceStatus;)V
    //   185: return
    //   186: astore_1
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	LocationManagerProvider
    //   8	1	1	localServiceStatus1	ServiceStatus
    //   138	31	1	localSecurityException1	SecurityException
    //   176	6	1	localServiceStatus2	ServiceStatus
    //   186	1	1	localSecurityException2	SecurityException
    //   100	31	2	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   9	65	100	java/lang/IllegalArgumentException
    //   65	70	100	java/lang/IllegalArgumentException
    //   9	65	138	java/lang/SecurityException
    //   65	70	138	java/lang/SecurityException
    //   84	99	186	java/lang/SecurityException
  }
  
  public void onStart()
  {
    locationManager = ((LocationManager)context.getSystemService("location"));
  }
  
  public void onStop()
  {
    locationManager = null;
  }
  
  public void setListener(Provider.ProviderListener paramProviderListener)
  {
    providerListener = paramProviderListener;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.LocationManagerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */