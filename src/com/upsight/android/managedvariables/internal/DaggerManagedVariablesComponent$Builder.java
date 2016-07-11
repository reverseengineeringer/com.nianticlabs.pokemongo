package com.upsight.android.managedvariables.internal;

import com.upsight.android.managedvariables.internal.experience.UserExperienceModule;
import com.upsight.android.managedvariables.internal.type.UxmModule;

public final class DaggerManagedVariablesComponent$Builder
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

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.DaggerManagedVariablesComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */