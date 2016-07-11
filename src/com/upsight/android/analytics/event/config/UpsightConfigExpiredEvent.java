package com.upsight.android.analytics.event.config;

import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.config.expired")
public class UpsightConfigExpiredEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightConfigExpiredEvent() {}
  
  protected UpsightConfigExpiredEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder()
  {
    return new Builder();
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightConfigExpiredEvent, UpsightConfigExpiredEvent.UpsightData>
  {
    protected UpsightConfigExpiredEvent build()
    {
      return new UpsightConfigExpiredEvent("upsight.config.expired", new UpsightConfigExpiredEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
  }
  
  static class UpsightData
  {
    protected UpsightData() {}
    
    protected UpsightData(UpsightConfigExpiredEvent.Builder paramBuilder) {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.config.UpsightConfigExpiredEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */