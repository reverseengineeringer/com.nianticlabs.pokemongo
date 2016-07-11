package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$30
  implements TypeAdapterFactory
{
  TypeAdapters$30(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    paramGson = paramTypeToken.getRawType();
    if ((paramGson == val$base) || (paramGson == val$sub)) {
      return val$typeAdapter;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + val$base.getName() + "+" + val$sub.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */