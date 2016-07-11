package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorSkipLast<T>
  implements Observable.Operator<T, T>
{
  private final int count;
  
  public OperatorSkipLast(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("count could not be negative");
    }
    count = paramInt;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private final Deque<Object> deque = new ArrayDeque();
      private final NotificationLite<T> on = NotificationLite.instance();
      
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
        if (count == 0)
        {
          paramSubscriber.onNext(paramAnonymousT);
          return;
        }
        if (deque.size() == count) {
          paramSubscriber.onNext(on.getValue(deque.removeFirst()));
        }
        for (;;)
        {
          deque.offerLast(on.next(paramAnonymousT));
          return;
          request(1L);
        }
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipLast
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */