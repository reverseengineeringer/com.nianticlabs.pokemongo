package com.unity3d.player;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class ReflectionHelper$1
  implements InvocationHandler
{
  ReflectionHelper$1(int paramInt, Class[] paramArrayOfClass) {}
  
  protected final void finalize()
  {
    try
    {
      ReflectionHelper.a(a);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    return ReflectionHelper.a(a, paramMethod.getName(), paramArrayOfObject);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.ReflectionHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */