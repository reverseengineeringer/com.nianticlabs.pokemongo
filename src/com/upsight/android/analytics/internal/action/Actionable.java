package com.upsight.android.analytics.internal.action;

import com.squareup.otto.Bus;

public abstract class Actionable
{
  private ActionMap mActionMap;
  private String mId;
  
  private Actionable() {}
  
  protected <T extends Actionable, U extends ActionContext> Actionable(String paramString, ActionMap<T, U> paramActionMap)
  {
    mId = paramString;
    mActionMap = paramActionMap;
  }
  
  public void executeActions(String paramString)
  {
    mActionMap.executeActions(paramString, this);
  }
  
  public String getId()
  {
    return mId;
  }
  
  public void signalActionCompleted(Bus paramBus)
  {
    if (mActionMap.signalActionCompleted()) {
      paramBus.post(new ActionMapFinishedEvent(mId, null));
    }
  }
  
  public void signalActionMapCompleted(Bus paramBus)
  {
    if (mActionMap.signalActionMapCompleted()) {
      paramBus.post(new ActionMapFinishedEvent(mId, null));
    }
  }
  
  public static class ActionMapFinishedEvent
  {
    public final String mId;
    
    private ActionMapFinishedEvent(String paramString)
    {
      mId = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.action.Actionable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */