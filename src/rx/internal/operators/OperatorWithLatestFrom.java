package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

public final class OperatorWithLatestFrom<T, U, R>
  implements Observable.Operator<R, T>
{
  static final Object EMPTY = new Object();
  final Observable<? extends U> other;
  final Func2<? super T, ? super U, ? extends R> resultSelector;
  
  public OperatorWithLatestFrom(Observable<? extends U> paramObservable, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    other = paramObservable;
    resultSelector = paramFunc2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    final SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    paramSubscriber.add(localSerializedSubscriber);
    final Object localObject = new AtomicReference(EMPTY);
    paramSubscriber = new Subscriber(localSerializedSubscriber, true)
    {
      public void onCompleted()
      {
        localSerializedSubscriber.onCompleted();
        localSerializedSubscriber.unsubscribe();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        localSerializedSubscriber.onError(paramAnonymousThrowable);
        localSerializedSubscriber.unsubscribe();
      }
      
      public void onNext(T paramAnonymousT)
      {
        Object localObject = localObject.get();
        if (localObject != OperatorWithLatestFrom.EMPTY) {}
        try
        {
          paramAnonymousT = resultSelector.call(paramAnonymousT, localObject);
          localSerializedSubscriber.onNext(paramAnonymousT);
          return;
        }
        catch (Throwable paramAnonymousT)
        {
          onError(paramAnonymousT);
        }
      }
    };
    localObject = new Subscriber()
    {
      public void onCompleted()
      {
        if (localObject.get() == OperatorWithLatestFrom.EMPTY)
        {
          localSerializedSubscriber.onCompleted();
          localSerializedSubscriber.unsubscribe();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        localSerializedSubscriber.onError(paramAnonymousThrowable);
        localSerializedSubscriber.unsubscribe();
      }
      
      public void onNext(U paramAnonymousU)
      {
        localObject.set(paramAnonymousU);
      }
    };
    localSerializedSubscriber.add(paramSubscriber);
    localSerializedSubscriber.add((Subscription)localObject);
    other.unsafeSubscribe((Subscriber)localObject);
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWithLatestFrom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */