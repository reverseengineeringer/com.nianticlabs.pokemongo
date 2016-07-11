package com.upsight.android.managedvariables.internal;

import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.internal.type.ManagedVariableManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BaseManagedVariablesModule_ProvideManagedVariablesApiFactory
  implements Factory<UpsightManagedVariablesApi>
{
  private final Provider<ManagedVariableManager> managedVariableManagerProvider;
  private final BaseManagedVariablesModule module;
  private final Provider<UpsightUserExperience> userExperienceProvider;
  
  static
  {
    if (!BaseManagedVariablesModule_ProvideManagedVariablesApiFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseManagedVariablesModule_ProvideManagedVariablesApiFactory(BaseManagedVariablesModule paramBaseManagedVariablesModule, Provider<ManagedVariableManager> paramProvider, Provider<UpsightUserExperience> paramProvider1)
  {
    assert (paramBaseManagedVariablesModule != null);
    module = paramBaseManagedVariablesModule;
    assert (paramProvider != null);
    managedVariableManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    userExperienceProvider = paramProvider1;
  }
  
  public static Factory<UpsightManagedVariablesApi> create(BaseManagedVariablesModule paramBaseManagedVariablesModule, Provider<ManagedVariableManager> paramProvider, Provider<UpsightUserExperience> paramProvider1)
  {
    return new BaseManagedVariablesModule_ProvideManagedVariablesApiFactory(paramBaseManagedVariablesModule, paramProvider, paramProvider1);
  }
  
  public UpsightManagedVariablesApi get()
  {
    UpsightManagedVariablesApi localUpsightManagedVariablesApi = module.provideManagedVariablesApi((ManagedVariableManager)managedVariableManagerProvider.get(), (UpsightUserExperience)userExperienceProvider.get());
    if (localUpsightManagedVariablesApi == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightManagedVariablesApi;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.BaseManagedVariablesModule_ProvideManagedVariablesApiFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */