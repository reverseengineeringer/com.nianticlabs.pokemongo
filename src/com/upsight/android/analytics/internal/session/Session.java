package com.upsight.android.analytics.internal.session;

import android.content.Context;

public abstract interface Session
  extends SessionInitializer
{
  public abstract long getPreviousTos();
  
  public abstract int getSessionNumber();
  
  public abstract long getTimeStamp();
  
  public abstract void updateDuration(Context paramContext, long paramLong);
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.Session
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */