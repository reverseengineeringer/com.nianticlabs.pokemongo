package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public final class OperatorTake<T>
  implements Observable.Operator<T, T>
{
  final int limit;
  
  public OperatorTake(int paramInt)
  {
    limit = paramInt;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    Subscriber local1 = new Subscriber()
    {
      boolean completed = false;
      int count = 0;
      
      public void onCompleted()
      {
        if (!completed) {
          paramSubscriber.onCompleted();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (!completed) {
          paramSubscriber.onError(paramAnonymousThrowable);
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (!isUnsubscribed())
        {
          int i = count + 1;
          count = i;
          if (i >= limit) {
            completed = true;
          }
          paramSubscriber.onNext(paramAnonymousT);
          if (completed)
          {
            paramSubscriber.onCompleted();
            unsubscribe();
          }
        }
      }
      
      public void setProducer(final Producer paramAnonymousProducer)
      {
        paramSubscriber.setProducer(new Producer()
        {
          final AtomicLong requested = new AtomicLong(0L);
          
          public void request(long paramAnonymous2Long)
          {
            if ((paramAnonymous2Long > 0L) && (!completed)) {}
            long l1;
            long l2;
            do
            {
              l1 = requested.get();
              l2 = Math.min(paramAnonymous2Long, limit - l1);
              if (l2 == 0L) {
                return;
              }
            } while (!requested.compareAndSet(l1, l1 + l2));
            paramAnonymousProducer.request(l2);
          }
        });
      }
    };
    if (limit == 0)
    {
      paramSubscriber.onCompleted();
      local1.unsubscribe();
    }
    paramSubscriber.add(local1);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTake
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */