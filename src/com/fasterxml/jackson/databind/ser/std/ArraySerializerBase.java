package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;

public abstract class ArraySerializerBase<T>
  extends ContainerSerializer<T>
  implements ContextualSerializer
{
  protected final BeanProperty _property;
  protected final Boolean _unwrapSingle;
  
  protected ArraySerializerBase(ArraySerializerBase<?> paramArraySerializerBase)
  {
    super(_handledType, false);
    _property = _property;
    _unwrapSingle = _unwrapSingle;
  }
  
  @Deprecated
  protected ArraySerializerBase(ArraySerializerBase<?> paramArraySerializerBase, BeanProperty paramBeanProperty)
  {
    super(_handledType, false);
    _property = paramBeanProperty;
    _unwrapSingle = _unwrapSingle;
  }
  
  protected ArraySerializerBase(ArraySerializerBase<?> paramArraySerializerBase, BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    super(_handledType, false);
    _property = paramBeanProperty;
    _unwrapSingle = paramBoolean;
  }
  
  protected ArraySerializerBase(Class<T> paramClass)
  {
    super(paramClass);
    _property = null;
    _unwrapSingle = null;
  }
  
  @Deprecated
  protected ArraySerializerBase(Class<T> paramClass, BeanProperty paramBeanProperty)
  {
    super(paramClass);
    _property = paramBeanProperty;
    _unwrapSingle = null;
  }
  
  public abstract JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, Boolean paramBoolean);
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = this;
    if (paramBeanProperty != null)
    {
      paramSerializerProvider = paramBeanProperty.findFormatOverrides(paramSerializerProvider.getAnnotationIntrospector());
      localObject = this;
      if (paramSerializerProvider != null)
      {
        paramSerializerProvider = paramSerializerProvider.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        localObject = this;
        if (paramSerializerProvider != _unwrapSingle) {
          localObject = _withResolved(paramBeanProperty, paramSerializerProvider);
        }
      }
    }
    return (JsonSerializer<?>)localObject;
  }
  
  public void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if (((_unwrapSingle == null) && (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || ((_unwrapSingle == Boolean.TRUE) && (hasSingleElement(paramT))))
    {
      serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray();
    paramJsonGenerator.setCurrentValue(paramT);
    serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  protected abstract void serializeContents(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  public final void serializeWithType(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    paramTypeSerializer.writeTypePrefixForArray(paramT, paramJsonGenerator);
    paramJsonGenerator.setCurrentValue(paramT);
    serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForArray(paramT, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */