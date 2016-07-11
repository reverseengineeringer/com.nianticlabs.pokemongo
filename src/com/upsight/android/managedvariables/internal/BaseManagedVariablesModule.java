package com.upsight.android.managedvariables.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.internal.type.ManagedVariableManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Module
public final class BaseManagedVariablesModule
{
  public static final String SCHEDULER_MAIN = "main";
  private final UpsightContext mUpsight;
  
  public BaseManagedVariablesModule(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  @Provides
  @Named("main")
  @Singleton
  Scheduler provideMainScheduler()
  {
    return AndroidSchedulers.mainThread();
  }
  
  @Provides
  @Singleton
  UpsightManagedVariablesApi provideManagedVariablesApi(ManagedVariableManager paramManagedVariableManager, UpsightUserExperience paramUpsightUserExperience)
  {
    return new ManagedVariables(paramManagedVariableManager, paramUpsightUserExperience);
  }
  
  @Provides
  @Singleton
  UpsightContext provideUpsightContext()
  {
    return mUpsight;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.BaseManagedVariablesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */