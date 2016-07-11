package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightContext;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import dagger.internal.Factory;
import javax.inject.Provider;
import rx.Scheduler;

public final class UxmModule_ProvideUxmContentFactoryFactory
  implements Factory<UxmContentFactory>
{
  private final UxmModule module;
  private final Provider<Scheduler> schedulerProvider;
  private final Provider<UpsightContext> upsightProvider;
  private final Provider<UpsightUserExperience> userExperienceProvider;
  
  static
  {
    if (!UxmModule_ProvideUxmContentFactoryFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UxmModule_ProvideUxmContentFactoryFactory(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<Scheduler> paramProvider1, Provider<UpsightUserExperience> paramProvider2)
  {
    assert (paramUxmModule != null);
    module = paramUxmModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    schedulerProvider = paramProvider1;
    assert (paramProvider2 != null);
    userExperienceProvider = paramProvider2;
  }
  
  public static Factory<UxmContentFactory> create(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<Scheduler> paramProvider1, Provider<UpsightUserExperience> paramProvider2)
  {
    return new UxmModule_ProvideUxmContentFactoryFactory(paramUxmModule, paramProvider, paramProvider1, paramProvider2);
  }
  
  public UxmContentFactory get()
  {
    UxmContentFactory localUxmContentFactory = module.provideUxmContentFactory((UpsightContext)upsightProvider.get(), (Scheduler)schedulerProvider.get(), (UpsightUserExperience)userExperienceProvider.get());
    if (localUxmContentFactory == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUxmContentFactory;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmContentFactoryFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */