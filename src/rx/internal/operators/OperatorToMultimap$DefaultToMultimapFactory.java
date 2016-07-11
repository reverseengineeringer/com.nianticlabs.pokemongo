package rx.internal.operators;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.functions.Func0;

public final class OperatorToMultimap$DefaultToMultimapFactory<K, V>
  implements Func0<Map<K, Collection<V>>>
{
  public Map<K, Collection<V>> call()
  {
    return new HashMap();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMultimap.DefaultToMultimapFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */