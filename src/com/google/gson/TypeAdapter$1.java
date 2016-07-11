package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapter$1
  extends TypeAdapter<T>
{
  TypeAdapter$1(TypeAdapter paramTypeAdapter) {}
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return (T)this$0.read(paramJsonReader);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    this$0.write(paramJsonWriter, paramT);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.TypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */