package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.managedvariables.type.UpsightManagedFloat;
import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.managedvariables.type.UpsightManagedString;
import java.util.HashMap;

final class ManagedVariableManager$1
  extends HashMap<Class<? extends ManagedVariable>, Class<? extends ManagedVariableModel>>
{
  ManagedVariableManager$1()
  {
    put(UpsightManagedString.class, ManagedString.Model.class);
    put(UpsightManagedBoolean.class, ManagedBoolean.Model.class);
    put(UpsightManagedInt.class, ManagedInt.Model.class);
    put(UpsightManagedFloat.class, ManagedFloat.Model.class);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */