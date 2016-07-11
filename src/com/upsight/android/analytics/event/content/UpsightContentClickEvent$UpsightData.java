package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightContentClickEvent$UpsightData
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
  
  protected UpsightContentClickEvent$UpsightData() {}
  
  protected UpsightContentClickEvent$UpsightData(UpsightContentClickEvent.Builder paramBuilder)
  {
    streamStartTs = UpsightContentClickEvent.Builder.access$000(paramBuilder);
    scope = UpsightContentClickEvent.Builder.access$100(paramBuilder);
    contentId = UpsightContentClickEvent.Builder.access$200(paramBuilder);
    streamId = UpsightContentClickEvent.Builder.access$300(paramBuilder);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentClickEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */