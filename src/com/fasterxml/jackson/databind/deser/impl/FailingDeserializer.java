package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class FailingDeserializer
  extends StdDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  protected final String _message;
  
  public FailingDeserializer(String paramString)
  {
    super(Object.class);
    _message = paramString;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    throw paramDeserializationContext.mappingException(_message);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.FailingDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */