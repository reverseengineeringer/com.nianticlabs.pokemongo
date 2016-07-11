package rx.subjects;

import rx.Scheduler;
import rx.functions.Func1;
import rx.schedulers.Timestamped;

final class ReplaySubject$AddTimestamped
  implements Func1<Object, Object>
{
  final Scheduler scheduler;
  
  public ReplaySubject$AddTimestamped(Scheduler paramScheduler)
  {
    scheduler = paramScheduler;
  }
  
  public Object call(Object paramObject)
  {
    return new Timestamped(scheduler.now(), paramObject);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.AddTimestamped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */