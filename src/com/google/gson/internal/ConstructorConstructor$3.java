package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ConstructorConstructor$3
  implements ObjectConstructor<T>
{
  ConstructorConstructor$3(ConstructorConstructor paramConstructorConstructor, Constructor paramConstructor) {}
  
  public T construct()
  {
    try
    {
      Object localObject = val$constructor.newInstance(null);
      return (T)localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + val$constructor + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + val$constructor + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */