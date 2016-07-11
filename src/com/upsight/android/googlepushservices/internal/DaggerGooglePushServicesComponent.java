package com.upsight.android.googlepushservices.internal;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightGooglePushServicesExtension;
import com.upsight.android.UpsightGooglePushServicesExtension_MembersInjector;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.googlepushservices.UpsightGooglePushServicesApi;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.inject.Provider;

public final class DaggerGooglePushServicesComponent
  implements GooglePushServicesComponent
{
  private Provider<GooglePushServices> googlePushServicesProvider;
  private Provider<GoogleCloudMessaging> provideGoogleCloudMessagingProvider;
  private Provider<UpsightGooglePushServicesApi> provideGooglePushServicesApiProvider;
  private Provider<SessionManager> provideSessionManagerProvider;
  private Provider<UpsightContext> provideUpsightContextProvider;
  private MembersInjector<PushClickIntentService> pushClickIntentServiceMembersInjector;
  private MembersInjector<PushIntentService> pushIntentServiceMembersInjector;
  private MembersInjector<UpsightGooglePushServicesExtension> upsightGooglePushServicesExtensionMembersInjector;
  
  static
  {
    if (!DaggerGooglePushServicesComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerGooglePushServicesComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Builder paramBuilder)
  {
    provideUpsightContextProvider = ScopedProvider.create(PushModule_ProvideUpsightContextFactory.create(pushModule));
    googlePushServicesProvider = ScopedProvider.create(GooglePushServices_Factory.create(provideUpsightContextProvider));
    provideGooglePushServicesApiProvider = ScopedProvider.create(PushModule_ProvideGooglePushServicesApiFactory.create(pushModule, googlePushServicesProvider));
    upsightGooglePushServicesExtensionMembersInjector = UpsightGooglePushServicesExtension_MembersInjector.create(MembersInjectors.noOp(), provideGooglePushServicesApiProvider);
    provideGoogleCloudMessagingProvider = ScopedProvider.create(GoogleCloudMessagingModule_ProvideGoogleCloudMessagingFactory.create(googleCloudMessagingModule, provideUpsightContextProvider));
    pushIntentServiceMembersInjector = PushIntentService_MembersInjector.create(MembersInjectors.noOp(), provideGoogleCloudMessagingProvider);
    provideSessionManagerProvider = ScopedProvider.create(PushModule_ProvideSessionManagerFactory.create(pushModule, provideUpsightContextProvider));
    pushClickIntentServiceMembersInjector = PushClickIntentService_MembersInjector.create(MembersInjectors.noOp(), provideSessionManagerProvider);
  }
  
  public void inject(UpsightGooglePushServicesExtension paramUpsightGooglePushServicesExtension)
  {
    upsightGooglePushServicesExtensionMembersInjector.injectMembers(paramUpsightGooglePushServicesExtension);
  }
  
  public void inject(PushClickIntentService paramPushClickIntentService)
  {
    pushClickIntentServiceMembersInjector.injectMembers(paramPushClickIntentService);
  }
  
  public void inject(PushIntentService paramPushIntentService)
  {
    pushIntentServiceMembersInjector.injectMembers(paramPushIntentService);
  }
  
  public static final class Builder
  {
    private GoogleCloudMessagingModule googleCloudMessagingModule;
    private GooglePushServicesModule googlePushServicesModule;
    private PushModule pushModule;
    
    public GooglePushServicesComponent build()
    {
      if (googlePushServicesModule == null) {
        googlePushServicesModule = new GooglePushServicesModule();
      }
      if (pushModule == null) {
        throw new IllegalStateException("pushModule must be set");
      }
      if (googleCloudMessagingModule == null) {
        googleCloudMessagingModule = new GoogleCloudMessagingModule();
      }
      return new DaggerGooglePushServicesComponent(this, null);
    }
    
    public Builder googleCloudMessagingModule(GoogleCloudMessagingModule paramGoogleCloudMessagingModule)
    {
      if (paramGoogleCloudMessagingModule == null) {
        throw new NullPointerException("googleCloudMessagingModule");
      }
      googleCloudMessagingModule = paramGoogleCloudMessagingModule;
      return this;
    }
    
    public Builder googlePushServicesModule(GooglePushServicesModule paramGooglePushServicesModule)
    {
      if (paramGooglePushServicesModule == null) {
        throw new NullPointerException("googlePushServicesModule");
      }
      googlePushServicesModule = paramGooglePushServicesModule;
      return this;
    }
    
    public Builder pushModule(PushModule paramPushModule)
    {
      if (paramPushModule == null) {
        throw new NullPointerException("pushModule");
      }
      pushModule = paramPushModule;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.DaggerGooglePushServicesComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */