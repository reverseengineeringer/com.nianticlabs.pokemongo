package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
import sun.misc.Unsafe;

public final class MpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public MpscLinkedQueue()
  {
    consumerNode = new LinkedQueueNode();
    xchgProducerNode(consumerNode);
  }
  
  public final boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("null elements not allowed");
    }
    paramE = new LinkedQueueNode(paramE);
    xchgProducerNode(paramE).soNext(paramE);
    return true;
  }
  
  public final E peek()
  {
    LinkedQueueNode localLinkedQueueNode1 = consumerNode;
    LinkedQueueNode localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
    if (localLinkedQueueNode2 != null) {
      return (E)localLinkedQueueNode2.lpValue();
    }
    if (localLinkedQueueNode1 != lvProducerNode())
    {
      do
      {
        localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
      } while (localLinkedQueueNode2 == null);
      return (E)localLinkedQueueNode2.lpValue();
    }
    return null;
  }
  
  public final E poll()
  {
    Object localObject = lpConsumerNode();
    LinkedQueueNode localLinkedQueueNode = ((LinkedQueueNode)localObject).lvNext();
    if (localLinkedQueueNode != null)
    {
      localObject = localLinkedQueueNode.getAndNullValue();
      spConsumerNode(localLinkedQueueNode);
      return (E)localObject;
    }
    if (localObject != lvProducerNode())
    {
      do
      {
        localLinkedQueueNode = ((LinkedQueueNode)localObject).lvNext();
      } while (localLinkedQueueNode == null);
      localObject = localLinkedQueueNode.getAndNullValue();
      consumerNode = localLinkedQueueNode;
      return (E)localObject;
    }
    return null;
  }
  
  protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    LinkedQueueNode localLinkedQueueNode;
    do
    {
      localLinkedQueueNode = producerNode;
    } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, localLinkedQueueNode, paramLinkedQueueNode));
    return (LinkedQueueNode)localLinkedQueueNode;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.MpscLinkedQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */