package rx;

import rx.functions.Func2;

final class Observable$2
  implements Func2<T, T, Boolean>
{
  public final Boolean call(T paramT1, T paramT2)
  {
    if (paramT1 == null)
    {
      if (paramT2 == null) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
    return Boolean.valueOf(paramT1.equals(paramT2));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */