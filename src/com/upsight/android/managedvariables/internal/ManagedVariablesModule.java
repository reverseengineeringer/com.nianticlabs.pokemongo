package com.upsight.android.managedvariables.internal;

import com.upsight.android.managedvariables.internal.experience.UserExperienceModule;
import com.upsight.android.managedvariables.internal.type.UxmModule;
import dagger.Module;

@Module(includes={ResourceModule.class, UxmModule.class, UserExperienceModule.class, BaseManagedVariablesModule.class})
public class ManagedVariablesModule {}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.ManagedVariablesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */