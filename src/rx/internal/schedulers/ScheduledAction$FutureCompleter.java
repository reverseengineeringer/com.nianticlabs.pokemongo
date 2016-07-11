package rx.internal.schedulers;

import java.util.concurrent.Future;
import rx.Subscription;

final class ScheduledAction$FutureCompleter
  implements Subscription
{
  private final Future<?> f;
  
  private ScheduledAction$FutureCompleter(Future<?> paramFuture)
  {
    Future localFuture;
    f = localFuture;
  }
  
  public boolean isUnsubscribed()
  {
    return f.isCancelled();
  }
  
  public void unsubscribe()
  {
    if (this$0.get() != Thread.currentThread())
    {
      f.cancel(true);
      return;
    }
    f.cancel(false);
  }
}

/* Location:
 * Qualified Name:     rx.internal.schedulers.ScheduledAction.FutureCompleter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */