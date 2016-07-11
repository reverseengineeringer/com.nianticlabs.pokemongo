package com.upsight.android.analytics.event.campaign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.campaign.impression")
public class UpsightCampaignImpressionEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightCampaignImpressionEvent() {}
  
  protected UpsightCampaignImpressionEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    return new Builder(paramString, paramInteger1, paramInteger2, paramInteger3);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightCampaignImpressionEvent, UpsightCampaignImpressionEvent.UpsightData>
  {
    private Integer adGameId;
    private Integer adTypeId;
    private Integer campaignId;
    private Integer contentId;
    private Integer contentTypeId;
    private Integer creativeId;
    private Integer ordinal;
    private String scope;
    private String streamId;
    private String streamStartTs;
    
    protected Builder(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
    {
      streamId = paramString;
      campaignId = paramInteger1;
      creativeId = paramInteger2;
      contentId = paramInteger3;
    }
    
    protected UpsightCampaignImpressionEvent build()
    {
      return new UpsightCampaignImpressionEvent("upsight.campaign.impression", new UpsightCampaignImpressionEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
    
    public Builder setAdGameId(Integer paramInteger)
    {
      adGameId = paramInteger;
      return this;
    }
    
    public Builder setAdTypeId(Integer paramInteger)
    {
      adTypeId = paramInteger;
      return this;
    }
    
    public Builder setContentTypeId(Integer paramInteger)
    {
      contentTypeId = paramInteger;
      return this;
    }
    
    public Builder setOrdinal(Integer paramInteger)
    {
      ordinal = paramInteger;
      return this;
    }
    
    public Builder setScope(String paramString)
    {
      scope = paramString;
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
    @JsonProperty("ad_game_id")
    Integer adGameId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ad_type_id")
    Integer adTypeId;
    @JsonProperty("campaign_id")
    Integer campaignId;
    @JsonProperty("content_id")
    Integer contentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("content_type_id")
    Integer contentTypeId;
    @JsonProperty("creative_id")
    Integer creativeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ordinal")
    Integer ordinal;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("scope")
    String scope;
    @JsonProperty("stream_id")
    String streamId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream_start_ts")
    String streamStartTs;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightCampaignImpressionEvent.Builder paramBuilder)
    {
      ordinal = ordinal;
      contentTypeId = contentTypeId;
      creativeId = creativeId;
      campaignId = campaignId;
      adTypeId = adTypeId;
      streamId = streamId;
      adGameId = adGameId;
      streamStartTs = streamStartTs;
      scope = scope;
      contentId = contentId;
    }
    
    public Integer getAdGameId()
    {
      return adGameId;
    }
    
    public Integer getAdTypeId()
    {
      return adTypeId;
    }
    
    public Integer getCampaignId()
    {
      return campaignId;
    }
    
    public Integer getContentId()
    {
      return contentId;
    }
    
    public Integer getContentTypeId()
    {
      return contentTypeId;
    }
    
    public Integer getCreativeId()
    {
      return creativeId;
    }
    
    public Integer getOrdinal()
    {
      return ordinal;
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
 * Qualified Name:     com.upsight.android.analytics.event.campaign.UpsightCampaignImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */