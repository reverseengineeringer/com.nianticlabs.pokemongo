package com.upsight.android.analytics.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.configuration")
public final class UpsightConfiguration
{
  @JsonProperty("id")
  @UpsightStorableIdentifier
  String id;
  @JsonProperty("scope")
  private String mScope;
  @JsonProperty("session_num_created")
  private int mSessionNumCreated;
  @JsonProperty("value")
  private String mValue;
  
  UpsightConfiguration() {}
  
  UpsightConfiguration(String paramString1, String paramString2, int paramInt)
  {
    mScope = paramString1;
    mValue = paramString2;
    mSessionNumCreated = paramInt;
  }
  
  public static UpsightConfiguration create(String paramString1, String paramString2, int paramInt)
  {
    return new UpsightConfiguration(paramString1, paramString2, paramInt);
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
      paramObject = (UpsightConfiguration)paramObject;
    } while ((id != null) && (id != null) && (id.equals(id)));
    return false;
  }
  
  public String getConfiguration()
  {
    return mValue;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getScope()
  {
    return mScope;
  }
  
  public int getSessionNumberCreated()
  {
    return mSessionNumCreated;
  }
  
  public int hashCode()
  {
    if (id != null) {
      return id.hashCode();
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.configuration.UpsightConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */