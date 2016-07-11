package com.upsight.android.analytics.event.session;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightSessionPauseEvent$Builder
  extends AnalyticsEvent.Builder<UpsightSessionPauseEvent, UpsightSessionPauseEvent.UpsightData>
{
  protected UpsightSessionPauseEvent build()
  {
    return new UpsightSessionPauseEvent("upsight.session.pause", new UpsightSessionPauseEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.session.UpsightSessionPauseEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */