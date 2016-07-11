package rx.internal.util.unsafe;

abstract interface MessagePassingQueue<M>
{
  public abstract boolean isEmpty();
  
  public abstract boolean offer(M paramM);
  
  public abstract M peek();
  
  public abstract M poll();
  
  public abstract int size();
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.MessagePassingQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */