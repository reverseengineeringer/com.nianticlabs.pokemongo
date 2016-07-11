package rx.subjects;

import rx.functions.Func1;
import rx.schedulers.Timestamped;

final class ReplaySubject$RemoveTimestamped
  implements Func1<Object, Object>
{
  public Object call(Object paramObject)
  {
    return ((Timestamped)paramObject).getValue();
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.RemoveTimestamped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */