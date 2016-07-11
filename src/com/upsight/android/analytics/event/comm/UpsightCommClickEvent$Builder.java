package com.upsight.android.analytics.event.comm;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightCommClickEvent$Builder
  extends AnalyticsEvent.Builder<UpsightCommClickEvent, UpsightCommClickEvent.UpsightData>
{
  private Integer msgCampaignId;
  private Integer msgId;
  
  protected UpsightCommClickEvent$Builder(Integer paramInteger)
  {
    msgId = paramInteger;
  }
  
  protected UpsightCommClickEvent build()
  {
    return new UpsightCommClickEvent("upsight.comm.click", new UpsightCommClickEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setMsgCampaignId(Integer paramInteger)
  {
    msgCampaignId = paramInteger;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommClickEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */