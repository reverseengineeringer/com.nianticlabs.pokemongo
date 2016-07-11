package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

final class TypeAdapters$15
  extends TypeAdapter<BigInteger>
{
  public BigInteger read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    try
    {
      paramJsonReader = new BigInteger(paramJsonReader.nextString());
      return paramJsonReader;
    }
    catch (NumberFormatException paramJsonReader)
    {
      throw new JsonSyntaxException(paramJsonReader);
    }
  }
  
  public void write(JsonWriter paramJsonWriter, BigInteger paramBigInteger)
    throws IOException
  {
    paramJsonWriter.value(paramBigInteger);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */