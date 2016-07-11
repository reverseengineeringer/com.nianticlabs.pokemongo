package com.upsight.android.managedvariables.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightManagedVariablesExtension;
import com.upsight.android.UpsightManagedVariablesExtension_MembersInjector;
import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.internal.experience.UserExperienceModule;
import com.upsight.android.managedvariables.internal.experience.UserExperienceModule_ProvideUserExperienceFactory;
import com.upsight.android.managedvariables.internal.type.ManagedVariableManager;
import com.upsight.android.managedvariables.internal.type.UxmBlockProvider;
import com.upsight.android.managedvariables.internal.type.UxmContentFactory;
import com.upsight.android.managedvariables.internal.type.UxmModule;
import com.upsight.android.managedvariables.internal.type.UxmModule_ProvideManagedVariableManagerFactory;
import com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmBlockProviderFactory;
import com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmContentFactoryFactory;
import com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmSchemaFactory;
import com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmSchemaMapperFactory;
import com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmSchemaRawStringFactory;
import com.upsight.android.managedvariables.internal.type.UxmSchema;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.inject.Provider;
import rx.Scheduler;

public final class DaggerManagedVariablesComponent
  implements ManagedVariablesComponent
{
  private Provider<Scheduler> provideMainSchedulerProvider;
  private Provider<ManagedVariableManager> provideManagedVariableManagerProvider;
  private Provider<UpsightManagedVariablesApi> provideManagedVariablesApiProvider;
  private Provider<UpsightContext> provideUpsightContextProvider;
  private Provider<UpsightUserExperience> provideUserExperienceProvider;
  private Provider<UxmBlockProvider> provideUxmBlockProvider;
  private Provider<UxmContentFactory> provideUxmContentFactoryProvider;
  private Provider<ObjectMapper> provideUxmSchemaMapperProvider;
  private Provider<UxmSchema> provideUxmSchemaProvider;
  private Provider<String> provideUxmSchemaRawStringProvider;
  private Provider<Integer> provideUxmSchemaResourceProvider;
  private MembersInjector<UpsightManagedVariablesExtension> upsightManagedVariablesExtensionMembersInjector;
  
  static
  {
    if (!DaggerManagedVariablesComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerManagedVariablesComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Builder paramBuilder)
  {
    provideUpsightContextProvider = ScopedProvider.create(BaseManagedVariablesModule_ProvideUpsightContextFactory.create(baseManagedVariablesModule));
    provideMainSchedulerProvider = ScopedProvider.create(BaseManagedVariablesModule_ProvideMainSchedulerFactory.create(baseManagedVariablesModule));
    provideUxmSchemaMapperProvider = ScopedProvider.create(UxmModule_ProvideUxmSchemaMapperFactory.create(uxmModule, provideUpsightContextProvider));
    provideUxmSchemaResourceProvider = ScopedProvider.create(ResourceModule_ProvideUxmSchemaResourceFactory.create(resourceModule));
    provideUxmSchemaRawStringProvider = ScopedProvider.create(UxmModule_ProvideUxmSchemaRawStringFactory.create(uxmModule, provideUpsightContextProvider, provideUxmSchemaResourceProvider));
    provideUxmSchemaProvider = ScopedProvider.create(UxmModule_ProvideUxmSchemaFactory.create(uxmModule, provideUpsightContextProvider, provideUxmSchemaMapperProvider, provideUxmSchemaRawStringProvider));
    provideManagedVariableManagerProvider = ScopedProvider.create(UxmModule_ProvideManagedVariableManagerFactory.create(uxmModule, provideUpsightContextProvider, provideMainSchedulerProvider, provideUxmSchemaProvider));
    provideUserExperienceProvider = ScopedProvider.create(UserExperienceModule_ProvideUserExperienceFactory.create(userExperienceModule, provideUpsightContextProvider));
    provideManagedVariablesApiProvider = ScopedProvider.create(BaseManagedVariablesModule_ProvideManagedVariablesApiFactory.create(baseManagedVariablesModule, provideManagedVariableManagerProvider, provideUserExperienceProvider));
    provideUxmContentFactoryProvider = ScopedProvider.create(UxmModule_ProvideUxmContentFactoryFactory.create(uxmModule, provideUpsightContextProvider, provideMainSchedulerProvider, provideUserExperienceProvider));
    provideUxmBlockProvider = ScopedProvider.create(UxmModule_ProvideUxmBlockProviderFactory.create(uxmModule, provideUpsightContextProvider, provideUxmSchemaRawStringProvider, provideUxmSchemaProvider));
    upsightManagedVariablesExtensionMembersInjector = UpsightManagedVariablesExtension_MembersInjector.create(MembersInjectors.noOp(), provideManagedVariablesApiProvider, provideUxmContentFactoryProvider, provideUxmBlockProvider);
  }
  
  public void inject(UpsightManagedVariablesExtension paramUpsightManagedVariablesExtension)
  {
    upsightManagedVariablesExtensionMembersInjector.injectMembers(paramUpsightManagedVariablesExtension);
  }
  
  public UxmSchema uxmSchema()
  {
    return (UxmSchema)provideUxmSchemaProvider.get();
  }
  
  public static final class Builder
  {
    private BaseManagedVariablesModule baseManagedVariablesModule;
    private ManagedVariablesModule managedVariablesModule;
    private ResourceModule resourceModule;
    private UserExperienceModule userExperienceModule;
    private UxmModule uxmModule;
    
    public Builder baseManagedVariablesModule(BaseManagedVariablesModule paramBaseManagedVariablesModule)
    {
      if (paramBaseManagedVariablesModule == null) {
        throw new NullPointerException("baseManagedVariablesModule");
      }
      baseManagedVariablesModule = paramBaseManagedVariablesModule;
      return this;
    }
    
    public ManagedVariablesComponent build()
    {
      if (managedVariablesModule == null) {
        managedVariablesModule = new ManagedVariablesModule();
      }
      if (resourceModule == null) {
        resourceModule = new ResourceModule();
      }
      if (uxmModule == null) {
        uxmModule = new UxmModule();
      }
      if (userExperienceModule == null) {
        userExperienceModule = new UserExperienceModule();
      }
      if (baseManagedVariablesModule == null) {
        throw new IllegalStateException("baseManagedVariablesModule must be set");
      }
      return new DaggerManagedVariablesComponent(this, null);
    }
    
    public Builder managedVariablesModule(ManagedVariablesModule paramManagedVariablesModule)
    {
      if (paramManagedVariablesModule == null) {
        throw new NullPointerException("managedVariablesModule");
      }
      managedVariablesModule = paramManagedVariablesModule;
      return this;
    }
    
    public Builder resourceModule(ResourceModule paramResourceModule)
    {
      if (paramResourceModule == null) {
        throw new NullPointerException("resourceModule");
      }
      resourceModule = paramResourceModule;
      return this;
    }
    
    public Builder userExperienceModule(UserExperienceModule paramUserExperienceModule)
    {
      if (paramUserExperienceModule == null) {
        throw new NullPointerException("userExperienceModule");
      }
      userExperienceModule = paramUserExperienceModule;
      return this;
    }
    
    public Builder uxmModule(UxmModule paramUxmModule)
    {
      if (paramUxmModule == null) {
        throw new NullPointerException("uxmModule");
      }
      uxmModule = paramUxmModule;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.DaggerManagedVariablesComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */