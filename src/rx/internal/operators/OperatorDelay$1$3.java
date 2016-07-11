package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

class OperatorDelay$1$3
  implements Action0
{
  OperatorDelay$1$3(OperatorDelay.1 param1, Object paramObject) {}
  
  public void call()
  {
    if (!this$1.done) {
      this$1.val$child.onNext(val$t);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDelay.1.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */