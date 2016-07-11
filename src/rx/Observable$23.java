package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$23
  implements Func0<Subject<? super T, ? extends T>>
{
  Observable$23(Observable paramObservable, long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler) {}
  
  public Subject<? super T, ? extends T> call()
  {
    return ReplaySubject.createWithTimeAndSize(val$time, val$unit, val$bufferSize, val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */