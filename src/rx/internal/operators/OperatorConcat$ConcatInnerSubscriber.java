package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

class OperatorConcat$ConcatInnerSubscriber<T>
  extends Subscriber<T>
{
  private static final AtomicIntegerFieldUpdater<ConcatInnerSubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(ConcatInnerSubscriber.class, "once");
  private final ProducerArbiter arbiter;
  private final Subscriber<T> child;
  private volatile int once = 0;
  private final OperatorConcat.ConcatSubscriber<T> parent;
  
  public OperatorConcat$ConcatInnerSubscriber(OperatorConcat.ConcatSubscriber<T> paramConcatSubscriber, Subscriber<T> paramSubscriber, ProducerArbiter paramProducerArbiter)
  {
    parent = paramConcatSubscriber;
    child = paramSubscriber;
    arbiter = paramProducerArbiter;
  }
  
  public void onCompleted()
  {
    if (ONCE.compareAndSet(this, 0, 1)) {
      parent.completeInner();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (ONCE.compareAndSet(this, 0, 1)) {
      parent.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    child.onNext(paramT);
    OperatorConcat.ConcatSubscriber.access$200(parent);
    arbiter.produced(1L);
  }
  
  public void setProducer(Producer paramProducer)
  {
    arbiter.setProducer(paramProducer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorConcat.ConcatInnerSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */