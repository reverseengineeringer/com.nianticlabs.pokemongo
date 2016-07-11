package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

final class OperatorSwitchIfEmpty$ParentSubscriber<T>
  extends Subscriber<T>
{
  private final Observable<? extends T> alternate;
  private final ProducerArbiter arbiter;
  private final Subscriber<? super T> child;
  private boolean empty = true;
  private final SerialSubscription ssub;
  
  OperatorSwitchIfEmpty$ParentSubscriber(Subscriber<? super T> paramSubscriber, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter, Observable<? extends T> paramObservable)
  {
    child = paramSubscriber;
    ssub = paramSerialSubscription;
    arbiter = paramProducerArbiter;
    alternate = paramObservable;
  }
  
  private void subscribeToAlternate()
  {
    OperatorSwitchIfEmpty.AlternateSubscriber localAlternateSubscriber = new OperatorSwitchIfEmpty.AlternateSubscriber(child, arbiter);
    ssub.set(localAlternateSubscriber);
    alternate.unsafeSubscribe(localAlternateSubscriber);
  }
  
  public void onCompleted()
  {
    if (!empty) {
      child.onCompleted();
    }
    while (child.isUnsubscribed()) {
      return;
    }
    subscribeToAlternate();
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    empty = false;
    child.onNext(paramT);
    arbiter.produced(1L);
  }
  
  public void setProducer(Producer paramProducer)
  {
    arbiter.setProducer(paramProducer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitchIfEmpty.ParentSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */