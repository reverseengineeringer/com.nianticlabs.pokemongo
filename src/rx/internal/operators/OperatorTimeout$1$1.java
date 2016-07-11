package rx.internal.operators;

import rx.functions.Action0;

class OperatorTimeout$1$1
  implements Action0
{
  OperatorTimeout$1$1(OperatorTimeout.1 param1, OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber, Long paramLong) {}
  
  public void call()
  {
    val$timeoutSubscriber.onTimeout(val$seqId.longValue());
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeout.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */