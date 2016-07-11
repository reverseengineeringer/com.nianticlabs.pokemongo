package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;

final class FilteredBeanPropertyWriter$SingleView
  extends BeanPropertyWriter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final BeanPropertyWriter _delegate;
  protected final Class<?> _view;
  
  protected FilteredBeanPropertyWriter$SingleView(BeanPropertyWriter paramBeanPropertyWriter, Class<?> paramClass)
  {
    super(paramBeanPropertyWriter);
    _delegate = paramBeanPropertyWriter;
    _view = paramClass;
  }
  
  public void assignNullSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    _delegate.assignNullSerializer(paramJsonSerializer);
  }
  
  public void assignSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    _delegate.assignSerializer(paramJsonSerializer);
  }
  
  public SingleView rename(NameTransformer paramNameTransformer)
  {
    return new SingleView(_delegate.rename(paramNameTransformer), _view);
  }
  
  public void serializeAsElement(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Class localClass = paramSerializerProvider.getActiveView();
    if ((localClass == null) || (_view.isAssignableFrom(localClass)))
    {
      _delegate.serializeAsElement(paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _delegate.serializeAsPlaceholder(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Class localClass = paramSerializerProvider.getActiveView();
    if ((localClass == null) || (_view.isAssignableFrom(localClass)))
    {
      _delegate.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _delegate.serializeAsOmittedField(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter.SingleView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */