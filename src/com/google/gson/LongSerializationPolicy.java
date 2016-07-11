package com.google.gson;

public enum LongSerializationPolicy
{
  DEFAULT,  STRING;
  
  private LongSerializationPolicy() {}
  
  public abstract JsonElement serialize(Long paramLong);
}

/* Location:
 * Qualified Name:     com.google.gson.LongSerializationPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */