package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

public final class SpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public SpscLinkedQueue()
  {
    spProducerNode(new LinkedQueueNode());
    spConsumerNode(producerNode);
    consumerNode.soNext(null);
  }
  
  public boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("null elements not allowed");
    }
    paramE = new LinkedQueueNode(paramE);
    producerNode.soNext(paramE);
    producerNode = paramE;
    return true;
  }
  
  public E peek()
  {
    LinkedQueueNode localLinkedQueueNode = consumerNode.lvNext();
    if (localLinkedQueueNode != null) {
      return (E)localLinkedQueueNode.lpValue();
    }
    return null;
  }
  
  public E poll()
  {
    LinkedQueueNode localLinkedQueueNode = consumerNode.lvNext();
    if (localLinkedQueueNode != null)
    {
      Object localObject = localLinkedQueueNode.getAndNullValue();
      consumerNode = localLinkedQueueNode;
      return (E)localObject;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.SpscLinkedQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */