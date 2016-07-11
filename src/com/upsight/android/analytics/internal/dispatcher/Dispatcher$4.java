package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.dispatcher.EndpointResponse;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;

class Dispatcher$4
  implements UpsightDataStoreListener<EndpointResponse>
{
  Dispatcher$4(Dispatcher paramDispatcher) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    Dispatcher.access$100(this$0).e("Dispatcher", paramUpsightException, "Could not store EndpointResponse.", new Object[0]);
  }
  
  public void onSuccess(EndpointResponse paramEndpointResponse)
  {
    Dispatcher.access$600(this$0).remove(paramEndpointResponse);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Dispatcher.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */