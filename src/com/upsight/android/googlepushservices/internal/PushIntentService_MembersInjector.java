package com.upsight.android.googlepushservices.internal;

import android.app.IntentService;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PushIntentService_MembersInjector
  implements MembersInjector<PushIntentService>
{
  private final Provider<GoogleCloudMessaging> mGcmProvider;
  private final MembersInjector<IntentService> supertypeInjector;
  
  static
  {
    if (!PushIntentService_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushIntentService_MembersInjector(MembersInjector<IntentService> paramMembersInjector, Provider<GoogleCloudMessaging> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mGcmProvider = paramProvider;
  }
  
  public static MembersInjector<PushIntentService> create(MembersInjector<IntentService> paramMembersInjector, Provider<GoogleCloudMessaging> paramProvider)
  {
    return new PushIntentService_MembersInjector(paramMembersInjector, paramProvider);
  }
  
  public void injectMembers(PushIntentService paramPushIntentService)
  {
    if (paramPushIntentService == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(paramPushIntentService);
    mGcm = ((GoogleCloudMessaging)mGcmProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushIntentService_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */