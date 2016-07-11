package rx.internal.operators;

import rx.functions.Action0;

class OperatorWindowWithSize$InexactSubscriber$1
  implements Action0
{
  OperatorWindowWithSize$InexactSubscriber$1(OperatorWindowWithSize.InexactSubscriber paramInexactSubscriber) {}
  
  public void call()
  {
    if (this$1.noWindow) {
      this$1.unsubscribe();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.InexactSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */