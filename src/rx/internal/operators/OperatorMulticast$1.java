package rx.internal.operators;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subjects.Subject;

class OperatorMulticast$1
  implements Observable.OnSubscribe<R>
{
  OperatorMulticast$1(Object paramObject, AtomicReference paramAtomicReference, List paramList) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    synchronized (val$guard)
    {
      if (val$connectedSubject.get() == null)
      {
        val$waitingForConnect.add(paramSubscriber);
        return;
      }
      ((Subject)val$connectedSubject.get()).unsafeSubscribe(paramSubscriber);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMulticast.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */