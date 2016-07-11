package com.upsight.android;

import android.app.Application.ActivityLifecycleCallbacks;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.analytics.UpsightAnalyticsComponent;
import com.upsight.android.analytics.internal.association.AssociationManager;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.internal.util.Opt;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class UpsightAnalyticsExtension_MembersInjector
  implements MembersInjector<UpsightAnalyticsExtension>
{
  private final Provider<UpsightAnalyticsApi> mAnalyticsProvider;
  private final Provider<AssociationManager> mAssociationManagerProvider;
  private final Provider<Clock> mClockProvider;
  private final Provider<Opt<Thread.UncaughtExceptionHandler>> mUncaughtExceptionHandlerProvider;
  private final Provider<Application.ActivityLifecycleCallbacks> mUpsightLifeCycleCallbacksProvider;
  private final MembersInjector<UpsightExtension<UpsightAnalyticsComponent, UpsightAnalyticsApi>> supertypeInjector;
  
  static
  {
    if (!UpsightAnalyticsExtension_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UpsightAnalyticsExtension_MembersInjector(MembersInjector<UpsightExtension<UpsightAnalyticsComponent, UpsightAnalyticsApi>> paramMembersInjector, Provider<Opt<Thread.UncaughtExceptionHandler>> paramProvider, Provider<UpsightAnalyticsApi> paramProvider1, Provider<Clock> paramProvider2, Provider<Application.ActivityLifecycleCallbacks> paramProvider3, Provider<AssociationManager> paramProvider4)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mUncaughtExceptionHandlerProvider = paramProvider;
    assert (paramProvider1 != null);
    mAnalyticsProvider = paramProvider1;
    assert (paramProvider2 != null);
    mClockProvider = paramProvider2;
    assert (paramProvider3 != null);
    mUpsightLifeCycleCallbacksProvider = paramProvider3;
    assert (paramProvider4 != null);
    mAssociationManagerProvider = paramProvider4;
  }
  
  public static MembersInjector<UpsightAnalyticsExtension> create(MembersInjector<UpsightExtension<UpsightAnalyticsComponent, UpsightAnalyticsApi>> paramMembersInjector, Provider<Opt<Thread.UncaughtExceptionHandler>> paramProvider, Provider<UpsightAnalyticsApi> paramProvider1, Provider<Clock> paramProvider2, Provider<Application.ActivityLifecycleCallbacks> paramProvider3, Provider<AssociationManager> paramProvider4)
  {
    return new UpsightAnalyticsExtension_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
  
  public void injectMembers(UpsightAnalyticsExtension paramUpsightAnalyticsExtension)
  {
    if (paramUpsightAnalyticsExtension == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(paramUpsightAnalyticsExtension);
    mUncaughtExceptionHandler = ((Opt)mUncaughtExceptionHandlerProvider.get());
    mAnalytics = ((UpsightAnalyticsApi)mAnalyticsProvider.get());
    mClock = ((Clock)mClockProvider.get());
    mUpsightLifeCycleCallbacks = ((Application.ActivityLifecycleCallbacks)mUpsightLifeCycleCallbacksProvider.get());
    mAssociationManager = ((AssociationManager)mAssociationManagerProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightAnalyticsExtension_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */