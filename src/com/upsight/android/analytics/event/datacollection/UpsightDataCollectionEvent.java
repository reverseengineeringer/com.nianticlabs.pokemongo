package com.upsight.android.analytics.event.datacollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.data_collection")
public class UpsightDataCollectionEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightDataCollectionEvent() {}
  
  protected UpsightDataCollectionEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(String paramString1, String paramString2)
  {
    return new Builder(paramString1, paramString2);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightDataCollectionEvent, UpsightDataCollectionEvent.UpsightData>
  {
    private String dataBundle;
    private String format;
    private String streamId;
    private String streamStartTs;
    
    protected Builder(String paramString1, String paramString2)
    {
      dataBundle = paramString1;
      streamId = paramString2;
    }
    
    protected UpsightDataCollectionEvent build()
    {
      return new UpsightDataCollectionEvent("upsight.data_collection", new UpsightDataCollectionEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
    
    public Builder setFormat(String paramString)
    {
      format = paramString;
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
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightDataCollectionEvent.Builder paramBuilder)
    {
      streamStartTs = streamStartTs;
      streamId = streamId;
      dataBundle = dataBundle;
      format = format;
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */