package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;

abstract class BaseLinkedQueue<E>
  extends BaseLinkedQueueConsumerNodeRef<E>
{
  long p00;
  long p01;
  long p02;
  long p03;
  long p04;
  long p05;
  long p06;
  long p07;
  long p30;
  long p31;
  long p32;
  long p33;
  long p34;
  long p35;
  long p36;
  long p37;
  
  public final boolean isEmpty()
  {
    return lvConsumerNode() == lvProducerNode();
  }
  
  public final Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    Object localObject = lvConsumerNode();
    LinkedQueueNode localLinkedQueueNode2 = lvProducerNode();
    int i = 0;
    while ((localObject != localLinkedQueueNode2) && (i < Integer.MAX_VALUE))
    {
      LinkedQueueNode localLinkedQueueNode1;
      do
      {
        localLinkedQueueNode1 = ((LinkedQueueNode)localObject).lvNext();
      } while (localLinkedQueueNode1 == null);
      localObject = localLinkedQueueNode1;
      i += 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.BaseLinkedQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */