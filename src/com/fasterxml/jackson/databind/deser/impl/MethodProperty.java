package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class MethodProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedMethod _annotated;
  protected final transient Method _setter;
  
  protected MethodProperty(MethodProperty paramMethodProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramMethodProperty, paramJsonDeserializer);
    _annotated = _annotated;
    _setter = _setter;
  }
  
  protected MethodProperty(MethodProperty paramMethodProperty, PropertyName paramPropertyName)
  {
    super(paramMethodProperty, paramPropertyName);
    _annotated = _annotated;
    _setter = _setter;
  }
  
  protected MethodProperty(MethodProperty paramMethodProperty, Method paramMethod)
  {
    super(paramMethodProperty);
    _annotated = _annotated;
    _setter = paramMethod;
  }
  
  public MethodProperty(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedMethod paramAnnotatedMethod)
  {
    super(paramBeanPropertyDefinition, paramJavaType, paramTypeDeserializer, paramAnnotations);
    _annotated = paramAnnotatedMethod;
    _setter = paramAnnotatedMethod.getAnnotated();
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    paramJsonParser = deserialize(paramJsonParser, paramDeserializationContext);
    try
    {
      _setter.invoke(paramObject, new Object[] { paramJsonParser });
      return;
    }
    catch (Exception paramDeserializationContext)
    {
      _throwAsIOE(paramDeserializationContext, paramJsonParser);
    }
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    paramJsonParser = deserialize(paramJsonParser, paramDeserializationContext);
    try
    {
      paramDeserializationContext = _setter.invoke(paramObject, new Object[] { paramJsonParser });
      if (paramDeserializationContext == null) {
        return paramObject;
      }
      return paramDeserializationContext;
    }
    catch (Exception paramDeserializationContext)
    {
      _throwAsIOE(paramDeserializationContext, paramJsonParser);
    }
    return null;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (_annotated == null) {
      return null;
    }
    return _annotated.getAnnotation(paramClass);
  }
  
  public AnnotatedMember getMember()
  {
    return _annotated;
  }
  
  Object readResolve()
  {
    return new MethodProperty(this, _annotated.getAnnotated());
  }
  
  public final void set(Object paramObject1, Object paramObject2)
    throws IOException
  {
    try
    {
      _setter.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      _throwAsIOE((Exception)paramObject1, paramObject2);
    }
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
    throws IOException
  {
    try
    {
      Object localObject = _setter.invoke(paramObject1, new Object[] { paramObject2 });
      if (localObject == null) {
        return paramObject1;
      }
      return localObject;
    }
    catch (Exception paramObject1)
    {
      _throwAsIOE((Exception)paramObject1, paramObject2);
    }
    return null;
  }
  
  public MethodProperty withName(PropertyName paramPropertyName)
  {
    return new MethodProperty(this, paramPropertyName);
  }
  
  public MethodProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new MethodProperty(this, paramJsonDeserializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.MethodProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */