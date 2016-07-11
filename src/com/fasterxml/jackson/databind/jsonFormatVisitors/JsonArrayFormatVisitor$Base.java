package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonArrayFormatVisitor$Base
  implements JsonArrayFormatVisitor
{
  protected SerializerProvider _provider;
  
  public JsonArrayFormatVisitor$Base() {}
  
  public JsonArrayFormatVisitor$Base(SerializerProvider paramSerializerProvider)
  {
    _provider = paramSerializerProvider;
  }
  
  public SerializerProvider getProvider()
  {
    return _provider;
  }
  
  public void itemsFormat(JsonFormatTypes paramJsonFormatTypes)
    throws JsonMappingException
  {}
  
  public void itemsFormat(JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException
  {}
  
  public void setProvider(SerializerProvider paramSerializerProvider)
  {
    _provider = paramSerializerProvider;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */