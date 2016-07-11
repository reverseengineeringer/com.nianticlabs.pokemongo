package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class BackpressureUtils
{
  private BackpressureUtils()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long getAndAddRequest(AtomicLong paramAtomicLong, long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = paramAtomicLong.get();
      long l2 = l3 + paramLong;
      l1 = l2;
      if (l2 < 0L) {
        l1 = Long.MAX_VALUE;
      }
    } while (!paramAtomicLong.compareAndSet(l3, l1));
    return l3;
  }
  
  public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> paramAtomicLongFieldUpdater, T paramT, long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = paramAtomicLongFieldUpdater.get(paramT);
      long l2 = l3 + paramLong;
      l1 = l2;
      if (l2 < 0L) {
        l1 = Long.MAX_VALUE;
      }
    } while (!paramAtomicLongFieldUpdater.compareAndSet(paramT, l3, l1));
    return l3;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BackpressureUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */