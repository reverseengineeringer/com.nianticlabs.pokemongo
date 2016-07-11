package com.upsight.android.internal.persistence.subscription;

import com.squareup.otto.Bus;
import com.upsight.android.persistence.UpsightSubscription;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public class Subscriptions
{
  public static final int MAX_QUEUE_LENGTH = 10;
  
  public static AnnotatedSubscriber create(Object paramObject)
  {
    SubscriptionHandlerVisitor localSubscriptionHandlerVisitor = new SubscriptionHandlerVisitor(paramObject);
    new ClassSubscriptionReader(paramObject.getClass()).accept(localSubscriptionHandlerVisitor);
    return new AnnotatedSubscriber(localSubscriptionHandlerVisitor.getHandlers());
  }
  
  public static UpsightSubscription from(Subscription paramSubscription)
  {
    return new SubscriptionAdapter(paramSubscription);
  }
  
  public static <T> Action1<T> publishCreated(Bus paramBus, final String paramString)
  {
    new Action1()
    {
      public void call(T paramAnonymousT)
      {
        val$bus.post(new DataStoreEvent(DataStoreEvent.Action.Created, paramString, paramAnonymousT));
      }
    };
  }
  
  public static <T> Action1<T> publishRemoved(Bus paramBus, final String paramString)
  {
    new Action1()
    {
      public void call(T paramAnonymousT)
      {
        val$bus.post(new DataStoreEvent(DataStoreEvent.Action.Removed, paramString, paramAnonymousT));
      }
    };
  }
  
  public static <T> Action1<T> publishUpdated(Bus paramBus, final String paramString)
  {
    new Action1()
    {
      public void call(T paramAnonymousT)
      {
        val$bus.post(new DataStoreEvent(DataStoreEvent.Action.Updated, paramString, paramAnonymousT));
      }
    };
  }
  
  public static Observable<DataStoreEvent> toObservable(Bus paramBus)
  {
    return Observable.create(new OnSubscribeBus(paramBus)).onBackpressureBlock(10);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.Subscriptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */