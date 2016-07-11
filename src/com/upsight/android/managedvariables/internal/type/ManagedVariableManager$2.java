package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener;
import rx.functions.Action1;

class ManagedVariableManager$2
  implements Action1<T>
{
  ManagedVariableManager$2(ManagedVariableManager paramManagedVariableManager, UpsightManagedVariable.Listener paramListener) {}
  
  public void call(T paramT)
  {
    val$listener.onSuccess(paramT);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */