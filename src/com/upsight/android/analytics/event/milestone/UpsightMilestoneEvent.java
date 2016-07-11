package com.upsight.android.analytics.event.milestone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.milestone")
public class UpsightMilestoneEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightMilestoneEvent() {}
  
  protected UpsightMilestoneEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(String paramString)
  {
    return new Builder(paramString);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightMilestoneEvent, UpsightMilestoneEvent.UpsightData>
  {
    private String scope;
    
    protected Builder(String paramString)
    {
      scope = paramString;
    }
    
    protected UpsightMilestoneEvent build()
    {
      return new UpsightMilestoneEvent("upsight.milestone", new UpsightMilestoneEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
  }
  
  static class UpsightData
  {
    @JsonProperty("scope")
    String scope;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightMilestoneEvent.Builder paramBuilder)
    {
      scope = scope;
    }
    
    public String getScope()
    {
      return scope;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.milestone.UpsightMilestoneEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */