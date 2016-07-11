package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import org.json.JSONObject;

public class UpsightContentUnrenderedEvent$Builder
  extends AnalyticsEvent.Builder<UpsightContentUnrenderedEvent, UpsightContentUnrenderedEvent.UpsightData>
{
  private Integer campaignId;
  private ObjectNode contentProvider;
  private String id;
  private String scope;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightContentUnrenderedEvent$Builder(JSONObject paramJSONObject)
  {
    contentProvider = JacksonHelper.JSONObjectSerializer.toObjectNode(paramJSONObject);
  }
  
  protected UpsightContentUnrenderedEvent build()
  {
    return new UpsightContentUnrenderedEvent("upsight.content.unrendered", new UpsightContentUnrenderedEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setCampaignId(Integer paramInteger)
  {
    campaignId = paramInteger;
    return this;
  }
  
  public Builder setId(String paramString)
  {
    id = paramString;
    return this;
  }
  
  public Builder setScope(String paramString)
  {
    scope = paramString;
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
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentUnrenderedEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */