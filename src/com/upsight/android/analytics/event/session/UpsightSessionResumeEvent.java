package com.upsight.android.analytics.event.session;

import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.session.resume")
public class UpsightSessionResumeEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightSessionResumeEvent() {}
  
  protected UpsightSessionResumeEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder()
  {
    return new Builder();
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightSessionResumeEvent, UpsightSessionResumeEvent.UpsightData>
  {
    protected UpsightSessionResumeEvent build()
    {
      return new UpsightSessionResumeEvent("upsight.session.resume", new UpsightSessionResumeEvent.UpsightData(this), mPublisherDataBuilder.build());
    }
  }
  
  static class UpsightData
  {
    protected UpsightData() {}
    
    protected UpsightData(UpsightSessionResumeEvent.Builder paramBuilder) {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.session.UpsightSessionResumeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */