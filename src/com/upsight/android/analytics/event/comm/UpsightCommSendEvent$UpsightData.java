package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import org.json.JSONObject;

class UpsightCommSendEvent$UpsightData
{
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("msg_campaign_id")
  Integer msgCampaignId;
  @JsonProperty("msg_id")
  Integer msgId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("payload")
  ObjectNode payload;
  @JsonProperty("token")
  String token;
  
  protected UpsightCommSendEvent$UpsightData() {}
  
  protected UpsightCommSendEvent$UpsightData(UpsightCommSendEvent.Builder paramBuilder)
  {
    token = UpsightCommSendEvent.Builder.access$000(paramBuilder);
    msgId = UpsightCommSendEvent.Builder.access$100(paramBuilder);
    payload = UpsightCommSendEvent.Builder.access$200(paramBuilder);
    msgCampaignId = UpsightCommSendEvent.Builder.access$300(paramBuilder);
  }
  
  public Integer getMsgCampaignId()
  {
    return msgCampaignId;
  }
  
  public Integer getMsgId()
  {
    return msgId;
  }
  
  public JSONObject getPayload()
  {
    return JacksonHelper.JSONObjectSerializer.fromObjectNode(payload);
  }
  
  public String getToken()
  {
    return token;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommSendEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */