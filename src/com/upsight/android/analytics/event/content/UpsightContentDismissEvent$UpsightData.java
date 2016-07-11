package com.upsight.android.analytics.event.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightContentDismissEvent$UpsightData
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
  
  protected UpsightContentDismissEvent$UpsightData() {}
  
  protected UpsightContentDismissEvent$UpsightData(UpsightContentDismissEvent.Builder paramBuilder)
  {
    action = UpsightContentDismissEvent.Builder.access$000(paramBuilder);
    scope = UpsightContentDismissEvent.Builder.access$100(paramBuilder);
    contentId = UpsightContentDismissEvent.Builder.access$200(paramBuilder);
    streamStartTs = UpsightContentDismissEvent.Builder.access$300(paramBuilder);
    streamId = UpsightContentDismissEvent.Builder.access$400(paramBuilder);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.content.UpsightContentDismissEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */