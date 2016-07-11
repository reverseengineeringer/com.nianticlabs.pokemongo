package rx.internal.operators;

import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

class OperatorTimestamp$1
  extends Subscriber<T>
{
  OperatorTimestamp$1(OperatorTimestamp paramOperatorTimestamp, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$o.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$o.onNext(new Timestamped(OperatorTimestamp.access$000(this$0).now(), paramT));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimestamp.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */