package com.upsight.android.analytics.event.uxm;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.analytics.internal.util.JacksonHelper.JSONArraySerializer;
import org.json.JSONArray;

public class UpsightUxmEnumerateEvent$Builder
  extends AnalyticsEvent.Builder<UpsightUxmEnumerateEvent, UpsightUxmEnumerateEvent.UpsightData>
{
  private ArrayNode uxm;
  
  protected UpsightUxmEnumerateEvent$Builder(JSONArray paramJSONArray)
  {
    uxm = JacksonHelper.JSONArraySerializer.toArrayNode(paramJSONArray);
  }
  
  protected UpsightUxmEnumerateEvent build()
  {
    return new UpsightUxmEnumerateEvent("upsight.uxm.enumerate", new UpsightUxmEnumerateEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */