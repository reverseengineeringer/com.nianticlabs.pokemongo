package rx.internal.operators;

import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public final class OperatorSkip<T>
  implements Observable.Operator<T, T>
{
  final int toSkip;
  
  public OperatorSkip(int paramInt)
  {
    toSkip = paramInt;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      int skipped = 0;
      
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
        if (skipped >= toSkip)
        {
          paramSubscriber.onNext(paramAnonymousT);
          return;
        }
        skipped += 1;
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        paramSubscriber.setProducer(paramAnonymousProducer);
        paramAnonymousProducer.request(toSkip);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */