package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorAll<T>
  implements Observable.Operator<Boolean, T>
{
  private final Func1<? super T, Boolean> predicate;
  
  public OperatorAll(Func1<? super T, Boolean> paramFunc1)
  {
    predicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super Boolean> paramSubscriber)
  {
    final SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    Subscriber local1 = new Subscriber()
    {
      boolean done;
      
      public void onCompleted()
      {
        if (!done)
        {
          done = true;
          localSingleDelayedProducer.setValue(Boolean.valueOf(true));
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        try
        {
          Boolean localBoolean = (Boolean)predicate.call(paramAnonymousT);
          if ((!localBoolean.booleanValue()) && (!done))
          {
            done = true;
            localSingleDelayedProducer.setValue(Boolean.valueOf(false));
            unsubscribe();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Exceptions.throwIfFatal(localThrowable);
          onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymousT));
        }
      }
    };
    paramSubscriber.add(local1);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorAll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */