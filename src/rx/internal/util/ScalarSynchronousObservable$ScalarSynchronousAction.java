package rx.internal.util;

import rx.Subscriber;
import rx.functions.Action0;

final class ScalarSynchronousObservable$ScalarSynchronousAction<T>
  implements Action0
{
  private final Subscriber<? super T> subscriber;
  private final T value;
  
  private ScalarSynchronousObservable$ScalarSynchronousAction(Subscriber<? super T> paramSubscriber, T paramT)
  {
    subscriber = paramSubscriber;
    value = paramT;
  }
  
  public void call()
  {
    try
    {
      subscriber.onNext(value);
      subscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      subscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.ScalarSynchronousAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */