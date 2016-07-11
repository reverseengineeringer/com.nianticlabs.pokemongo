package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T>
  implements Observable.Operator<T, T>
{
  private final Func2<? super T, Integer, Boolean> predicate;
  
  public OperatorSkipWhile(Func2<? super T, Integer, Boolean> paramFunc2)
  {
    predicate = paramFunc2;
  }
  
  public static <T> Func2<T, Integer, Boolean> toPredicate2(Func1<? super T, Boolean> paramFunc1)
  {
    new Func2()
    {
      public Boolean call(T paramAnonymousT, Integer paramAnonymousInteger)
      {
        return (Boolean)val$predicate.call(paramAnonymousT);
      }
    };
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      int index;
      boolean skipping = true;
      
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
        if (!skipping)
        {
          paramSubscriber.onNext(paramAnonymousT);
          return;
        }
        Func2 localFunc2 = predicate;
        int i = index;
        index = (i + 1);
        if (!((Boolean)localFunc2.call(paramAnonymousT, Integer.valueOf(i))).booleanValue())
        {
          skipping = false;
          paramSubscriber.onNext(paramAnonymousT);
          return;
        }
        request(1L);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipWhile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */