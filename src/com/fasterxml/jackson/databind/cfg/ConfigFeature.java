package com.fasterxml.jackson.databind.cfg;

public abstract interface ConfigFeature
{
  public abstract boolean enabledByDefault();
  
  public abstract boolean enabledIn(int paramInt);
  
  public abstract int getMask();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.cfg.ConfigFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */