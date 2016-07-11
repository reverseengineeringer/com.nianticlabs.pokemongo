package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightException;
import com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener;
import rx.functions.Action1;

class ManagedVariableManager$4
  implements Action1<Throwable>
{
  ManagedVariableManager$4(ManagedVariableManager paramManagedVariableManager, UpsightManagedVariable.Listener paramListener) {}
  
  public void call(Throwable paramThrowable)
  {
    val$listener.onFailure(new UpsightException(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableManager.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */