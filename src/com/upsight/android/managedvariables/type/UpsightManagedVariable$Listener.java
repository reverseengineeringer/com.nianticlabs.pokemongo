package com.upsight.android.managedvariables.type;

import com.upsight.android.UpsightException;

public abstract interface UpsightManagedVariable$Listener<T>
{
  public abstract void onFailure(UpsightException paramUpsightException);
  
  public abstract void onSuccess(T paramT);
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */