package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$18
  implements Func0<Subject<T, T>>
{
  Observable$18(Observable paramObservable, long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler) {}
  
  public final Subject<T, T> call()
  {
    return ReplaySubject.createWithTimeAndSize(val$time, val$unit, val$bufferSize, val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */