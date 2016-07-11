package com.upsight.android.googleadvertisingid.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.logger.UpsightLogger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class GooglePlayAdvertisingProvider
  extends UpsightDataProvider
{
  public static final String AID_KEY = "ids.aid";
  public static final String LIMITED_AD_TRACKING_KEY = "device.limit_ad_tracking";
  public static final String LOG_TAG = GooglePlayAdvertisingProvider.class.getSimpleName();
  private final Context mContext;
  private final UpsightLogger mLogger;
  
  public GooglePlayAdvertisingProvider(Context paramContext, UpsightLogger paramUpsightLogger)
  {
    mContext = paramContext;
    mLogger = paramUpsightLogger;
  }
  
  public Set<String> availableKeys()
  {
    return new HashSet(Arrays.asList(new String[] { "ids.aid", "device.limit_ad_tracking" }));
  }
  
  public Object get(String paramString)
  {
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      try
      {
        switch (paramString.hashCode())
        {
        case 1669192966: 
          paramString = super.get(paramString);
          return paramString;
        }
      }
      finally {}
      if (paramString.equals("ids.aid"))
      {
        break label198;
        boolean bool = paramString.equals("device.limit_ad_tracking");
        if (bool)
        {
          i = 1;
          break label198;
          String str = null;
          try
          {
            paramString = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
            str = paramString;
          }
          catch (Exception paramString)
          {
            mLogger.w(LOG_TAG, "Unable to resolve Google Advertising ID", new Object[] { paramString });
            continue;
          }
          paramString = (String)localObject;
          if (str == null) {
            continue;
          }
          paramString = str.getId();
          continue;
          str = null;
          try
          {
            paramString = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
            str = paramString;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              mLogger.w(LOG_TAG, "Unable to resolve Google limited ad tracking status", new Object[] { paramString });
            }
          }
          paramString = (String)localObject;
          if (str == null) {
            continue;
          }
          paramString = Boolean.valueOf(str.isLimitAdTrackingEnabled());
          continue;
        }
      }
      i = -1;
      label198:
      switch (i)
      {
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googleadvertisingid.internal.GooglePlayAdvertisingProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */