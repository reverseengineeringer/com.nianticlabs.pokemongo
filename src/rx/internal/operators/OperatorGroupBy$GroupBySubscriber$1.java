package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.functions.Action0;

class OperatorGroupBy$GroupBySubscriber$1
  implements Action0
{
  OperatorGroupBy$GroupBySubscriber$1(OperatorGroupBy.GroupBySubscriber paramGroupBySubscriber) {}
  
  public void call()
  {
    if (OperatorGroupBy.GroupBySubscriber.WIP_FOR_UNSUBSCRIBE_UPDATER.decrementAndGet(this$0.self) == 0) {
      this$0.self.unsubscribe();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */