package rx.internal.operators;

import rx.Scheduler;
import rx.Subscriber;

class OperatorThrottleFirst$1
  extends Subscriber<T>
{
  private long lastOnNext = 0L;
  
  OperatorThrottleFirst$1(OperatorThrottleFirst paramOperatorThrottleFirst, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = OperatorThrottleFirst.access$000(this$0).now();
    if ((lastOnNext == 0L) || (l - lastOnNext >= OperatorThrottleFirst.access$100(this$0)))
    {
      lastOnNext = l;
      val$subscriber.onNext(paramT);
    }
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorThrottleFirst.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */