package com.upsight.android.analytics.event.datacollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightDataCollectionEvent$UpsightData
{
  @JsonProperty("data_bundle")
  String dataBundle;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("format")
  String format;
  @JsonProperty("stream_id")
  String streamId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_start_ts")
  String streamStartTs;
  
  protected UpsightDataCollectionEvent$UpsightData() {}
  
  protected UpsightDataCollectionEvent$UpsightData(UpsightDataCollectionEvent.Builder paramBuilder)
  {
    streamStartTs = UpsightDataCollectionEvent.Builder.access$000(paramBuilder);
    streamId = UpsightDataCollectionEvent.Builder.access$100(paramBuilder);
    dataBundle = UpsightDataCollectionEvent.Builder.access$200(paramBuilder);
    format = UpsightDataCollectionEvent.Builder.access$300(paramBuilder);
  }
  
  public String getDataBundle()
  {
    return dataBundle;
  }
  
  public String getFormat()
  {
    return format;
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
 * Qualified Name:     com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */