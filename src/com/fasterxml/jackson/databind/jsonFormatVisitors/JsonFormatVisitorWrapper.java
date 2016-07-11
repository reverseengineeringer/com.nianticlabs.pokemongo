package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract interface JsonFormatVisitorWrapper
  extends JsonFormatVisitorWithSerializerProvider
{
  public abstract JsonAnyFormatVisitor expectAnyFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonArrayFormatVisitor expectArrayFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonBooleanFormatVisitor expectBooleanFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonIntegerFormatVisitor expectIntegerFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonMapFormatVisitor expectMapFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonNullFormatVisitor expectNullFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonNumberFormatVisitor expectNumberFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonObjectFormatVisitor expectObjectFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract JsonStringFormatVisitor expectStringFormat(JavaType paramJavaType)
    throws JsonMappingException;
  
  public static class Base
    implements JsonFormatVisitorWrapper
  {
    protected SerializerProvider _provider;
    
    public Base() {}
    
    public Base(SerializerProvider paramSerializerProvider)
    {
      _provider = paramSerializerProvider;
    }
    
    public JsonAnyFormatVisitor expectAnyFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonArrayFormatVisitor expectArrayFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonBooleanFormatVisitor expectBooleanFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonIntegerFormatVisitor expectIntegerFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonMapFormatVisitor expectMapFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonNullFormatVisitor expectNullFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonNumberFormatVisitor expectNumberFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonObjectFormatVisitor expectObjectFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonStringFormatVisitor expectStringFormat(JavaType paramJavaType)
      throws JsonMappingException
    {
      return null;
    }
    
    public SerializerProvider getProvider()
    {
      return _provider;
    }
    
    public void setProvider(SerializerProvider paramSerializerProvider)
    {
      _provider = paramSerializerProvider;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */