package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

class OperatorSkipLastTimed$1
  extends Subscriber<T>
{
  private Deque<Timestamped<T>> buffer = new ArrayDeque();
  
  OperatorSkipLastTimed$1(OperatorSkipLastTimed paramOperatorSkipLastTimed, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  private void emitItemsOutOfWindow(long paramLong)
  {
    long l = OperatorSkipLastTimed.access$000(this$0);
    while (!buffer.isEmpty())
    {
      Timestamped localTimestamped = (Timestamped)buffer.getFirst();
      if (localTimestamped.getTimestampMillis() >= paramLong - l) {
        break;
      }
      buffer.removeFirst();
      val$subscriber.onNext(localTimestamped.getValue());
    }
  }
  
  public void onCompleted()
  {
    emitItemsOutOfWindow(OperatorSkipLastTimed.access$100(this$0).now());
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = OperatorSkipLastTimed.access$100(this$0).now();
    emitItemsOutOfWindow(l);
    buffer.offerLast(new Timestamped(l, paramT));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipLastTimed.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */