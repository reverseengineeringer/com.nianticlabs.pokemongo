package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class Dispatcher$2
  implements UpsightDataStoreListener<Set<UpsightConfiguration>>
{
  Dispatcher$2(Dispatcher paramDispatcher) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    Dispatcher.access$100(this$0).e("Dispatcher", "Could not fetch config from store.", new Object[] { paramUpsightException });
    if (Dispatcher.access$200(this$0) == null) {
      Dispatcher.access$500(this$0);
    }
  }
  
  public void onSuccess(Set<UpsightConfiguration> paramSet)
  {
    if (Dispatcher.access$200(this$0) != null) {}
    boolean bool;
    do
    {
      return;
      bool = false;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramSet.next();
        if (("upsight.configuration.dispatcher".equals(localUpsightConfiguration.getScope())) && (Dispatcher.access$300(this$0, localUpsightConfiguration))) {
          bool = Dispatcher.access$400(this$0, localUpsightConfiguration.getConfiguration());
        }
      }
    } while (bool);
    Dispatcher.access$500(this$0);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Dispatcher.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */