package com.unity3d.player;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

final class r
  implements LocationListener
{
  private final Context a;
  private final UnityPlayer b;
  private Location c;
  private float d = 0.0F;
  private boolean e = false;
  private int f = 0;
  private boolean g = false;
  private int h = 0;
  
  protected r(Context paramContext, UnityPlayer paramUnityPlayer)
  {
    a = paramContext;
    b = paramUnityPlayer;
  }
  
  private void a(int paramInt)
  {
    h = paramInt;
    b.nativeSetLocationStatus(paramInt);
  }
  
  private void a(Location paramLocation)
  {
    if (paramLocation == null) {}
    while (!a(paramLocation, c)) {
      return;
    }
    c = paramLocation;
    GeomagneticField localGeomagneticField = new GeomagneticField((float)c.getLatitude(), (float)c.getLongitude(), (float)c.getAltitude(), c.getTime());
    b.nativeSetLocation((float)paramLocation.getLatitude(), (float)paramLocation.getLongitude(), (float)paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getTime() / 1000.0D, localGeomagneticField.getDeclination());
  }
  
  private static boolean a(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation2 == null) {}
    int j;
    int k;
    label40:
    int i;
    label65:
    label71:
    label74:
    for (;;)
    {
      return true;
      long l = paramLocation1.getTime() - paramLocation2.getTime();
      if (l > 120000L)
      {
        j = 1;
        if (l >= -120000L) {
          break label65;
        }
        k = 1;
        if (l <= 0L) {
          break label71;
        }
      }
      for (i = 1;; i = 0)
      {
        if (j != 0) {
          break label74;
        }
        if (k == 0) {
          break label76;
        }
        return false;
        j = 0;
        break;
        k = 0;
        break label40;
      }
    }
    label76:
    int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    if (m > 0)
    {
      j = 1;
      label95:
      if (m >= 0) {
        break label176;
      }
      k = 1;
      label103:
      if (m <= 200) {
        break label182;
      }
      m = 1;
      label114:
      if (paramLocation1.getAccuracy() != 0.0F) {
        break label188;
      }
    }
    label176:
    label182:
    label188:
    for (int n = 1;; n = 0)
    {
      boolean bool = a(paramLocation1.getProvider(), paramLocation2.getProvider());
      if ((k != 0) || ((i != 0) && (j == 0)) || ((i != 0) && ((m | n) == 0) && (bool))) {
        break;
      }
      return false;
      j = 0;
      break label95;
      k = 0;
      break label103;
      m = 0;
      break label114;
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public final void a(float paramFloat)
  {
    d = paramFloat;
  }
  
  public final boolean a()
  {
    return !((LocationManager)a.getSystemService("location")).getProviders(new Criteria(), true).isEmpty();
  }
  
  public final void b()
  {
    g = false;
    if (e)
    {
      m.Log(5, "Location_StartUpdatingLocation already started!");
      return;
    }
    if (!a())
    {
      a(3);
      return;
    }
    LocationManager localLocationManager = (LocationManager)a.getSystemService("location");
    a(1);
    Object localObject1 = localLocationManager.getProviders(true);
    if (((List)localObject1).isEmpty())
    {
      a(3);
      return;
    }
    Object localObject2;
    LocationProvider localLocationProvider;
    if (f == 2)
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localLocationProvider = localLocationManager.getProvider((String)((Iterator)localObject2).next());
      } while (localLocationProvider.getAccuracy() != 2);
    }
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localLocationProvider == null) || (localLocationManager.getProvider((String)localObject2).getAccuracy() != 1))
        {
          a(localLocationManager.getLastKnownLocation((String)localObject2));
          localLocationManager.requestLocationUpdates((String)localObject2, 0L, d, this, a.getMainLooper());
          e = true;
        }
      }
      break;
      localLocationProvider = null;
    }
  }
  
  public final void b(float paramFloat)
  {
    if (paramFloat < 100.0F)
    {
      f = 1;
      return;
    }
    if (paramFloat < 500.0F)
    {
      f = 1;
      return;
    }
    f = 2;
  }
  
  public final void c()
  {
    ((LocationManager)a.getSystemService("location")).removeUpdates(this);
    e = false;
    c = null;
    a(0);
  }
  
  public final void d()
  {
    if ((h == 1) || (h == 2))
    {
      g = true;
      c();
    }
  }
  
  public final void e()
  {
    if (g) {
      b();
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    a(2);
    a(paramLocation);
  }
  
  public final void onProviderDisabled(String paramString)
  {
    c = null;
  }
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}

/* Location:
 * Qualified Name:     com.unity3d.player.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */