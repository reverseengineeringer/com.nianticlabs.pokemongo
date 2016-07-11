package com.upsight.android.googlepushservices.internal;

import android.app.IntentService;
import com.upsight.android.analytics.internal.session.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PushClickIntentService_MembersInjector
  implements MembersInjector<PushClickIntentService>
{
  private final Provider<SessionManager> mSessionManagerProvider;
  private final MembersInjector<IntentService> supertypeInjector;
  
  static
  {
    if (!PushClickIntentService_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushClickIntentService_MembersInjector(MembersInjector<IntentService> paramMembersInjector, Provider<SessionManager> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mSessionManagerProvider = paramProvider;
  }
  
  public static MembersInjector<PushClickIntentService> create(MembersInjector<IntentService> paramMembersInjector, Provider<SessionManager> paramProvider)
  {
    return new PushClickIntentService_MembersInjector(paramMembersInjector, paramProvider);
  }
  
  public void injectMembers(PushClickIntentService paramPushClickIntentService)
  {
    if (paramPushClickIntentService == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(paramPushClickIntentService);
    mSessionManager = ((SessionManager)mSessionManagerProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushClickIntentService_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */