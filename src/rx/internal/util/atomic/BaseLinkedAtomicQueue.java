package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

abstract class BaseLinkedAtomicQueue<E>
  extends AbstractQueue<E>
{
  private final AtomicReference<LinkedQueueNode<E>> consumerNode = new AtomicReference();
  private final AtomicReference<LinkedQueueNode<E>> producerNode = new AtomicReference();
  
  public final boolean isEmpty()
  {
    return lvConsumerNode() == lvProducerNode();
  }
  
  public final Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final LinkedQueueNode<E> lpConsumerNode()
  {
    return (LinkedQueueNode)consumerNode.get();
  }
  
  protected final LinkedQueueNode<E> lpProducerNode()
  {
    return (LinkedQueueNode)producerNode.get();
  }
  
  protected final LinkedQueueNode<E> lvConsumerNode()
  {
    return (LinkedQueueNode)consumerNode.get();
  }
  
  protected final LinkedQueueNode<E> lvProducerNode()
  {
    return (LinkedQueueNode)producerNode.get();
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
  
  protected final void spConsumerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    consumerNode.lazySet(paramLinkedQueueNode);
  }
  
  protected final void spProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    producerNode.lazySet(paramLinkedQueueNode);
  }
  
  protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    return (LinkedQueueNode)producerNode.getAndSet(paramLinkedQueueNode);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.atomic.BaseLinkedAtomicQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */