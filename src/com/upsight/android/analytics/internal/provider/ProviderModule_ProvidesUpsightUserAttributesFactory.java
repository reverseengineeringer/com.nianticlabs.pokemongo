package com.upsight.android.analytics.internal.provider;

import com.upsight.android.analytics.provider.UpsightUserAttributes;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProviderModule_ProvidesUpsightUserAttributesFactory
  implements Factory<UpsightUserAttributes>
{
  private final ProviderModule module;
  private final Provider<UserAttributes> userAttributesProvider;
  
  static
  {
    if (!ProviderModule_ProvidesUpsightUserAttributesFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProviderModule_ProvidesUpsightUserAttributesFactory(ProviderModule paramProviderModule, Provider<UserAttributes> paramProvider)
  {
    assert (paramProviderModule != null);
    module = paramProviderModule;
    assert (paramProvider != null);
    userAttributesProvider = paramProvider;
  }
  
  public static Factory<UpsightUserAttributes> create(ProviderModule paramProviderModule, Provider<UserAttributes> paramProvider)
  {
    return new ProviderModule_ProvidesUpsightUserAttributesFactory(paramProviderModule, paramProvider);
  }
  
  public UpsightUserAttributes get()
  {
    UpsightUserAttributes localUpsightUserAttributes = module.providesUpsightUserAttributes((UserAttributes)userAttributesProvider.get());
    if (localUpsightUserAttributes == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightUserAttributes;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.ProviderModule_ProvidesUpsightUserAttributesFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */