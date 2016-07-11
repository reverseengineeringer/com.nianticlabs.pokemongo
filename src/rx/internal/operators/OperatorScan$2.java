package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;
import rx.functions.Func2;

class OperatorScan$2
  extends Subscriber<T>
{
  private final R initialValue = OperatorScan.access$000(this$0).call();
  boolean initialized = false;
  private R value = initialValue;
  
  OperatorScan$2(OperatorScan paramOperatorScan, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  private void emitInitialValueIfNeeded(Subscriber<? super R> paramSubscriber)
  {
    if (!initialized)
    {
      initialized = true;
      if (initialValue != OperatorScan.access$100()) {
        paramSubscriber.onNext(initialValue);
      }
    }
  }
  
  public void onCompleted()
  {
    emitInitialValueIfNeeded(val$child);
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    emitInitialValueIfNeeded(val$child);
    if (value == OperatorScan.access$100()) {
      value = paramT;
    }
    for (;;)
    {
      val$child.onNext(value);
      return;
      try
      {
        value = OperatorScan.access$200(this$0).call(value, paramT);
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        val$child.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
      }
    }
  }
  
  public void setProducer(final Producer paramProducer)
  {
    val$child.setProducer(new Producer()
    {
      final AtomicBoolean excessive = new AtomicBoolean();
      final AtomicBoolean once = new AtomicBoolean();
      
      public void request(long paramAnonymousLong)
      {
        if (once.compareAndSet(false, true))
        {
          if ((initialValue == OperatorScan.access$100()) || (paramAnonymousLong == Long.MAX_VALUE))
          {
            paramProducer.request(paramAnonymousLong);
            return;
          }
          if (paramAnonymousLong == 1L)
          {
            excessive.set(true);
            paramProducer.request(1L);
            return;
          }
          paramProducer.request(paramAnonymousLong - 1L);
          return;
        }
        if ((paramAnonymousLong > 1L) && (excessive.compareAndSet(true, false)) && (paramAnonymousLong != Long.MAX_VALUE))
        {
          paramProducer.request(paramAnonymousLong - 1L);
          return;
        }
        paramProducer.request(paramAnonymousLong);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorScan.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */