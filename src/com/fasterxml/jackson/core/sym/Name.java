package com.fasterxml.jackson.core.sym;

public abstract class Name
{
  protected final int _hashCode;
  protected final String _name;
  
  protected Name(String paramString, int paramInt)
  {
    _name = paramString;
    _hashCode = paramInt;
  }
  
  public abstract boolean equals(int paramInt);
  
  public abstract boolean equals(int paramInt1, int paramInt2);
  
  public abstract boolean equals(int paramInt1, int paramInt2, int paramInt3);
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public abstract boolean equals(int[] paramArrayOfInt, int paramInt);
  
  public String getName()
  {
    return _name;
  }
  
  public final int hashCode()
  {
    return _hashCode;
  }
  
  public String toString()
  {
    return _name;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.Name
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */