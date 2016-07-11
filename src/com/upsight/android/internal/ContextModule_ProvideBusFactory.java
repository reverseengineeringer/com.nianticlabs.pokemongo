package com.upsight.android.internal;

import com.squareup.otto.Bus;
import dagger.internal.Factory;

public final class ContextModule_ProvideBusFactory
  implements Factory<Bus>
{
  private final ContextModule module;
  
  static
  {
    if (!ContextModule_ProvideBusFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContextModule_ProvideBusFactory(ContextModule paramContextModule)
  {
    assert (paramContextModule != null);
    module = paramContextModule;
  }
  
  public static Factory<Bus> create(ContextModule paramContextModule)
  {
    return new ContextModule_ProvideBusFactory(paramContextModule);
  }
  
  public Bus get()
  {
    Bus localBus = module.provideBus();
    if (localBus == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localBus;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ContextModule_ProvideBusFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */