package com.upsight.android.analytics.internal.configuration;

import com.upsight.android.analytics.event.config.UpsightConfigExpiredEvent;
import com.upsight.android.analytics.event.config.UpsightConfigExpiredEvent.Builder;
import rx.functions.Action0;

class ConfigurationManager$2
  implements Action0
{
  ConfigurationManager$2(ConfigurationManager paramConfigurationManager) {}
  
  public void call()
  {
    UpsightConfigExpiredEvent.createBuilder().record(ConfigurationManager.access$400(this$0));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */