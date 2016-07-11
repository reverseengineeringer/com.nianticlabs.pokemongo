package com.upsight.android.managedvariables.internal;

import dagger.internal.Factory;

public final class ResourceModule_ProvideUxmSchemaResourceFactory
  implements Factory<Integer>
{
  private final ResourceModule module;
  
  static
  {
    if (!ResourceModule_ProvideUxmSchemaResourceFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ResourceModule_ProvideUxmSchemaResourceFactory(ResourceModule paramResourceModule)
  {
    assert (paramResourceModule != null);
    module = paramResourceModule;
  }
  
  public static Factory<Integer> create(ResourceModule paramResourceModule)
  {
    return new ResourceModule_ProvideUxmSchemaResourceFactory(paramResourceModule);
  }
  
  public Integer get()
  {
    Integer localInteger = module.provideUxmSchemaResource();
    if (localInteger == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localInteger;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.ResourceModule_ProvideUxmSchemaResourceFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */