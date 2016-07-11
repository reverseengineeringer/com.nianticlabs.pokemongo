package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import org.json.JSONObject;

class UpsightContentUnrenderedEvent$UpsightData
{
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("campaign_id")
  Integer campaignId;
  @JsonProperty("content_provider")
  ObjectNode contentProvider;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("id")
  String id;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("scope")
  String scope;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_id")
  String streamId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_start_ts")
  String streamStartTs;
  
  protected UpsightContentUnrenderedEvent$UpsightData() {}
  
  protected UpsightContentUnrenderedEvent$UpsightData(UpsightContentUnrenderedEvent.Builder paramBuilder)
  {
    contentProvider = UpsightContentUnrenderedEvent.Builder.access$000(paramBuilder);
    campaignId = UpsightContentUnrenderedEvent.Builder.access$100(paramBuilder);
    streamId = UpsightContentUnrenderedEvent.Builder.access$200(paramBuilder);
    streamStartTs = UpsightContentUnrenderedEvent.Builder.access$300(paramBuilder);
    scope = UpsightContentUnrenderedEvent.Builder.access$400(paramBuilder);
    id = UpsightContentUnrenderedEvent.Builder.access$500(paramBuilder);
  }
  
  public Integer getCampaignId()
  {
    return campaignId;
  }
  
  public JSONObject getContentProvider()
  {
    return JacksonHelper.JSONObjectSerializer.fromObjectNode(contentProvider);
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getScope()
  {
    return scope;
  }
  
  public String getStreamId()
  {
    return streamId;
  }
  
  public String getStreamStartTs()
  {
    return streamStartTs;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentUnrenderedEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */