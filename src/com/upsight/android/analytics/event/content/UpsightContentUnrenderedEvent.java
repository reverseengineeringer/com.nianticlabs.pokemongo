package com.upsight.android.analytics.event.content;

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

@UpsightStorableType("upsight.content.unrendered")
public class UpsightContentUnrenderedEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightContentUnrenderedEvent() {}
  
  protected UpsightContentUnrenderedEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(JSONObject paramJSONObject)
  {
    return new Builder(paramJSONObject);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightContentUnrenderedEvent, UpsightContentUnrenderedEvent.UpsightData>
  {
    private Integer campaignId;
    private ObjectNode contentProvider;
    private String id;
    private String scope;
    private String streamId;
    private String streamStartTs;
    
    protected Builder(JSONObject paramJSONObject)
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
  
  static class UpsightData
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
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightContentUnrenderedEvent.Builder paramBuilder)
    {
      contentProvider = contentProvider;
      campaignId = campaignId;
      streamId = streamId;
      streamStartTs = streamStartTs;
      scope = scope;
      id = id;
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentUnrenderedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */