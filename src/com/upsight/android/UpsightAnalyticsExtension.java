package com.upsight.android;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.analytics.UpsightAnalyticsComponent;
import com.upsight.android.analytics.event.install.UpsightInstallEvent;
import com.upsight.android.analytics.event.install.UpsightInstallEvent.Builder;
import com.upsight.android.analytics.internal.BaseAnalyticsModule;
import com.upsight.android.analytics.internal.DaggerAnalyticsComponent;
import com.upsight.android.analytics.internal.DaggerAnalyticsComponent.Builder;
import com.upsight.android.analytics.internal.association.AssociationManager;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.internal.util.Opt;
import com.upsight.android.internal.util.PreferencesHelper;
import javax.inject.Inject;
import javax.inject.Named;

public class UpsightAnalyticsExtension
  extends UpsightExtension<UpsightAnalyticsComponent, UpsightAnalyticsApi>
{
  public static final String EXTENSION_NAME = "com.upsight.extension.analytics";
  @Inject
  UpsightAnalyticsApi mAnalytics;
  @Inject
  AssociationManager mAssociationManager;
  @Inject
  Clock mClock;
  @Inject
  @Named("optUncaughtExceptionHandler")
  Opt<Thread.UncaughtExceptionHandler> mUncaughtExceptionHandler;
  @Inject
  Application.ActivityLifecycleCallbacks mUpsightLifeCycleCallbacks;
  
  public UpsightAnalyticsApi getApi()
  {
    return mAnalytics;
  }
  
  protected void onCreate(UpsightContext paramUpsightContext)
  {
    if (mUncaughtExceptionHandler.isPresent()) {
      Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)mUncaughtExceptionHandler.get());
    }
    ((Application)paramUpsightContext.getApplicationContext()).registerActivityLifecycleCallbacks(mUpsightLifeCycleCallbacks);
    mAssociationManager.launch();
  }
  
  protected void onPostCreate(UpsightContext paramUpsightContext)
  {
    if (!PreferencesHelper.contains(paramUpsightContext, "install_ts"))
    {
      PreferencesHelper.putLong(paramUpsightContext, "install_ts", mClock.currentTimeSeconds());
      UpsightInstallEvent.createBuilder().record(paramUpsightContext);
    }
  }
  
  protected UpsightAnalyticsComponent onResolve(UpsightContext paramUpsightContext)
  {
    return DaggerAnalyticsComponent.builder().baseAnalyticsModule(new BaseAnalyticsModule(paramUpsightContext)).build();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightAnalyticsExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */