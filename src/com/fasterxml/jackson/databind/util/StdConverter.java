package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class StdConverter<IN, OUT>
  implements Converter<IN, OUT>
{
  public abstract OUT convert(IN paramIN);
  
  public JavaType getInputType(TypeFactory paramTypeFactory)
  {
    paramTypeFactory = paramTypeFactory.findTypeParameters(getClass(), Converter.class);
    if ((paramTypeFactory == null) || (paramTypeFactory.length < 2)) {
      throw new IllegalStateException("Can not find OUT type parameter for Converter of type " + getClass().getName());
    }
    return paramTypeFactory[0];
  }
  
  public JavaType getOutputType(TypeFactory paramTypeFactory)
  {
    paramTypeFactory = paramTypeFactory.findTypeParameters(getClass(), Converter.class);
    if ((paramTypeFactory == null) || (paramTypeFactory.length < 2)) {
      throw new IllegalStateException("Can not find OUT type parameter for Converter of type " + getClass().getName());
    }
    return paramTypeFactory[1];
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.StdConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */