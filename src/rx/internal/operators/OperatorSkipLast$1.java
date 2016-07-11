package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Subscriber;

class OperatorSkipLast$1
  extends Subscriber<T>
{
  private final Deque<Object> deque = new ArrayDeque();
  private final NotificationLite<T> on = NotificationLite.instance();
  
  OperatorSkipLast$1(OperatorSkipLast paramOperatorSkipLast, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    if (OperatorSkipLast.access$000(this$0) == 0)
    {
      val$subscriber.onNext(paramT);
      return;
    }
    if (deque.size() == OperatorSkipLast.access$000(this$0)) {
      val$subscriber.onNext(on.getValue(deque.removeFirst()));
    }
    for (;;)
    {
      deque.offerLast(on.next(paramT));
      return;
      request(1L);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipLast.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */