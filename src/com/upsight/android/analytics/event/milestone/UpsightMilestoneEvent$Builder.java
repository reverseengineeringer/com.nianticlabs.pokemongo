package com.upsight.android.analytics.event.milestone;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightMilestoneEvent$Builder
  extends AnalyticsEvent.Builder<UpsightMilestoneEvent, UpsightMilestoneEvent.UpsightData>
{
  private String scope;
  
  protected UpsightMilestoneEvent$Builder(String paramString)
  {
    scope = paramString;
  }
  
  protected UpsightMilestoneEvent build()
  {
    return new UpsightMilestoneEvent("upsight.milestone", new UpsightMilestoneEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.milestone.UpsightMilestoneEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */