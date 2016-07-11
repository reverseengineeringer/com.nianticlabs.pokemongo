package com.upsight.android.managedvariables.internal.type;

import rx.functions.Func1;

class ManagedVariableManager$5
  implements Func1<ManagedVariableModel, Boolean>
{
  ManagedVariableManager$5(ManagedVariableManager paramManagedVariableManager, Class paramClass, String paramString) {}
  
  public Boolean call(ManagedVariableModel paramManagedVariableModel)
  {
    return Boolean.valueOf(access$200this$0).get(val$clazz, val$tag).tag.equals(paramManagedVariableModel.getTag()));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableManager.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */