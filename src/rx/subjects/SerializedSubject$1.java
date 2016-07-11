package rx.subjects;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SerializedSubject$1
  implements Observable.OnSubscribe<R>
{
  SerializedSubject$1(Subject paramSubject) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    val$actual.unsafeSubscribe(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.SerializedSubject.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */