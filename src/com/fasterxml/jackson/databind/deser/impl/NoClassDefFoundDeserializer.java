package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class NoClassDefFoundDeserializer<T>
  extends JsonDeserializer<T>
{
  private final NoClassDefFoundError _cause;
  
  public NoClassDefFoundDeserializer(NoClassDefFoundError paramNoClassDefFoundError)
  {
    _cause = paramNoClassDefFoundError;
  }
  
  public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    throw _cause;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.NoClassDefFoundDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */