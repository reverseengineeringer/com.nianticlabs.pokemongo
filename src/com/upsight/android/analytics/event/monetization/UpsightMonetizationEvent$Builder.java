package com.upsight.android.analytics.event.monetization;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightMonetizationEvent$Builder
  extends AnalyticsEvent.Builder<UpsightMonetizationEvent, UpsightMonetizationEvent.UpsightData>
{
  private String currency;
  private Double price;
  private String product;
  private Integer quantity;
  private String resolution;
  private String streamId;
  private String streamStartTs;
  private Double totalPrice;
  
  protected UpsightMonetizationEvent$Builder(Double paramDouble, String paramString)
  {
    totalPrice = paramDouble;
    currency = paramString;
  }
  
  protected UpsightMonetizationEvent build()
  {
    return new UpsightMonetizationEvent("upsight.monetization", new UpsightMonetizationEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setPrice(Double paramDouble)
  {
    price = paramDouble;
    return this;
  }
  
  public Builder setProduct(String paramString)
  {
    product = paramString;
    return this;
  }
  
  public Builder setQuantity(Integer paramInteger)
  {
    quantity = paramInteger;
    return this;
  }
  
  public Builder setResolution(String paramString)
  {
    resolution = paramString;
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.monetization.UpsightMonetizationEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */