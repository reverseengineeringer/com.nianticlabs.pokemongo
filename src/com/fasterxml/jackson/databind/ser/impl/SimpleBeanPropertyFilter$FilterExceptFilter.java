package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.Serializable;
import java.util.Set;

public class SimpleBeanPropertyFilter$FilterExceptFilter
  extends SimpleBeanPropertyFilter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Set<String> _propertiesToInclude;
  
  public SimpleBeanPropertyFilter$FilterExceptFilter(Set<String> paramSet)
  {
    _propertiesToInclude = paramSet;
  }
  
  protected boolean include(BeanPropertyWriter paramBeanPropertyWriter)
  {
    return _propertiesToInclude.contains(paramBeanPropertyWriter.getName());
  }
  
  protected boolean include(PropertyWriter paramPropertyWriter)
  {
    return _propertiesToInclude.contains(paramPropertyWriter.getName());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.FilterExceptFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */