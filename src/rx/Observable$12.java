package rx;

import rx.functions.Func1;

class Observable$12
  implements Func1<T, Boolean>
{
  Observable$12(Observable paramObservable, Class paramClass) {}
  
  public final Boolean call(T paramT)
  {
    return Boolean.valueOf(val$klass.isInstance(paramT));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */