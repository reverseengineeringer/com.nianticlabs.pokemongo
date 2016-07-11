package com.upsight.android.analytics.event.content;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightContentViewEvent$Builder
  extends AnalyticsEvent.Builder<UpsightContentViewEvent, UpsightContentViewEvent.UpsightData>
{
  private Integer contentId;
  private String scope;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightContentViewEvent$Builder(String paramString, Integer paramInteger)
  {
    streamId = paramString;
    contentId = paramInteger;
  }
  
  protected UpsightContentViewEvent build()
  {
    return new UpsightContentViewEvent("upsight.content.view", new UpsightContentViewEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setScope(String paramString)
  {
    scope = paramString;
    return this;
  }
  
  public Builder setStreamStartTs(String paramString)
  {
    streamStartTs = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */