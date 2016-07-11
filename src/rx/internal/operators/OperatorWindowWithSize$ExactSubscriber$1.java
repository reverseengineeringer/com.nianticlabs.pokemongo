package rx.internal.operators;

import rx.functions.Action0;

class OperatorWindowWithSize$ExactSubscriber$1
  implements Action0
{
  OperatorWindowWithSize$ExactSubscriber$1(OperatorWindowWithSize.ExactSubscriber paramExactSubscriber) {}
  
  public void call()
  {
    if (this$1.noWindow) {
      this$1.unsubscribe();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.ExactSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */