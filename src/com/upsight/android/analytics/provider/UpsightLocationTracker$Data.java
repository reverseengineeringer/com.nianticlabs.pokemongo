package com.upsight.android.analytics.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.model.location")
public final class UpsightLocationTracker$Data
{
  @UpsightStorableIdentifier
  String id;
  @JsonProperty
  double latitude;
  @JsonProperty
  double longitude;
  @JsonProperty
  String timeZone;
  
  UpsightLocationTracker$Data() {}
  
  private UpsightLocationTracker$Data(double paramDouble1, double paramDouble2, String paramString)
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.provider.UpsightLocationTracker.Data
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */