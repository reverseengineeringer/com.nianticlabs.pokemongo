package com.upsight.android.managedvariables.internal.experience;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.upsight.android.analytics.internal.action.Actionable.ActionMapFinishedEvent;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import com.upsight.android.managedvariables.internal.type.UxmContentActions.ScheduleSyncNotificationEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserExperience
  extends UpsightUserExperience
{
  private static final UpsightUserExperience.Handler DEFAULT_HANDLER = new DefaultHandler(null);
  private Bus mBus;
  private UpsightUserExperience.Handler mHandler = DEFAULT_HANDLER;
  private Map<String, List<String>> mSyncNotifications = new HashMap();
  
  UserExperience(Bus paramBus)
  {
    mBus = paramBus;
    mBus.register(this);
  }
  
  public UpsightUserExperience.Handler getHandler()
  {
    try
    {
      UpsightUserExperience.Handler localHandler = mHandler;
      return localHandler;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Subscribe
  public void handleActionMapFinishedEvent(Actionable.ActionMapFinishedEvent paramActionMapFinishedEvent)
  {
    try
    {
      paramActionMapFinishedEvent = (List)mSyncNotifications.remove(mId);
      if (paramActionMapFinishedEvent != null) {
        mHandler.onSynchronize(paramActionMapFinishedEvent);
      }
      return;
    }
    finally {}
  }
  
  @Subscribe
  public void handleScheduleSyncNotificationEvent(UxmContentActions.ScheduleSyncNotificationEvent paramScheduleSyncNotificationEvent)
  {
    try
    {
      mSyncNotifications.put(mId, mTags);
      return;
    }
    finally
    {
      paramScheduleSyncNotificationEvent = finally;
      throw paramScheduleSyncNotificationEvent;
    }
  }
  
  public void registerHandler(UpsightUserExperience.Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      try
      {
        mHandler = paramHandler;
        return;
      }
      finally {}
      mHandler = DEFAULT_HANDLER;
    }
  }
  
  private static class DefaultHandler
    implements UpsightUserExperience.Handler
  {
    public boolean onReceive()
    {
      return true;
    }
    
    public void onSynchronize(List<String> paramList) {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.experience.UserExperience
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */