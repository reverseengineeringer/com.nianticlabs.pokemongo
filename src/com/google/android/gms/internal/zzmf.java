package com.google.android.gms.internal;

public class zzmf
{
  public static final int[] EMPTY_INTS = new int[0];
  public static final long[] EMPTY_LONGS = new long[0];
  public static final Object[] EMPTY_OBJECTS = new Object[0];
  
  public static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    paramInt1 = i;
    i = j;
    while (paramInt1 <= i)
    {
      j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2) {
        paramInt1 = j + 1;
      } else if (k > paramInt2) {
        i = j - 1;
      } else {
        return j;
      }
    }
    return paramInt1 ^ 0xFFFFFFFF;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */