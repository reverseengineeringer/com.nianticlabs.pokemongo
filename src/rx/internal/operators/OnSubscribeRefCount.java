package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeRefCount<T>
  implements Observable.OnSubscribe<T>
{
  private volatile CompositeSubscription baseSubscription = new CompositeSubscription();
  private final ReentrantLock lock = new ReentrantLock();
  private final ConnectableObservable<? extends T> source;
  private final AtomicInteger subscriptionCount = new AtomicInteger(0);
  
  public OnSubscribeRefCount(ConnectableObservable<? extends T> paramConnectableObservable)
  {
    source = paramConnectableObservable;
  }
  
  private Subscription disconnect(final CompositeSubscription paramCompositeSubscription)
  {
    Subscriptions.create(new Action0()
    {
      public void call()
      {
        lock.lock();
        try
        {
          if ((baseSubscription == paramCompositeSubscription) && (subscriptionCount.decrementAndGet() == 0))
          {
            baseSubscription.unsubscribe();
            OnSubscribeRefCount.access$002(OnSubscribeRefCount.this, new CompositeSubscription());
          }
          return;
        }
        finally
        {
          lock.unlock();
        }
      }
    });
  }
  
  private Action1<Subscription> onSubscribe(final Subscriber<? super T> paramSubscriber, final AtomicBoolean paramAtomicBoolean)
  {
    new Action1()
    {
      public void call(Subscription paramAnonymousSubscription)
      {
        try
        {
          baseSubscription.add(paramAnonymousSubscription);
          doSubscribe(paramSubscriber, baseSubscription);
          return;
        }
        finally
        {
          lock.unlock();
          paramAtomicBoolean.set(false);
        }
      }
    };
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    lock.lock();
    if (subscriptionCount.incrementAndGet() == 1)
    {
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
      try
      {
        source.connect(onSubscribe(paramSubscriber, localAtomicBoolean));
        return;
      }
      finally
      {
        if (localAtomicBoolean.get()) {
          lock.unlock();
        }
      }
    }
    try
    {
      doSubscribe(paramSubscriber, baseSubscription);
      return;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  void doSubscribe(final Subscriber<? super T> paramSubscriber, final CompositeSubscription paramCompositeSubscription)
  {
    paramSubscriber.add(disconnect(paramCompositeSubscription));
    source.unsafeSubscribe(new Subscriber(paramSubscriber)
    {
      void cleanup()
      {
        lock.lock();
        try
        {
          if (baseSubscription == paramCompositeSubscription)
          {
            baseSubscription.unsubscribe();
            OnSubscribeRefCount.access$002(OnSubscribeRefCount.this, new CompositeSubscription());
            subscriptionCount.set(0);
          }
          return;
        }
        finally
        {
          lock.unlock();
        }
      }
      
      public void onCompleted()
      {
        cleanup();
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        cleanup();
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSubscriber.onNext(paramAnonymousT);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */