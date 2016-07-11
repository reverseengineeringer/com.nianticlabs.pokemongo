package com.upsight.android.analytics.internal.action;

import java.util.HashMap;
import java.util.Map;

public class ActionableStore$DefaultImpl<T extends Actionable>
  implements ActionableStore<T>
{
  private Map<String, T> mMap = new HashMap();
  
  public T get(String paramString)
  {
    try
    {
      paramString = (Actionable)mMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean put(String paramString, T paramT)
  {
    try
    {
      mMap.put(paramString, paramT);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean remove(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/upsight/android/analytics/internal/action/ActionableStore$DefaultImpl:mMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 42 2 0
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +9 -> 23
    //   17: iconst_1
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	DefaultImpl
    //   0	33	1	paramString	String
    //   18	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.action.ActionableStore.DefaultImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */