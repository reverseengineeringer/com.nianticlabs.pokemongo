package com.upsight.android.analytics.internal.session;

import android.content.Context;
import android.content.Intent;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.analytics.event.session.UpsightSessionPauseEvent;
import com.upsight.android.analytics.event.session.UpsightSessionPauseEvent.Builder;
import com.upsight.android.analytics.event.session.UpsightSessionResumeEvent;
import com.upsight.android.analytics.event.session.UpsightSessionResumeEvent.Builder;
import com.upsight.android.analytics.event.session.UpsightSessionStartEvent;
import com.upsight.android.analytics.event.session.UpsightSessionStartEvent.Builder;
import com.upsight.android.analytics.internal.DispatcherService;
import com.upsight.android.analytics.provider.UpsightLocationTracker;
import com.upsight.android.analytics.session.UpsightSessionCallbacks;
import com.upsight.android.internal.util.PreferencesHelper;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.annotation.Created;
import com.upsight.android.persistence.annotation.Updated;
import java.io.IOException;

public class SessionManagerImpl
  implements SessionManager
{
  private static final String KEY_SESSION = "com.upsight.session_callbacks";
  private static final String LOG_TAG = SessionManagerImpl.class.getSimpleName();
  private static final String PREFERENCES_KEY_JSON_CONFIG = "session_manager_json_config";
  private static final String PREFERENCES_KEY_LAST_KNOWN_SESSION_TIME = "last_known_session_time";
  private Context mAppContext;
  private final Clock mClock;
  private ConfigParser mConfigParser;
  private Config mCurrentConfig;
  private long mLastKnownSessionTs;
  private UpsightLogger mLogger;
  private Session mSession;
  private long mStopRequestedTs;
  private UpsightContext mUpsight;
  private UpsightSessionCallbacks mUpsightSessionCallbacks;
  
  SessionManagerImpl(Context paramContext, UpsightContext paramUpsightContext, UpsightDataStore paramUpsightDataStore, UpsightLogger paramUpsightLogger, ConfigParser paramConfigParser, Clock paramClock)
  {
    mLogger = paramUpsightLogger;
    mConfigParser = paramConfigParser;
    mAppContext = paramContext;
    mUpsight = paramUpsightContext;
    mClock = paramClock;
    mLastKnownSessionTs = PreferencesHelper.getLong(paramContext, "last_known_session_time", 0L);
    loadSessionHook();
    paramUpsightDataStore.subscribe(this);
    applyConfiguration(fetchCurrentConfig());
  }
  
  private boolean applyConfiguration(String paramString)
  {
    Config localConfig;
    try
    {
      localConfig = mConfigParser.parseConfig(paramString);
      if ((localConfig == null) || (!localConfig.isValid()))
      {
        mLogger.w(LOG_TAG, "New config is invalid", new Object[0]);
        return false;
      }
      if (localConfig.equals(mCurrentConfig))
      {
        mLogger.w(LOG_TAG, "New config ignored because it is equal to current config", new Object[0]);
        return true;
      }
    }
    catch (IOException paramString)
    {
      mLogger.e(LOG_TAG, "Failed to apply new config", new Object[] { paramString });
      return false;
    }
    PreferencesHelper.putString(mAppContext, "session_manager_json_config", paramString);
    mCurrentConfig = localConfig;
    return true;
  }
  
  private String fetchCurrentConfig()
  {
    return PreferencesHelper.getString(mAppContext, "session_manager_json_config", "{\"session_gap\": 120}");
  }
  
  private boolean isExpired()
  {
    return ((mStopRequestedTs != 0L) && (mClock.currentTimeSeconds() - mStopRequestedTs > mCurrentConfig.timeToNewSession)) || ((mSession == null) && (mClock.currentTimeSeconds() - mLastKnownSessionTs > mCurrentConfig.timeToNewSession));
  }
  
  private boolean isSessionNull()
  {
    return mSession == null;
  }
  
  /* Error */
  private void loadSessionHook()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/upsight/android/analytics/internal/session/SessionManagerImpl:mUpsight	Lcom/upsight/android/UpsightContext;
    //   4: invokevirtual 160	com/upsight/android/UpsightContext:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: aload_0
    //   8: getfield 62	com/upsight/android/analytics/internal/session/SessionManagerImpl:mUpsight	Lcom/upsight/android/UpsightContext;
    //   11: invokevirtual 163	com/upsight/android/UpsightContext:getPackageName	()Ljava/lang/String;
    //   14: sipush 128
    //   17: invokevirtual 169	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   20: getfield 175	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +98 -> 123
    //   28: aload_1
    //   29: ldc 13
    //   31: invokevirtual 180	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   34: ifeq +89 -> 123
    //   37: aload_1
    //   38: ldc 13
    //   40: invokevirtual 183	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: invokestatic 187	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   48: astore_2
    //   49: ldc -67
    //   51: aload_2
    //   52: invokevirtual 193	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   55: ifne +69 -> 124
    //   58: new 195	java/lang/IllegalStateException
    //   61: dup
    //   62: ldc -59
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_2
    //   71: invokevirtual 200	java/lang/Class:getName	()Ljava/lang/String;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: ldc -67
    //   79: invokevirtual 200	java/lang/Class:getName	()Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokespecial 209	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_2
    //   91: aload_0
    //   92: getfield 56	com/upsight/android/analytics/internal/session/SessionManagerImpl:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   95: ldc -45
    //   97: ldc -43
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_1
    //   106: aastore
    //   107: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: iconst_1
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: aastore
    //   118: invokeinterface 121 4 0
    //   123: return
    //   124: aload_0
    //   125: aload_2
    //   126: invokevirtual 217	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   129: checkcast 189	com/upsight/android/analytics/session/UpsightSessionCallbacks
    //   132: putfield 219	com/upsight/android/analytics/internal/session/SessionManagerImpl:mUpsightSessionCallbacks	Lcom/upsight/android/analytics/session/UpsightSessionCallbacks;
    //   135: return
    //   136: astore_2
    //   137: aload_0
    //   138: getfield 56	com/upsight/android/analytics/internal/session/SessionManagerImpl:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   141: ldc -45
    //   143: ldc -35
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_1
    //   152: aastore
    //   153: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_2
    //   163: aastore
    //   164: invokeinterface 121 4 0
    //   169: return
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 56	com/upsight/android/analytics/internal/session/SessionManagerImpl:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   175: ldc -45
    //   177: ldc -33
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_1
    //   186: aastore
    //   187: invokeinterface 121 4 0
    //   192: return
    //   193: astore_2
    //   194: aload_0
    //   195: getfield 56	com/upsight/android/analytics/internal/session/SessionManagerImpl:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   198: ldc -45
    //   200: ldc -31
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: aastore
    //   210: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_2
    //   220: aastore
    //   221: invokeinterface 121 4 0
    //   226: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	SessionManagerImpl
    //   23	129	1	localObject	Object
    //   170	39	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   48	23	2	localClass	Class
    //   90	36	2	localClassNotFoundException	ClassNotFoundException
    //   136	27	2	localIllegalAccessException	IllegalAccessException
    //   193	27	2	localInstantiationException	InstantiationException
    // Exception table:
    //   from	to	target	type
    //   44	90	90	java/lang/ClassNotFoundException
    //   124	135	90	java/lang/ClassNotFoundException
    //   44	90	136	java/lang/IllegalAccessException
    //   124	135	136	java/lang/IllegalAccessException
    //   0	24	170	android/content/pm/PackageManager$NameNotFoundException
    //   28	44	170	android/content/pm/PackageManager$NameNotFoundException
    //   44	90	170	android/content/pm/PackageManager$NameNotFoundException
    //   91	123	170	android/content/pm/PackageManager$NameNotFoundException
    //   124	135	170	android/content/pm/PackageManager$NameNotFoundException
    //   137	169	170	android/content/pm/PackageManager$NameNotFoundException
    //   194	226	170	android/content/pm/PackageManager$NameNotFoundException
    //   44	90	193	java/lang/InstantiationException
    //   124	135	193	java/lang/InstantiationException
  }
  
  private Session startSession(boolean paramBoolean1, boolean paramBoolean2, SessionInitializer paramSessionInitializer)
  {
    mUpsight.startService(new Intent(mUpsight, DispatcherService.class));
    Integer localInteger1 = null;
    Integer localInteger2 = null;
    int i;
    int j;
    if (paramSessionInitializer != null)
    {
      i = 1;
      if (mStopRequestedTs == 0L) {
        break label175;
      }
      j = 1;
      label46:
      mStopRequestedTs = 0L;
      if ((i == 0) && (!paramBoolean2)) {
        break label181;
      }
      UpsightLocationTracker.purge(mUpsight);
      if (mUpsightSessionCallbacks != null) {
        mUpsightSessionCallbacks.onStart(mUpsight);
      }
      if (i != 0)
      {
        localInteger1 = paramSessionInitializer.getCampaignID();
        localInteger2 = paramSessionInitializer.getMessageID();
      }
      mSession = SessionImpl.incrementAndCreate(mAppContext, mClock, localInteger1, localInteger2);
      UpsightSessionStartEvent.createBuilder().record(mUpsight);
    }
    for (;;)
    {
      mLastKnownSessionTs = mClock.currentTimeSeconds();
      PreferencesHelper.putLong(mAppContext, "last_known_session_time", mLastKnownSessionTs);
      return mSession;
      i = 0;
      break;
      label175:
      j = 0;
      break label46;
      label181:
      if (paramBoolean1)
      {
        UpsightLocationTracker.purge(mUpsight);
        if (mUpsightSessionCallbacks != null) {
          mUpsightSessionCallbacks.onStart(mUpsight);
        }
        mSession = SessionImpl.create(mAppContext, mClock, null, null);
        UpsightSessionResumeEvent.createBuilder().record(mUpsight);
      }
      else if (j != 0)
      {
        UpsightSessionResumeEvent.createBuilder().record(mUpsight);
      }
    }
  }
  
  /* Error */
  public Session getCurrentSession()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 293	com/upsight/android/analytics/internal/session/SessionManagerImpl:isSessionNull	()Z
    //   6: istore_1
    //   7: aload_0
    //   8: invokespecial 295	com/upsight/android/analytics/internal/session/SessionManagerImpl:isExpired	()Z
    //   11: istore_2
    //   12: iload_1
    //   13: ifne +7 -> 20
    //   16: iload_2
    //   17: ifeq +15 -> 32
    //   20: aload_0
    //   21: iload_1
    //   22: iload_2
    //   23: aconst_null
    //   24: invokespecial 297	com/upsight/android/analytics/internal/session/SessionManagerImpl:startSession	(ZZLcom/upsight/android/analytics/internal/session/SessionInitializer;)Lcom/upsight/android/analytics/internal/session/Session;
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aload_0
    //   33: getfield 145	com/upsight/android/analytics/internal/session/SessionManagerImpl:mSession	Lcom/upsight/android/analytics/internal/session/Session;
    //   36: astore_3
    //   37: goto -9 -> 28
    //   40: astore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_3
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	SessionManagerImpl
    //   6	16	1	bool1	boolean
    //   11	12	2	bool2	boolean
    //   27	10	3	localSession	Session
    //   40	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	40	finally
    //   20	28	40	finally
    //   32	37	40	finally
  }
  
  @Updated
  public void onApplicationStatusUpdated(ApplicationStatus paramApplicationStatus)
  {
    try
    {
      if (ApplicationStatus.State.BACKGROUND.equals(paramApplicationStatus.getState()))
      {
        mLastKnownSessionTs = mClock.currentTimeSeconds();
        PreferencesHelper.putLong(mAppContext, "last_known_session_time", mLastKnownSessionTs);
        UpsightSessionPauseEvent.createBuilder().record(mUpsight);
      }
      return;
    }
    finally
    {
      paramApplicationStatus = finally;
      throw paramApplicationStatus;
    }
  }
  
  @Created
  public void onConfigurationCreated(UpsightConfiguration paramUpsightConfiguration)
  {
    try
    {
      if ("upsight.configuration.session_manager".equals(paramUpsightConfiguration.getScope())) {
        applyConfiguration(paramUpsightConfiguration.getConfiguration());
      }
      return;
    }
    finally
    {
      paramUpsightConfiguration = finally;
      throw paramUpsightConfiguration;
    }
  }
  
  public Session startSession(SessionInitializer paramSessionInitializer)
  {
    try
    {
      paramSessionInitializer = startSession(isSessionNull(), isExpired(), paramSessionInitializer);
      return paramSessionInitializer;
    }
    finally
    {
      paramSessionInitializer = finally;
      throw paramSessionInitializer;
    }
  }
  
  public void stopSession()
  {
    try
    {
      Session localSession = getCurrentSession();
      mStopRequestedTs = mClock.currentTimeSeconds();
      localSession.updateDuration(mAppContext, mStopRequestedTs);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static final class Config
  {
    public final long timeToNewSession;
    
    Config(long paramLong)
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionManagerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */