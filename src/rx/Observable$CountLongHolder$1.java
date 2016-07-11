package rx;

import rx.functions.Func2;

final class Observable$CountLongHolder$1
  implements Func2<Long, Object, Long>
{
  public final Long call(Long paramLong, Object paramObject)
  {
    return Long.valueOf(paramLong.longValue() + 1L);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.CountLongHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */