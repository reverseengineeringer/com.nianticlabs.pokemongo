package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson$FutureTypeAdapter<T>
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (delegate == null) {
      throw new IllegalStateException();
    }
    return (T)delegate.read(paramJsonReader);
  }
  
  public void setDelegate(TypeAdapter<T> paramTypeAdapter)
  {
    if (delegate != null) {
      throw new AssertionError();
    }
    delegate = paramTypeAdapter;
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (delegate == null) {
      throw new IllegalStateException();
    }
    delegate.write(paramJsonWriter, paramT);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.FutureTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */