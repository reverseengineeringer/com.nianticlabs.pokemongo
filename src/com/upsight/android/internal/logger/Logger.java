package com.upsight.android.internal.logger;

import android.text.TextUtils;
import com.upsight.android.UpsightException;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.logger.UpsightLogger.Level;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import com.upsight.android.persistence.UpsightSubscription;
import com.upsight.android.persistence.annotation.Created;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Logger
  implements UpsightLogger
{
  private final UpsightDataStore mDataStore;
  private final LogWriter mLogWriter;
  private final Map<String, UpsightSubscription> mSubscriptionsMap = new ConcurrentHashMap();
  
  Logger(UpsightDataStore paramUpsightDataStore, LogWriter paramLogWriter)
  {
    mDataStore = paramUpsightDataStore;
    mLogWriter = paramLogWriter;
  }
  
  public static Logger create(UpsightDataStore paramUpsightDataStore, LogWriter paramLogWriter)
  {
    return new Logger(paramUpsightDataStore, paramLogWriter);
  }
  
  private static String formatString(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return paramString;
    }
    return String.format(paramString, paramVarArgs);
  }
  
  private void log(UpsightLogger.Level paramLevel, String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    StringWriter localStringWriter = new StringWriter();
    if (paramThrowable != null) {
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    }
    paramLevel = new LogMessage(paramString1, paramLevel, formatString(paramString2, paramVarArgs), localStringWriter.getBuffer().toString());
    mDataStore.store(paramLevel, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException) {}
      
      public void onSuccess(LogMessage paramAnonymousLogMessage)
      {
        mDataStore.remove(paramAnonymousLogMessage);
      }
    });
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.DEBUG, paramString1, null, paramString2, paramVarArgs);
  }
  
  public void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.DEBUG, paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.ERROR, paramString1, null, paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.ERROR, paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.INFO, paramString1, null, paramString2, paramVarArgs);
  }
  
  public void i(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.INFO, paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public void setLogLevel(String paramString, EnumSet<UpsightLogger.Level> paramEnumSet)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Log tag can not be null or empty.");
    }
    paramEnumSet = new LogSubscriber(paramString, paramEnumSet, mLogWriter);
    paramEnumSet = mDataStore.subscribe(paramEnumSet);
    paramString = (UpsightSubscription)mSubscriptionsMap.put(paramString, paramEnumSet);
    if (paramString != null) {
      paramString.unsubscribe();
    }
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.VERBOSE, paramString1, null, paramString2, paramVarArgs);
  }
  
  public void v(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.VERBOSE, paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.WARN, paramString1, null, paramString2, paramVarArgs);
  }
  
  public void w(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    log(UpsightLogger.Level.WARN, paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public static final class LogSubscriber
  {
    private final EnumSet<UpsightLogger.Level> mLevels;
    private final Pattern mTag;
    private final LogWriter mWriter;
    
    public LogSubscriber(String paramString, EnumSet<UpsightLogger.Level> paramEnumSet, LogWriter paramLogWriter)
    {
      mTag = Pattern.compile(paramString);
      mLevels = paramEnumSet;
      mWriter = paramLogWriter;
    }
    
    @Created
    public void onLogMessageCreated(LogMessage paramLogMessage)
    {
      if (!mTag.matcher(paramLogMessage.getTag()).matches()) {}
      while (!mLevels.contains(paramLogMessage.getLevel())) {
        return;
      }
      mWriter.write(paramLogMessage.getTag(), paramLogMessage.getLevel(), paramLogMessage.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.logger.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */