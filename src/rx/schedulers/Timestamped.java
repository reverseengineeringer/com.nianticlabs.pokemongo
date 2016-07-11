package rx.schedulers;

public final class Timestamped<T>
{
  private final long timestampMillis;
  private final T value;
  
  public Timestamped(long paramLong, T paramT)
  {
    value = paramT;
    timestampMillis = paramLong;
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
        if (!(paramObject instanceof Timestamped)) {
          return false;
        }
        paramObject = (Timestamped)paramObject;
        if (timestampMillis != timestampMillis) {
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
  
  public long getTimestampMillis()
  {
    return timestampMillis;
  }
  
  public T getValue()
  {
    return (T)value;
  }
  
  public int hashCode()
  {
    int j = (int)(timestampMillis ^ timestampMillis >>> 32);
    if (value == null) {}
    for (int i = 0;; i = value.hashCode()) {
      return (j + 31) * 31 + i;
    }
  }
  
  public String toString()
  {
    return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[] { Long.valueOf(timestampMillis), value.toString() });
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.Timestamped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */