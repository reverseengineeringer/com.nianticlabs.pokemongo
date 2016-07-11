package com.upsight.android.analytics.internal.configuration;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class ConfigurationManager$1
  implements UpsightDataStoreListener<Set<UpsightConfiguration>>
{
  ConfigurationManager$1(ConfigurationManager paramConfigurationManager) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    ConfigurationManager.access$300(this$0).e("Configurator", "Could not fetch existing configs from datastore", new Object[] { paramUpsightException });
    if (ConfigurationManager.access$000(this$0) == null) {
      ConfigurationManager.access$200(this$0);
    }
  }
  
  public void onSuccess(Set<UpsightConfiguration> paramSet)
  {
    if (ConfigurationManager.access$000(this$0) != null) {}
    int i;
    do
    {
      return;
      i = 0;
      boolean bool = false;
      if (paramSet.size() > 0)
      {
        paramSet = paramSet.iterator();
        for (;;)
        {
          i = bool;
          if (!paramSet.hasNext()) {
            break;
          }
          UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramSet.next();
          if (localUpsightConfiguration.getScope().equals("upsight.configuration.configurationManager")) {
            bool = ConfigurationManager.access$100(this$0, localUpsightConfiguration.getConfiguration());
          }
        }
      }
    } while (i != 0);
    ConfigurationManager.access$200(this$0);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */