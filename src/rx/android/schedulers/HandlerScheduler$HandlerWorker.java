package rx.android.schedulers;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

class HandlerScheduler$HandlerWorker
  extends Scheduler.Worker
{
  private final CompositeSubscription compositeSubscription = new CompositeSubscription();
  private final Handler handler;
  
  HandlerScheduler$HandlerWorker(Handler paramHandler)
  {
    handler = paramHandler;
  }
  
  public boolean isUnsubscribed()
  {
    return compositeSubscription.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    return schedule(paramAction0, 0L, TimeUnit.MILLISECONDS);
  }
  
  public Subscription schedule(final Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (compositeSubscription.isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    paramAction0 = new ScheduledAction(RxAndroidPlugins.getInstance().getSchedulersHook().onSchedule(paramAction0));
    paramAction0.addParent(compositeSubscription);
    compositeSubscription.add(paramAction0);
    handler.postDelayed(paramAction0, paramTimeUnit.toMillis(paramLong));
    paramAction0.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        handler.removeCallbacks(paramAction0);
      }
    }));
    return paramAction0;
  }
  
  public void unsubscribe()
  {
    compositeSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.android.schedulers.HandlerScheduler.HandlerWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */