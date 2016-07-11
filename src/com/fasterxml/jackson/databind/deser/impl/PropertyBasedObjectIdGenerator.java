package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

public class PropertyBasedObjectIdGenerator
  extends ObjectIdGenerators.PropertyGenerator
{
  private static final long serialVersionUID = 1L;
  
  public PropertyBasedObjectIdGenerator(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public ObjectIdGenerator<Object> forScope(Class<?> paramClass)
  {
    if (paramClass == _scope) {
      return this;
    }
    return new PropertyBasedObjectIdGenerator(paramClass);
  }
  
  public Object generateId(Object paramObject)
  {
    throw new UnsupportedOperationException();
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
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */