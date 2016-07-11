package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorDebounceWithSelector$1
  extends Subscriber<T>
{
  final Subscriber<?> self = this;
  final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState();
  
  OperatorDebounceWithSelector$1(OperatorDebounceWithSelector paramOperatorDebounceWithSelector, Subscriber paramSubscriber, SerializedSubscriber paramSerializedSubscriber, SerialSubscription paramSerialSubscription)
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
    try
    {
      Observable localObservable = (Observable)this$0.selector.call(paramT);
      paramT = new Subscriber()
      {
        public void onCompleted()
        {
          state.emit(val$index, val$s, self);
          unsubscribe();
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          self.onError(paramAnonymousThrowable);
        }
        
        public void onNext(U paramAnonymousU)
        {
          onCompleted();
        }
      };
      val$ssub.set(paramT);
      localObservable.unsafeSubscribe(paramT);
      return;
    }
    catch (Throwable paramT)
    {
      onError(paramT);
    }
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithSelector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */