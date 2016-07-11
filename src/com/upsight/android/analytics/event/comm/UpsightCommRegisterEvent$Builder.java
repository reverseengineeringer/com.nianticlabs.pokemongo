package com.upsight.android.analytics.event.comm;

import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;

public class UpsightCommRegisterEvent$Builder
  extends AnalyticsEvent.Builder<UpsightCommRegisterEvent, UpsightCommRegisterEvent.UpsightData>
{
  private String token;
  
  protected UpsightCommRegisterEvent build()
  {
    return new UpsightCommRegisterEvent("upsight.comm.register", new UpsightCommRegisterEvent.UpsightData(this), mPublisherDataBuilder.build());
  }
  
  public Builder setToken(String paramString)
  {
    token = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.comm.UpsightCommRegisterEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */