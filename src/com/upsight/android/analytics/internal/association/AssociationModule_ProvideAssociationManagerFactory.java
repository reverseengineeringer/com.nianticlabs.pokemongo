package com.upsight.android.analytics.internal.association;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.session.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AssociationModule_ProvideAssociationManagerFactory
  implements Factory<AssociationManager>
{
  private final Provider<Clock> clockProvider;
  private final AssociationModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!AssociationModule_ProvideAssociationManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AssociationModule_ProvideAssociationManagerFactory(AssociationModule paramAssociationModule, Provider<UpsightContext> paramProvider, Provider<Clock> paramProvider1)
  {
    assert (paramAssociationModule != null);
    module = paramAssociationModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    clockProvider = paramProvider1;
  }
  
  public static Factory<AssociationManager> create(AssociationModule paramAssociationModule, Provider<UpsightContext> paramProvider, Provider<Clock> paramProvider1)
  {
    return new AssociationModule_ProvideAssociationManagerFactory(paramAssociationModule, paramProvider, paramProvider1);
  }
  
  public AssociationManager get()
  {
    AssociationManager localAssociationManager = module.provideAssociationManager((UpsightContext)upsightProvider.get(), (Clock)clockProvider.get());
    if (localAssociationManager == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localAssociationManager;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.association.AssociationModule_ProvideAssociationManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */