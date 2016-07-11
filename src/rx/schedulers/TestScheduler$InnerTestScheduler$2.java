package rx.schedulers;

import java.util.Queue;
import rx.functions.Action0;

class TestScheduler$InnerTestScheduler$2
  implements Action0
{
  TestScheduler$InnerTestScheduler$2(TestScheduler.InnerTestScheduler paramInnerTestScheduler, TestScheduler.TimedAction paramTimedAction) {}
  
  public void call()
  {
    TestScheduler.access$900(this$1.this$0).remove(val$timedAction);
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.TestScheduler.InnerTestScheduler.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */