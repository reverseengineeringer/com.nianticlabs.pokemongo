package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeToObservableFuture
{
  private OnSubscribeToObservableFuture()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> paramFuture)
  {
    return new ToObservableFuture(paramFuture);
  }
  
  public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return new ToObservableFuture(paramFuture, paramLong, paramTimeUnit);
  }
  
  static class ToObservableFuture<T>
    implements Observable.OnSubscribe<T>
  {
    private final Future<? extends T> that;
    private final long time;
    private final TimeUnit unit;
    
    public ToObservableFuture(Future<? extends T> paramFuture)
    {
      that = paramFuture;
      time = 0L;
      unit = null;
    }
    
    public ToObservableFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    {
      that = paramFuture;
      time = paramLong;
      unit = paramTimeUnit;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      paramSubscriber.add(Subscriptions.create(new Action0()
      {
        public void call()
        {
          that.cancel(true);
        }
      }));
      try
      {
        if (paramSubscriber.isUnsubscribed()) {
          return;
        }
        if (unit != null) {
          break label64;
        }
        localObject1 = that.get();
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        while (!paramSubscriber.isUnsubscribed())
        {
          paramSubscriber.onError(localThrowable);
          return;
          Object localObject2 = that.get(time, unit);
        }
      }
      paramSubscriber.onNext(localObject1);
      paramSubscriber.onCompleted();
      return;
      label64:
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */