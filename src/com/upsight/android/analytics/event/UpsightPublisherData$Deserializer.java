package com.upsight.android.analytics.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class UpsightPublisherData$Deserializer
  extends JsonDeserializer<UpsightPublisherData>
{
  public UpsightPublisherData deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return new UpsightPublisherData.Builder((ObjectNode)paramJsonParser.readValueAs(ObjectNode.class)).build();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightPublisherData.Deserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */