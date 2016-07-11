package com.upsight.android.managedvariables.internal.type;

import java.util.Observable;

public abstract class ManagedVariable<T>
  extends Observable
{
  private T mDefaultValue;
  private String mTag;
  private T mValue;
  
  protected ManagedVariable(String paramString, T paramT1, T paramT2)
  {
    mTag = paramString;
    mDefaultValue = paramT1;
    if (paramT2 != null) {}
    for (;;)
    {
      mValue = paramT2;
      return;
      paramT2 = paramT1;
    }
  }
  
  public T get()
  {
    try
    {
      Object localObject1 = mValue;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  /* Error */
  void set(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 22	com/upsight/android/managedvariables/internal/type/ManagedVariable:mValue	Ljava/lang/Object;
    //   7: if_acmpeq +20 -> 27
    //   10: aload_1
    //   11: ifnull +19 -> 30
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 22	com/upsight/android/managedvariables/internal/type/ManagedVariable:mValue	Ljava/lang/Object;
    //   19: aload_0
    //   20: invokevirtual 35	com/upsight/android/managedvariables/internal/type/ManagedVariable:setChanged	()V
    //   23: aload_0
    //   24: invokevirtual 38	com/upsight/android/managedvariables/internal/type/ManagedVariable:notifyObservers	()V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 20	com/upsight/android/managedvariables/internal/type/ManagedVariable:mDefaultValue	Ljava/lang/Object;
    //   35: putfield 22	com/upsight/android/managedvariables/internal/type/ManagedVariable:mValue	Ljava/lang/Object;
    //   38: goto -19 -> 19
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	ManagedVariable
    //   0	46	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   2	10	41	finally
    //   14	19	41	finally
    //   19	27	41	finally
    //   30	38	41	finally
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */