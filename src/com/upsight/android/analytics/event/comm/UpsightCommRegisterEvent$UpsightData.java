package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightCommRegisterEvent$UpsightData
{
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("token")
  String token;
  
  protected UpsightCommRegisterEvent$UpsightData() {}
  
  protected UpsightCommRegisterEvent$UpsightData(UpsightCommRegisterEvent.Builder paramBuilder)
  {
    token = UpsightCommRegisterEvent.Builder.access$000(paramBuilder);
  }
  
  public String getToken()
  {
    return token;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommRegisterEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */