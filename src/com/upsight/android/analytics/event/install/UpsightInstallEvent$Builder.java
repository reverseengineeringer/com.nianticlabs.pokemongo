package com.upsight.android.analytics.event.install;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightInstallEvent$Builder
  extends AnalyticsEvent.Builder<UpsightInstallEvent, UpsightInstallEvent.UpsightData>
{
  private String referrer;
  private String sourceId;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightInstallEvent build()
  {
    return new UpsightInstallEvent("upsight.install", new UpsightInstallEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setReferrer(String paramString)
  {
    referrer = paramString;
    return this;
  }
  
  public Builder setSourceId(String paramString)
  {
    sourceId = paramString;
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
 * Qualified Name:     com.upsight.android.analytics.event.install.UpsightInstallEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */