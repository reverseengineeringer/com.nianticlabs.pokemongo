package com.upsight.android.analytics.event.comm;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightCommUnregisterEvent$Builder
  extends AnalyticsEvent.Builder<UpsightCommUnregisterEvent, UpsightCommUnregisterEvent.UpsightData>
{
  protected UpsightCommUnregisterEvent build()
  {
    return new UpsightCommUnregisterEvent("upsight.comm.unregister", new UpsightCommUnregisterEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommUnregisterEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */