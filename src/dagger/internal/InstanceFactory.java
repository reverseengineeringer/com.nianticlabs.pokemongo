package dagger.internal;

public final class InstanceFactory<T>
  implements Factory<T>
{
  private final T instance;
  
  private InstanceFactory(T paramT)
  {
    instance = paramT;
  }
  
  public static <T> Factory<T> create(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return new InstanceFactory(paramT);
  }
  
  public T get()
  {
    return (T)instance;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.InstanceFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */