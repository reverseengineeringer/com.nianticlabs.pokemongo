package com.upsight.android.analytics.event.install;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.install")
public class UpsightInstallEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightInstallEvent() {}
  
  protected UpsightInstallEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder()
  {
    return new Builder();
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightInstallEvent, UpsightInstallEvent.UpsightData>
  {
    private String referrer;
    private String sourceId;
    private String streamId;
    private String streamStartTs;
    
    protected UpsightInstallEvent build()
    {
      return new UpsightInstallEvent("upsight.install", new UpsightInstallEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
    
    public Builder setReferrer(String paramString)
    {
      referrer = paramString;
      return this;
    }
    
    public Builder setSourceId(String paramString)
    {
      sourceId = paramString;
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
    @JsonProperty("source_id")
    String sourceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_id")
    String streamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_start_ts")
    String streamStartTs;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightInstallEvent.Builder paramBuilder)
    {
      sourceId = sourceId;
      referrer = referrer;
      streamStartTs = streamStartTs;
      streamId = streamId;
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.install.UpsightInstallEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */