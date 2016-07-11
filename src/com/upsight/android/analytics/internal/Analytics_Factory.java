package com.upsight.android.analytics.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightGooglePlayHelper;
import com.upsight.android.analytics.internal.association.AssociationManager;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.analytics.provider.UpsightLocationTracker;
import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import com.upsight.android.analytics.provider.UpsightUserAttributes;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class Analytics_Factory
  implements Factory<Analytics>
{
  private final Provider<AssociationManager> associationManagerProvider;
  private final Provider<UpsightGooglePlayHelper> googlePlayHelperProvider;
  private final Provider<UpsightLocationTracker> locationTrackerProvider;
  private final Provider<UpsightOptOutStatus> optOutStatusProvider;
  private final Provider<SchemaSelectorBuilder> schemaSelectorProvider;
  private final Provider<SessionManager> sessionManagerProvider;
  private final Provider<UpsightContext> upsightProvider;
  private final Provider<UpsightUserAttributes> userAttributesProvider;
  
  static
  {
    if (!Analytics_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Analytics_Factory(Provider<UpsightContext> paramProvider, Provider<SessionManager> paramProvider1, Provider<SchemaSelectorBuilder> paramProvider2, Provider<AssociationManager> paramProvider3, Provider<UpsightOptOutStatus> paramProvider4, Provider<UpsightLocationTracker> paramProvider5, Provider<UpsightUserAttributes> paramProvider6, Provider<UpsightGooglePlayHelper> paramProvider7)
  {
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    sessionManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    schemaSelectorProvider = paramProvider2;
    assert (paramProvider3 != null);
    associationManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    optOutStatusProvider = paramProvider4;
    assert (paramProvider5 != null);
    locationTrackerProvider = paramProvider5;
    assert (paramProvider6 != null);
    userAttributesProvider = paramProvider6;
    assert (paramProvider7 != null);
    googlePlayHelperProvider = paramProvider7;
  }
  
  public static Factory<Analytics> create(Provider<UpsightContext> paramProvider, Provider<SessionManager> paramProvider1, Provider<SchemaSelectorBuilder> paramProvider2, Provider<AssociationManager> paramProvider3, Provider<UpsightOptOutStatus> paramProvider4, Provider<UpsightLocationTracker> paramProvider5, Provider<UpsightUserAttributes> paramProvider6, Provider<UpsightGooglePlayHelper> paramProvider7)
  {
    return new Analytics_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }
  
  public Analytics get()
  {
    return new Analytics((UpsightContext)upsightProvider.get(), (SessionManager)sessionManagerProvider.get(), (SchemaSelectorBuilder)schemaSelectorProvider.get(), (AssociationManager)associationManagerProvider.get(), (UpsightOptOutStatus)optOutStatusProvider.get(), (UpsightLocationTracker)locationTrackerProvider.get(), (UpsightUserAttributes)userAttributesProvider.get(), (UpsightGooglePlayHelper)googlePlayHelperProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.Analytics_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */