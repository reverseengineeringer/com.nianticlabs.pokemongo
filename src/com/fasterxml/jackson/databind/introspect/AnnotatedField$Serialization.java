package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Field;

final class AnnotatedField$Serialization
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Class<?> clazz;
  protected String name;
  
  public AnnotatedField$Serialization(Field paramField)
  {
    clazz = paramField.getDeclaringClass();
    name = paramField.getName();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedField.Serialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */