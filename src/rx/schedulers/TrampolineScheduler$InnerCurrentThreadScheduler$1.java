package rx.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import rx.functions.Action0;

class TrampolineScheduler$InnerCurrentThreadScheduler$1
  implements Action0
{
  TrampolineScheduler$InnerCurrentThreadScheduler$1(TrampolineScheduler.InnerCurrentThreadScheduler paramInnerCurrentThreadScheduler, TrampolineScheduler.TimedAction paramTimedAction) {}
  
  public void call()
  {
    TrampolineScheduler.InnerCurrentThreadScheduler.access$200(this$0).remove(val$timedAction);
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */