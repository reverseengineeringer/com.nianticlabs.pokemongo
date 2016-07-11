package rx;

import rx.functions.Action2;
import rx.functions.Func2;

class Observable$4
  implements Func2<R, T, R>
{
  Observable$4(Observable paramObservable, Action2 paramAction2) {}
  
  public final R call(R paramR, T paramT)
  {
    val$collector.call(paramR, paramT);
    return paramR;
  }
}

/* Location:
 * Qualified Name:     rx.Observable.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */