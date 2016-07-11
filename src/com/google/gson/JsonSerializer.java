package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonSerializer<T>
{
  public abstract JsonElement serialize(T paramT, Type paramType, JsonSerializationContext paramJsonSerializationContext);
}

/* Location:
 * Qualified Name:     com.google.gson.JsonSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */