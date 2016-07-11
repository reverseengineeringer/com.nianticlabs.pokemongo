package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDeserializer
  extends StdScalarDeserializer<AtomicBoolean>
{
  private static final long serialVersionUID = 1L;
  
  public AtomicBooleanDeserializer()
  {
    super(AtomicBoolean.class);
  }
  
  public AtomicBoolean deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return new AtomicBoolean(_parseBooleanPrimitive(paramJsonParser, paramDeserializationContext));
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */