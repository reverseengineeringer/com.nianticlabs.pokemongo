package com.upsight.android.googlepushservices.internal;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GoogleCloudMessagingModule_ProvideGoogleCloudMessagingFactory
  implements Factory<GoogleCloudMessaging>
{
  private final GoogleCloudMessagingModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!GoogleCloudMessagingModule_ProvideGoogleCloudMessagingFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GoogleCloudMessagingModule_ProvideGoogleCloudMessagingFactory(GoogleCloudMessagingModule paramGoogleCloudMessagingModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramGoogleCloudMessagingModule != null);
    module = paramGoogleCloudMessagingModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<GoogleCloudMessaging> create(GoogleCloudMessagingModule paramGoogleCloudMessagingModule, Provider<UpsightContext> paramProvider)
  {
    return new GoogleCloudMessagingModule_ProvideGoogleCloudMessagingFactory(paramGoogleCloudMessagingModule, paramProvider);
  }
  
  public GoogleCloudMessaging get()
  {
    GoogleCloudMessaging localGoogleCloudMessaging = module.provideGoogleCloudMessaging((UpsightContext)upsightProvider.get());
    if (localGoogleCloudMessaging == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localGoogleCloudMessaging;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GoogleCloudMessagingModule_ProvideGoogleCloudMessagingFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */