package rx.internal.util.unsafe;

public final class Pow2
{
  private Pow2()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static boolean isPowerOfTwo(int paramInt)
  {
    return (paramInt - 1 & paramInt) == 0;
  }
  
  public static int roundToPowerOfTwo(int paramInt)
  {
    return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.Pow2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */