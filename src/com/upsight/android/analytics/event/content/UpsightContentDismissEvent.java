package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.content.dismiss")
public class UpsightContentDismissEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightContentDismissEvent() {}
  
  protected UpsightContentDismissEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(String paramString1, Integer paramInteger, String paramString2)
  {
    return new Builder(paramString1, paramInteger, paramString2);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightContentDismissEvent, UpsightContentDismissEvent.UpsightData>
  {
    private String action;
    private Integer contentId;
    private String scope;
    private String streamId;
    private String streamStartTs;
    
    protected Builder(String paramString1, Integer paramInteger, String paramString2)
    {
      streamId = paramString1;
      contentId = paramInteger;
      action = paramString2;
    }
    
    protected UpsightContentDismissEvent build()
    {
      return new UpsightContentDismissEvent("upsight.content.dismiss", new UpsightContentDismissEvent.UpsightData(this), mPublisherDataBuilder.build());
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
    @JsonProperty("action")
    String action;
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
    
    protected UpsightData(UpsightContentDismissEvent.Builder paramBuilder)
    {
      action = action;
      scope = scope;
      contentId = contentId;
      streamStartTs = streamStartTs;
      streamId = streamId;
    }
    
    public String getAction()
    {
      return action;
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
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentDismissEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */