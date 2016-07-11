package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$29
  implements TypeAdapterFactory
{
  TypeAdapters$29(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    paramGson = paramTypeToken.getRawType();
    if ((paramGson == val$unboxed) || (paramGson == val$boxed)) {
      return val$typeAdapter;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + val$boxed.getName() + "+" + val$unboxed.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */