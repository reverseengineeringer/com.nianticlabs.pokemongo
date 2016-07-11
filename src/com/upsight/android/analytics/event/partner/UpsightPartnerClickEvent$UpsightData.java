package com.upsight.android.analytics.event.partner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightPartnerClickEvent$UpsightData
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
  
  protected UpsightPartnerClickEvent$UpsightData() {}
  
  protected UpsightPartnerClickEvent$UpsightData(UpsightPartnerClickEvent.Builder paramBuilder)
  {
    partnerName = UpsightPartnerClickEvent.Builder.access$000(paramBuilder);
    streamId = UpsightPartnerClickEvent.Builder.access$100(paramBuilder);
    streamStartTs = UpsightPartnerClickEvent.Builder.access$200(paramBuilder);
    scope = UpsightPartnerClickEvent.Builder.access$300(paramBuilder);
    contentId = UpsightPartnerClickEvent.Builder.access$400(paramBuilder);
    partnerId = UpsightPartnerClickEvent.Builder.access$500(paramBuilder);
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
 * Qualified Name:     com.upsight.android.analytics.event.partner.UpsightPartnerClickEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */