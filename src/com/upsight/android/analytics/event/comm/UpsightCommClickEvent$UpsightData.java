package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightCommClickEvent$UpsightData
{
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("msg_campaign_id")
  Integer msgCampaignId;
  @JsonProperty("msg_id")
  Integer msgId;
  
  protected UpsightCommClickEvent$UpsightData() {}
  
  protected UpsightCommClickEvent$UpsightData(UpsightCommClickEvent.Builder paramBuilder)
  {
    msgId = UpsightCommClickEvent.Builder.access$000(paramBuilder);
    msgCampaignId = UpsightCommClickEvent.Builder.access$100(paramBuilder);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommClickEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */