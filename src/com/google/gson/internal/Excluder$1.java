package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Excluder$1
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  Excluder$1(Excluder paramExcluder, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, TypeToken paramTypeToken) {}
  
  private TypeAdapter<T> delegate()
  {
    TypeAdapter localTypeAdapter = delegate;
    if (localTypeAdapter != null) {
      return localTypeAdapter;
    }
    localTypeAdapter = val$gson.getDelegateAdapter(this$0, val$type);
    delegate = localTypeAdapter;
    return localTypeAdapter;
  }
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (val$skipDeserialize)
    {
      paramJsonReader.skipValue();
      return null;
    }
    return (T)delegate().read(paramJsonReader);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (val$skipSerialize)
    {
      paramJsonWriter.nullValue();
      return;
    }
    delegate().write(paramJsonWriter, paramT);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.Excluder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */