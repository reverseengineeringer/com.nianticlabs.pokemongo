package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action0;

class OperatorPublish$PublishSubscriber$1
  implements Action0
{
  OperatorPublish$PublishSubscriber$1(OperatorPublish.PublishSubscriber paramPublishSubscriber) {}
  
  public void call()
  {
    this$0.producers.getAndSet(OperatorPublish.PublishSubscriber.TERMINATED);
    this$0.current.compareAndSet(this$0, null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish.PublishSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */