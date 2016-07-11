package com.upsight.android.analytics.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

public abstract class UpsightLocationTracker
{
  public static void purge(UpsightContext paramUpsightContext)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().purgeLocation();
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public static void track(UpsightContext paramUpsightContext, Data paramData)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().trackLocation(paramData);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public abstract void purge();
  
  public abstract void track(Data paramData);
  
  @UpsightStorableType("upsight.model.location")
  public static final class Data
  {
    @UpsightStorableIdentifier
    String id;
    @JsonProperty
    double latitude;
    @JsonProperty
    double longitude;
    @JsonProperty
    String timeZone;
    
    Data() {}
    
    private Data(double paramDouble1, double paramDouble2, String paramString)
    {
      latitude = paramDouble1;
      longitude = paramDouble2;
      timeZone = paramString;
    }
    
    public static Data create(double paramDouble1, double paramDouble2)
    {
      return new Data(paramDouble1, paramDouble2, null);
    }
    
    public static Data create(double paramDouble1, double paramDouble2, String paramString)
    {
      return new Data(paramDouble1, paramDouble2, paramString);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (Data)paramObject;
        if (id == null) {
          break;
        }
      } while (id.equals(id));
      for (;;)
      {
        return false;
        if (id == null) {
          break;
        }
      }
    }
    
    public double getLatitude()
    {
      return latitude;
    }
    
    public double getLongitude()
    {
      return longitude;
    }
    
    public String getTimeZone()
    {
      return timeZone;
    }
    
    public int hashCode()
    {
      if (id != null) {
        return id.hashCode();
      }
      return 0;
    }
    
    public void setLatitude(double paramDouble)
    {
      latitude = paramDouble;
    }
    
    public void setLongitude(double paramDouble)
    {
      longitude = paramDouble;
    }
    
    public void setTimeZone(String paramString)
    {
      timeZone = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.provider.UpsightLocationTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */