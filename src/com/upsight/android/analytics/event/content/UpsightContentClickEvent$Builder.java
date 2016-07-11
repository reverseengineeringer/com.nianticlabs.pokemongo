package com.upsight.android.analytics.event.content;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightContentClickEvent$Builder
  extends AnalyticsEvent.Builder<UpsightContentClickEvent, UpsightContentClickEvent.UpsightData>
{
  private Integer contentId;
  private String scope;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightContentClickEvent$Builder(String paramString, Integer paramInteger)
  {
    streamId = paramString;
    contentId = paramInteger;
  }
  
  protected UpsightContentClickEvent build()
  {
    return new UpsightContentClickEvent("upsight.content.click", new UpsightContentClickEvent.UpsightData(this), mPublisherDataBuilder.build());
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
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentClickEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */