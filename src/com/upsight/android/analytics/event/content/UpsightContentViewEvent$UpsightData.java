package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightContentViewEvent$UpsightData
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
  
  protected UpsightContentViewEvent$UpsightData() {}
  
  protected UpsightContentViewEvent$UpsightData(UpsightContentViewEvent.Builder paramBuilder)
  {
    streamStartTs = UpsightContentViewEvent.Builder.access$000(paramBuilder);
    scope = UpsightContentViewEvent.Builder.access$100(paramBuilder);
    contentId = UpsightContentViewEvent.Builder.access$200(paramBuilder);
    streamId = UpsightContentViewEvent.Builder.access$300(paramBuilder);
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
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentViewEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */