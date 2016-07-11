package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithSize$ExactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  int count;
  volatile boolean noWindow = true;
  BufferUntilSubscriber<T> window;
  
  public OperatorWindowWithSize$ExactSubscriber(Subscriber<? super Observable<T>> paramSubscriber)
  {
    Subscriber localSubscriber;
    child = localSubscriber;
  }
  
  void init()
  {
    child.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        if (noWindow) {
          unsubscribe();
        }
      }
    }));
    child.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        if (paramAnonymousLong > 0L)
        {
          long l2 = paramAnonymousLong * this$0.size;
          long l1 = l2;
          if (l2 >>> 31 != 0L)
          {
            l1 = l2;
            if (l2 / paramAnonymousLong != this$0.size) {
              l1 = Long.MAX_VALUE;
            }
          }
          requestMore(l1);
        }
      }
    });
  }
  
  public void onCompleted()
  {
    if (window != null) {
      window.onCompleted();
    }
    child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (window != null) {
      window.onError(paramThrowable);
    }
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (window == null)
    {
      noWindow = false;
      window = BufferUntilSubscriber.create();
      child.onNext(window);
    }
    window.onNext(paramT);
    int i = count + 1;
    count = i;
    if (i % this$0.size == 0)
    {
      window.onCompleted();
      window = null;
      noWindow = true;
      if (child.isUnsubscribed()) {
        unsubscribe();
      }
    }
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.ExactSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */