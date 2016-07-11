package rx.internal.util.unsafe;

abstract class SpmcArrayQueueProducerIndexCacheField<E>
  extends SpmcArrayQueueMidPad<E>
{
  private volatile long producerIndexCache;
  
  public SpmcArrayQueueProducerIndexCacheField(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long lvProducerIndexCache()
  {
    return producerIndexCache;
  }
  
  protected final void svProducerIndexCache(long paramLong)
  {
    producerIndexCache = paramLong;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.SpmcArrayQueueProducerIndexCacheField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */