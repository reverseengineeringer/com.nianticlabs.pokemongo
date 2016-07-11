package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.functions.Action0;

class OperatorGroupBy$GroupBySubscriber$2$3
  implements Action0
{
  OperatorGroupBy$GroupBySubscriber$2$3(OperatorGroupBy.GroupBySubscriber.2 param2, AtomicBoolean paramAtomicBoolean) {}
  
  public void call()
  {
    if (val$once.compareAndSet(false, true)) {
      OperatorGroupBy.GroupBySubscriber.access$400(this$1.this$0, this$1.val$key);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */