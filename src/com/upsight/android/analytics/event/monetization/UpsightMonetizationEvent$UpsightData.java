package com.upsight.android.analytics.event.monetization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

class UpsightMonetizationEvent$UpsightData
{
  @JsonProperty("currency")
  String currency;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("price")
  Double price;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("product")
  String product;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("quantity")
  Integer quantity;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("resolution")
  String resolution;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_id")
  String streamId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_start_ts")
  String streamStartTs;
  @JsonProperty("total_price")
  Double totalPrice;
  
  protected UpsightMonetizationEvent$UpsightData() {}
  
  protected UpsightMonetizationEvent$UpsightData(UpsightMonetizationEvent.Builder paramBuilder)
  {
    product = UpsightMonetizationEvent.Builder.access$000(paramBuilder);
    totalPrice = UpsightMonetizationEvent.Builder.access$100(paramBuilder);
    streamId = UpsightMonetizationEvent.Builder.access$200(paramBuilder);
    price = UpsightMonetizationEvent.Builder.access$300(paramBuilder);
    currency = UpsightMonetizationEvent.Builder.access$400(paramBuilder);
    streamStartTs = UpsightMonetizationEvent.Builder.access$500(paramBuilder);
    resolution = UpsightMonetizationEvent.Builder.access$600(paramBuilder);
    quantity = UpsightMonetizationEvent.Builder.access$700(paramBuilder);
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public Double getPrice()
  {
    return price;
  }
  
  public String getProduct()
  {
    return product;
  }
  
  public Integer getQuantity()
  {
    return quantity;
  }
  
  public String getResolution()
  {
    return resolution;
  }
  
  public String getStreamId()
  {
    return streamId;
  }
  
  public String getStreamStartTs()
  {
    return streamStartTs;
  }
  
  public Double getTotalPrice()
  {
    return totalPrice;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.monetization.UpsightMonetizationEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */