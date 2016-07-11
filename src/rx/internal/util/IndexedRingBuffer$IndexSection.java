package rx.internal.util;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

class IndexedRingBuffer$IndexSection
{
  private final AtomicReference<IndexSection> _next = new AtomicReference();
  private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);
  
  public int getAndSet(int paramInt1, int paramInt2)
  {
    return unsafeArray.getAndSet(paramInt1, paramInt2);
  }
  
  IndexSection getNext()
  {
    if (_next.get() != null) {
      return (IndexSection)_next.get();
    }
    IndexSection localIndexSection = new IndexSection();
    if (_next.compareAndSet(null, localIndexSection)) {
      return localIndexSection;
    }
    return (IndexSection)_next.get();
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    unsafeArray.set(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.IndexedRingBuffer.IndexSection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */