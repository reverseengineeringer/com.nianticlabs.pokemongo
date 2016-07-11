package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract interface JsonObjectFormatVisitor
  extends JsonFormatVisitorWithSerializerProvider
{
  public abstract void optionalProperty(BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract void optionalProperty(String paramString, JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract void property(BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract void property(String paramString, JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException;
  
  public static class Base
    implements JsonObjectFormatVisitor
  {
    protected SerializerProvider _provider;
    
    public Base() {}
    
    public Base(SerializerProvider paramSerializerProvider)
    {
      _provider = paramSerializerProvider;
    }
    
    public SerializerProvider getProvider()
    {
      return _provider;
    }
    
    public void optionalProperty(BeanProperty paramBeanProperty)
      throws JsonMappingException
    {}
    
    public void optionalProperty(String paramString, JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
      throws JsonMappingException
    {}
    
    public void property(BeanProperty paramBeanProperty)
      throws JsonMappingException
    {}
    
    public void property(String paramString, JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
      throws JsonMappingException
    {}
    
    public void setProvider(SerializerProvider paramSerializerProvider)
    {
      _provider = paramSerializerProvider;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */