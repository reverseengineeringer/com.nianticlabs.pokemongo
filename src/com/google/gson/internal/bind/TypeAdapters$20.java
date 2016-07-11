package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

final class TypeAdapters$20
  extends TypeAdapter<InetAddress>
{
  public InetAddress read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return InetAddress.getByName(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, InetAddress paramInetAddress)
    throws IOException
  {
    if (paramInetAddress == null) {}
    for (paramInetAddress = null;; paramInetAddress = paramInetAddress.getHostAddress())
    {
      paramJsonWriter.value(paramInetAddress);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */