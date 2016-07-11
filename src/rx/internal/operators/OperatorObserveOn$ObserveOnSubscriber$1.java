package rx.internal.operators;

import rx.Producer;

class OperatorObserveOn$ObserveOnSubscriber$1
  implements Producer
{
  OperatorObserveOn$ObserveOnSubscriber$1(OperatorObserveOn.ObserveOnSubscriber paramObserveOnSubscriber) {}
  
  public void request(long paramLong)
  {
    BackpressureUtils.getAndAddRequest(OperatorObserveOn.ObserveOnSubscriber.REQUESTED, this$0, paramLong);
    this$0.schedule();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */