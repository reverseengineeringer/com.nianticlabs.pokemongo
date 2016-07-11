package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
import sun.misc.Unsafe;

abstract class BaseLinkedQueueConsumerNodeRef<E>
  extends BaseLinkedQueuePad1<E>
{
  protected static final long C_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
  protected LinkedQueueNode<E> consumerNode;
  
  protected final LinkedQueueNode<E> lpConsumerNode()
  {
    return consumerNode;
  }
  
  protected final LinkedQueueNode<E> lvConsumerNode()
  {
    return (LinkedQueueNode)UnsafeAccess.UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
  }
  
  protected final void spConsumerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    consumerNode = paramLinkedQueueNode;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */