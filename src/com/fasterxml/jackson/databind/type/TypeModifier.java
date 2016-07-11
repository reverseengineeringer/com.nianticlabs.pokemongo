package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Type;

public abstract class TypeModifier
{
  public abstract JavaType modifyType(JavaType paramJavaType, Type paramType, TypeBindings paramTypeBindings, TypeFactory paramTypeFactory);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.TypeModifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */