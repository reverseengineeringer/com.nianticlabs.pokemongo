package rx;

import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T>
  implements Observer<T>, Subscription
{
  private static final Long NOT_SET = Long.valueOf(Long.MIN_VALUE);
  private Producer producer;
  private long requested = NOT_SET.longValue();
  private final Subscriber<?> subscriber;
  private final SubscriptionList subscriptions;
  
  protected Subscriber()
  {
    this(null, false);
  }
  
  protected Subscriber(Subscriber<?> paramSubscriber)
  {
    this(paramSubscriber, true);
  }
  
  protected Subscriber(Subscriber<?> paramSubscriber, boolean paramBoolean)
  {
    subscriber = paramSubscriber;
    if ((paramBoolean) && (paramSubscriber != null)) {}
    for (paramSubscriber = subscriptions;; paramSubscriber = new SubscriptionList())
    {
      subscriptions = paramSubscriber;
      return;
    }
  }
  
  private void addToRequested(long paramLong)
  {
    if (requested == NOT_SET.longValue())
    {
      requested = paramLong;
      return;
    }
    paramLong = requested + paramLong;
    if (paramLong < 0L)
    {
      requested = Long.MAX_VALUE;
      return;
    }
    requested = paramLong;
  }
  
  public final void add(Subscription paramSubscription)
  {
    subscriptions.add(paramSubscription);
  }
  
  public final boolean isUnsubscribed()
  {
    return subscriptions.isUnsubscribed();
  }
  
  public void onStart() {}
  
  protected final void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: " + paramLong);
    }
    try
    {
      if (producer != null)
      {
        Producer localProducer = producer;
        localProducer.request(paramLong);
        return;
      }
      addToRequested(paramLong);
      return;
    }
    finally {}
  }
  
  public void setProducer(Producer paramProducer)
  {
    int j = 0;
    long l;
    try
    {
      l = requested;
      producer = paramProducer;
      int i = j;
      if (subscriber != null)
      {
        i = j;
        if (l == NOT_SET.longValue()) {
          i = 1;
        }
      }
      if (i != 0)
      {
        subscriber.setProducer(producer);
        return;
      }
    }
    finally {}
    if (l == NOT_SET.longValue())
    {
      producer.request(Long.MAX_VALUE);
      return;
    }
    producer.request(l);
  }
  
  public final void unsubscribe()
  {
    subscriptions.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.Subscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */