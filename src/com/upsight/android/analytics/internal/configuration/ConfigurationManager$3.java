package com.upsight.android.analytics.internal.configuration;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class ConfigurationManager$3
  implements UpsightDataStoreListener<Set<UpsightConfiguration>>
{
  ConfigurationManager$3(ConfigurationManager paramConfigurationManager) {}
  
  public void onFailure(UpsightException paramUpsightException) {}
  
  public void onSuccess(Set<UpsightConfiguration> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramSet.next();
      ConfigurationManager.access$500(this$0).remove(localUpsightConfiguration);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */