package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.content.view")
public class UpsightContentViewEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightContentViewEvent() {}
  
  protected UpsightContentViewEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(String paramString, Integer paramInteger)
  {
    return new Builder(paramString, paramInteger);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightContentViewEvent, UpsightContentViewEvent.UpsightData>
  {
    private Integer contentId;
    private String scope;
    private String streamId;
    private String streamStartTs;
    
    protected Builder(String paramString, Integer paramInteger)
    {
      streamId = paramString;
      contentId = paramInteger;
    }
    
    protected UpsightContentViewEvent build()
    {
      return new UpsightContentViewEvent("upsight.content.view", new UpsightContentViewEvent.UpsightData(this), mPublisherDataBuilder.build());
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
  
  static class UpsightData
  {
    @JsonProperty("content_id")
    Integer contentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("scope")
    String scope;
    @JsonProperty("stream_id")
    String streamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_start_ts")
    String streamStartTs;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightContentViewEvent.Builder paramBuilder)
    {
      streamStartTs = streamStartTs;
      scope = scope;
      contentId = contentId;
      streamId = streamId;
    }
    
    public Integer getContentId()
    {
      return contentId;
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
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentViewEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */