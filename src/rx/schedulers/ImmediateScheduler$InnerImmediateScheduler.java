package rx.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

class ImmediateScheduler$InnerImmediateScheduler
  extends Scheduler.Worker
  implements Subscription
{
  final BooleanSubscription innerSubscription = new BooleanSubscription();
  
  private ImmediateScheduler$InnerImmediateScheduler(ImmediateScheduler paramImmediateScheduler) {}
  
  public boolean isUnsubscribed()
  {
    return innerSubscription.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    paramAction0.call();
    return Subscriptions.unsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    return schedule(new SleepingAction(paramAction0, this, this$0.now() + paramTimeUnit.toMillis(paramLong)));
  }
  
  public void unsubscribe()
  {
    innerSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.ImmediateScheduler.InnerImmediateScheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */