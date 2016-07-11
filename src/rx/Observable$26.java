package rx;

import rx.functions.Func0;
import rx.internal.operators.OperatorReplay;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$26
  implements Func0<Subject<? super T, ? extends T>>
{
  Observable$26(Observable paramObservable, Scheduler paramScheduler) {}
  
  public Subject<? super T, ? extends T> call()
  {
    return OperatorReplay.createScheduledSubject(ReplaySubject.create(), val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */