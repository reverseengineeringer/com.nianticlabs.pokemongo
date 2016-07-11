package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.marketing.UpsightPurchase;
import java.io.IOException;

public final class Purchase
  implements UpsightPurchase
{
  @JsonProperty("product")
  String product;
  @JsonProperty("quantity")
  int quantity;
  
  static UpsightPurchase from(JsonNode paramJsonNode, ObjectMapper paramObjectMapper)
    throws IOException
  {
    return (UpsightPurchase)paramObjectMapper.treeToValue(paramJsonNode, Purchase.class);
  }
  
  public String getProduct()
  {
    return product;
  }
  
  public int getQuantity()
  {
    return quantity;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.Purchase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */