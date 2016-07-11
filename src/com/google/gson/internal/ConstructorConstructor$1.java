package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$1
  implements ObjectConstructor<T>
{
  ConstructorConstructor$1(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {}
  
  public T construct()
  {
    return (T)val$typeCreator.createInstance(val$type);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */