package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorAny<T>
  implements Observable.Operator<Boolean, T>
{
  private final Func1<? super T, Boolean> predicate;
  private final boolean returnOnEmpty;
  
  public OperatorAny(Func1<? super T, Boolean> paramFunc1, boolean paramBoolean)
  {
    predicate = paramFunc1;
    returnOnEmpty = paramBoolean;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super Boolean> paramSubscriber)
  {
    final SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    Subscriber local1 = new Subscriber()
    {
      boolean done;
      boolean hasElements;
      
      public void onCompleted()
      {
        if (!done)
        {
          done = true;
          if (hasElements) {
            localSingleDelayedProducer.setValue(Boolean.valueOf(false));
          }
        }
        else
        {
          return;
        }
        localSingleDelayedProducer.setValue(Boolean.valueOf(returnOnEmpty));
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        hasElements = true;
        for (;;)
        {
          try
          {
            bool = ((Boolean)predicate.call(paramAnonymousT)).booleanValue();
            if ((bool) && (!done))
            {
              done = true;
              paramAnonymousT = localSingleDelayedProducer;
              if (!returnOnEmpty)
              {
                bool = true;
                paramAnonymousT.setValue(Boolean.valueOf(bool));
                unsubscribe();
              }
            }
            else
            {
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwIfFatal(localThrowable);
            onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymousT));
            return;
          }
          boolean bool = false;
        }
      }
    };
    paramSubscriber.add(local1);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorAny
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */