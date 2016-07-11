package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;

public abstract interface ValueInstantiators
{
  public abstract ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, ValueInstantiator paramValueInstantiator);
  
  public static class Base
    implements ValueInstantiators
  {
    public ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, ValueInstantiator paramValueInstantiator)
    {
      return paramValueInstantiator;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.ValueInstantiators
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */