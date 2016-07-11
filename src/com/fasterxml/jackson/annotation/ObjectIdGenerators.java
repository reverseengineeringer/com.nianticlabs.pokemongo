package com.fasterxml.jackson.annotation;

import java.util.UUID;

public class ObjectIdGenerators
{
  private static abstract class Base<T>
    extends ObjectIdGenerator<T>
  {
    protected final Class<?> _scope;
    
    protected Base(Class<?> paramClass)
    {
      _scope = paramClass;
    }
    
    public boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator)
    {
      return (paramObjectIdGenerator.getClass() == getClass()) && (paramObjectIdGenerator.getScope() == _scope);
    }
    
    public abstract T generateId(Object paramObject);
    
    public final Class<?> getScope()
    {
      return _scope;
    }
  }
  
  public static final class IntSequenceGenerator
    extends ObjectIdGenerators.Base<Integer>
  {
    private static final long serialVersionUID = 1L;
    protected transient int _nextValue;
    
    public IntSequenceGenerator()
    {
      this(Object.class, -1);
    }
    
    public IntSequenceGenerator(Class<?> paramClass, int paramInt)
    {
      super();
      _nextValue = paramInt;
    }
    
    public ObjectIdGenerator<Integer> forScope(Class<?> paramClass)
    {
      if (_scope == paramClass) {
        return this;
      }
      return new IntSequenceGenerator(paramClass, _nextValue);
    }
    
    public Integer generateId(Object paramObject)
    {
      if (paramObject == null) {
        return null;
      }
      int i = _nextValue;
      _nextValue += 1;
      return Integer.valueOf(i);
    }
    
    protected int initialValue()
    {
      return 1;
    }
    
    public ObjectIdGenerator.IdKey key(Object paramObject)
    {
      if (paramObject == null) {
        return null;
      }
      return new ObjectIdGenerator.IdKey(getClass(), _scope, paramObject);
    }
    
    public ObjectIdGenerator<Integer> newForSerialization(Object paramObject)
    {
      return new IntSequenceGenerator(_scope, initialValue());
    }
  }
  
  public static abstract class None
    extends ObjectIdGenerator<Object>
  {}
  
  public static abstract class PropertyGenerator
    extends ObjectIdGenerators.Base<Object>
  {
    private static final long serialVersionUID = 1L;
    
    protected PropertyGenerator(Class<?> paramClass)
    {
      super();
    }
  }
  
  public static final class UUIDGenerator
    extends ObjectIdGenerators.Base<UUID>
  {
    private static final long serialVersionUID = 1L;
    
    public UUIDGenerator()
    {
      this(Object.class);
    }
    
    private UUIDGenerator(Class<?> paramClass)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */