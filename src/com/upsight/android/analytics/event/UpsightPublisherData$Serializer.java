package com.upsight.android.analytics.event;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public final class UpsightPublisherData$Serializer
  extends JsonSerializer<UpsightPublisherData>
{
  public void serialize(UpsightPublisherData paramUpsightPublisherData, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramSerializerProvider.defaultSerializeValue(UpsightPublisherData.access$000(paramUpsightPublisherData), paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightPublisherData.Serializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */