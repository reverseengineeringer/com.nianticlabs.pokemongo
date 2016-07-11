package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import rx.functions.Action0;

class OperatorConcat$ConcatSubscriber$1
  implements Action0
{
  OperatorConcat$ConcatSubscriber$1(OperatorConcat.ConcatSubscriber paramConcatSubscriber) {}
  
  public void call()
  {
    this$0.queue.clear();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorConcat.ConcatSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */