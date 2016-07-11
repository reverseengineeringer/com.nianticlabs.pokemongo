package com.upsight.android.managedvariables;

import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import com.upsight.android.managedvariables.type.UpsightManagedVariable;
import com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener;
import com.upsight.android.persistence.UpsightSubscription;

public abstract interface UpsightManagedVariablesApi
{
  public abstract <T extends UpsightManagedVariable> T fetch(Class<T> paramClass, String paramString);
  
  public abstract <T extends UpsightManagedVariable> UpsightSubscription fetch(Class<T> paramClass, String paramString, UpsightManagedVariable.Listener<T> paramListener);
  
  public abstract void registerUserExperienceHandler(UpsightUserExperience.Handler paramHandler);
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.UpsightManagedVariablesApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */