package com.upsight.android.analytics.event.datacollection;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightDataCollectionEvent$Builder
  extends AnalyticsEvent.Builder<UpsightDataCollectionEvent, UpsightDataCollectionEvent.UpsightData>
{
  private String dataBundle;
  private String format;
  private String streamId;
  private String streamStartTs;
  
  protected UpsightDataCollectionEvent$Builder(String paramString1, String paramString2)
  {
    dataBundle = paramString1;
    streamId = paramString2;
  }
  
  protected UpsightDataCollectionEvent build()
  {
    return new UpsightDataCollectionEvent("upsight.data_collection", new UpsightDataCollectionEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setFormat(String paramString)
  {
    format = paramString;
    return this;
  }
  
  public Builder setStreamStartTs(String paramString)
  {
    streamStartTs = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */