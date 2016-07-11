package com.upsight.android.managedvariables.internal.experience;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class UserExperienceModule
{
  @Provides
  @Singleton
  UpsightUserExperience provideUserExperience(UpsightContext paramUpsightContext)
  {
    return new UserExperience(paramUpsightContext.getCoreComponent().bus());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.experience.UserExperienceModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */