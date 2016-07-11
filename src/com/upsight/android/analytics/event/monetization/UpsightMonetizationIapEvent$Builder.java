package com.upsight.android.analytics.event.monetization;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import org.json.JSONObject;

public class UpsightMonetizationIapEvent$Builder
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
  
  protected UpsightMonetizationIapEvent$Builder(String paramString1, JSONObject paramJSONObject, Double paramDouble1, Double paramDouble2, Integer paramInteger, String paramString2, String paramString3)
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.monetization.UpsightMonetizationIapEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */