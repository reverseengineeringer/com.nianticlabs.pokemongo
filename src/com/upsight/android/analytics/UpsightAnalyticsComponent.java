package com.upsight.android.analytics;

import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightExtension.BaseComponent;
import com.upsight.android.analytics.internal.DispatcherService;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.analytics.internal.session.SessionManager;

public abstract interface UpsightAnalyticsComponent
  extends UpsightExtension.BaseComponent<UpsightAnalyticsExtension>
{
  public abstract Clock clock();
  
  public abstract void inject(DispatcherService paramDispatcherService);
  
  public abstract SessionManager sessionManager();
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.UpsightAnalyticsComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */