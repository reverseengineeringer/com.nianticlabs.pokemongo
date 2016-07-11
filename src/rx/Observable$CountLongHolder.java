package rx;

import rx.functions.Func2;

final class Observable$CountLongHolder
{
  static final Func2<Long, Object, Long> INSTANCE = new Func2()
  {
    public final Long call(Long paramAnonymousLong, Object paramAnonymousObject)
    {
      return Long.valueOf(paramAnonymousLong.longValue() + 1L);
    }
  };
}

/* Location:
 * Qualified Name:     rx.Observable.CountLongHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */