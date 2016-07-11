package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$16
  extends TypeAdapter<StringBuilder>
{
  public StringBuilder read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return new StringBuilder(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, StringBuilder paramStringBuilder)
    throws IOException
  {
    if (paramStringBuilder == null) {}
    for (paramStringBuilder = null;; paramStringBuilder = paramStringBuilder.toString())
    {
      paramJsonWriter.value(paramStringBuilder);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */