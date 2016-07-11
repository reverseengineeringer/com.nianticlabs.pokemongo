package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;
import rx.functions.Func2;

public final class OperatorScan<R, T>
  implements Observable.Operator<R, T>
{
  private static final Object NO_INITIAL_VALUE = new Object();
  private final Func2<R, ? super T, R> accumulator;
  private final Func0<R> initialValueFactory;
  
  public OperatorScan(R paramR, Func2<R, ? super T, R> paramFunc2)
  {
    this(new Func0()
    {
      public R call()
      {
        return OperatorScan.this;
      }
    }, paramFunc2);
  }
  
  public OperatorScan(Func0<R> paramFunc0, Func2<R, ? super T, R> paramFunc2)
  {
    initialValueFactory = paramFunc0;
    accumulator = paramFunc2;
  }
  
  public OperatorScan(Func2<R, ? super T, R> paramFunc2)
  {
    this(NO_INITIAL_VALUE, paramFunc2);
  }
  
  public Subscriber<? super T> call(final Subscriber<? super R> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private final R initialValue = initialValueFactory.call();
      boolean initialized = false;
      private R value = initialValue;
      
      private void emitInitialValueIfNeeded(Subscriber<? super R> paramAnonymousSubscriber)
      {
        if (!initialized)
        {
          initialized = true;
          if (initialValue != OperatorScan.NO_INITIAL_VALUE) {
            paramAnonymousSubscriber.onNext(initialValue);
          }
        }
      }
      
      public void onCompleted()
      {
        emitInitialValueIfNeeded(paramSubscriber);
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        emitInitialValueIfNeeded(paramSubscriber);
        if (value == OperatorScan.NO_INITIAL_VALUE) {
          value = paramAnonymousT;
        }
        for (;;)
        {
          paramSubscriber.onNext(value);
          return;
          try
          {
            value = accumulator.call(value, paramAnonymousT);
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwIfFatal(localThrowable);
            paramSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymousT));
          }
        }
      }
      
      public void setProducer(final Producer paramAnonymousProducer)
      {
        paramSubscriber.setProducer(new Producer()
        {
          final AtomicBoolean excessive = new AtomicBoolean();
          final AtomicBoolean once = new AtomicBoolean();
          
          public void request(long paramAnonymous2Long)
          {
            if (once.compareAndSet(false, true))
            {
              if ((initialValue == OperatorScan.NO_INITIAL_VALUE) || (paramAnonymous2Long == Long.MAX_VALUE))
              {
                paramAnonymousProducer.request(paramAnonymous2Long);
                return;
              }
              if (paramAnonymous2Long == 1L)
              {
                excessive.set(true);
                paramAnonymousProducer.request(1L);
                return;
              }
              paramAnonymousProducer.request(paramAnonymous2Long - 1L);
              return;
            }
            if ((paramAnonymous2Long > 1L) && (excessive.compareAndSet(true, false)) && (paramAnonymous2Long != Long.MAX_VALUE))
            {
              paramAnonymousProducer.request(paramAnonymous2Long - 1L);
              return;
            }
            paramAnonymousProducer.request(paramAnonymous2Long);
          }
        });
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorScan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */