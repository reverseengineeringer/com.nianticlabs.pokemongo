package rx.internal.operators;

import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.TimeInterval;

class OperatorTimeInterval$1
  extends Subscriber<T>
{
  private long lastTimestamp = OperatorTimeInterval.access$000(this$0).now();
  
  OperatorTimeInterval$1(OperatorTimeInterval paramOperatorTimeInterval, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    long l = OperatorTimeInterval.access$000(this$0).now();
    val$subscriber.onNext(new TimeInterval(l - lastTimestamp, paramT));
    lastTimestamp = l;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeInterval.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */