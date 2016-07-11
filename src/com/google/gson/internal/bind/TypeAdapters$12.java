package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$12
  extends TypeAdapter<Character>
{
  public Character read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    paramJsonReader = paramJsonReader.nextString();
    if (paramJsonReader.length() != 1) {
      throw new JsonSyntaxException("Expecting character, got: " + paramJsonReader);
    }
    return Character.valueOf(paramJsonReader.charAt(0));
  }
  
  public void write(JsonWriter paramJsonWriter, Character paramCharacter)
    throws IOException
  {
    if (paramCharacter == null) {}
    for (paramCharacter = null;; paramCharacter = String.valueOf(paramCharacter))
    {
      paramJsonWriter.value(paramCharacter);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */