package com.upsight.android.analytics.event.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightSessionStartEvent$UpsightData
{
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("referrer")
  String referrer;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_id")
  String streamId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_start_ts")
  String streamStartTs;
  
  protected UpsightSessionStartEvent$UpsightData() {}
  
  protected UpsightSessionStartEvent$UpsightData(UpsightSessionStartEvent.Builder paramBuilder)
  {
    streamStartTs = UpsightSessionStartEvent.Builder.access$000(paramBuilder);
    referrer = UpsightSessionStartEvent.Builder.access$100(paramBuilder);
    streamId = UpsightSessionStartEvent.Builder.access$200(paramBuilder);
  }
  
  public String getReferrer()
  {
    return referrer;
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
 * Qualified Name:     com.upsight.android.analytics.event.session.UpsightSessionStartEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */