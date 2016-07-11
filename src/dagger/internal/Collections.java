package dagger.internal;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

final class Collections
{
  private static final int MAX_POWER_OF_TWO = 1073741824;
  
  private static int calculateInitialCapacity(int paramInt)
  {
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return Integer.MAX_VALUE;
  }
  
  static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int paramInt)
  {
    return new LinkedHashMap(calculateInitialCapacity(paramInt));
  }
  
  static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int paramInt)
  {
    return new LinkedHashSet(calculateInitialCapacity(paramInt));
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Collections
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */