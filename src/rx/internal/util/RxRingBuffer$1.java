package rx.internal.util;

import java.util.Queue;
import rx.internal.util.unsafe.SpscArrayQueue;

final class RxRingBuffer$1
  extends ObjectPool<Queue<Object>>
{
  protected SpscArrayQueue<Object> createObject()
  {
    return new SpscArrayQueue(RxRingBuffer.SIZE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.RxRingBuffer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */