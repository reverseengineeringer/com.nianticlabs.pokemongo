package com.upsight.android.analytics.internal.session;

public abstract interface SessionManager
{
  public static final String CONFIGURATION_SUBTYPE = "upsight.configuration.session_manager";
  public static final String DEFAULT_CONFIGURATION = "{\"session_gap\": 120}";
  public static final String SESSION_CAMPAIGN_ID = "campaign_id";
  public static final String SESSION_EXTRA = "session_extra";
  public static final String SESSION_MESSAGE_ID = "message_id";
  
  public abstract Session getCurrentSession();
  
  public abstract Session startSession(SessionInitializer paramSessionInitializer);
  
  public abstract void stopSession();
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */