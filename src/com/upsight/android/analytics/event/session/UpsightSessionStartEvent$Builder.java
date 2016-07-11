package com.upsight.android.analytics.event.session;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightSessionStartEvent$Builder
  extends AnalyticsEvent.Builder<UpsightSessionStartEvent, UpsightSessionStartEvent.UpsightData>
{
  private String referrer;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightSessionStartEvent build()
  {
    return new UpsightSessionStartEvent("upsight.session.start", new UpsightSessionStartEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setReferrer(String paramString)
  {
    referrer = paramString;
    return this;
  }
  
  public Builder setStreamId(String paramString)
  {
    streamId = paramString;
    return this;
  }
  
  public Builder setStreamStartTs(String paramString)
  {
    streamStartTs = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.session.UpsightSessionStartEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */