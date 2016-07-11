package rx.internal.util.atomic;

public final class SpscLinkedAtomicQueue<E>
  extends BaseLinkedAtomicQueue<E>
{
  public SpscLinkedAtomicQueue()
  {
    LinkedQueueNode localLinkedQueueNode = new LinkedQueueNode();
    spProducerNode(localLinkedQueueNode);
    spConsumerNode(localLinkedQueueNode);
    localLinkedQueueNode.soNext(null);
  }
  
  public boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("null elements not allowed");
    }
    paramE = new LinkedQueueNode(paramE);
    lpProducerNode().soNext(paramE);
    spProducerNode(paramE);
    return true;
  }
  
  public E peek()
  {
    LinkedQueueNode localLinkedQueueNode = lpConsumerNode().lvNext();
    if (localLinkedQueueNode != null) {
      return (E)localLinkedQueueNode.lpValue();
    }
    return null;
  }
  
  public E poll()
  {
    LinkedQueueNode localLinkedQueueNode = lpConsumerNode().lvNext();
    if (localLinkedQueueNode != null)
    {
      Object localObject = localLinkedQueueNode.getAndNullValue();
      spConsumerNode(localLinkedQueueNode);
      return (E)localObject;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.atomic.SpscLinkedAtomicQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */