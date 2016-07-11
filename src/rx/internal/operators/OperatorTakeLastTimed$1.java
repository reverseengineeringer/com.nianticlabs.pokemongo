package rx.internal.operators;

import java.util.Deque;
import rx.Scheduler;
import rx.Subscriber;

class OperatorTakeLastTimed$1
  extends Subscriber<T>
{
  OperatorTakeLastTimed$1(OperatorTakeLastTimed paramOperatorTakeLastTimed, Subscriber paramSubscriber1, Deque paramDeque1, Deque paramDeque2, NotificationLite paramNotificationLite, Subscriber paramSubscriber2, TakeLastQueueProducer paramTakeLastQueueProducer)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    runEvictionPolicy(OperatorTakeLastTimed.access$200(this$0).now());
    val$timestampBuffer.clear();
    val$buffer.offer(val$notification.completed());
    val$producer.startEmitting();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$timestampBuffer.clear();
    val$buffer.clear();
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = OperatorTakeLastTimed.access$200(this$0).now();
    val$timestampBuffer.add(Long.valueOf(l));
    val$buffer.add(val$notification.next(paramT));
    runEvictionPolicy(l);
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
  
  protected void runEvictionPolicy(long paramLong)
  {
    while ((OperatorTakeLastTimed.access$000(this$0) >= 0) && (val$buffer.size() > OperatorTakeLastTimed.access$000(this$0)))
    {
      val$timestampBuffer.pollFirst();
      val$buffer.pollFirst();
    }
    while ((!val$buffer.isEmpty()) && (((Long)val$timestampBuffer.peekFirst()).longValue() < paramLong - OperatorTakeLastTimed.access$100(this$0)))
    {
      val$timestampBuffer.pollFirst();
      val$buffer.pollFirst();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeLastTimed.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */