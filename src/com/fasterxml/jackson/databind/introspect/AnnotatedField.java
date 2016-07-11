package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public final class AnnotatedField
  extends AnnotatedMember
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final transient Field _field;
  protected Serialization _serialization;
  
  public AnnotatedField(AnnotatedClass paramAnnotatedClass, Field paramField, AnnotationMap paramAnnotationMap)
  {
    super(paramAnnotatedClass, paramAnnotationMap);
    _field = paramField;
  }
  
  protected AnnotatedField(Serialization paramSerialization)
  {
    super(null, null);
    _field = null;
    _serialization = paramSerialization;
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
    } while (_field == _field);
    return false;
  }
  
  public Field getAnnotated()
  {
    return _field;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (_annotations == null) {
      return null;
    }
    return _annotations.get(paramClass);
  }
  
  public int getAnnotationCount()
  {
    return _annotations.size();
  }
  
  public Class<?> getDeclaringClass()
  {
    return _field.getDeclaringClass();
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName();
  }
  
  public Type getGenericType()
  {
    return _field.getGenericType();
  }
  
  public Member getMember()
  {
    return _field;
  }
  
  public int getModifiers()
  {
    return _field.getModifiers();
  }
  
  public String getName()
  {
    return _field.getName();
  }
  
  public Class<?> getRawType()
  {
    return _field.getType();
  }
  
  public Object getValue(Object paramObject)
    throws IllegalArgumentException
  {
    try
    {
      paramObject = _field.get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalArgumentException("Failed to getValue() for field " + getFullName() + ": " + ((IllegalAccessException)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    return _field.getName().hashCode();
  }
  
  public boolean isTransient()
  {
    return Modifier.isTransient(getModifiers());
  }
  
  Object readResolve()
  {
    Class localClass = _serialization.clazz;
    try
    {
      Object localObject = localClass.getDeclaredField(_serialization.name);
      if (!((Field)localObject).isAccessible()) {
        ClassUtil.checkAndFixAccess((Member)localObject);
      }
      localObject = new AnnotatedField(null, (Field)localObject, null);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Could not find method '" + _serialization.name + "' from Class '" + localClass.getName());
    }
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
    throws IllegalArgumentException
  {
    try
    {
      _field.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() for field " + getFullName() + ": " + ((IllegalAccessException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
  }
  
  public String toString()
  {
    return "[field " + getFullName() + "]";
  }
  
  public AnnotatedField withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedField(_context, _field, paramAnnotationMap);
  }
  
  Object writeReplace()
  {
    return new AnnotatedField(new Serialization(_field));
  }
  
  private static final class Serialization
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected Class<?> clazz;
    protected String name;
    
    public Serialization(Field paramField)
    {
      clazz = paramField.getDeclaringClass();
      name = paramField.getName();
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */