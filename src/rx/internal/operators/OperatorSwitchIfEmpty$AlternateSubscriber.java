package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

final class OperatorSwitchIfEmpty$AlternateSubscriber<T>
  extends Subscriber<T>
{
  private final ProducerArbiter arbiter;
  private final Subscriber<? super T> child;
  
  OperatorSwitchIfEmpty$AlternateSubscriber(Subscriber<? super T> paramSubscriber, ProducerArbiter paramProducerArbiter)
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

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitchIfEmpty.AlternateSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */