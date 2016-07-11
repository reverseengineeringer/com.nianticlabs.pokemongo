package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;

class OnSubscribeRedo$4$1
  extends Subscriber<Object>
{
  OnSubscribeRedo$4$1(OnSubscribeRedo.4 param4, Subscriber paramSubscriber)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    this$1.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.val$child.onError(paramThrowable);
  }
  
  public void onNext(Object paramObject)
  {
    if (!this$1.val$child.isUnsubscribed())
    {
      if (this$1.val$consumerCapacity.get() > 0L) {
        this$1.val$worker.schedule(this$1.val$subscribeToSource);
      }
    }
    else {
      return;
    }
    this$1.val$resumeBoundary.compareAndSet(false, true);
  }
  
  public void setProducer(Producer paramProducer)
  {
    paramProducer.request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.4.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */