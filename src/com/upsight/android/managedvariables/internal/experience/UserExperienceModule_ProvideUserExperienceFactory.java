package com.upsight.android.managedvariables.internal.experience;

import com.upsight.android.UpsightContext;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UserExperienceModule_ProvideUserExperienceFactory
  implements Factory<UpsightUserExperience>
{
  private final UserExperienceModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!UserExperienceModule_ProvideUserExperienceFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UserExperienceModule_ProvideUserExperienceFactory(UserExperienceModule paramUserExperienceModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramUserExperienceModule != null);
    module = paramUserExperienceModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<UpsightUserExperience> create(UserExperienceModule paramUserExperienceModule, Provider<UpsightContext> paramProvider)
  {
    return new UserExperienceModule_ProvideUserExperienceFactory(paramUserExperienceModule, paramProvider);
  }
  
  public UpsightUserExperience get()
  {
    UpsightUserExperience localUpsightUserExperience = module.provideUserExperience((UpsightContext)upsightProvider.get());
    if (localUpsightUserExperience == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightUserExperience;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.experience.UserExperienceModule_ProvideUserExperienceFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */