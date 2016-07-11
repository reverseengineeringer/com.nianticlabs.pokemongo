package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$28
  implements TypeAdapterFactory
{
  TypeAdapters$28(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.getRawType() == val$type) {
      return val$typeAdapter;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + val$type.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */