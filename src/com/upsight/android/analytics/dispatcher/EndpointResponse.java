package com.upsight.android.analytics.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.dispatcher.response")
public final class EndpointResponse
{
  @JsonProperty("id")
  @UpsightStorableIdentifier
  String id;
  @JsonProperty("content")
  private String mContent;
  @JsonProperty("type")
  private String mType;
  
  EndpointResponse() {}
  
  EndpointResponse(String paramString1, String paramString2)
  {
    mType = paramString1;
    mContent = paramString2;
  }
  
  public static EndpointResponse create(String paramString1, String paramString2)
  {
    return new EndpointResponse(paramString1, paramString2);
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
      paramObject = (EndpointResponse)paramObject;
    } while ((id != null) && (id != null) && (id.equals(id)));
    return false;
  }
  
  public String getContent()
  {
    return mContent;
  }
  
  public String getType()
  {
    return mType;
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
 * Qualified Name:     com.upsight.android.analytics.dispatcher.EndpointResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */