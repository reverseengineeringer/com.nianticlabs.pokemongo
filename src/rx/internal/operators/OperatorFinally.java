package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorFinally<T>
  implements Observable.Operator<T, T>
{
  final Action0 action;
  
  public OperatorFinally(Action0 paramAction0)
  {
    action = paramAction0;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        try
        {
          paramSubscriber.onCompleted();
          return;
        }
        finally
        {
          action.call();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        try
        {
          paramSubscriber.onError(paramAnonymousThrowable);
          return;
        }
        finally
        {
          action.call();
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSubscriber.onNext(paramAnonymousT);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorFinally
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */