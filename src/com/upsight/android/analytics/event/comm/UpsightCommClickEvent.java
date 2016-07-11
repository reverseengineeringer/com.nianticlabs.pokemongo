package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.comm.click")
public class UpsightCommClickEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightCommClickEvent() {}
  
  protected UpsightCommClickEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(Integer paramInteger)
  {
    return new Builder(paramInteger);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightCommClickEvent, UpsightCommClickEvent.UpsightData>
  {
    private Integer msgCampaignId;
    private Integer msgId;
    
    protected Builder(Integer paramInteger)
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
  
  static class UpsightData
  {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("msg_campaign_id")
    Integer msgCampaignId;
    @JsonProperty("msg_id")
    Integer msgId;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightCommClickEvent.Builder paramBuilder)
    {
      msgId = msgId;
      msgCampaignId = msgCampaignId;
    }
    
    public Integer getMsgCampaignId()
    {
      return msgCampaignId;
    }
    
    public Integer getMsgId()
    {
      return msgId;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommClickEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */