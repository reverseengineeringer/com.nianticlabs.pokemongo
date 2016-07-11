package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson$3
  extends TypeAdapter<Number>
{
  Gson$3(Gson paramGson) {}
  
  public Double read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Double.valueOf(paramJsonReader.nextDouble());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
    throws IOException
  {
    if (paramNumber == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    double d = paramNumber.doubleValue();
    Gson.access$000(this$0, d);
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */