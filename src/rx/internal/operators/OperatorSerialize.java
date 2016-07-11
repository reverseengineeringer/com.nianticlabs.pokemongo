package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSerialize<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorSerialize<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new SerializedSubscriber(new Subscriber(paramSubscriber)
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
        paramSubscriber.onNext(paramAnonymousT);
      }
    });
  }
  
  private static final class Holder
  {
    static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize(null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSerialize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */