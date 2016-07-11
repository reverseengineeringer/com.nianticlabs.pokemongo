package com.fasterxml.jackson.annotation;

public abstract interface ObjectIdResolver
{
  public abstract void bindItem(ObjectIdGenerator.IdKey paramIdKey, Object paramObject);
  
  public abstract boolean canUseFor(ObjectIdResolver paramObjectIdResolver);
  
  public abstract ObjectIdResolver newForDeserialization(Object paramObject);
  
  public abstract Object resolveId(ObjectIdGenerator.IdKey paramIdKey);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */