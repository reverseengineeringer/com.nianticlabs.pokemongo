package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Subscriber;
import rx.functions.Action0;

final class OperatorSampleWithTime$SamplerSubscriber<T>
  extends Subscriber<T>
  implements Action0
{
  private static final Object EMPTY_TOKEN = new Object();
  static final AtomicReferenceFieldUpdater<SamplerSubscriber, Object> VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SamplerSubscriber.class, Object.class, "value");
  private final Subscriber<? super T> subscriber;
  volatile Object value = EMPTY_TOKEN;
  
  public OperatorSampleWithTime$SamplerSubscriber(Subscriber<? super T> paramSubscriber)
  {
    subscriber = paramSubscriber;
  }
  
  public void call()
  {
    Object localObject = VALUE_UPDATER.getAndSet(this, EMPTY_TOKEN);
    if (localObject != EMPTY_TOKEN) {}
    try
    {
      subscriber.onNext(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  public void onCompleted()
  {
    subscriber.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    subscriber.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    value = paramT;
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSampleWithTime.SamplerSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */