package com.google.gson;

public abstract interface ExclusionStrategy
{
  public abstract boolean shouldSkipClass(Class<?> paramClass);
  
  public abstract boolean shouldSkipField(FieldAttributes paramFieldAttributes);
}

/* Location:
 * Qualified Name:     com.google.gson.ExclusionStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */