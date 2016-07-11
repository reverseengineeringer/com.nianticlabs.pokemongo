package com.fasterxml.jackson.core.sym;

public final class Name3
  extends Name
{
  private final int q1;
  private final int q2;
  private final int q3;
  
  Name3(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramInt1);
    q1 = paramInt2;
    q2 = paramInt3;
    q3 = paramInt4;
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
    return (q1 == paramInt1) && (q2 == paramInt2) && (q3 == paramInt3);
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 3) && (paramArrayOfInt[0] == q1) && (paramArrayOfInt[1] == q2) && (paramArrayOfInt[2] == q3);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.Name3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */