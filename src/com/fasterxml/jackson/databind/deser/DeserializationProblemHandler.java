package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public abstract class DeserializationProblemHandler
{
  public boolean handleUnknownProperty(DeserializationContext paramDeserializationContext, JsonParser paramJsonParser, JsonDeserializer<?> paramJsonDeserializer, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DeserializationProblemHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */