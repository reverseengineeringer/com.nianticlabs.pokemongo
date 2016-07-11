package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

class OperatorTake$1
  extends Subscriber<T>
{
  boolean completed = false;
  int count = 0;
  
  OperatorTake$1(OperatorTake paramOperatorTake, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!completed) {
      val$child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!completed) {
      val$child.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if (!isUnsubscribed())
    {
      int i = count + 1;
      count = i;
      if (i >= this$0.limit) {
        completed = true;
      }
      val$child.onNext(paramT);
      if (completed)
      {
        val$child.onCompleted();
        unsubscribe();
      }
    }
  }
  
  public void setProducer(final Producer paramProducer)
  {
    val$child.setProducer(new Producer()
    {
      final AtomicLong requested = new AtomicLong(0L);
      
      public void request(long paramAnonymousLong)
      {
        if ((paramAnonymousLong > 0L) && (!completed)) {}
        long l1;
        long l2;
        do
        {
          l1 = requested.get();
          l2 = Math.min(paramAnonymousLong, this$0.limit - l1);
          if (l2 == 0L) {
            return;
          }
        } while (!requested.compareAndSet(l1, l1 + l2));
        paramProducer.request(l2);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTake.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */