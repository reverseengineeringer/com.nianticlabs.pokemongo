package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class TypeAdapters$EnumTypeAdapter<T extends Enum<T>>
  extends TypeAdapter<T>
{
  private final Map<T, String> constantToName = new HashMap();
  private final Map<String, T> nameToConstant = new HashMap();
  
  public TypeAdapters$EnumTypeAdapter(Class<T> paramClass)
  {
    try
    {
      Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
      int j = arrayOfEnum.length;
      int i = 0;
      while (i < j)
      {
        Enum localEnum = arrayOfEnum[i];
        String str = localEnum.name();
        SerializedName localSerializedName = (SerializedName)paramClass.getField(str).getAnnotation(SerializedName.class);
        if (localSerializedName != null) {
          str = localSerializedName.value();
        }
        nameToConstant.put(str, localEnum);
        constantToName.put(localEnum, str);
        i += 1;
      }
      return;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AssertionError();
    }
  }
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return (Enum)nameToConstant.get(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (paramT == null) {}
    for (paramT = null;; paramT = (String)constantToName.get(paramT))
    {
      paramJsonWriter.value(paramT);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */