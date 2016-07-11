package com.fasterxml.jackson.annotation;

abstract class ObjectIdGenerators$Base<T>
  extends ObjectIdGenerator<T>
{
  protected final Class<?> _scope;
  
  protected ObjectIdGenerators$Base(Class<?> paramClass)
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */