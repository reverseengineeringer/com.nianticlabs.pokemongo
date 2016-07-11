package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.sql.Time;

final class TimeTypeAdapter$1
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.getRawType() == Time.class) {
      return new TimeTypeAdapter();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TimeTypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */