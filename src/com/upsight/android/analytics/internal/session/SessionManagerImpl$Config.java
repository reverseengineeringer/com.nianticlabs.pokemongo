package com.upsight.android.analytics.internal.session;

public final class SessionManagerImpl$Config
{
  public final long timeToNewSession;
  
  SessionManagerImpl$Config(long paramLong)
  {
    timeToNewSession = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
    } while (timeToNewSession == timeToNewSession);
    return false;
  }
  
  public boolean isValid()
  {
    return timeToNewSession > 0L;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionManagerImpl.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */