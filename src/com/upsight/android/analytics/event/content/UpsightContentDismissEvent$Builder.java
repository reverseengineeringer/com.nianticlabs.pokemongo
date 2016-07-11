package com.upsight.android.analytics.event.content;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightContentDismissEvent$Builder
  extends AnalyticsEvent.Builder<UpsightContentDismissEvent, UpsightContentDismissEvent.UpsightData>
{
  private String action;
  private Integer contentId;
  private String scope;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightContentDismissEvent$Builder(String paramString1, Integer paramInteger, String paramString2)
  {
    streamId = paramString1;
    contentId = paramInteger;
    action = paramString2;
  }
  
  protected UpsightContentDismissEvent build()
  {
    return new UpsightContentDismissEvent("upsight.content.dismiss", new UpsightContentDismissEvent.UpsightData(this), mPublisherDataBuilder.build());
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
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentDismissEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */