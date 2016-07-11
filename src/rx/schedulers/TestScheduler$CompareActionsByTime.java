package rx.schedulers;

import java.util.Comparator;

class TestScheduler$CompareActionsByTime
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

/* Location:
 * Qualified Name:     rx.schedulers.TestScheduler.CompareActionsByTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */