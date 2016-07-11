package rx;

import rx.functions.Func2;

final class Observable$CountHolder$1
  implements Func2<Integer, Object, Integer>
{
  public final Integer call(Integer paramInteger, Object paramObject)
  {
    return Integer.valueOf(paramInteger.intValue() + 1);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.CountHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */