package com.upsight.android.internal.logger;

import com.upsight.android.logger.UpsightLogger.Level;

public abstract interface LogWriter
{
  public abstract void write(String paramString1, UpsightLogger.Level paramLevel, String paramString2);
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.logger.LogWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */