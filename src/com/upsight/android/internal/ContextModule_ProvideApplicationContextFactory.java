package com.upsight.android.internal;

import android.content.Context;
import dagger.internal.Factory;

public final class ContextModule_ProvideApplicationContextFactory
  implements Factory<Context>
{
  private final ContextModule module;
  
  static
  {
    if (!ContextModule_ProvideApplicationContextFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContextModule_ProvideApplicationContextFactory(ContextModule paramContextModule)
  {
    assert (paramContextModule != null);
    module = paramContextModule;
  }
  
  public static Factory<Context> create(ContextModule paramContextModule)
  {
    return new ContextModule_ProvideApplicationContextFactory(paramContextModule);
  }
  
  public Context get()
  {
    Context localContext = module.provideApplicationContext();
    if (localContext == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localContext;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ContextModule_ProvideApplicationContextFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */