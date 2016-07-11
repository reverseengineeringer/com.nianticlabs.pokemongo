package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonMapFormatVisitor$Base
  implements JsonMapFormatVisitor
{
  protected SerializerProvider _provider;
  
  public JsonMapFormatVisitor$Base() {}
  
  public JsonMapFormatVisitor$Base(SerializerProvider paramSerializerProvider)
  {
    _provider = paramSerializerProvider;
  }
  
  public SerializerProvider getProvider()
  {
    return _provider;
  }
  
  public void keyFormat(JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException
  {}
  
  public void setProvider(SerializerProvider paramSerializerProvider)
  {
    _provider = paramSerializerProvider;
  }
  
  public void valueFormat(JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException
  {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */