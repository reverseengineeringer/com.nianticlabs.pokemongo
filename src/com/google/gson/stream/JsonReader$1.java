package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.IOException;

final class JsonReader$1
  extends JsonReaderInternalAccess
{
  public void promoteNameToValue(JsonReader paramJsonReader)
    throws IOException
  {
    if ((paramJsonReader instanceof JsonTreeReader))
    {
      ((JsonTreeReader)paramJsonReader).promoteNameToValue();
      return;
    }
    int j = JsonReader.access$000(paramJsonReader);
    int i = j;
    if (j == 0) {
      i = JsonReader.access$100(paramJsonReader);
    }
    if (i == 13)
    {
      JsonReader.access$002(paramJsonReader, 9);
      return;
    }
    if (i == 12)
    {
      JsonReader.access$002(paramJsonReader, 8);
      return;
    }
    if (i == 14)
    {
      JsonReader.access$002(paramJsonReader, 10);
      return;
    }
    throw new IllegalStateException("Expected a name but was " + paramJsonReader.peek() + " " + " at line " + JsonReader.access$200(paramJsonReader) + " column " + JsonReader.access$300(paramJsonReader));
  }
}

/* Location:
 * Qualified Name:     com.google.gson.stream.JsonReader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */