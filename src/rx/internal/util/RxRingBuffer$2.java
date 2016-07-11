package rx.internal.util;

import java.util.Queue;
import rx.internal.util.unsafe.SpmcArrayQueue;

final class RxRingBuffer$2
  extends ObjectPool<Queue<Object>>
{
  protected SpmcArrayQueue<Object> createObject()
  {
    return new SpmcArrayQueue(RxRingBuffer.SIZE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.RxRingBuffer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */