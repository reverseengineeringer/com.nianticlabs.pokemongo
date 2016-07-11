package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class FieldProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedField _annotated;
  protected final transient Field _field;
  
  protected FieldProperty(FieldProperty paramFieldProperty)
  {
    super(paramFieldProperty);
    _annotated = _annotated;
    paramFieldProperty = _annotated.getAnnotated();
    if (paramFieldProperty == null) {
      throw new IllegalArgumentException("Missing field (broken JDK (de)serialization?)");
    }
    _field = paramFieldProperty;
  }
  
  protected FieldProperty(FieldProperty paramFieldProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramFieldProperty, paramJsonDeserializer);
    _annotated = _annotated;
    _field = _field;
  }
  
  protected FieldProperty(FieldProperty paramFieldProperty, PropertyName paramPropertyName)
  {
    super(paramFieldProperty, paramPropertyName);
    _annotated = _annotated;
    _field = _field;
  }
  
  public FieldProperty(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedField paramAnnotatedField)
  {
    super(paramBeanPropertyDefinition, paramJavaType, paramTypeDeserializer, paramAnnotations);
    _annotated = paramAnnotatedField;
    _field = paramAnnotatedField.getAnnotated();
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    paramJsonParser = deserialize(paramJsonParser, paramDeserializationContext);
    try
    {
      _field.set(paramObject, paramJsonParser);
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
      _field.set(paramObject, paramJsonParser);
      return paramObject;
    }
    catch (Exception paramDeserializationContext)
    {
      _throwAsIOE(paramDeserializationContext, paramJsonParser);
    }
    return paramObject;
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
    return new FieldProperty(this);
  }
  
  public final void set(Object paramObject1, Object paramObject2)
    throws IOException
  {
    try
    {
      _field.set(paramObject1, paramObject2);
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
      _field.set(paramObject1, paramObject2);
      return paramObject1;
    }
    catch (Exception localException)
    {
      _throwAsIOE(localException, paramObject2);
    }
    return paramObject1;
  }
  
  public FieldProperty withName(PropertyName paramPropertyName)
  {
    return new FieldProperty(this, paramPropertyName);
  }
  
  public FieldProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new FieldProperty(this, paramJsonDeserializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.FieldProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */