package rx.schedulers;

public class TimeInterval<T>
{
  private final long intervalInMilliseconds;
  private final T value;
  
  public TimeInterval(long paramLong, T paramT)
  {
    value = paramT;
    intervalInMilliseconds = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (TimeInterval)paramObject;
        if (intervalInMilliseconds != intervalInMilliseconds) {
          return false;
        }
        if (value != null) {
          break;
        }
      } while (value == null);
      return false;
    } while (value.equals(value));
    return false;
  }
  
  public long getIntervalInMilliseconds()
  {
    return intervalInMilliseconds;
  }
  
  public T getValue()
  {
    return (T)value;
  }
  
  public int hashCode()
  {
    int j = (int)(intervalInMilliseconds ^ intervalInMilliseconds >>> 32);
    if (value == null) {}
    for (int i = 0;; i = value.hashCode()) {
      return (j + 31) * 31 + i;
    }
  }
  
  public String toString()
  {
    return "TimeInterval [intervalInMilliseconds=" + intervalInMilliseconds + ", value=" + value + "]";
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.TimeInterval
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */