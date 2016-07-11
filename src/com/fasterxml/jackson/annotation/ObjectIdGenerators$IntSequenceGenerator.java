package com.fasterxml.jackson.annotation;

public final class ObjectIdGenerators$IntSequenceGenerator
  extends ObjectIdGenerators.Base<Integer>
{
  private static final long serialVersionUID = 1L;
  protected transient int _nextValue;
  
  public ObjectIdGenerators$IntSequenceGenerator()
  {
    this(Object.class, -1);
  }
  
  public ObjectIdGenerators$IntSequenceGenerator(Class<?> paramClass, int paramInt)
  {
    super(paramClass);
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */