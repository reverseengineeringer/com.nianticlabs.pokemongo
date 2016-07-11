package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.persistence.annotation.UpsightStorableType;

class ManagedInt
  extends UpsightManagedInt
{
  static final String MODEL_TYPE = "com.upsight.uxm.integer";
  
  ManagedInt(String paramString, Integer paramInteger1, Integer paramInteger2)
  {
    super(paramString, paramInteger1, paramInteger2);
  }
  
  @UpsightStorableType("com.upsight.uxm.integer")
  static class Model
    extends ManagedVariableModel<Integer>
  {}
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedInt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */