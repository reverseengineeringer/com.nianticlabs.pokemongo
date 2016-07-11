package rx;

import rx.functions.Func0;
import rx.internal.operators.OperatorReplay;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$21
  implements Func0<Subject<T, T>>
{
  Observable$21(Observable paramObservable, Scheduler paramScheduler) {}
  
  public final Subject<T, T> call()
  {
    return OperatorReplay.createScheduledSubject(ReplaySubject.create(), val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */