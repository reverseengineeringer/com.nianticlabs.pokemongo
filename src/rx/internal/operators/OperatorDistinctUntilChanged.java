package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class OperatorDistinctUntilChanged<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends U> keySelector;
  
  public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> paramFunc1)
  {
    keySelector = paramFunc1;
  }
  
  public static <T> OperatorDistinctUntilChanged<T, T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      boolean hasPrevious;
      U previousKey;
      
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
        Object localObject1 = previousKey;
        Object localObject2 = keySelector.call(paramAnonymousT);
        previousKey = localObject2;
        if (hasPrevious)
        {
          if ((localObject1 != localObject2) && ((localObject2 == null) || (!localObject2.equals(localObject1))))
          {
            paramSubscriber.onNext(paramAnonymousT);
            return;
          }
          request(1L);
          return;
        }
        hasPrevious = true;
        paramSubscriber.onNext(paramAnonymousT);
      }
    };
  }
  
  private static class Holder
  {
    static final OperatorDistinctUntilChanged<?, ?> INSTANCE = new OperatorDistinctUntilChanged(UtilityFunctions.identity());
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDistinctUntilChanged
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */