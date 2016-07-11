package rx.internal.operators;

import rx.Subscriber;

class OperatorTimeoutWithSelector$2$1
  extends Subscriber<V>
{
  OperatorTimeoutWithSelector$2$1(OperatorTimeoutWithSelector.2 param2, OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber, Long paramLong) {}
  
  public void onCompleted()
  {
    val$timeoutSubscriber.onTimeout(val$seqId.longValue());
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$timeoutSubscriber.onError(paramThrowable);
  }
  
  public void onNext(V paramV)
  {
    val$timeoutSubscriber.onTimeout(val$seqId.longValue());
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */