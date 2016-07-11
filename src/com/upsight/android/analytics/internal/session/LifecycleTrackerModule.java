package com.upsight.android.analytics.internal.session;

import android.app.Application.ActivityLifecycleCallbacks;
import com.upsight.android.analytics.UpsightLifeCycleTracker;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class LifecycleTrackerModule
{
  @Provides
  @Singleton
  public UpsightLifeCycleTracker provideManualTracker(ManualTracker paramManualTracker)
  {
    return paramManualTracker;
  }
  
  @Provides
  @Singleton
  public Application.ActivityLifecycleCallbacks provideUpsightLifeCycleCallbacks(ActivityLifecycleTracker paramActivityLifecycleTracker)
  {
    return paramActivityLifecycleTracker;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.LifecycleTrackerModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */