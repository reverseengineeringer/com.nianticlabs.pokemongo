package dagger.internal;

import javax.inject.Provider;

public final class ScopedProvider<T>
  implements Provider<T>
{
  private static final Object UNINITIALIZED;
  private final Factory<T> factory;
  private volatile Object instance = UNINITIALIZED;
  
  static
  {
    if (!ScopedProvider.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      UNINITIALIZED = new Object();
      return;
    }
  }
  
  private ScopedProvider(Factory<T> paramFactory)
  {
    assert (paramFactory != null);
    factory = paramFactory;
  }
  
  public static <T> Provider<T> create(Factory<T> paramFactory)
  {
    if (paramFactory == null) {
      throw new NullPointerException();
    }
    return new ScopedProvider(paramFactory);
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
          localObject1 = factory.get();
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
 * Qualified Name:     dagger.internal.ScopedProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */