package com.upsight.android.analytics.event.uxm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONArraySerializer;
import com.upsight.android.persistence.annotation.UpsightStorableType;
import org.json.JSONArray;

@UpsightStorableType("upsight.uxm.enumerate")
public class UpsightUxmEnumerateEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightUxmEnumerateEvent() {}
  
  protected UpsightUxmEnumerateEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder(JSONArray paramJSONArray)
  {
    return new Builder(paramJSONArray);
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightUxmEnumerateEvent, UpsightUxmEnumerateEvent.UpsightData>
  {
    private ArrayNode uxm;
    
    protected Builder(JSONArray paramJSONArray)
    {
      uxm = JacksonHelper.JSONArraySerializer.toArrayNode(paramJSONArray);
    }
    
    protected UpsightUxmEnumerateEvent build()
    {
      return new UpsightUxmEnumerateEvent("upsight.uxm.enumerate", new UpsightUxmEnumerateEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
  }
  
  static class UpsightData
  {
    @JsonProperty("uxm")
    ArrayNode uxm;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightUxmEnumerateEvent.Builder paramBuilder)
    {
      uxm = uxm;
    }
    
    public JSONArray getUxm()
    {
      return JacksonHelper.JSONArraySerializer.fromArrayNode(uxm);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */