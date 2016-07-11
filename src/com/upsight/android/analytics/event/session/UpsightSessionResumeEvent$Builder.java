package com.upsight.android.analytics.event.session;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightSessionResumeEvent$Builder
  extends AnalyticsEvent.Builder<UpsightSessionResumeEvent, UpsightSessionResumeEvent.UpsightData>
{
  protected UpsightSessionResumeEvent build()
  {
    return new UpsightSessionResumeEvent("upsight.session.resume", new UpsightSessionResumeEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.session.UpsightSessionResumeEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */