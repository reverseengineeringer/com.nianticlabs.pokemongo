package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

public final class OperatorTimeout<T>
  extends OperatorTimeoutBase<T>
{
  public OperatorTimeout(long paramLong, TimeUnit paramTimeUnit, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    super(new OperatorTimeoutBase.FirstTimeoutStub()new OperatorTimeoutBase.TimeoutStub
    {
      public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> paramAnonymousTimeoutSubscriber, final Long paramAnonymousLong, Scheduler.Worker paramAnonymousWorker)
      {
        paramAnonymousWorker.schedule(new Action0()
        {
          public void call()
          {
            paramAnonymousTimeoutSubscriber.onTimeout(paramAnonymousLong.longValue());
          }
        }, val$timeout, val$timeUnit);
      }
    }, new OperatorTimeoutBase.TimeoutStub()
    {
      public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> paramAnonymousTimeoutSubscriber, final Long paramAnonymousLong, T paramAnonymousT, Scheduler.Worker paramAnonymousWorker)
      {
        paramAnonymousWorker.schedule(new Action0()
        {
          public void call()
          {
            paramAnonymousTimeoutSubscriber.onTimeout(paramAnonymousLong.longValue());
          }
        }, val$timeout, val$timeUnit);
      }
    }, paramObservable, paramScheduler);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */