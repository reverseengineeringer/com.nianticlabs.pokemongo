package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$13
  extends TypeAdapter<String>
{
  public String read(JsonReader paramJsonReader)
    throws IOException
  {
    JsonToken localJsonToken = paramJsonReader.peek();
    if (localJsonToken == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    if (localJsonToken == JsonToken.BOOLEAN) {
      return Boolean.toString(paramJsonReader.nextBoolean());
    }
    return paramJsonReader.nextString();
  }
  
  public void write(JsonWriter paramJsonWriter, String paramString)
    throws IOException
  {
    paramJsonWriter.value(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */