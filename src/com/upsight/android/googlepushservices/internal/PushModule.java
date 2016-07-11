package com.upsight.android.googlepushservices.internal;

import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsComponent;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.googlepushservices.UpsightGooglePushServicesApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class PushModule
{
  private final UpsightContext mUpsight;
  
  public PushModule(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  @Provides
  @Singleton
  public UpsightGooglePushServicesApi provideGooglePushServicesApi(GooglePushServices paramGooglePushServices)
  {
    return paramGooglePushServices;
  }
  
  @Provides
  @Singleton
  SessionManager provideSessionManager(UpsightContext paramUpsightContext)
  {
    return ((UpsightAnalyticsComponent)((UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics")).getComponent()).sessionManager();
  }
  
  @Provides
  @Singleton
  UpsightContext provideUpsightContext()
  {
    return mUpsight;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */