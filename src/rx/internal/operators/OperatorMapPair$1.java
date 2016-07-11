package rx.internal.operators;

import rx.Observable;
import rx.functions.Func1;

final class OperatorMapPair$1
  implements Func1<T, Observable<U>>
{
  OperatorMapPair$1(Func1 paramFunc1) {}
  
  public Observable<U> call(T paramT)
  {
    return Observable.from((Iterable)val$selector.call(paramT));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMapPair.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */