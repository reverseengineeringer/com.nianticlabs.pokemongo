package com.upsight.android.analytics.internal.session;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class SessionModule
{
  @Provides
  @Singleton
  public SessionManager providesSessionManager(SessionManagerImpl paramSessionManagerImpl)
  {
    return paramSessionManagerImpl;
  }
  
  @Provides
  @Singleton
  public SessionManagerImpl providesSessionManagerImpl(UpsightContext paramUpsightContext, ConfigParser paramConfigParser, Clock paramClock)
  {
    return new SessionManagerImpl(paramUpsightContext.getCoreComponent().applicationContext(), paramUpsightContext, paramUpsightContext.getDataStore(), paramUpsightContext.getLogger(), paramConfigParser, paramClock);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */