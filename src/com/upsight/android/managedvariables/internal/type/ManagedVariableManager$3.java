package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightException;
import com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener;
import java.util.Map;
import rx.functions.Action1;

class ManagedVariableManager$3
  implements Action1<ManagedVariableModel>
{
  ManagedVariableManager$3(ManagedVariableManager paramManagedVariableManager, String paramString, UpsightManagedVariable.Listener paramListener, Class paramClass) {}
  
  public void call(ManagedVariableModel paramManagedVariableModel)
  {
    for (;;)
    {
      synchronized (ManagedVariableManager.access$000(this$0))
      {
        ManagedVariable localManagedVariable = (ManagedVariable)ManagedVariableManager.access$000(this$0).get(val$tag);
        if (localManagedVariable != null)
        {
          val$listener.onSuccess(localManagedVariable);
          return;
        }
        paramManagedVariableModel = ManagedVariableManager.access$100(this$0, val$clazz, val$tag, paramManagedVariableModel);
        if (paramManagedVariableModel != null)
        {
          ManagedVariableManager.access$000(this$0).put(val$tag, paramManagedVariableModel);
          val$listener.onSuccess(paramManagedVariableModel);
        }
      }
      val$listener.onFailure(new UpsightException("Invalid managed variable tag", new Object[0]));
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */