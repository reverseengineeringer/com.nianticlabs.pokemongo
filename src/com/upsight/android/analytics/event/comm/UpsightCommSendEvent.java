package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import com.upsight.android.persistence.annotation.UpsightStorableType;
import org.json.JSONObject;

@UpsightStorableType("upsight.comm.send")
public class UpsightCommSendEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightCommSendEvent() {}
  
  protected UpsightCommSendEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(Integer paramInteger, String paramString)
  {
    return new Builder(paramInteger, paramString);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightCommSendEvent, UpsightCommSendEvent.UpsightData>
  {
    private Integer msgCampaignId;
    private Integer msgId;
    private ObjectNode payload;
    private String token;
    
    protected Builder(Integer paramInteger, String paramString)
    {
      msgId = paramInteger;
      token = paramString;
    }
    
    protected UpsightCommSendEvent build()
    {
      return new UpsightCommSendEvent("upsight.comm.send", new UpsightCommSendEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
    
    public Builder setMsgCampaignId(Integer paramInteger)
    {
      msgCampaignId = paramInteger;
      return this;
    }
    
    public Builder setPayload(JSONObject paramJSONObject)
    {
      payload = JacksonHelper.JSONObjectSerializer.toObjectNode(paramJSONObject);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("payload")
    ObjectNode payload;
    @JsonProperty("token")
    String token;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightCommSendEvent.Builder paramBuilder)
    {
      token = token;
      msgId = msgId;
      payload = payload;
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
    
    public JSONObject getPayload()
    {
      return JacksonHelper.JSONObjectSerializer.fromObjectNode(payload);
    }
    
    public String getToken()
    {
      return token;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommSendEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */