package com.upsight.android.analytics.internal;

import com.upsight.android.analytics.internal.session.Clock;
import java.util.concurrent.TimeUnit;

class BaseAnalyticsModule$1
  implements Clock
{
  BaseAnalyticsModule$1(BaseAnalyticsModule paramBaseAnalyticsModule) {}
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long currentTimeSeconds()
  {
    return TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.BaseAnalyticsModule.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */