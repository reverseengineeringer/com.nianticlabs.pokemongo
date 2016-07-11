package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import rx.functions.Func1;

public final class OperatorToMultimap$DefaultMultimapCollectionFactory<K, V>
  implements Func1<K, Collection<V>>
{
  public Collection<V> call(K paramK)
  {
    return new ArrayList();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMultimap.DefaultMultimapCollectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */