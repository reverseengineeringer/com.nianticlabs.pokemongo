package com.upsight.android.analytics.event.config;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightConfigExpiredEvent$Builder
  extends AnalyticsEvent.Builder<UpsightConfigExpiredEvent, UpsightConfigExpiredEvent.UpsightData>
{
  protected UpsightConfigExpiredEvent build()
  {
    return new UpsightConfigExpiredEvent("upsight.config.expired", new UpsightConfigExpiredEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.config.UpsightConfigExpiredEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */