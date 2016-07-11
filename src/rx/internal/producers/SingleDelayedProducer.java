package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;

public final class SingleDelayedProducer<T>
  extends AtomicInteger
  implements Producer
{
  static final int HAS_REQUEST_HAS_VALUE = 3;
  static final int HAS_REQUEST_NO_VALUE = 2;
  static final int NO_REQUEST_HAS_VALUE = 1;
  static final int NO_REQUEST_NO_VALUE = 0;
  private static final long serialVersionUID = -2873467947112093874L;
  final Subscriber<? super T> child;
  T value;
  
  public SingleDelayedProducer(Subscriber<? super T> paramSubscriber)
  {
    child = paramSubscriber;
  }
  
  private static <T> void emit(Subscriber<? super T> paramSubscriber, T paramT)
  {
    if (paramSubscriber.isUnsubscribed()) {}
    for (;;)
    {
      return;
      try
      {
        paramSubscriber.onNext(paramT);
        if (!paramSubscriber.isUnsubscribed())
        {
          paramSubscriber.onCompleted();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        paramSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
      }
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if (paramLong == 0L) {}
    int i;
    label44:
    do
    {
      return;
      for (;;)
      {
        i = get();
        if (i != 0) {
          break label44;
        }
        if (compareAndSet(0, 2)) {
          break;
        }
      }
    } while ((i != 1) || (!compareAndSet(1, 3)));
    emit(child, value);
  }
  
  public void setValue(T paramT)
  {
    int i;
    do
    {
      i = get();
      if (i != 0) {
        break;
      }
      value = paramT;
    } while (!compareAndSet(0, 1));
    while ((i != 2) || (!compareAndSet(2, 3))) {
      return;
    }
    emit(child, paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.producers.SingleDelayedProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */