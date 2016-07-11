package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

class UnwrappingBeanPropertyWriter$1
  extends JsonFormatVisitorWrapper.Base
{
  UnwrappingBeanPropertyWriter$1(UnwrappingBeanPropertyWriter paramUnwrappingBeanPropertyWriter, SerializerProvider paramSerializerProvider, JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
  {
    super(paramSerializerProvider);
  }
  
  public JsonObjectFormatVisitor expectObjectFormat(JavaType paramJavaType)
    throws JsonMappingException
  {
    return val$visitor;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */