package com.upsight.android.analytics.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent.Builder;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;
import java.io.PrintWriter;
import java.io.StringWriter;

class CrashLogHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;
  private UpsightAnalyticsApi mUpsightAnalytics;
  
  public CrashLogHandler(UpsightAnalyticsApi paramUpsightAnalyticsApi)
  {
    mUpsightAnalytics = paramUpsightAnalyticsApi;
    mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
  }
  
  private void sendToServer(String paramString)
  {
    paramString = new CrashLogHandler.CrashLogEvent.Builder(paramString).build();
    mUpsightAnalytics.record(paramString);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      ((Throwable)localObject).printStackTrace(localPrintWriter);
    }
    localObject = localStringWriter.toString();
    localPrintWriter.close();
    sendToServer((String)localObject);
    mDefaultExceptionHandler.uncaughtException(paramThread, paramThrowable);
  }
  
  @UpsightStorableType("upsight.crash_log")
  public static class CrashLogEvent
    extends UpsightAnalyticsEvent<UpsightData, UpsightPublisherData>
  {
    protected CrashLogEvent() {}
    
    protected CrashLogEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
    {
      super(paramUpsightData, paramUpsightPublisherData);
    }
    
    public static class Builder
      extends UpsightAnalyticsEvent.Builder<CrashLogHandler.CrashLogEvent, CrashLogHandler.CrashLogEvent.UpsightData, UpsightPublisherData>
    {
      private String crashID;
      private UpsightPublisherData publisherData;
      private String stacktrace;
      
      public Builder(String paramString)
      {
        stacktrace = paramString;
        publisherData = new UpsightPublisherData.Builder().build();
      }
      
      public CrashLogHandler.CrashLogEvent build()
      {
        return new CrashLogHandler.CrashLogEvent("upsight.crashlog", new CrashLogHandler.CrashLogEvent.UpsightData(this), publisherData);
      }
      
      public Builder setCrashId(String paramString)
      {
        crashID = paramString;
        return this;
      }
      
      public Builder with(UpsightPublisherData paramUpsightPublisherData)
      {
        publisherData = paramUpsightPublisherData;
        return this;
      }
    }
    
    public static class UpsightData
    {
      @JsonProperty("crashID")
      String crashID;
      @JsonProperty("stacktrace")
      String stacktrace;
      
      protected UpsightData() {}
      
      protected UpsightData(CrashLogHandler.CrashLogEvent.Builder paramBuilder)
      {
        stacktrace = stacktrace;
        crashID = crashID;
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
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.CrashLogHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */