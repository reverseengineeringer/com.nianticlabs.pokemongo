package com.google.gson;

import java.lang.reflect.Type;

class Gson$2
  implements JsonSerializationContext
{
  Gson$2(Gson paramGson) {}
  
  public JsonElement serialize(Object paramObject)
  {
    return this$0.toJsonTree(paramObject);
  }
  
  public JsonElement serialize(Object paramObject, Type paramType)
  {
    return this$0.toJsonTree(paramObject, paramType);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */