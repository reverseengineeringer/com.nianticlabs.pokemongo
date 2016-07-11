package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

public final class OperatorFilter<T>
  implements Observable.Operator<T, T>
{
  private final Func1<? super T, Boolean> predicate;
  
  public OperatorFilter(Func1<? super T, Boolean> paramFunc1)
  {
    predicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        try
        {
          if (((Boolean)predicate.call(paramAnonymousT)).booleanValue())
          {
            paramSubscriber.onNext(paramAnonymousT);
            return;
          }
          request(1L);
          return;
        }
        catch (Throwable localThrowable)
        {
          paramSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymousT));
        }
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */