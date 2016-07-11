package com.upsight.android.managedvariables.type;

import com.upsight.android.UpsightException;
import com.upsight.android.managedvariables.internal.type.ManagedVariable;
import com.upsight.android.persistence.UpsightSubscription;

public abstract class UpsightManagedVariable<T>
  extends ManagedVariable<T>
{
  protected UpsightManagedVariable(String paramString, T paramT1, T paramT2)
  {
    super(paramString, paramT1, paramT2);
  }
  
  public static abstract interface Listener<T>
  {
    public abstract void onFailure(UpsightException paramUpsightException);
    
    public abstract void onSuccess(T paramT);
  }
  
  protected static class NoOpSubscription
    implements UpsightSubscription
  {
    public boolean isSubscribed()
    {
      return false;
    }
    
    public void unsubscribe() {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.type.UpsightManagedVariable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */