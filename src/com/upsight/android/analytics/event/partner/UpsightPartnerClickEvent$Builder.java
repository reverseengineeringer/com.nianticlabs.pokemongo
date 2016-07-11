package com.upsight.android.analytics.event.partner;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightPartnerClickEvent$Builder
  extends AnalyticsEvent.Builder<UpsightPartnerClickEvent, UpsightPartnerClickEvent.UpsightData>
{
  private Integer contentId;
  private Integer partnerId;
  private String partnerName;
  private String scope;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightPartnerClickEvent$Builder(Integer paramInteger1, String paramString1, String paramString2, Integer paramInteger2)
  {
    partnerId = paramInteger1;
    scope = paramString1;
    streamId = paramString2;
    contentId = paramInteger2;
  }
  
  protected UpsightPartnerClickEvent build()
  {
    return new UpsightPartnerClickEvent("upsight.partner.click", new UpsightPartnerClickEvent.UpsightData(this), mPublisherDataBuilder.build());
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.partner.UpsightPartnerClickEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */