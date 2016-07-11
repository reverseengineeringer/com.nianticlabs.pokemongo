package rx.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

class IndexedRingBuffer$ElementSection<E>
{
  private final AtomicReferenceArray<E> array = new AtomicReferenceArray(IndexedRingBuffer.SIZE);
  private final AtomicReference<ElementSection<E>> next = new AtomicReference();
  
  ElementSection<E> getNext()
  {
    if (next.get() != null) {
      return (ElementSection)next.get();
    }
    ElementSection localElementSection = new ElementSection();
    if (next.compareAndSet(null, localElementSection)) {
      return localElementSection;
    }
    return (ElementSection)next.get();
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.IndexedRingBuffer.ElementSection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */