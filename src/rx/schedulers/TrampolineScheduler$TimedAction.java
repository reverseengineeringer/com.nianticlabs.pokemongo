package rx.schedulers;

import rx.functions.Action0;

final class TrampolineScheduler$TimedAction
  implements Comparable<TimedAction>
{
  final Action0 action;
  final int count;
  final Long execTime;
  
  private TrampolineScheduler$TimedAction(Action0 paramAction0, Long paramLong, int paramInt)
  {
    action = paramAction0;
    execTime = paramLong;
    count = paramInt;
  }
  
  public int compareTo(TimedAction paramTimedAction)
  {
    int j = execTime.compareTo(execTime);
    int i = j;
    if (j == 0) {
      i = TrampolineScheduler.access$300(count, count);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.TrampolineScheduler.TimedAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */