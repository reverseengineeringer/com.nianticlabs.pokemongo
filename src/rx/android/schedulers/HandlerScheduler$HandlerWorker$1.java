package rx.android.schedulers;

import android.os.Handler;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;

class HandlerScheduler$HandlerWorker$1
  implements Action0
{
  HandlerScheduler$HandlerWorker$1(HandlerScheduler.HandlerWorker paramHandlerWorker, ScheduledAction paramScheduledAction) {}
  
  public void call()
  {
    HandlerScheduler.HandlerWorker.access$000(this$0).removeCallbacks(val$scheduledAction);
  }
}

/* Location:
 * Qualified Name:     rx.android.schedulers.HandlerScheduler.HandlerWorker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */