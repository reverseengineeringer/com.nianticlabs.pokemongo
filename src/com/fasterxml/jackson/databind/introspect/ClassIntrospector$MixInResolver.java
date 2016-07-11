package com.fasterxml.jackson.databind.introspect;

public abstract interface ClassIntrospector$MixInResolver
{
  public abstract MixInResolver copy();
  
  public abstract Class<?> findMixInClassFor(Class<?> paramClass);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */