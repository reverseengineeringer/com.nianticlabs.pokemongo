package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public class TestScheduler
  extends Scheduler
{
  private static long counter = 0L;
  private final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime(null));
  private long time;
  
  private void triggerActions(long paramLong)
  {
    TimedAction localTimedAction;
    if (!queue.isEmpty())
    {
      localTimedAction = (TimedAction)queue.peek();
      if (time <= paramLong) {}
    }
    else
    {
      time = paramLong;
      return;
    }
    if (time == 0L) {}
    for (long l = time;; l = time)
    {
      time = l;
      queue.remove();
      if (scheduler.isUnsubscribed()) {
        break;
      }
      action.call();
      break;
    }
  }
  
  public void advanceTimeBy(long paramLong, TimeUnit paramTimeUnit)
  {
    advanceTimeTo(time + paramTimeUnit.toNanos(paramLong), TimeUnit.NANOSECONDS);
  }
  
  public void advanceTimeTo(long paramLong, TimeUnit paramTimeUnit)
  {
    triggerActions(paramTimeUnit.toNanos(paramLong));
  }
  
  public Scheduler.Worker createWorker()
  {
    return new InnerTestScheduler(null);
  }
  
  public long now()
  {
    return TimeUnit.NANOSECONDS.toMillis(time);
  }
  
  public void triggerActions()
  {
    triggerActions(time);
  }
  
  private static class CompareActionsByTime
    implements Comparator<TestScheduler.TimedAction>
  {
    public int compare(TestScheduler.TimedAction paramTimedAction1, TestScheduler.TimedAction paramTimedAction2)
    {
      if (TestScheduler.TimedAction.access$200(paramTimedAction1) == TestScheduler.TimedAction.access$200(paramTimedAction2)) {
        return Long.valueOf(TestScheduler.TimedAction.access$300(paramTimedAction1)).compareTo(Long.valueOf(TestScheduler.TimedAction.access$300(paramTimedAction2)));
      }
      return Long.valueOf(TestScheduler.TimedAction.access$200(paramTimedAction1)).compareTo(Long.valueOf(TestScheduler.TimedAction.access$200(paramTimedAction2)));
    }
  }
  
  private final class InnerTestScheduler
    extends Scheduler.Worker
  {
    private final BooleanSubscription s = new BooleanSubscription();
    
    private InnerTestScheduler() {}
    
    public boolean isUnsubscribed()
    {
      return s.isUnsubscribed();
    }
    
    public long now()
    {
      return TestScheduler.this.now();
    }
    
    public Subscription schedule(final Action0 paramAction0)
    {
      paramAction0 = new TestScheduler.TimedAction(this, 0L, paramAction0, null);
      queue.add(paramAction0);
      Subscriptions.create(new Action0()
      {
        public void call()
        {
          queue.remove(paramAction0);
        }
      });
    }
    
    public Subscription schedule(final Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      paramAction0 = new TestScheduler.TimedAction(this, time + paramTimeUnit.toNanos(paramLong), paramAction0, null);
      queue.add(paramAction0);
      Subscriptions.create(new Action0()
      {
        public void call()
        {
          queue.remove(paramAction0);
        }
      });
    }
    
    public void unsubscribe()
    {
      s.unsubscribe();
    }
  }
  
  private static final class TimedAction
  {
    private final Action0 action;
    private final long count = TestScheduler.access$108();
    private final Scheduler.Worker scheduler;
    private final long time;
    
    private TimedAction(Scheduler.Worker paramWorker, long paramLong, Action0 paramAction0)
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
}

/* Location:
 * Qualified Name:     rx.schedulers.TestScheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */