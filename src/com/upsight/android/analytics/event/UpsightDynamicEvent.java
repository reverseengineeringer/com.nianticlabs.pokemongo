package com.upsight.android.analytics.event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.analytics.internal.DynamicIdentifiers;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("com.upsight.dynamic")
public final class UpsightDynamicEvent
  extends UpsightAnalyticsEvent<JsonNode, JsonNode>
  implements DynamicIdentifiers
{
  private String identifiers;
  
  UpsightDynamicEvent() {}
  
  UpsightDynamicEvent(String paramString1, String paramString2, JsonNode paramJsonNode1, JsonNode paramJsonNode2)
  {
    super(paramString1, paramJsonNode1, paramJsonNode2);
    identifiers = paramString2;
  }
  
  public static Builder createBuilder(String paramString)
  {
    return new Builder(paramString, null);
  }
  
  public String getIdentifiersName()
  {
    return identifiers;
  }
  
  public static final class Builder
  {
    private String identifiers;
    private JsonNode publisherData = JsonNodeFactory.instance.objectNode();
    private final String type;
    private JsonNode upsightData = JsonNodeFactory.instance.objectNode();
    
    private Builder(String paramString)
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightDynamicEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */