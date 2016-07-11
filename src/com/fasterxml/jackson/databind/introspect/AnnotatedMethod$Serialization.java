package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Method;

final class AnnotatedMethod$Serialization
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Class<?>[] args;
  protected Class<?> clazz;
  protected String name;
  
  public AnnotatedMethod$Serialization(Method paramMethod)
  {
    clazz = paramMethod.getDeclaringClass();
    name = paramMethod.getName();
    args = paramMethod.getParameterTypes();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedMethod.Serialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */