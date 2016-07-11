package com.upsight.android.analytics.internal;

import com.upsight.android.analytics.event.UpsightAnalyticsEvent.Builder;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;

public class CrashLogHandler$CrashLogEvent$Builder
  extends UpsightAnalyticsEvent.Builder<CrashLogHandler.CrashLogEvent, CrashLogHandler.CrashLogEvent.UpsightData, UpsightPublisherData>
{
  private String crashID;
  private UpsightPublisherData publisherData;
  private String stacktrace;
  
  public CrashLogHandler$CrashLogEvent$Builder(String paramString)
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.CrashLogHandler.CrashLogEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */