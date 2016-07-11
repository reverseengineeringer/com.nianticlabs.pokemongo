package com.upsight.android.analytics.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent.Builder;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.crash_log")
public class CrashLogHandler$CrashLogEvent
  extends UpsightAnalyticsEvent<UpsightData, UpsightPublisherData>
{
  protected CrashLogHandler$CrashLogEvent() {}
  
  protected CrashLogHandler$CrashLogEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.CrashLogHandler.CrashLogEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */