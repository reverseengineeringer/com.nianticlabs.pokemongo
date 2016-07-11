package com.upsight.android.analytics.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrashLogHandler$CrashLogEvent$UpsightData
{
  @JsonProperty("crashID")
  String crashID;
  @JsonProperty("stacktrace")
  String stacktrace;
  
  protected CrashLogHandler$CrashLogEvent$UpsightData() {}
  
  protected CrashLogHandler$CrashLogEvent$UpsightData(CrashLogHandler.CrashLogEvent.Builder paramBuilder)
  {
    stacktrace = CrashLogHandler.CrashLogEvent.Builder.access$000(paramBuilder);
    crashID = CrashLogHandler.CrashLogEvent.Builder.access$100(paramBuilder);
  }
  
  public String getCrashID()
  {
    return crashID;
  }
  
  public String getStacktrace()
  {
    return stacktrace;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.CrashLogHandler.CrashLogEvent.UpsightData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */