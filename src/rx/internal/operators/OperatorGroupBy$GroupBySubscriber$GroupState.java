package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.subjects.Subject;

class OperatorGroupBy$GroupBySubscriber$GroupState<K, T>
{
  private final Queue<Object> buffer = new ConcurrentLinkedQueue();
  private final AtomicLong count = new AtomicLong();
  private final AtomicLong requested = new AtomicLong();
  private final Subject<T, T> s = BufferUntilSubscriber.create();
  
  public Observable<T> getObservable()
  {
    return s;
  }
  
  public Observer<T> getObserver()
  {
    return s;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber.GroupState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */