package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

final class BlockingOperatorLatest$1
  implements Iterable<T>
{
  BlockingOperatorLatest$1(Observable paramObservable) {}
  
  public Iterator<T> iterator()
  {
    BlockingOperatorLatest.LatestObserverIterator localLatestObserverIterator = new BlockingOperatorLatest.LatestObserverIterator();
    val$source.materialize().subscribe(localLatestObserverIterator);
    return localLatestObserverIterator;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorLatest.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */