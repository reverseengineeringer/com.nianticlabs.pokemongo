package rx.internal.operators;

import rx.Subscriber;

class OperatorTimeoutWithSelector$1$1
  extends Subscriber<U>
{
  OperatorTimeoutWithSelector$1$1(OperatorTimeoutWithSelector.1 param1, OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber, Long paramLong) {}
  
  public void onCompleted()
  {
    val$timeoutSubscriber.onTimeout(val$seqId.longValue());
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$timeoutSubscriber.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    val$timeoutSubscriber.onTimeout(val$seqId.longValue());
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */