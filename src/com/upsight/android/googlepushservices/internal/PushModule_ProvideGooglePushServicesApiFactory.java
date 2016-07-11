package com.upsight.android.googlepushservices.internal;

import com.upsight.android.googlepushservices.UpsightGooglePushServicesApi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PushModule_ProvideGooglePushServicesApiFactory
  implements Factory<UpsightGooglePushServicesApi>
{
  private final Provider<GooglePushServices> googlePushServicesProvider;
  private final PushModule module;
  
  static
  {
    if (!PushModule_ProvideGooglePushServicesApiFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushModule_ProvideGooglePushServicesApiFactory(PushModule paramPushModule, Provider<GooglePushServices> paramProvider)
  {
    assert (paramPushModule != null);
    module = paramPushModule;
    assert (paramProvider != null);
    googlePushServicesProvider = paramProvider;
  }
  
  public static Factory<UpsightGooglePushServicesApi> create(PushModule paramPushModule, Provider<GooglePushServices> paramProvider)
  {
    return new PushModule_ProvideGooglePushServicesApiFactory(paramPushModule, paramProvider);
  }
  
  public UpsightGooglePushServicesApi get()
  {
    UpsightGooglePushServicesApi localUpsightGooglePushServicesApi = module.provideGooglePushServicesApi((GooglePushServices)googlePushServicesProvider.get());
    if (localUpsightGooglePushServicesApi == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightGooglePushServicesApi;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushModule_ProvideGooglePushServicesApiFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */