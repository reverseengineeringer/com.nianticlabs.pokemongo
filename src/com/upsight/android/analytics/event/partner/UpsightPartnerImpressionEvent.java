package com.upsight.android.analytics.event.partner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.partner.impression")
public class UpsightPartnerImpressionEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightPartnerImpressionEvent() {}
  
  protected UpsightPartnerImpressionEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(Integer paramInteger1, String paramString1, String paramString2, Integer paramInteger2)
  {
    return new Builder(paramInteger1, paramString1, paramString2, paramInteger2);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightPartnerImpressionEvent, UpsightPartnerImpressionEvent.UpsightData>
  {
    private Integer contentId;
    private Integer partnerId;
    private String partnerName;
    private String scope;
    private String streamId;
    private String streamStartTs;
    
    protected Builder(Integer paramInteger1, String paramString1, String paramString2, Integer paramInteger2)
    {
      partnerId = paramInteger1;
      scope = paramString1;
      streamId = paramString2;
      contentId = paramInteger2;
    }
    
    protected UpsightPartnerImpressionEvent build()
    {
      return new UpsightPartnerImpressionEvent("upsight.partner.impression", new UpsightPartnerImpressionEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
    
    public Builder setPartnerName(String paramString)
    {
      partnerName = paramString;
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
    @JsonProperty("content_id")
    Integer contentId;
    @JsonProperty("partner_id")
    Integer partnerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("partner_name")
    String partnerName;
    @JsonProperty("scope")
    String scope;
    @JsonProperty("stream_id")
    String streamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_start_ts")
    String streamStartTs;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightPartnerImpressionEvent.Builder paramBuilder)
    {
      partnerName = partnerName;
      streamId = streamId;
      streamStartTs = streamStartTs;
      scope = scope;
      contentId = contentId;
      partnerId = partnerId;
    }
    
    public Integer getContentId()
    {
      return contentId;
    }
    
    public Integer getPartnerId()
    {
      return partnerId;
    }
    
    public String getPartnerName()
    {
      return partnerName;
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
 * Qualified Name:     com.upsight.android.analytics.event.partner.UpsightPartnerImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */