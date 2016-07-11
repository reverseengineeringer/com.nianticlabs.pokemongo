package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$11
  extends TypeAdapter<Number>
{
  public Number read(JsonReader paramJsonReader)
    throws IOException
  {
    JsonToken localJsonToken = paramJsonReader.peek();
    switch (TypeAdapters.32.$SwitchMap$com$google$gson$stream$JsonToken[localJsonToken.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      throw new JsonSyntaxException("Expecting number, got: " + localJsonToken);
    case 4: 
      paramJsonReader.nextNull();
      return null;
    }
    return new LazilyParsedNumber(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
    throws IOException
  {
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */