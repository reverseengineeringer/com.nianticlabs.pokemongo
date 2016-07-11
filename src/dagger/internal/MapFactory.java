package dagger.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;

public final class MapFactory<K, V>
  implements Factory<Map<K, V>>
{
  private final Map<K, Provider<V>> contributingMap;
  
  private MapFactory(Map<K, Provider<V>> paramMap)
  {
    contributingMap = java.util.Collections.unmodifiableMap(paramMap);
  }
  
  public static <K, V> MapFactory<K, V> create(Provider<Map<K, Provider<V>>> paramProvider)
  {
    return new MapFactory((Map)paramProvider.get());
  }
  
  public Map<K, V> get()
  {
    LinkedHashMap localLinkedHashMap = Collections.newLinkedHashMapWithExpectedSize(contributingMap.size());
    Iterator localIterator = contributingMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedHashMap.put(localEntry.getKey(), ((Provider)localEntry.getValue()).get());
    }
    return java.util.Collections.unmodifiableMap(localLinkedHashMap);
  }
}

/* Location:
 * Qualified Name:     dagger.internal.MapFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */