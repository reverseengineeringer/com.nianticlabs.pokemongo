package rx;

import java.util.List;
import rx.functions.Func1;

final class Observable$3
  implements Func1<List<? extends Observable<?>>, Observable<?>[]>
{
  public Observable<?>[] call(List<? extends Observable<?>> paramList)
  {
    return (Observable[])paramList.toArray(new Observable[paramList.size()]);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */