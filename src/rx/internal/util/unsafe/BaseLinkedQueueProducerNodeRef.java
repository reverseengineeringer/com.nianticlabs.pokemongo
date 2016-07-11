package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
import sun.misc.Unsafe;

abstract class BaseLinkedQueueProducerNodeRef<E>
  extends BaseLinkedQueuePad0<E>
{
  protected static final long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");
  protected LinkedQueueNode<E> producerNode;
  
  protected final LinkedQueueNode<E> lpProducerNode()
  {
    return producerNode;
  }
  
  protected final LinkedQueueNode<E> lvProducerNode()
  {
    return (LinkedQueueNode)UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
  }
  
  protected final void spProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    producerNode = paramLinkedQueueNode;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */