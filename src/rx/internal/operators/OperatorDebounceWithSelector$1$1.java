package rx.internal.operators;

import rx.Subscriber;

class OperatorDebounceWithSelector$1$1
  extends Subscriber<U>
{
  OperatorDebounceWithSelector$1$1(OperatorDebounceWithSelector.1 param1, int paramInt) {}
  
  public void onCompleted()
  {
    this$1.state.emit(val$index, this$1.val$s, this$1.self);
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.self.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithSelector.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */