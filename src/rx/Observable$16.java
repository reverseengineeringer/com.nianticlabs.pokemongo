package rx;

import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$16
  implements Func0<Subject<T, T>>
{
  Observable$16(Observable paramObservable) {}
  
  public final Subject<T, T> call()
  {
    return ReplaySubject.create();
  }
}

/* Location:
 * Qualified Name:     rx.Observable.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */