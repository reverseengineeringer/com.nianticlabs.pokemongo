package com.upsight.android.analytics.internal.session;

import android.app.Activity;
import android.content.Intent;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.UpsightLifeCycleTracker;
import com.upsight.android.analytics.UpsightLifeCycleTracker.ActivityState;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class ManualTracker
  implements UpsightLifeCycleTracker
{
  private Set<WeakReference<Activity>> mActivitySet;
  private UpsightDataStore mDataStore;
  private SessionManager mSessionManager;
  
  @Inject
  public ManualTracker(SessionManager paramSessionManager, UpsightContext paramUpsightContext)
  {
    mSessionManager = paramSessionManager;
    mDataStore = paramUpsightContext.getDataStore();
    mActivitySet = new HashSet();
  }
  
  private static boolean isPurgeable(Activity paramActivity)
  {
    return paramActivity == null;
  }
  
  private static void removeAndPurge(Set<WeakReference<Activity>> paramSet, Activity paramActivity)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)paramSet.next()).get();
      if ((localActivity == paramActivity) || (isPurgeable(localActivity))) {
        paramSet.remove();
      }
    }
  }
  
  public void track(Activity paramActivity, UpsightLifeCycleTracker.ActivityState paramActivityState, SessionInitializer paramSessionInitializer)
  {
    switch (paramActivityState)
    {
    }
    do
    {
      return;
      if (mActivitySet.isEmpty())
      {
        mDataStore.fetch(ApplicationStatus.class, new UpsightDataStoreListener()
        {
          public void onFailure(UpsightException paramAnonymousUpsightException) {}
          
          public void onSuccess(Set<ApplicationStatus> paramAnonymousSet)
          {
            if (paramAnonymousSet.isEmpty()) {
              mDataStore.store(new ApplicationStatus(ApplicationStatus.State.FOREGROUND));
            }
            for (;;)
            {
              return;
              paramAnonymousSet = paramAnonymousSet.iterator();
              int i = 0;
              while (paramAnonymousSet.hasNext())
              {
                ApplicationStatus localApplicationStatus = (ApplicationStatus)paramAnonymousSet.next();
                if (i == 0)
                {
                  state = ApplicationStatus.State.FOREGROUND;
                  mDataStore.store(localApplicationStatus);
                  i = 1;
                }
                else
                {
                  mDataStore.remove(localApplicationStatus);
                }
              }
            }
          }
        });
        paramActivityState = paramActivity.getIntent();
        if ((paramActivityState == null) || (!paramActivityState.hasExtra("pushMessage"))) {
          mSessionManager.startSession(paramSessionInitializer);
        }
      }
      mActivitySet.add(new WeakReference(paramActivity));
      return;
      removeAndPurge(mActivitySet, paramActivity);
    } while ((paramActivity.isChangingConfigurations()) || (!mActivitySet.isEmpty()));
    mDataStore.fetch(ApplicationStatus.class, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException) {}
      
      public void onSuccess(Set<ApplicationStatus> paramAnonymousSet)
      {
        if (paramAnonymousSet.isEmpty()) {
          mDataStore.store(new ApplicationStatus(ApplicationStatus.State.BACKGROUND));
        }
        for (;;)
        {
          return;
          paramAnonymousSet = paramAnonymousSet.iterator();
          int i = 0;
          while (paramAnonymousSet.hasNext())
          {
            ApplicationStatus localApplicationStatus = (ApplicationStatus)paramAnonymousSet.next();
            if (i == 0)
            {
              state = ApplicationStatus.State.BACKGROUND;
              mDataStore.store(localApplicationStatus);
              i = 1;
            }
            else
            {
              mDataStore.remove(localApplicationStatus);
              paramAnonymousSet.remove();
            }
          }
        }
      }
    });
    mSessionManager.stopSession();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ManualTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */