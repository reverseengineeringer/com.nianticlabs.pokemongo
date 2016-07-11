package com.google.gson;

public final class JsonNull
  extends JsonElement
{
  public static final JsonNull INSTANCE = new JsonNull();
  
  JsonNull deepCopy()
  {
    return INSTANCE;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || ((paramObject instanceof JsonNull));
  }
  
  public int hashCode()
  {
    return JsonNull.class.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.JsonNull
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */