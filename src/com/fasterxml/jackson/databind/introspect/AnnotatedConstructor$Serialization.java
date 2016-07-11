package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Constructor;

final class AnnotatedConstructor$Serialization
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Class<?>[] args;
  protected Class<?> clazz;
  
  public AnnotatedConstructor$Serialization(Constructor<?> paramConstructor)
  {
    clazz = paramConstructor.getDeclaringClass();
    args = paramConstructor.getParameterTypes();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedConstructor.Serialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */