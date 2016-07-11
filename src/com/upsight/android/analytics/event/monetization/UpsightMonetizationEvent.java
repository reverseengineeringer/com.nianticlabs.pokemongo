package com.upsight.android.analytics.event.monetization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.monetization")
public class UpsightMonetizationEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightMonetizationEvent() {}
  
  protected UpsightMonetizationEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(Double paramDouble, String paramString)
  {
    return new Builder(paramDouble, paramString);
  }
  
  public static class Builder
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
    
    protected Builder(Double paramDouble, String paramString)
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
  
  static class UpsightData
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
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightMonetizationEvent.Builder paramBuilder)
    {
      product = product;
      totalPrice = totalPrice;
      streamId = streamId;
      price = price;
      currency = currency;
      streamStartTs = streamStartTs;
      resolution = resolution;
      quantity = quantity;
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.monetization.UpsightMonetizationEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */