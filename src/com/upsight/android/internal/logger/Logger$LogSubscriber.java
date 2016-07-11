package com.upsight.android.internal.logger;

import com.upsight.android.logger.UpsightLogger.Level;
import com.upsight.android.persistence.annotation.Created;
import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Logger$LogSubscriber
{
  private final EnumSet<UpsightLogger.Level> mLevels;
  private final Pattern mTag;
  private final LogWriter mWriter;
  
  public Logger$LogSubscriber(String paramString, EnumSet<UpsightLogger.Level> paramEnumSet, LogWriter paramLogWriter)
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

/* Location:
 * Qualified Name:     com.upsight.android.internal.logger.Logger.LogSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */