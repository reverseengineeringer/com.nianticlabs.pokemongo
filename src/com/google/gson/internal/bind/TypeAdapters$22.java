package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

final class TypeAdapters$22
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.getRawType() != Timestamp.class) {
      return null;
    }
    new TypeAdapter()
    {
      public Timestamp read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        paramAnonymousJsonReader = (Date)val$dateTypeAdapter.read(paramAnonymousJsonReader);
        if (paramAnonymousJsonReader != null) {
          return new Timestamp(paramAnonymousJsonReader.getTime());
        }
        return null;
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Timestamp paramAnonymousTimestamp)
        throws IOException
      {
        val$dateTypeAdapter.write(paramAnonymousJsonWriter, paramAnonymousTimestamp);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */