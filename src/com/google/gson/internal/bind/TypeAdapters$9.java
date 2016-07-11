package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$9
  extends TypeAdapter<Number>
{
  public Number read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Float.valueOf((float)paramJsonReader.nextDouble());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
    throws IOException
  {
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */