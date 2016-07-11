package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class ConstructorConstructor$5
  implements ObjectConstructor<T>
{
  ConstructorConstructor$5(ConstructorConstructor paramConstructorConstructor, Type paramType) {}
  
  public T construct()
  {
    if ((val$type instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)val$type).getActualTypeArguments()[0];
      if ((localType instanceof Class)) {
        return EnumSet.noneOf((Class)localType);
      }
      throw new JsonIOException("Invalid EnumSet type: " + val$type.toString());
    }
    throw new JsonIOException("Invalid EnumSet type: " + val$type.toString());
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */