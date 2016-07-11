package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.internal.producers.ProducerArbiter;

class OnSubscribeRedo$5
  implements Producer
{
  OnSubscribeRedo$5(OnSubscribeRedo paramOnSubscribeRedo, AtomicLong paramAtomicLong, ProducerArbiter paramProducerArbiter, AtomicBoolean paramAtomicBoolean, Scheduler.Worker paramWorker, Action0 paramAction0) {}
  
  public void request(long paramLong)
  {
    if (paramLong > 0L)
    {
      BackpressureUtils.getAndAddRequest(val$consumerCapacity, paramLong);
      val$arbiter.request(paramLong);
      if (val$resumeBoundary.compareAndSet(true, false)) {
        val$worker.schedule(val$subscribeToSource);
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */