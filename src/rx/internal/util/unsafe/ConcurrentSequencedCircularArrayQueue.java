package rx.internal.util.unsafe;

import sun.misc.Unsafe;

public abstract class ConcurrentSequencedCircularArrayQueue<E>
  extends ConcurrentCircularArrayQueue<E>
{
  private static final long ARRAY_BASE;
  private static final int ELEMENT_SHIFT;
  protected final long[] sequenceBuffer;
  
  static
  {
    if (8 == UnsafeAccess.UNSAFE.arrayIndexScale(long[].class))
    {
      ELEMENT_SHIFT = SPARSE_SHIFT + 3;
      ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class) + (32 << ELEMENT_SHIFT - SPARSE_SHIFT);
      return;
    }
    throw new IllegalStateException("Unexpected long[] element size");
  }
  
  public ConcurrentSequencedCircularArrayQueue(int paramInt)
  {
    super(paramInt);
    paramInt = (int)(mask + 1L);
    sequenceBuffer = new long[(paramInt << SPARSE_SHIFT) + 64];
    for (long l = 0L; l < paramInt; l += 1L) {
      soSequence(sequenceBuffer, calcSequenceOffset(l), l);
    }
  }
  
  protected final long calcSequenceOffset(long paramLong)
  {
    return ARRAY_BASE + ((mask & paramLong) << ELEMENT_SHIFT);
  }
  
  protected final long lvSequence(long[] paramArrayOfLong, long paramLong)
  {
    return UnsafeAccess.UNSAFE.getLongVolatile(paramArrayOfLong, paramLong);
  }
  
  protected final void soSequence(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(paramArrayOfLong, paramLong1, paramLong2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.ConcurrentSequencedCircularArrayQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */