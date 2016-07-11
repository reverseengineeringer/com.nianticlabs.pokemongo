package com.upsight.android.analytics.event;

import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.logger.UpsightLogger;

public abstract class UpsightAnalyticsEvent$Builder<T extends UpsightAnalyticsEvent<U, P>, U, P>
{
  protected abstract T build();
  
  public final T record(UpsightContext paramUpsightContext)
  {
    UpsightAnalyticsEvent localUpsightAnalyticsEvent = build();
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().record(localUpsightAnalyticsEvent);
      return localUpsightAnalyticsEvent;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return localUpsightAnalyticsEvent;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightAnalyticsEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */