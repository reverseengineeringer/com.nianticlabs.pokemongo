package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorDebounceWithTime$1
  extends Subscriber<T>
{
  final Subscriber<?> self = this;
  final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState();
  
  OperatorDebounceWithTime$1(OperatorDebounceWithTime paramOperatorDebounceWithTime, Subscriber paramSubscriber, SerialSubscription paramSerialSubscription, Scheduler.Worker paramWorker, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    state.emitAndComplete(val$s, this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$s.onError(paramThrowable);
    unsubscribe();
    state.clear();
  }
  
  public void onNext(T paramT)
  {
    final int i = state.next(paramT);
    val$ssub.set(val$worker.schedule(new Action0()
    {
      public void call()
      {
        state.emit(i, val$s, self);
      }
    }, this$0.timeout, this$0.unit));
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithTime.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */