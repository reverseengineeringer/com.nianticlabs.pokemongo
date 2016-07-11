package rx.observables;

import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

final class AbstractOnSubscribe$LambdaOnSubscribe<T, S>
  extends AbstractOnSubscribe<T, S>
{
  final Action1<AbstractOnSubscribe.SubscriptionState<T, S>> next;
  final Func1<? super Subscriber<? super T>, ? extends S> onSubscribe;
  final Action1<? super S> onTerminated;
  
  private AbstractOnSubscribe$LambdaOnSubscribe(Action1<AbstractOnSubscribe.SubscriptionState<T, S>> paramAction1, Func1<? super Subscriber<? super T>, ? extends S> paramFunc1, Action1<? super S> paramAction11)
  {
    next = paramAction1;
    onSubscribe = paramFunc1;
    onTerminated = paramAction11;
  }
  
  protected void next(AbstractOnSubscribe.SubscriptionState<T, S> paramSubscriptionState)
  {
    next.call(paramSubscriptionState);
  }
  
  protected S onSubscribe(Subscriber<? super T> paramSubscriber)
  {
    return (S)onSubscribe.call(paramSubscriber);
  }
  
  protected void onTerminated(S paramS)
  {
    onTerminated.call(paramS);
  }
}

/* Location:
 * Qualified Name:     rx.observables.AbstractOnSubscribe.LambdaOnSubscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */