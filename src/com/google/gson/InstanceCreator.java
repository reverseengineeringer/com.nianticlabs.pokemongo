package com.google.gson;

import java.lang.reflect.Type;

public abstract interface InstanceCreator<T>
{
  public abstract T createInstance(Type paramType);
}

/* Location:
 * Qualified Name:     com.google.gson.InstanceCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */