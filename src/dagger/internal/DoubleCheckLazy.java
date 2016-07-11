package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheckLazy<T>
  implements Lazy<T>
{
  private static final Object UNINITIALIZED;
  private volatile Object instance = UNINITIALIZED;
  private final Provider<T> provider;
  
  static
  {
    if (!DoubleCheckLazy.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      UNINITIALIZED = new Object();
      return;
    }
  }
  
  private DoubleCheckLazy(Provider<T> paramProvider)
  {
    assert (paramProvider != null);
    provider = paramProvider;
  }
  
  public static <T> Lazy<T> create(Provider<T> paramProvider)
  {
    if (paramProvider == null) {
      throw new NullPointerException();
    }
    return new DoubleCheckLazy(paramProvider);
  }
  
  public T get()
  {
    Object localObject1 = instance;
    if (localObject1 == UNINITIALIZED) {
      try
      {
        Object localObject2 = instance;
        localObject1 = localObject2;
        if (localObject2 == UNINITIALIZED)
        {
          localObject1 = provider.get();
          instance = localObject1;
        }
        return (T)localObject1;
      }
      finally {}
    }
    return ?;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.DoubleCheckLazy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */