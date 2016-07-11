package com.upsight.android.analytics.event.monetization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import org.json.JSONObject;

class UpsightMonetizationIapEvent$UpsightData
{
  @JsonProperty("currency")
  String currency;
  @JsonProperty("iap_bundle")
  ObjectNode iapBundle;
  @JsonProperty("price")
  Double price;
  @JsonProperty("product")
  String product;
  @JsonProperty("quantity")
  Integer quantity;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("resolution")
  String resolution;
  @JsonProperty("store")
  String store;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_id")
  String streamId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("stream_start_ts")
  String streamStartTs;
  @JsonProperty("total_price")
  Double totalPrice;
  
  protected UpsightMonetizationIapEvent$UpsightData() {}
  
  protected UpsightMonetizationIapEvent$UpsightData(UpsightMonetizationIapEvent.Builder paramBuilder)
  {
    product = UpsightMonetizationIapEvent.Builder.access$000(paramBuilder);
    totalPrice = UpsightMonetizationIapEvent.Builder.access$100(paramBuilder);
    streamId = UpsightMonetizationIapEvent.Builder.access$200(paramBuilder);
    price = UpsightMonetizationIapEvent.Builder.access$300(paramBuilder);
    currency = UpsightMonetizationIapEvent.Builder.access$400(paramBuilder);
    iapBundle = UpsightMonetizationIapEvent.Builder.access$500(paramBuilder);
    streamStartTs = UpsightMonetizationIapEvent.Builder.access$600(paramBuilder);
    resolution = UpsightMonetizationIapEvent.Builder.access$700(paramBuilder);
    store = UpsightMonetizationIapEvent.Builder.access$800(paramBuilder);
    quantity = UpsightMonetizationIapEvent.Builder.access$900(paramBuilder);
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public JSONObject getIapBundle()
  {
    return JacksonHelper.JSONObjectSerializer.fromObjectNode(iapBundle);
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
  
  public String getStore()
  {
    return store;
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
 * Qualified Name:     com.upsight.android.analytics.event.monetization.UpsightMonetizationIapEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */