package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

public class NullifyingDeserializer
  extends StdDeserializer<Object>
{
  public static final NullifyingDeserializer instance = new NullifyingDeserializer();
  private static final long serialVersionUID = 1L;
  
  public NullifyingDeserializer()
  {
    super(Object.class);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    paramJsonParser.skipChildren();
    return null;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    switch (localJsonToken)
    {
    default: 
      return null;
    }
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */