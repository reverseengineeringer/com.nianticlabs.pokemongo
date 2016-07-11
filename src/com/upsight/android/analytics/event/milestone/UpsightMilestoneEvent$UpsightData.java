package com.upsight.android.analytics.event.milestone;

import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightMilestoneEvent$UpsightData
{
  @JsonProperty("scope")
  String scope;
  
  protected UpsightMilestoneEvent$UpsightData() {}
  
  protected UpsightMilestoneEvent$UpsightData(UpsightMilestoneEvent.Builder paramBuilder)
  {
    scope = UpsightMilestoneEvent.Builder.access$000(paramBuilder);
  }
  
  public String getScope()
  {
    return scope;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.milestone.UpsightMilestoneEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */