package rx;

import rx.functions.Func0;
import rx.internal.operators.OperatorReplay;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$24
  implements Func0<Subject<? super T, ? extends T>>
{
  Observable$24(Observable paramObservable, int paramInt, Scheduler paramScheduler) {}
  
  public Subject<? super T, ? extends T> call()
  {
    return OperatorReplay.createScheduledSubject(ReplaySubject.createWithSize(val$bufferSize), val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */