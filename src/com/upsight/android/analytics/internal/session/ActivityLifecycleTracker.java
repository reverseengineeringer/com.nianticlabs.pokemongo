package com.upsight.android.analytics.internal.session;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.upsight.android.analytics.UpsightLifeCycleTracker.ActivityState;
import javax.inject.Inject;

@TargetApi(14)
public class ActivityLifecycleTracker
  implements Application.ActivityLifecycleCallbacks
{
  private ManualTracker mTracker;
  
  @Inject
  public ActivityLifecycleTracker(ManualTracker paramManualTracker)
  {
    mTracker = paramManualTracker;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    mTracker.track(paramActivity, UpsightLifeCycleTracker.ActivityState.STARTED, null);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    mTracker.track(paramActivity, UpsightLifeCycleTracker.ActivityState.STOPPED, null);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ActivityLifecycleTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */