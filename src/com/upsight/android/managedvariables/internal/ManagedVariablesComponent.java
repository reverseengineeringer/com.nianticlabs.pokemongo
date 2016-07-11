package com.upsight.android.managedvariables.internal;

import com.upsight.android.managedvariables.UpsightManagedVariablesComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={ManagedVariablesModule.class})
@Singleton
public abstract interface ManagedVariablesComponent
  extends UpsightManagedVariablesComponent
{}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.ManagedVariablesComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */