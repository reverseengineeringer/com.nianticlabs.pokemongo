package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subjects.BehaviorSubject;

class OnSubscribeRedo$2$1
  extends Subscriber<T>
{
  boolean done;
  
  OnSubscribeRedo$2$1(OnSubscribeRedo.2 param2) {}
  
  private void decrementConsumerCapacity()
  {
    long l;
    do
    {
      l = this$1.val$consumerCapacity.get();
    } while ((l != Long.MAX_VALUE) && (!this$1.val$consumerCapacity.compareAndSet(l, l - 1L)));
  }
  
  public void onCompleted()
  {
    if (!done)
    {
      done = true;
      unsubscribe();
      this$1.val$terminals.onNext(Notification.createOnCompleted());
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!done)
    {
      done = true;
      unsubscribe();
      this$1.val$terminals.onNext(Notification.createOnError(paramThrowable));
    }
  }
  
  public void onNext(T paramT)
  {
    if (!done)
    {
      this$1.val$child.onNext(paramT);
      decrementConsumerCapacity();
      this$1.val$arbiter.produced(1L);
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this$1.val$arbiter.setProducer(paramProducer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */