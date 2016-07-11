package com.upsight.android.managedvariables;

import com.upsight.android.UpsightExtension.BaseComponent;
import com.upsight.android.UpsightManagedVariablesExtension;
import com.upsight.android.managedvariables.internal.type.UxmSchema;

public abstract interface UpsightManagedVariablesComponent
  extends UpsightExtension.BaseComponent<UpsightManagedVariablesExtension>
{
  public abstract UxmSchema uxmSchema();
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.UpsightManagedVariablesComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */