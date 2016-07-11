package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$25
  implements Func0<Subject<? super T, ? extends T>>
{
  Observable$25(Observable paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {}
  
  public Subject<? super T, ? extends T> call()
  {
    return ReplaySubject.createWithTime(val$time, val$unit, val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */