package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public class OperatorDoOnSubscribe<T>
  implements Observable.Operator<T, T>
{
  private final Action0 subscribe;
  
  public OperatorDoOnSubscribe(Action0 paramAction0)
  {
    subscribe = paramAction0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    subscribe.call();
    return Subscribers.wrap(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDoOnSubscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */