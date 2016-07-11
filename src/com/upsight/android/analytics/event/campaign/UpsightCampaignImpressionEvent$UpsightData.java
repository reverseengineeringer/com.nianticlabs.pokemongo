package com.upsight.android.analytics.event.campaign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightCampaignImpressionEvent$UpsightData
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
  
  protected UpsightCampaignImpressionEvent$UpsightData() {}
  
  protected UpsightCampaignImpressionEvent$UpsightData(UpsightCampaignImpressionEvent.Builder paramBuilder)
  {
    ordinal = UpsightCampaignImpressionEvent.Builder.access$000(paramBuilder);
    contentTypeId = UpsightCampaignImpressionEvent.Builder.access$100(paramBuilder);
    creativeId = UpsightCampaignImpressionEvent.Builder.access$200(paramBuilder);
    campaignId = UpsightCampaignImpressionEvent.Builder.access$300(paramBuilder);
    adTypeId = UpsightCampaignImpressionEvent.Builder.access$400(paramBuilder);
    streamId = UpsightCampaignImpressionEvent.Builder.access$500(paramBuilder);
    adGameId = UpsightCampaignImpressionEvent.Builder.access$600(paramBuilder);
    streamStartTs = UpsightCampaignImpressionEvent.Builder.access$700(paramBuilder);
    scope = UpsightCampaignImpressionEvent.Builder.access$800(paramBuilder);
    contentId = UpsightCampaignImpressionEvent.Builder.access$900(paramBuilder);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.campaign.UpsightCampaignImpressionEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */