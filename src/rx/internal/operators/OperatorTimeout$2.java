package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

class OperatorTimeout$2
  implements OperatorTimeoutBase.TimeoutStub<T>
{
  OperatorTimeout$2(long paramLong, TimeUnit paramTimeUnit) {}
  
  public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, final Long paramLong, T paramT, Scheduler.Worker paramWorker)
  {
    paramWorker.schedule(new Action0()
    {
      public void call()
      {
        paramTimeoutSubscriber.onTimeout(paramLong.longValue());
      }
    }, val$timeout, val$timeUnit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeout.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */