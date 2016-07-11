package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

class OperatorSingle$1
  implements Producer
{
  private final AtomicBoolean requestedTwo = new AtomicBoolean(false);
  
  OperatorSingle$1(OperatorSingle paramOperatorSingle, OperatorSingle.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    if ((paramLong > 0L) && (requestedTwo.compareAndSet(false, true))) {
      val$parent.requestMore(2L);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSingle.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */