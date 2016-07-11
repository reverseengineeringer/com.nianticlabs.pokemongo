package rx;

import rx.functions.Func1;

class Observable$5
  implements Func1<T, Boolean>
{
  Observable$5(Observable paramObservable, Object paramObject) {}
  
  public final Boolean call(T paramT)
  {
    boolean bool;
    if (val$element == null) {
      if (paramT == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return Boolean.valueOf(bool);
      bool = false;
      continue;
      bool = val$element.equals(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.Observable.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */