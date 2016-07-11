package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializer<T>
{
  public abstract T deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException;
}

/* Location:
 * Qualified Name:     com.google.gson.JsonDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */