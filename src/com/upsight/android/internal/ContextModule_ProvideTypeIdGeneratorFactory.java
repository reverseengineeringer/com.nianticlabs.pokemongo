package com.upsight.android.internal;

import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import dagger.internal.Factory;

public final class ContextModule_ProvideTypeIdGeneratorFactory
  implements Factory<StorableIdFactory>
{
  private final ContextModule module;
  
  static
  {
    if (!ContextModule_ProvideTypeIdGeneratorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContextModule_ProvideTypeIdGeneratorFactory(ContextModule paramContextModule)
  {
    assert (paramContextModule != null);
    module = paramContextModule;
  }
  
  public static Factory<StorableIdFactory> create(ContextModule paramContextModule)
  {
    return new ContextModule_ProvideTypeIdGeneratorFactory(paramContextModule);
  }
  
  public StorableIdFactory get()
  {
    StorableIdFactory localStorableIdFactory = module.provideTypeIdGenerator();
    if (localStorableIdFactory == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localStorableIdFactory;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ContextModule_ProvideTypeIdGeneratorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */