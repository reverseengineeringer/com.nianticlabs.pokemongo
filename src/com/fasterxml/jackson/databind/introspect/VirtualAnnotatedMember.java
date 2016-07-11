package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public class VirtualAnnotatedMember
  extends AnnotatedMember
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _declaringClass;
  protected final String _name;
  protected final Class<?> _rawType;
  
  public VirtualAnnotatedMember(AnnotatedClass paramAnnotatedClass, Class<?> paramClass1, String paramString, Class<?> paramClass2)
  {
    super(paramAnnotatedClass, null);
    _declaringClass = paramClass1;
    _rawType = paramClass2;
    _name = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (VirtualAnnotatedMember)paramObject;
    } while ((_declaringClass == _declaringClass) && (_name.equals(_name)));
    return false;
  }
  
  public Field getAnnotated()
  {
    return null;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return null;
  }
  
  public int getAnnotationCount()
  {
    return 0;
  }
  
  public Class<?> getDeclaringClass()
  {
    return _declaringClass;
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName();
  }
  
  public Type getGenericType()
  {
    return _rawType;
  }
  
  public Member getMember()
  {
    return null;
  }
  
  public int getModifiers()
  {
    return 0;
  }
  
  public String getName()
  {
    return _name;
  }
  
  public Class<?> getRawType()
  {
    return _rawType;
  }
  
  public Object getValue(Object paramObject)
    throws IllegalArgumentException
  {
    throw new IllegalArgumentException("Can not get virtual property '" + _name + "'");
  }
  
  public int hashCode()
  {
    return _name.hashCode();
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
    throws IllegalArgumentException
  {
    throw new IllegalArgumentException("Can not set virtual property '" + _name + "'");
  }
  
  public String toString()
  {
    return "[field " + getFullName() + "]";
  }
  
  public Annotated withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */