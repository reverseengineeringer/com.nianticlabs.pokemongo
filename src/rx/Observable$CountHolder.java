package rx;

import rx.functions.Func2;

final class Observable$CountHolder
{
  static final Func2<Integer, Object, Integer> INSTANCE = new Func2()
  {
    public final Integer call(Integer paramAnonymousInteger, Object paramAnonymousObject)
    {
      return Integer.valueOf(paramAnonymousInteger.intValue() + 1);
    }
  };
}

/* Location:
 * Qualified Name:     rx.Observable.CountHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */