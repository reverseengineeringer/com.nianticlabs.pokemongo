package rx.internal.operators;

import java.util.Iterator;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R>
  implements Observable.Operator<R, T1>
{
  final Iterable<? extends T2> iterable;
  final Func2<? super T1, ? super T2, ? extends R> zipFunction;
  
  public OperatorZipIterable(Iterable<? extends T2> paramIterable, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    iterable = paramIterable;
    zipFunction = paramFunc2;
  }
  
  public Subscriber<? super T1> call(final Subscriber<? super R> paramSubscriber)
  {
    final Iterator localIterator = iterable.iterator();
    try
    {
      if (!localIterator.hasNext())
      {
        paramSubscriber.onCompleted();
        Subscriber localSubscriber = Subscribers.empty();
        return localSubscriber;
      }
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
    new Subscriber(paramSubscriber)
    {
      boolean once;
      
      public void onCompleted()
      {
        if (once) {
          return;
        }
        once = true;
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T1 paramAnonymousT1)
      {
        try
        {
          paramSubscriber.onNext(zipFunction.call(paramAnonymousT1, localIterator.next()));
          if (!localIterator.hasNext()) {
            onCompleted();
          }
          return;
        }
        catch (Throwable paramAnonymousT1)
        {
          onError(paramAnonymousT1);
        }
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZipIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */