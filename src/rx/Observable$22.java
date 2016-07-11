package rx;

import rx.functions.Func0;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class Observable$22
  implements Func0<Subject<? super T, ? extends T>>
{
  Observable$22(Observable paramObservable, int paramInt) {}
  
  public Subject<? super T, ? extends T> call()
  {
    return ReplaySubject.createWithSize(val$bufferSize);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */