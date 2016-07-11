package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class OperatorDistinct<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends U> keySelector;
  
  public OperatorDistinct(Func1<? super T, ? extends U> paramFunc1)
  {
    keySelector = paramFunc1;
  }
  
  public static <T> OperatorDistinct<T, T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      Set<U> keyMemory = new HashSet();
      
      public void onCompleted()
      {
        keyMemory = null;
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        keyMemory = null;
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        Object localObject = keySelector.call(paramAnonymousT);
        if (keyMemory.add(localObject))
        {
          paramSubscriber.onNext(paramAnonymousT);
          return;
        }
        request(1L);
      }
    };
  }
  
  private static class Holder
  {
    static final OperatorDistinct<?, ?> INSTANCE = new OperatorDistinct(UtilityFunctions.identity());
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDistinct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */