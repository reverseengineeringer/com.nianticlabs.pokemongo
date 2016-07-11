package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import org.json.JSONObject;

public class UpsightCommSendEvent$Builder
  extends AnalyticsEvent.Builder<UpsightCommSendEvent, UpsightCommSendEvent.UpsightData>
{
  private Integer msgCampaignId;
  private Integer msgId;
  private ObjectNode payload;
  private String token;
  
  protected UpsightCommSendEvent$Builder(Integer paramInteger, String paramString)
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommSendEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */