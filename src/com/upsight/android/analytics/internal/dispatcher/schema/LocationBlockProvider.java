package com.upsight.android.analytics.internal.dispatcher.schema;

import android.location.Location;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.persistence.UpsightDataStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import rx.Observable;
import rx.observables.BlockingObservable;

public class LocationBlockProvider
  extends UpsightDataProvider
{
  public static final String LATITUDE_KEY = "location.lat";
  public static final String LONGITUDE_KEY = "location.lon";
  public static final String TIME_ZONE_KEY = "location.tz";
  private UpsightContext mUpsight;
  
  LocationBlockProvider(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  private UpsightLocationTracker.Data fetchLatestLocation()
  {
    return (UpsightLocationTracker.Data)mUpsight.getDataStore().fetchObservable(UpsightLocationTracker.Data.class).lastOrDefault(null).toBlocking().first();
  }
  
  public Set<String> availableKeys()
  {
    return new HashSet(Arrays.asList(new String[] { "location.tz", "location.lat", "location.lon" }));
  }
  
  public Object get(String paramString)
  {
    int i = 0;
    for (;;)
    {
      UpsightLocationTracker.Data localData;
      try
      {
        localData = fetchLatestLocation();
        if (localData == null)
        {
          paramString = null;
          return paramString;
        }
        switch (paramString.hashCode())
        {
        case 552272735: 
          paramString = super.get(paramString);
          continue;
          if (!paramString.equals("location.tz")) {
            break label142;
          }
        }
      }
      finally {}
      if (paramString.equals("location.lat"))
      {
        i = 1;
        break label144;
        if (paramString.equals("location.lon"))
        {
          i = 2;
          break label144;
          paramString = localData.getTimeZone();
          continue;
          paramString = Location.convert(localData.getLatitude(), 0);
          continue;
          paramString = Location.convert(localData.getLongitude(), 0);
          continue;
        }
      }
      label142:
      i = -1;
      label144:
      switch (i)
      {
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.LocationBlockProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */