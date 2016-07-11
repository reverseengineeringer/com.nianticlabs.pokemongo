package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends E> other;
  
  public OperatorTakeUntil(Observable<? extends E> paramObservable)
  {
    other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    final SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    final Subscriber local1 = new Subscriber(localSerializedSubscriber, false)
    {
      public void onCompleted()
      {
        try
        {
          localSerializedSubscriber.onCompleted();
          return;
        }
        finally
        {
          localSerializedSubscriber.unsubscribe();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        try
        {
          localSerializedSubscriber.onError(paramAnonymousThrowable);
          return;
        }
        finally
        {
          localSerializedSubscriber.unsubscribe();
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        localSerializedSubscriber.onNext(paramAnonymousT);
      }
    };
    Subscriber local2 = new Subscriber()
    {
      public void onCompleted()
      {
        local1.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        local1.onError(paramAnonymousThrowable);
      }
      
      public void onNext(E paramAnonymousE)
      {
        onCompleted();
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
    localSerializedSubscriber.add(local1);
    localSerializedSubscriber.add(local2);
    paramSubscriber.add(localSerializedSubscriber);
    other.unsafeSubscribe(local2);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */