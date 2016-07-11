package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

public class AnyGetterWriter
{
  protected final AnnotatedMember _accessor;
  protected MapSerializer _mapSerializer;
  protected final BeanProperty _property;
  protected JsonSerializer<Object> _serializer;
  
  public AnyGetterWriter(BeanProperty paramBeanProperty, AnnotatedMember paramAnnotatedMember, JsonSerializer<?> paramJsonSerializer)
  {
    _accessor = paramAnnotatedMember;
    _property = paramBeanProperty;
    _serializer = paramJsonSerializer;
    if ((paramJsonSerializer instanceof MapSerializer)) {
      _mapSerializer = ((MapSerializer)paramJsonSerializer);
    }
  }
  
  public void getAndFilter(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, PropertyFilter paramPropertyFilter)
    throws Exception
  {
    paramObject = _accessor.getValue(paramObject);
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof Map)) {
      throw new JsonMappingException("Value returned by 'any-getter' (" + _accessor.getName() + "()) not java.util.Map but " + paramObject.getClass().getName());
    }
    if (_mapSerializer != null)
    {
      _mapSerializer.serializeFilteredFields((Map)paramObject, paramJsonGenerator, paramSerializerProvider, paramPropertyFilter, null);
      return;
    }
    _serializer.serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public void getAndSerialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    paramObject = _accessor.getValue(paramObject);
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof Map)) {
      throw new JsonMappingException("Value returned by 'any-getter' (" + _accessor.getName() + "()) not java.util.Map but " + paramObject.getClass().getName());
    }
    if (_mapSerializer != null)
    {
      _mapSerializer.serializeFields((Map)paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _serializer.serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    if ((_serializer instanceof ContextualSerializer))
    {
      paramSerializerProvider = paramSerializerProvider.handlePrimaryContextualization(_serializer, _property);
      _serializer = paramSerializerProvider;
      if ((paramSerializerProvider instanceof MapSerializer)) {
        _mapSerializer = ((MapSerializer)paramSerializerProvider);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.AnyGetterWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */