package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

final class TypeAdapters$24
  extends TypeAdapter<Locale>
{
  public Locale read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramJsonReader.nextString(), "_");
    paramJsonReader = null;
    String str1 = null;
    String str2 = null;
    if (localStringTokenizer.hasMoreElements()) {
      paramJsonReader = localStringTokenizer.nextToken();
    }
    if (localStringTokenizer.hasMoreElements()) {
      str1 = localStringTokenizer.nextToken();
    }
    if (localStringTokenizer.hasMoreElements()) {
      str2 = localStringTokenizer.nextToken();
    }
    if ((str1 == null) && (str2 == null)) {
      return new Locale(paramJsonReader);
    }
    if (str2 == null) {
      return new Locale(paramJsonReader, str1);
    }
    return new Locale(paramJsonReader, str1, str2);
  }
  
  public void write(JsonWriter paramJsonWriter, Locale paramLocale)
    throws IOException
  {
    if (paramLocale == null) {}
    for (paramLocale = null;; paramLocale = paramLocale.toString())
    {
      paramJsonWriter.value(paramLocale);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */