package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.persistence.annotation.UpsightStorableType;

class ManagedBoolean
  extends UpsightManagedBoolean
{
  static final String MODEL_TYPE = "com.upsight.uxm.boolean";
  
  ManagedBoolean(String paramString, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    super(paramString, paramBoolean1, paramBoolean2);
  }
  
  @UpsightStorableType("com.upsight.uxm.boolean")
  static class Model
    extends ManagedVariableModel<Boolean>
  {}
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedBoolean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */