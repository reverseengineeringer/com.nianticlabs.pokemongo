package rx.schedulers;

import rx.Scheduler.Worker;
import rx.functions.Action0;

final class TestScheduler$TimedAction
{
  private final Action0 action;
  private final long count = TestScheduler.access$108();
  private final Scheduler.Worker scheduler;
  private final long time;
  
  private TestScheduler$TimedAction(Scheduler.Worker paramWorker, long paramLong, Action0 paramAction0)
  {
    time = paramLong;
    action = paramAction0;
    scheduler = paramWorker;
  }
  
  public String toString()
  {
    return String.format("TimedAction(time = %d, action = %s)", new Object[] { Long.valueOf(time), action.toString() });
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.TestScheduler.TimedAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */