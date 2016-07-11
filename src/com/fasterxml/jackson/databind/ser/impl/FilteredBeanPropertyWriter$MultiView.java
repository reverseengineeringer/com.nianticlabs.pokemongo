package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;

final class FilteredBeanPropertyWriter$MultiView
  extends BeanPropertyWriter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final BeanPropertyWriter _delegate;
  protected final Class<?>[] _views;
  
  protected FilteredBeanPropertyWriter$MultiView(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    super(paramBeanPropertyWriter);
    _delegate = paramBeanPropertyWriter;
    _views = paramArrayOfClass;
  }
  
  public void assignNullSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    _delegate.assignNullSerializer(paramJsonSerializer);
  }
  
  public void assignSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    _delegate.assignSerializer(paramJsonSerializer);
  }
  
  public MultiView rename(NameTransformer paramNameTransformer)
  {
    return new MultiView(_delegate.rename(paramNameTransformer), _views);
  }
  
  public void serializeAsElement(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Class localClass = paramSerializerProvider.getActiveView();
    if (localClass != null)
    {
      int i = 0;
      int j = _views.length;
      for (;;)
      {
        if ((i >= j) || (_views[i].isAssignableFrom(localClass)))
        {
          if (i != j) {
            break;
          }
          _delegate.serializeAsPlaceholder(paramObject, paramJsonGenerator, paramSerializerProvider);
          return;
        }
        i += 1;
      }
    }
    _delegate.serializeAsElement(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Class localClass = paramSerializerProvider.getActiveView();
    if (localClass != null)
    {
      int i = 0;
      int j = _views.length;
      for (;;)
      {
        if ((i >= j) || (_views[i].isAssignableFrom(localClass)))
        {
          if (i != j) {
            break;
          }
          _delegate.serializeAsOmittedField(paramObject, paramJsonGenerator, paramSerializerProvider);
          return;
        }
        i += 1;
      }
    }
    _delegate.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter.MultiView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */