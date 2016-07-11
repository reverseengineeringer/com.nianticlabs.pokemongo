package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson$4
  extends TypeAdapter<Number>
{
  Gson$4(Gson paramGson) {}
  
  public Float read(JsonReader paramJsonReader)
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
    if (paramNumber == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    float f = paramNumber.floatValue();
    Gson.access$000(this$0, f);
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */