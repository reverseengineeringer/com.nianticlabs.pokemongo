package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

public final class NameN
  extends Name
{
  private final int[] q;
  private final int q1;
  private final int q2;
  private final int q3;
  private final int q4;
  private final int qlen;
  
  NameN(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt, int paramInt6)
  {
    super(paramString, paramInt1);
    q1 = paramInt2;
    q2 = paramInt3;
    q3 = paramInt4;
    q4 = paramInt5;
    q = paramArrayOfInt;
    qlen = paramInt6;
  }
  
  private final boolean _equals2(int[] paramArrayOfInt)
  {
    int j = qlen;
    int i = 0;
    while (i < j - 4)
    {
      if (paramArrayOfInt[(i + 4)] != q[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static NameN construct(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 < 4) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramArrayOfInt[2];
    int m = paramArrayOfInt[3];
    if (paramInt2 - 4 > 0) {}
    for (paramArrayOfInt = Arrays.copyOfRange(paramArrayOfInt, 4, paramInt2);; paramArrayOfInt = null) {
      return new NameN(paramString, paramInt1, i, j, k, m, paramArrayOfInt, paramInt2);
    }
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != qlen) {}
    do
    {
      do
      {
        return false;
      } while ((paramArrayOfInt[0] != q1) || (paramArrayOfInt[1] != q2) || (paramArrayOfInt[2] != q3) || (paramArrayOfInt[3] != q4));
      switch (paramInt)
      {
      default: 
        return _equals2(paramArrayOfInt);
      }
    } while ((paramArrayOfInt[7] != q[3]) || (paramArrayOfInt[6] != q[2]) || (paramArrayOfInt[5] != q[1]) || (paramArrayOfInt[4] != q[0]));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.NameN
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */