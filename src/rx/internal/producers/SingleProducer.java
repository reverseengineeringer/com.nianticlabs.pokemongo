package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;

public final class SingleProducer<T>
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = -3353584923995471404L;
  final Subscriber<? super T> child;
  final T value;
  
  public SingleProducer(Subscriber<? super T> paramSubscriber, T paramT)
  {
    child = paramSubscriber;
    value = paramT;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if (paramLong == 0L) {
      break label22;
    }
    for (;;)
    {
      label22:
      return;
      if (compareAndSet(false, true))
      {
        Subscriber localSubscriber = child;
        Object localObject = value;
        if (localSubscriber.isUnsubscribed()) {
          break;
        }
        try
        {
          localSubscriber.onNext(localObject);
          if (!localSubscriber.isUnsubscribed())
          {
            localSubscriber.onCompleted();
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          Exceptions.throwIfFatal(localThrowable);
          localSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, localObject));
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.producers.SingleProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */