package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer;
import com.upsight.android.marketing.UpsightReward;
import java.io.IOException;
import org.json.JSONObject;

public final class Reward
  implements UpsightReward
{
  @JsonProperty("product")
  String product;
  @JsonProperty("quantity")
  int quantity;
  @JsonProperty("signature_data")
  ObjectNode signatureData;
  
  static UpsightReward from(JsonNode paramJsonNode, ObjectMapper paramObjectMapper)
    throws IOException
  {
    return (UpsightReward)paramObjectMapper.treeToValue(paramJsonNode, Reward.class);
  }
  
  public String getProduct()
  {
    return product;
  }
  
  public int getQuantity()
  {
    return quantity;
  }
  
  public JSONObject getSignatureData()
  {
    return JacksonHelper.JSONObjectSerializer.fromObjectNode(signatureData);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.Reward
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */