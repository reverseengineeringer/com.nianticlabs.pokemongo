package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.functions.Func0;

public final class OperatorToMap$DefaultToMapFactory<K, V>
  implements Func0<Map<K, V>>
{
  public Map<K, V> call()
  {
    return new HashMap();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMap.DefaultToMapFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */