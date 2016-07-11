package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedConstructor
  extends AnnotatedWithParams
{
  private static final long serialVersionUID = 1L;
  protected final Constructor<?> _constructor;
  protected Serialization _serialization;
  
  public AnnotatedConstructor(AnnotatedClass paramAnnotatedClass, Constructor<?> paramConstructor, AnnotationMap paramAnnotationMap, AnnotationMap[] paramArrayOfAnnotationMap)
  {
    super(paramAnnotatedClass, paramAnnotationMap, paramArrayOfAnnotationMap);
    if (paramConstructor == null) {
      throw new IllegalArgumentException("Null constructor not allowed");
    }
    _constructor = paramConstructor;
  }
  
  protected AnnotatedConstructor(Serialization paramSerialization)
  {
    super(null, null, null);
    _constructor = null;
    _serialization = paramSerialization;
  }
  
  public final Object call()
    throws Exception
  {
    return _constructor.newInstance(new Object[0]);
  }
  
  public final Object call(Object[] paramArrayOfObject)
    throws Exception
  {
    return _constructor.newInstance(paramArrayOfObject);
  }
  
  public final Object call1(Object paramObject)
    throws Exception
  {
    return _constructor.newInstance(new Object[] { paramObject });
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
    } while (_constructor == _constructor);
    return false;
  }
  
  public Constructor<?> getAnnotated()
  {
    return _constructor;
  }
  
  public Class<?> getDeclaringClass()
  {
    return _constructor.getDeclaringClass();
  }
  
  public Type getGenericParameterType(int paramInt)
  {
    Type[] arrayOfType = _constructor.getGenericParameterTypes();
    if (paramInt >= arrayOfType.length) {
      return null;
    }
    return arrayOfType[paramInt];
  }
  
  public Type getGenericType()
  {
    return getRawType();
  }
  
  public Member getMember()
  {
    return _constructor;
  }
  
  public int getModifiers()
  {
    return _constructor.getModifiers();
  }
  
  public String getName()
  {
    return _constructor.getName();
  }
  
  public int getParameterCount()
  {
    return _constructor.getParameterTypes().length;
  }
  
  public Class<?> getRawParameterType(int paramInt)
  {
    Class[] arrayOfClass = _constructor.getParameterTypes();
    if (paramInt >= arrayOfClass.length) {
      return null;
    }
    return arrayOfClass[paramInt];
  }
  
  public Class<?> getRawType()
  {
    return _constructor.getDeclaringClass();
  }
  
  public JavaType getType(TypeBindings paramTypeBindings)
  {
    return getType(paramTypeBindings, _constructor.getTypeParameters());
  }
  
  public Object getValue(Object paramObject)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + getDeclaringClass().getName());
  }
  
  public int hashCode()
  {
    return _constructor.getName().hashCode();
  }
  
  Object readResolve()
  {
    Class localClass = _serialization.clazz;
    try
    {
      Object localObject = localClass.getDeclaredConstructor(_serialization.args);
      if (!((Constructor)localObject).isAccessible()) {
        ClassUtil.checkAndFixAccess((Member)localObject);
      }
      localObject = new AnnotatedConstructor(null, (Constructor)localObject, null, null);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Could not find constructor with " + _serialization.args.length + " args from Class '" + localClass.getName());
    }
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + getDeclaringClass().getName());
  }
  
  public String toString()
  {
    return "[constructor for " + getName() + ", annotations: " + _annotations + "]";
  }
  
  public AnnotatedConstructor withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedConstructor(_context, _constructor, paramAnnotationMap, _paramAnnotations);
  }
  
  Object writeReplace()
  {
    return new AnnotatedConstructor(new Serialization(_constructor));
  }
  
  private static final class Serialization
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected Class<?>[] args;
    protected Class<?> clazz;
    
    public Serialization(Constructor<?> paramConstructor)
    {
      clazz = paramConstructor.getDeclaringClass();
      args = paramConstructor.getParameterTypes();
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */