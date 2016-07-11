package com.upsight.android.googlepushservices.internal;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;

public final class PushModule_ProvideUpsightContextFactory
  implements Factory<UpsightContext>
{
  private final PushModule module;
  
  static
  {
    if (!PushModule_ProvideUpsightContextFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushModule_ProvideUpsightContextFactory(PushModule paramPushModule)
  {
    assert (paramPushModule != null);
    module = paramPushModule;
  }
  
  public static Factory<UpsightContext> create(PushModule paramPushModule)
  {
    return new PushModule_ProvideUpsightContextFactory(paramPushModule);
  }
  
  public UpsightContext get()
  {
    UpsightContext localUpsightContext = module.provideUpsightContext();
    if (localUpsightContext == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightContext;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushModule_ProvideUpsightContextFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */