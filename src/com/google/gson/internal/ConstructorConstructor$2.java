package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$2
  implements ObjectConstructor<T>
{
  ConstructorConstructor$2(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {}
  
  public T construct()
  {
    return (T)val$rawTypeCreator.createInstance(val$type);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */