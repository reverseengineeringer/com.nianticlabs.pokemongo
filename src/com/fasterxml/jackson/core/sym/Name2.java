package com.fasterxml.jackson.core.sym;

public final class Name2
  extends Name
{
  private final int q1;
  private final int q2;
  
  Name2(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1);
    q1 = paramInt2;
    q2 = paramInt3;
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == q1) && (paramInt2 == q2);
  }
  
  public boolean equals(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 2) && (paramArrayOfInt[0] == q1) && (paramArrayOfInt[1] == q2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.Name2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */