package rx.internal.operators;

import java.util.Deque;
import rx.Subscriber;

class OperatorTakeLast$1
  extends Subscriber<T>
{
  OperatorTakeLast$1(OperatorTakeLast paramOperatorTakeLast, Subscriber paramSubscriber1, Deque paramDeque, NotificationLite paramNotificationLite, TakeLastQueueProducer paramTakeLastQueueProducer, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$deque.offer(val$notification.completed());
    val$producer.startEmitting();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$deque.clear();
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (OperatorTakeLast.access$000(this$0) == 0) {
      return;
    }
    if (val$deque.size() == OperatorTakeLast.access$000(this$0)) {
      val$deque.removeFirst();
    }
    val$deque.offerLast(val$notification.next(paramT));
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeLast.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */