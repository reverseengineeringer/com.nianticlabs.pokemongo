package rx;

import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$15
  implements Func0<Subject<? super T, ? extends T>>
{
  Observable$15(Observable paramObservable) {}
  
  public Subject<? super T, ? extends T> call()
  {
    return ReplaySubject.create();
  }
}

/* Location:
 * Qualified Name:     rx.Observable.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */