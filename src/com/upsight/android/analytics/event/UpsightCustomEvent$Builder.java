package com.upsight.android.analytics.event;

import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public final class UpsightCustomEvent$Builder
  extends AnalyticsEvent.Builder<UpsightCustomEvent, UpsightPublisherData>
{
  private static final String FORMAT = "pub.%s";
  private String type;
  private UpsightPublisherData.Builder upsightDataBuilder = new UpsightPublisherData.Builder();
  
  private UpsightCustomEvent$Builder(String paramString)
  {
    type = String.format("pub.%s", new Object[] { paramString });
  }
  
  protected UpsightCustomEvent build()
  {
    return new UpsightCustomEvent(type, upsightDataBuilder.build(), mPublisherDataBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightCustomEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */