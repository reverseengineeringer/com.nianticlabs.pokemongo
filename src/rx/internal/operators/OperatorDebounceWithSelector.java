package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithSelector<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends Observable<U>> selector;
  
  public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> paramFunc1)
  {
    selector = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    final SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber);
    final SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    new Subscriber(paramSubscriber)
    {
      final Subscriber<?> self = this;
      final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState();
      
      public void onCompleted()
      {
        state.emitAndComplete(localSerializedSubscriber, this);
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        localSerializedSubscriber.onError(paramAnonymousThrowable);
        unsubscribe();
        state.clear();
      }
      
      public void onNext(T paramAnonymousT)
      {
        try
        {
          Observable localObservable = (Observable)selector.call(paramAnonymousT);
          paramAnonymousT = new Subscriber()
          {
            public void onCompleted()
            {
              state.emit(val$index, val$s, self);
              unsubscribe();
            }
            
            public void onError(Throwable paramAnonymous2Throwable)
            {
              self.onError(paramAnonymous2Throwable);
            }
            
            public void onNext(U paramAnonymous2U)
            {
              onCompleted();
            }
          };
          localSerialSubscription.set(paramAnonymousT);
          localObservable.unsafeSubscribe(paramAnonymousT);
          return;
        }
        catch (Throwable paramAnonymousT)
        {
          onError(paramAnonymousT);
        }
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */