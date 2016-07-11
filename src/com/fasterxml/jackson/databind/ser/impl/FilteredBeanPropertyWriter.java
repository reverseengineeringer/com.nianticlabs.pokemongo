package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;

public abstract class FilteredBeanPropertyWriter
{
  public static BeanPropertyWriter constructViewBased(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass.length == 1) {
      return new SingleView(paramBeanPropertyWriter, paramArrayOfClass[0]);
    }
    return new MultiView(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  private static final class MultiView
    extends BeanPropertyWriter
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final BeanPropertyWriter _delegate;
    protected final Class<?>[] _views;
    
    protected MultiView(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
    {
      super();
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
  
  private static final class SingleView
    extends BeanPropertyWriter
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final BeanPropertyWriter _delegate;
    protected final Class<?> _view;
    
    protected SingleView(BeanPropertyWriter paramBeanPropertyWriter, Class<?> paramClass)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */