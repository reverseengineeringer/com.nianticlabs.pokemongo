package rx.internal.operators;

import rx.functions.Action0;

class OperatorWindowWithTime$ExactSubscriber$1
  implements Action0
{
  OperatorWindowWithTime$ExactSubscriber$1(OperatorWindowWithTime.ExactSubscriber paramExactSubscriber, OperatorWindowWithTime paramOperatorWindowWithTime) {}
  
  public void call()
  {
    if (this$1.state.consumer == null) {
      this$1.unsubscribe();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */