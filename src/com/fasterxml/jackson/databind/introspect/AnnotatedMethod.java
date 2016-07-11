package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class AnnotatedMethod
  extends AnnotatedWithParams
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final transient Method _method;
  protected Class<?>[] _paramClasses;
  protected Serialization _serialization;
  
  public AnnotatedMethod(AnnotatedClass paramAnnotatedClass, Method paramMethod, AnnotationMap paramAnnotationMap, AnnotationMap[] paramArrayOfAnnotationMap)
  {
    super(paramAnnotatedClass, paramAnnotationMap, paramArrayOfAnnotationMap);
    if (paramMethod == null) {
      throw new IllegalArgumentException("Can not construct AnnotatedMethod with null Method");
    }
    _method = paramMethod;
  }
  
  protected AnnotatedMethod(Serialization paramSerialization)
  {
    super(null, null, null);
    _method = null;
    _serialization = paramSerialization;
  }
  
  public final Object call()
    throws Exception
  {
    return _method.invoke(null, new Object[0]);
  }
  
  public final Object call(Object[] paramArrayOfObject)
    throws Exception
  {
    return _method.invoke(null, paramArrayOfObject);
  }
  
  public final Object call1(Object paramObject)
    throws Exception
  {
    return _method.invoke(null, new Object[] { paramObject });
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
    } while (_method == _method);
    return false;
  }
  
  public Method getAnnotated()
  {
    return _method;
  }
  
  public Class<?> getDeclaringClass()
  {
    return _method.getDeclaringClass();
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName() + "(" + getParameterCount() + " params)";
  }
  
  public Type getGenericParameterType(int paramInt)
  {
    Type[] arrayOfType = _method.getGenericParameterTypes();
    if (paramInt >= arrayOfType.length) {
      return null;
    }
    return arrayOfType[paramInt];
  }
  
  public Type[] getGenericParameterTypes()
  {
    return _method.getGenericParameterTypes();
  }
  
  public Type getGenericReturnType()
  {
    return _method.getGenericReturnType();
  }
  
  public Type getGenericType()
  {
    return _method.getGenericReturnType();
  }
  
  public Method getMember()
  {
    return _method;
  }
  
  public int getModifiers()
  {
    return _method.getModifiers();
  }
  
  public String getName()
  {
    return _method.getName();
  }
  
  public int getParameterCount()
  {
    return getRawParameterTypes().length;
  }
  
  public Class<?> getRawParameterType(int paramInt)
  {
    Class[] arrayOfClass = getRawParameterTypes();
    if (paramInt >= arrayOfClass.length) {
      return null;
    }
    return arrayOfClass[paramInt];
  }
  
  public Class<?>[] getRawParameterTypes()
  {
    if (_paramClasses == null) {
      _paramClasses = _method.getParameterTypes();
    }
    return _paramClasses;
  }
  
  public Class<?> getRawReturnType()
  {
    return _method.getReturnType();
  }
  
  public Class<?> getRawType()
  {
    return _method.getReturnType();
  }
  
  public JavaType getType(TypeBindings paramTypeBindings)
  {
    return getType(paramTypeBindings, _method.getTypeParameters());
  }
  
  public Object getValue(Object paramObject)
    throws IllegalArgumentException
  {
    try
    {
      paramObject = _method.invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + ((IllegalAccessException)paramObject).getMessage(), (Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + ((InvocationTargetException)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  public boolean hasReturnType()
  {
    Class localClass = getRawReturnType();
    return (localClass != Void.TYPE) && (localClass != Void.class);
  }
  
  public int hashCode()
  {
    return _method.getName().hashCode();
  }
  
  Object readResolve()
  {
    Class localClass = _serialization.clazz;
    try
    {
      Object localObject = localClass.getDeclaredMethod(_serialization.name, _serialization.args);
      if (!((Method)localObject).isAccessible()) {
        ClassUtil.checkAndFixAccess((Member)localObject);
      }
      localObject = new AnnotatedMethod(null, (Method)localObject, null, null);
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
      _method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + ((IllegalAccessException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
    catch (InvocationTargetException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + ((InvocationTargetException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
  }
  
  public String toString()
  {
    return "[method " + getFullName() + "]";
  }
  
  public AnnotatedMethod withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedMethod(_context, _method, paramAnnotationMap, _paramAnnotations);
  }
  
  public AnnotatedMethod withMethod(Method paramMethod)
  {
    return new AnnotatedMethod(_context, paramMethod, _annotations, _paramAnnotations);
  }
  
  Object writeReplace()
  {
    return new AnnotatedMethod(new Serialization(_method));
  }
  
  private static final class Serialization
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected Class<?>[] args;
    protected Class<?> clazz;
    protected String name;
    
    public Serialization(Method paramMethod)
    {
      clazz = paramMethod.getDeclaringClass();
      name = paramMethod.getName();
      args = paramMethod.getParameterTypes();
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */