package com.upsight.android.internal.persistence.subscription;

import android.util.Log;
import com.upsight.android.UpsightException;
import java.util.Iterator;
import java.util.Set;
import rx.Subscriber;

class AnnotatedSubscriber
  extends Subscriber<DataStoreEvent>
{
  private final Set<SubscriptionHandler> mHandlers;
  
  AnnotatedSubscriber(Set<SubscriptionHandler> paramSet)
  {
    mHandlers = paramSet;
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(DataStoreEvent paramDataStoreEvent)
  {
    Iterator localIterator = mHandlers.iterator();
    while (localIterator.hasNext())
    {
      SubscriptionHandler localSubscriptionHandler = (SubscriptionHandler)localIterator.next();
      if (localSubscriptionHandler.matches(action, sourceType)) {
        try
        {
          localSubscriptionHandler.handle(paramDataStoreEvent);
        }
        catch (UpsightException localUpsightException)
        {
          Log.e("Upsight", "Failed to handle subscription.", localUpsightException);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.AnnotatedSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */