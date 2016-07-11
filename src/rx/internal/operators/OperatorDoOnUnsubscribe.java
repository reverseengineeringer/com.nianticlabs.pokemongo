package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;
import rx.subscriptions.Subscriptions;

public class OperatorDoOnUnsubscribe<T>
  implements Observable.Operator<T, T>
{
  private final Action0 unsubscribe;
  
  public OperatorDoOnUnsubscribe(Action0 paramAction0)
  {
    unsubscribe = paramAction0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(Subscriptions.create(unsubscribe));
    return Subscribers.wrap(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDoOnUnsubscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */