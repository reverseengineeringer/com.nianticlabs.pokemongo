package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

final class BlockingOperatorMostRecent$1
  implements Iterable<T>
{
  BlockingOperatorMostRecent$1(Object paramObject, Observable paramObservable) {}
  
  public Iterator<T> iterator()
  {
    BlockingOperatorMostRecent.MostRecentObserver localMostRecentObserver = new BlockingOperatorMostRecent.MostRecentObserver(val$initialValue, null);
    val$source.subscribe(localMostRecentObserver);
    return localMostRecentObserver.getIterable();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */