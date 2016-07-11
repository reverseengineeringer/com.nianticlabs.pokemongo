package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

final class BlockingOperatorNext$1
  implements Iterable<T>
{
  BlockingOperatorNext$1(Observable paramObservable) {}
  
  public Iterator<T> iterator()
  {
    BlockingOperatorNext.NextObserver localNextObserver = new BlockingOperatorNext.NextObserver(null);
    return new BlockingOperatorNext.NextIterator(val$items, localNextObserver, null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */