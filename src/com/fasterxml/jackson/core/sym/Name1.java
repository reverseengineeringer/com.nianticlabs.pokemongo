package com.fasterxml.jackson.core.sym;

public final class Name1
  extends Name
{
  private static final Name1 EMPTY = new Name1("", 0, 0);
  private final int q;
  
  Name1(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
    q = paramInt2;
  }
  
  public static Name1 getEmptyName()
  {
    return EMPTY;
  }
  
  public boolean equals(int paramInt)
  {
    return paramInt == q;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == q) && (paramInt2 == 0);
  }
  
  public boolean equals(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 1) && (paramArrayOfInt[0] == q);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.Name1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */