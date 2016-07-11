package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

public final class OperatorSwitchIfEmpty<T>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends T> alternate;
  
  public OperatorSwitchIfEmpty(Observable<? extends T> paramObservable)
  {
    alternate = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerialSubscription localSerialSubscription = new SerialSubscription();
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    ParentSubscriber localParentSubscriber = new ParentSubscriber(paramSubscriber, localSerialSubscription, localProducerArbiter, alternate);
    localSerialSubscription.set(localParentSubscriber);
    paramSubscriber.add(localSerialSubscription);
    paramSubscriber.setProducer(localProducerArbiter);
    return localParentSubscriber;
  }
  
  private static final class AlternateSubscriber<T>
    extends Subscriber<T>
  {
    private final ProducerArbiter arbiter;
    private final Subscriber<? super T> child;
    
    AlternateSubscriber(Subscriber<? super T> paramSubscriber, ProducerArbiter paramProducerArbiter)
    {
      child = paramSubscriber;
      arbiter = paramProducerArbiter;
    }
    
    public void onCompleted()
    {
      child.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      child.onNext(paramT);
      arbiter.produced(1L);
    }
    
    public void setProducer(Producer paramProducer)
    {
      arbiter.setProducer(paramProducer);
    }
  }
  
  private static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private final Observable<? extends T> alternate;
    private final ProducerArbiter arbiter;
    private final Subscriber<? super T> child;
    private boolean empty = true;
    private final SerialSubscription ssub;
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter, Observable<? extends T> paramObservable)
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
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitchIfEmpty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */