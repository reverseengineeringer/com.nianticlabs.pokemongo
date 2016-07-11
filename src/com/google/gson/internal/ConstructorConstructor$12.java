package com.google.gson.internal;

import java.lang.reflect.Type;

class ConstructorConstructor$12
  implements ObjectConstructor<T>
{
  private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
  
  ConstructorConstructor$12(ConstructorConstructor paramConstructorConstructor, Class paramClass, Type paramType) {}
  
  public T construct()
  {
    try
    {
      Object localObject = unsafeAllocator.newInstance(val$rawType);
      return (T)localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to invoke no-args constructor for " + val$type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */