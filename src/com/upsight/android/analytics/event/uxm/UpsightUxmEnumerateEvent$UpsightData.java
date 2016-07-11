package com.upsight.android.analytics.event.uxm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONArraySerializer;
import org.json.JSONArray;

class UpsightUxmEnumerateEvent$UpsightData
{
  @JsonProperty("uxm")
  ArrayNode uxm;
  
  protected UpsightUxmEnumerateEvent$UpsightData() {}
  
  protected UpsightUxmEnumerateEvent$UpsightData(UpsightUxmEnumerateEvent.Builder paramBuilder)
  {
    uxm = UpsightUxmEnumerateEvent.Builder.access$000(paramBuilder);
  }
  
  public JSONArray getUxm()
  {
    return JacksonHelper.JSONArraySerializer.fromArrayNode(uxm);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */