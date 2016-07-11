package rx.schedulers;

import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

final class TestScheduler$InnerTestScheduler
  extends Scheduler.Worker
{
  private final BooleanSubscription s = new BooleanSubscription();
  
  private TestScheduler$InnerTestScheduler(TestScheduler paramTestScheduler) {}
  
  public boolean isUnsubscribed()
  {
    return s.isUnsubscribed();
  }
  
  public long now()
  {
    return this$0.now();
  }
  
  public Subscription schedule(final Action0 paramAction0)
  {
    paramAction0 = new TestScheduler.TimedAction(this, 0L, paramAction0, null);
    TestScheduler.access$900(this$0).add(paramAction0);
    Subscriptions.create(new Action0()
    {
      public void call()
      {
        TestScheduler.access$900(this$0).remove(paramAction0);
      }
    });
  }
  
  public Subscription schedule(final Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    paramAction0 = new TestScheduler.TimedAction(this, TestScheduler.access$700(this$0) + paramTimeUnit.toNanos(paramLong), paramAction0, null);
    TestScheduler.access$900(this$0).add(paramAction0);
    Subscriptions.create(new Action0()
    {
      public void call()
      {
        TestScheduler.access$900(this$0).remove(paramAction0);
      }
    });
  }
  
  public void unsubscribe()
  {
    s.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.TestScheduler.InnerTestScheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */