package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public abstract interface Converter<IN, OUT>
{
  public abstract OUT convert(IN paramIN);
  
  public abstract JavaType getInputType(TypeFactory paramTypeFactory);
  
  public abstract JavaType getOutputType(TypeFactory paramTypeFactory);
  
  public static abstract class None
    implements Converter<Object, Object>
  {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */