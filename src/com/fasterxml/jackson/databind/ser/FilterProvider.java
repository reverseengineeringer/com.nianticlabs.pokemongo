package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public abstract class FilterProvider
{
  @Deprecated
  public abstract BeanPropertyFilter findFilter(Object paramObject);
  
  public PropertyFilter findPropertyFilter(Object paramObject1, Object paramObject2)
  {
    paramObject1 = findFilter(paramObject1);
    if (paramObject1 == null) {
      return null;
    }
    return SimpleBeanPropertyFilter.from((BeanPropertyFilter)paramObject1);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.FilterProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */