package com.upsight.android.internal.logger;

import com.upsight.android.logger.UpsightLogger.Level;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("com.upsight.message.log")
public final class LogMessage
{
  @UpsightStorableIdentifier
  public String id;
  private UpsightLogger.Level level;
  private String message;
  private String tag;
  private String throwableString;
  
  LogMessage() {}
  
  LogMessage(LogMessage paramLogMessage)
  {
    this(tag, level, message, throwableString);
  }
  
  LogMessage(String paramString1, UpsightLogger.Level paramLevel, String paramString2, String paramString3)
  {
    tag = paramString1;
    level = paramLevel;
    message = paramString2;
    throwableString = paramString3;
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
      paramObject = (LogMessage)paramObject;
      if (id == null) {
        break;
      }
    } while (id.equals(id));
    for (;;)
    {
      return false;
      if (id == null) {
        break;
      }
    }
  }
  
  public UpsightLogger.Level getLevel()
  {
    return level;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String getTag()
  {
    return tag;
  }
  
  public String getThrowableString()
  {
    return throwableString;
  }
  
  public int hashCode()
  {
    if (id != null) {
      return id.hashCode();
    }
    return 0;
  }
  
  public void setLevel(UpsightLogger.Level paramLevel)
  {
    level = paramLevel;
  }
  
  public void setMessage(String paramString)
  {
    message = paramString;
  }
  
  public void setTag(String paramString)
  {
    tag = paramString;
  }
  
  public void setThrowableString(String paramString)
  {
    throwableString = paramString;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.logger.LogMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */