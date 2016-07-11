package com.fasterxml.jackson.annotation;

import java.util.UUID;

public final class ObjectIdGenerators$UUIDGenerator
  extends ObjectIdGenerators.Base<UUID>
{
  private static final long serialVersionUID = 1L;
  
  public ObjectIdGenerators$UUIDGenerator()
  {
    this(Object.class);
  }
  
  private ObjectIdGenerators$UUIDGenerator(Class<?> paramClass)
  {
    super(Object.class);
  }
  
  public boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    return paramObjectIdGenerator.getClass() == getClass();
  }
  
  public ObjectIdGenerator<UUID> forScope(Class<?> paramClass)
  {
    return this;
  }
  
  public UUID generateId(Object paramObject)
  {
    return UUID.randomUUID();
  }
  
  public ObjectIdGenerator.IdKey key(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new ObjectIdGenerator.IdKey(getClass(), null, paramObject);
  }
  
  public ObjectIdGenerator<UUID> newForSerialization(Object paramObject)
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */