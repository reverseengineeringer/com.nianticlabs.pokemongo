package com.upsight.android.analytics.event.install;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightInstallEvent$UpsightData
{
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("referrer")
  String referrer;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("source_id")
  String sourceId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_id")
  String streamId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_start_ts")
  String streamStartTs;
  
  protected UpsightInstallEvent$UpsightData() {}
  
  protected UpsightInstallEvent$UpsightData(UpsightInstallEvent.Builder paramBuilder)
  {
    sourceId = UpsightInstallEvent.Builder.access$000(paramBuilder);
    referrer = UpsightInstallEvent.Builder.access$100(paramBuilder);
    streamStartTs = UpsightInstallEvent.Builder.access$200(paramBuilder);
    streamId = UpsightInstallEvent.Builder.access$300(paramBuilder);
  }
  
  public String getReferrer()
  {
    return referrer;
  }
  
  public String getSourceId()
  {
    return sourceId;
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
 * Qualified Name:     com.upsight.android.analytics.event.install.UpsightInstallEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */