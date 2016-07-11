package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class StdArraySerializers$TypedPrimitiveArraySerializer<T>
  extends ArraySerializerBase<T>
{
  protected final TypeSerializer _valueTypeSerializer;
  
  protected StdArraySerializers$TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> paramTypedPrimitiveArraySerializer, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, Boolean paramBoolean)
  {
    super(paramTypedPrimitiveArraySerializer, paramBeanProperty, paramBoolean);
    _valueTypeSerializer = paramTypeSerializer;
  }
  
  protected StdArraySerializers$TypedPrimitiveArraySerializer(Class<T> paramClass)
  {
    super(paramClass);
    _valueTypeSerializer = null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdArraySerializers.TypedPrimitiveArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */