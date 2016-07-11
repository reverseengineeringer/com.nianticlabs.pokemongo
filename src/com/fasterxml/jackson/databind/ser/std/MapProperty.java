package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class MapProperty
  extends PropertyWriter
{
  protected Object _key;
  protected JsonSerializer<Object> _keySerializer;
  protected final BeanProperty _property;
  protected final TypeSerializer _typeSerializer;
  protected JsonSerializer<Object> _valueSerializer;
  
  @Deprecated
  public MapProperty(TypeSerializer paramTypeSerializer)
  {
    this(paramTypeSerializer, null);
  }
  
  public MapProperty(TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    _typeSerializer = paramTypeSerializer;
    _property = paramBeanProperty;
  }
  
  public void depositSchemaProperty(JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
    throws JsonMappingException
  {}
  
  @Deprecated
  public void depositSchemaProperty(ObjectNode paramObjectNode, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {}
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (_property == null) {
      return null;
    }
    return _property.getAnnotation(paramClass);
  }
  
  public <A extends Annotation> A getContextAnnotation(Class<A> paramClass)
  {
    if (_property == null) {
      return null;
    }
    return _property.getContextAnnotation(paramClass);
  }
  
  public PropertyName getFullName()
  {
    return new PropertyName(getName());
  }
  
  public String getName()
  {
    if ((_key instanceof String)) {
      return (String)_key;
    }
    return String.valueOf(_key);
  }
  
  public void reset(Object paramObject, JsonSerializer<Object> paramJsonSerializer1, JsonSerializer<Object> paramJsonSerializer2)
  {
    _key = paramObject;
    _keySerializer = paramJsonSerializer1;
    _valueSerializer = paramJsonSerializer2;
  }
  
  public void serializeAsElement(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    if (_typeSerializer == null)
    {
      _valueSerializer.serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _valueSerializer.serializeWithType(paramObject, paramJsonGenerator, paramSerializerProvider, _typeSerializer);
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    _keySerializer.serialize(_key, paramJsonGenerator, paramSerializerProvider);
    if (_typeSerializer == null)
    {
      _valueSerializer.serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _valueSerializer.serializeWithType(paramObject, paramJsonGenerator, paramSerializerProvider, _typeSerializer);
  }
  
  public void serializeAsOmittedField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    if (!paramJsonGenerator.canOmitFields()) {
      paramJsonGenerator.writeOmittedField(getName());
    }
  }
  
  public void serializeAsPlaceholder(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    paramJsonGenerator.writeNull();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.MapProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */