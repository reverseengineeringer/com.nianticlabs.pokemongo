package com.upsight.android.analytics.event.partner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightPartnerImpressionEvent$UpsightData
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
  
  protected UpsightPartnerImpressionEvent$UpsightData() {}
  
  protected UpsightPartnerImpressionEvent$UpsightData(UpsightPartnerImpressionEvent.Builder paramBuilder)
  {
    partnerName = UpsightPartnerImpressionEvent.Builder.access$000(paramBuilder);
    streamId = UpsightPartnerImpressionEvent.Builder.access$100(paramBuilder);
    streamStartTs = UpsightPartnerImpressionEvent.Builder.access$200(paramBuilder);
    scope = UpsightPartnerImpressionEvent.Builder.access$300(paramBuilder);
    contentId = UpsightPartnerImpressionEvent.Builder.access$400(paramBuilder);
    partnerId = UpsightPartnerImpressionEvent.Builder.access$500(paramBuilder);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.partner.UpsightPartnerImpressionEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */