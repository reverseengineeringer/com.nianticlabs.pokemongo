package rx.internal.operators;

import java.util.concurrent.BlockingQueue;
import rx.Notification;
import rx.Subscriber;

final class BlockingOperatorToIterator$1
  extends Subscriber<Notification<? extends T>>
{
  BlockingOperatorToIterator$1(BlockingQueue paramBlockingQueue) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    val$notifications.offer(Notification.createOnError(paramThrowable));
  }
  
  public void onNext(Notification<? extends T> paramNotification)
  {
    val$notifications.offer(paramNotification);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorToIterator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */