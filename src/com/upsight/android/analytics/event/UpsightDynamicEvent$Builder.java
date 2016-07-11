package com.upsight.android.analytics.event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;

public final class UpsightDynamicEvent$Builder
{
  private String identifiers;
  private JsonNode publisherData = JsonNodeFactory.instance.objectNode();
  private final String type;
  private JsonNode upsightData = JsonNodeFactory.instance.objectNode();
  
  private UpsightDynamicEvent$Builder(String paramString)
  {
    type = paramString;
  }
  
  private UpsightDynamicEvent build()
  {
    return new UpsightDynamicEvent(type, identifiers, upsightData, publisherData);
  }
  
  public Builder putPublisherData(JsonNode paramJsonNode)
  {
    publisherData = paramJsonNode.deepCopy();
    return this;
  }
  
  public Builder putUpsightData(JsonNode paramJsonNode)
  {
    upsightData = paramJsonNode.deepCopy();
    return this;
  }
  
  public final UpsightDynamicEvent record(UpsightContext paramUpsightContext)
  {
    UpsightDynamicEvent localUpsightDynamicEvent = build();
    ((UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics")).getApi().record(localUpsightDynamicEvent);
    return localUpsightDynamicEvent;
  }
  
  public Builder setDynamicIdentifiers(String paramString)
  {
    identifiers = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightDynamicEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */