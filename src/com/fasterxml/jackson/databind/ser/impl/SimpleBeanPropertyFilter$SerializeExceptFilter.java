package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class SimpleBeanPropertyFilter$SerializeExceptFilter
  extends SimpleBeanPropertyFilter
  implements Serializable
{
  static final SerializeExceptFilter INCLUDE_ALL = new SerializeExceptFilter();
  private static final long serialVersionUID = 1L;
  protected final Set<String> _propertiesToExclude;
  
  SimpleBeanPropertyFilter$SerializeExceptFilter()
  {
    _propertiesToExclude = Collections.emptySet();
  }
  
  public SimpleBeanPropertyFilter$SerializeExceptFilter(Set<String> paramSet)
  {
    _propertiesToExclude = paramSet;
  }
  
  protected boolean include(BeanPropertyWriter paramBeanPropertyWriter)
  {
    return !_propertiesToExclude.contains(paramBeanPropertyWriter.getName());
  }
  
  protected boolean include(PropertyWriter paramPropertyWriter)
  {
    return !_propertiesToExclude.contains(paramPropertyWriter.getName());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */