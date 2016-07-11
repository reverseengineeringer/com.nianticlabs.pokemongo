package com.google.android.gms.common.data;

public abstract interface Freezable<T>
{
  public abstract T freeze();
  
  public abstract boolean isDataValid();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.Freezable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */