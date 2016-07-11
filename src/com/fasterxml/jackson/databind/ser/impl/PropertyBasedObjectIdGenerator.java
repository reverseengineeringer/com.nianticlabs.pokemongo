package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

public class PropertyBasedObjectIdGenerator
  extends ObjectIdGenerators.PropertyGenerator
{
  private static final long serialVersionUID = 1L;
  protected final BeanPropertyWriter _property;
  
  public PropertyBasedObjectIdGenerator(ObjectIdInfo paramObjectIdInfo, BeanPropertyWriter paramBeanPropertyWriter)
  {
    this(paramObjectIdInfo.getScope(), paramBeanPropertyWriter);
  }
  
  protected PropertyBasedObjectIdGenerator(Class<?> paramClass, BeanPropertyWriter paramBeanPropertyWriter)
  {
    super(paramClass);
    _property = paramBeanPropertyWriter;
  }
  
  public boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObjectIdGenerator.getClass() == getClass())
    {
      paramObjectIdGenerator = (PropertyBasedObjectIdGenerator)paramObjectIdGenerator;
      bool1 = bool2;
      if (paramObjectIdGenerator.getScope() == _scope)
      {
        bool1 = bool2;
        if (_property == _property) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public ObjectIdGenerator<Object> forScope(Class<?> paramClass)
  {
    if (paramClass == _scope) {
      return this;
    }
    return new PropertyBasedObjectIdGenerator(paramClass, _property);
  }
  
  public Object generateId(Object paramObject)
  {
    try
    {
      paramObject = _property.get(paramObject);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      throw ((Throwable)paramObject);
    }
    catch (Exception paramObject)
    {
      throw new IllegalStateException("Problem accessing property '" + _property.getName() + "': " + ((Exception)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  public ObjectIdGenerator.IdKey key(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new ObjectIdGenerator.IdKey(getClass(), _scope, paramObject);
  }
  
  public ObjectIdGenerator<Object> newForSerialization(Object paramObject)
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */