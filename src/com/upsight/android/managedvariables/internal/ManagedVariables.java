package com.upsight.android.managedvariables.internal;

import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import com.upsight.android.managedvariables.internal.type.ManagedVariableManager;
import com.upsight.android.managedvariables.type.UpsightManagedVariable;
import com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener;
import com.upsight.android.persistence.UpsightSubscription;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class ManagedVariables
  implements UpsightManagedVariablesApi
{
  private ManagedVariableManager mManagedVariableManager;
  private UpsightUserExperience mUserExperience;
  
  @Inject
  public ManagedVariables(ManagedVariableManager paramManagedVariableManager, UpsightUserExperience paramUpsightUserExperience)
  {
    mManagedVariableManager = paramManagedVariableManager;
    mUserExperience = paramUpsightUserExperience;
  }
  
  public <T extends UpsightManagedVariable> T fetch(Class<T> paramClass, String paramString)
  {
    return (UpsightManagedVariable)mManagedVariableManager.fetch(paramClass, paramString);
  }
  
  public <T extends UpsightManagedVariable> UpsightSubscription fetch(Class<T> paramClass, String paramString, UpsightManagedVariable.Listener<T> paramListener)
  {
    return mManagedVariableManager.fetch(paramClass, paramString, paramListener);
  }
  
  public void registerUserExperienceHandler(UpsightUserExperience.Handler paramHandler)
  {
    mUserExperience.registerHandler(paramHandler);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.ManagedVariables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */