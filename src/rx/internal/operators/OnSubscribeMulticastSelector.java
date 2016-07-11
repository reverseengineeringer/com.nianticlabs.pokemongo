package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;
import rx.observers.SafeSubscriber;
import rx.subjects.Subject;

public final class OnSubscribeMulticastSelector<TInput, TIntermediate, TResult>
  implements Observable.OnSubscribe<TResult>
{
  final Func1<? super Observable<TIntermediate>, ? extends Observable<TResult>> resultSelector;
  final Observable<? extends TInput> source;
  final Func0<? extends Subject<? super TInput, ? extends TIntermediate>> subjectFactory;
  
  public OnSubscribeMulticastSelector(Observable<? extends TInput> paramObservable, Func0<? extends Subject<? super TInput, ? extends TIntermediate>> paramFunc0, Func1<? super Observable<TIntermediate>, ? extends Observable<TResult>> paramFunc1)
  {
    source = paramObservable;
    subjectFactory = paramFunc0;
    resultSelector = paramFunc1;
  }
  
  public void call(final Subscriber<? super TResult> paramSubscriber)
  {
    try
    {
      OperatorMulticast localOperatorMulticast = new OperatorMulticast(source, subjectFactory);
      Observable localObservable = (Observable)resultSelector.call(localOperatorMulticast);
      paramSubscriber = new SafeSubscriber(paramSubscriber);
      localObservable.unsafeSubscribe(paramSubscriber);
      localOperatorMulticast.connect(new Action1()
      {
        public void call(Subscription paramAnonymousSubscription)
        {
          paramSubscriber.add(paramAnonymousSubscription);
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeMulticastSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */