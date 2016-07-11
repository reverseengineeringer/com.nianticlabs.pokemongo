package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public abstract class ContainerSerializer<T>
  extends StdSerializer<T>
{
  protected ContainerSerializer(JavaType paramJavaType)
  {
    super(paramJavaType);
  }
  
  protected ContainerSerializer(ContainerSerializer<?> paramContainerSerializer)
  {
    super(_handledType, false);
  }
  
  protected ContainerSerializer(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected ContainerSerializer(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  protected abstract ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer);
  
  public abstract JsonSerializer<?> getContentSerializer();
  
  public abstract JavaType getContentType();
  
  protected boolean hasContentTypeAnnotation(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    if (paramBeanProperty != null)
    {
      paramSerializerProvider = paramSerializerProvider.getAnnotationIntrospector();
      AnnotatedMember localAnnotatedMember = paramBeanProperty.getMember();
      if ((localAnnotatedMember != null) && (paramSerializerProvider != null) && (paramSerializerProvider.findSerializationContentType(localAnnotatedMember, paramBeanProperty.getType()) != null)) {
        return true;
      }
    }
    return false;
  }
  
  public abstract boolean hasSingleElement(T paramT);
  
  @Deprecated
  public boolean isEmpty(T paramT)
  {
    return isEmpty(null, paramT);
  }
  
  public ContainerSerializer<?> withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer == null) {
      return this;
    }
    return _withValueTypeSerializer(paramTypeSerializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.ContainerSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */