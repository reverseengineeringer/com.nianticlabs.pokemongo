package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedParameter
  extends AnnotatedMember
{
  private static final long serialVersionUID = 1L;
  protected final int _index;
  protected final AnnotatedWithParams _owner;
  protected final Type _type;
  
  public AnnotatedParameter(AnnotatedWithParams paramAnnotatedWithParams, Type paramType, AnnotationMap paramAnnotationMap, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (AnnotatedParameter)paramObject;
    } while ((_owner.equals(_owner)) && (_index == _index));
    return false;
  }
  
  public AnnotatedElement getAnnotated()
  {
    return null;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (_annotations == null) {
      return null;
    }
    return _annotations.get(paramClass);
  }
  
  public Class<?> getDeclaringClass()
  {
    return _owner.getDeclaringClass();
  }
  
  public Type getGenericType()
  {
    return _type;
  }
  
  public int getIndex()
  {
    return _index;
  }
  
  public Member getMember()
  {
    return _owner.getMember();
  }
  
  public int getModifiers()
  {
    return _owner.getModifiers();
  }
  
  public String getName()
  {
    return "";
  }
  
  public AnnotatedWithParams getOwner()
  {
    return _owner;
  }
  
  public Type getParameterType()
  {
    return _type;
  }
  
  public Class<?> getRawType()
  {
    if ((_type instanceof Class)) {
      return (Class)_type;
    }
    return TypeFactory.defaultInstance().constructType(_type).getRawClass();
  }
  
  public Object getValue(Object paramObject)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + getDeclaringClass().getName());
  }
  
  public int hashCode()
  {
    return _owner.hashCode() + _index;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + getDeclaringClass().getName());
  }
  
  public String toString()
  {
    return "[parameter #" + getIndex() + ", annotations: " + _annotations + "]";
  }
  
  public AnnotatedParameter withAnnotations(AnnotationMap paramAnnotationMap)
  {
    if (paramAnnotationMap == _annotations) {
      return this;
    }
    return _owner.replaceParameterAnnotations(_index, paramAnnotationMap);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedParameter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */