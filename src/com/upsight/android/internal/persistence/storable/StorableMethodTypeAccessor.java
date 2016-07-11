package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class StorableMethodTypeAccessor<T>
  implements StorableTypeAccessor<T>
{
  private final Method mMethod;
  
  public StorableMethodTypeAccessor(Method paramMethod)
  {
    mMethod = paramMethod;
  }
  
  public String getType()
    throws UpsightException
  {
    return null;
  }
  
  public String getType(T paramT)
    throws UpsightException
  {
    try
    {
      paramT = (String)mMethod.invoke(paramT, new Object[0]);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      throw new UpsightException(paramT);
    }
    catch (InvocationTargetException paramT)
    {
      for (;;) {}
    }
  }
  
  public boolean isDynamic()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableMethodTypeAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */