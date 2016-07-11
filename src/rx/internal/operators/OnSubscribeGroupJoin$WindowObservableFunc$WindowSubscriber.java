package rx.internal.operators;

import rx.Subscriber;
import rx.Subscription;

final class OnSubscribeGroupJoin$WindowObservableFunc$WindowSubscriber
  extends Subscriber<T>
{
  private final Subscription ref;
  final Subscriber<? super T> subscriber;
  
  public OnSubscribeGroupJoin$WindowObservableFunc$WindowSubscriber(Subscriber<? super T> paramSubscriber, Subscription paramSubscription)
  {
    super(paramSubscription);
    subscriber = paramSubscription;
    Subscription localSubscription;
    ref = localSubscription;
  }
  
  public void onCompleted()
  {
    subscriber.onCompleted();
    ref.unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    subscriber.onError(paramThrowable);
    ref.unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    subscriber.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.WindowObservableFunc.WindowSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */