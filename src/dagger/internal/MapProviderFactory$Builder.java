package dagger.internal;

import java.util.LinkedHashMap;
import javax.inject.Provider;

public final class MapProviderFactory$Builder<K, V>
{
  private final LinkedHashMap<K, Provider<V>> mapBuilder;
  
  private MapProviderFactory$Builder(int paramInt)
  {
    mapBuilder = Collections.newLinkedHashMapWithExpectedSize(paramInt);
  }
  
  public MapProviderFactory<K, V> build()
  {
    return new MapProviderFactory(mapBuilder, null);
  }
  
  public Builder<K, V> put(K paramK, Provider<V> paramProvider)
  {
    if (paramK == null) {
      throw new NullPointerException("The key is null");
    }
    if (paramProvider == null) {
      throw new NullPointerException("The provider of the value is null");
    }
    mapBuilder.put(paramK, paramProvider);
    return this;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.MapProviderFactory.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */