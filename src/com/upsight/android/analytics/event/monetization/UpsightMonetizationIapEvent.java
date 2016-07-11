package com.upsight.android.analytics.event.monetization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import com.upsight.android.persistence.annotation.UpsightStorableType;
import org.json.JSONObject;

@UpsightStorableType("upsight.monetization.iap")
public class UpsightMonetizationIapEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightMonetizationIapEvent() {}
  
  protected UpsightMonetizationIapEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(String paramString1, JSONObject paramJSONObject, Double paramDouble1, Double paramDouble2, Integer paramInteger, String paramString2, String paramString3)
  {
    return new Builder(paramString1, paramJSONObject, paramDouble1, paramDouble2, paramInteger, paramString2, paramString3);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightMonetizationIapEvent, UpsightMonetizationIapEvent.UpsightData>
  {
    private String currency;
    private ObjectNode iapBundle;
    private Double price;
    private String product;
    private Integer quantity;
    private String resolution;
    private String store;
    private String streamId;
    private String streamStartTs;
    private Double totalPrice;
    
    protected Builder(String paramString1, JSONObject paramJSONObject, Double paramDouble1, Double paramDouble2, Integer paramInteger, String paramString2, String paramString3)
    {
      store = paramString1;
      iapBundle = JacksonHelper.JSONObjectSerializer.toObjectNode(paramJSONObject);
      totalPrice = paramDouble1;
      price = paramDouble2;
      quantity = paramInteger;
      currency = paramString2;
      product = paramString3;
    }
    
    protected UpsightMonetizationIapEvent build()
    {
      return new UpsightMonetizationIapEvent("upsight.monetization.iap", new UpsightMonetizationIapEvent.UpsightData(this), mPublisherDataBuilder.build());
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
  
  static class UpsightData
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
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightMonetizationIapEvent.Builder paramBuilder)
    {
      product = product;
      totalPrice = totalPrice;
      streamId = streamId;
      price = price;
      currency = currency;
      iapBundle = iapBundle;
      streamStartTs = streamStartTs;
      resolution = resolution;
      store = store;
      quantity = quantity;
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.monetization.UpsightMonetizationIapEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */