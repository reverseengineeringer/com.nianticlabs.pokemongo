package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.dispatcher.AnalyticsEventDeliveryStatus;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;

class Dispatcher$3
  implements UpsightDataStoreListener<AnalyticsEventDeliveryStatus>
{
  Dispatcher$3(Dispatcher paramDispatcher) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    Dispatcher.access$100(this$0).e("Dispatcher", paramUpsightException, "Could not store DeliveryStatus.", new Object[0]);
  }
  
  public void onSuccess(AnalyticsEventDeliveryStatus paramAnalyticsEventDeliveryStatus)
  {
    Dispatcher.access$600(this$0).remove(paramAnalyticsEventDeliveryStatus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Dispatcher.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */