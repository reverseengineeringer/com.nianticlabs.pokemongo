package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
final class StdKeyDeserializer$StringKD
  extends StdKeyDeserializer
{
  private static final StringKD sObject = new StringKD(Object.class);
  private static final StringKD sString = new StringKD(String.class);
  private static final long serialVersionUID = 1L;
  
  private StdKeyDeserializer$StringKD(Class<?> paramClass)
  {
    super(-1, paramClass);
  }
  
  public static StringKD forType(Class<?> paramClass)
  {
    if (paramClass == String.class) {
      return sString;
    }
    if (paramClass == Object.class) {
      return sObject;
    }
    return new StringKD(paramClass);
  }
  
  public Object deserializeKey(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    return paramString;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringKD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */