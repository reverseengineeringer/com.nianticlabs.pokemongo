package rx;

import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$17
  implements Func0<Subject<T, T>>
{
  Observable$17(Observable paramObservable, int paramInt) {}
  
  public final Subject<T, T> call()
  {
    return ReplaySubject.createWithSize(val$bufferSize);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */