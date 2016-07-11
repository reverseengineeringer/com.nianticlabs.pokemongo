package com.upsight.android.analytics.event.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.session.start")
public class UpsightSessionStartEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightSessionStartEvent() {}
  
  protected UpsightSessionStartEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder()
  {
    return new Builder();
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightSessionStartEvent, UpsightSessionStartEvent.UpsightData>
  {
    private String referrer;
    private String streamId;
    private String streamStartTs;
    
    protected UpsightSessionStartEvent build()
    {
      return new UpsightSessionStartEvent("upsight.session.start", new UpsightSessionStartEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
    
    public Builder setReferrer(String paramString)
    {
      referrer = paramString;
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
    @JsonProperty("referrer")
    String referrer;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_id")
    String streamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_start_ts")
    String streamStartTs;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightSessionStartEvent.Builder paramBuilder)
    {
      streamStartTs = streamStartTs;
      referrer = referrer;
      streamId = streamId;
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.session.UpsightSessionStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */