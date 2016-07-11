package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializationContext
{
  public abstract <T> T deserialize(JsonElement paramJsonElement, Type paramType)
    throws JsonParseException;
}

/* Location:
 * Qualified Name:     com.google.gson.JsonDeserializationContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */