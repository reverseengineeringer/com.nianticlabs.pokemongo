package com.fasterxml.jackson.core;

public abstract interface FormatFeature
{
  public abstract boolean enabledByDefault();
  
  public abstract boolean enabledIn(int paramInt);
  
  public abstract int getMask();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.FormatFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */