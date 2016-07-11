package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class MapTypeAdapterFactory$Adapter<K, V>
  extends TypeAdapter<Map<K, V>>
{
  private final ObjectConstructor<? extends Map<K, V>> constructor;
  private final TypeAdapter<K> keyTypeAdapter;
  private final TypeAdapter<V> valueTypeAdapter;
  
  public MapTypeAdapterFactory$Adapter(Gson paramGson, Type paramType1, TypeAdapter<K> paramTypeAdapter, Type paramType2, TypeAdapter<V> paramTypeAdapter1, ObjectConstructor<? extends Map<K, V>> paramObjectConstructor)
  {
    keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramType1, paramType2, paramTypeAdapter);
    valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramType1, paramObjectConstructor, paramTypeAdapter1);
    ObjectConstructor localObjectConstructor;
    constructor = localObjectConstructor;
  }
  
  private String keyToString(JsonElement paramJsonElement)
  {
    if (paramJsonElement.isJsonPrimitive())
    {
      paramJsonElement = paramJsonElement.getAsJsonPrimitive();
      if (paramJsonElement.isNumber()) {
        return String.valueOf(paramJsonElement.getAsNumber());
      }
      if (paramJsonElement.isBoolean()) {
        return Boolean.toString(paramJsonElement.getAsBoolean());
      }
      if (paramJsonElement.isString()) {
        return paramJsonElement.getAsString();
      }
      throw new AssertionError();
    }
    if (paramJsonElement.isJsonNull()) {
      return "null";
    }
    throw new AssertionError();
  }
  
  public Map<K, V> read(JsonReader paramJsonReader)
    throws IOException
  {
    Object localObject = paramJsonReader.peek();
    if (localObject == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    Map localMap = (Map)constructor.construct();
    if (localObject == JsonToken.BEGIN_ARRAY)
    {
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext())
      {
        paramJsonReader.beginArray();
        localObject = keyTypeAdapter.read(paramJsonReader);
        if (localMap.put(localObject, valueTypeAdapter.read(paramJsonReader)) != null) {
          throw new JsonSyntaxException("duplicate key: " + localObject);
        }
        paramJsonReader.endArray();
      }
      paramJsonReader.endArray();
      return localMap;
    }
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      JsonReaderInternalAccess.INSTANCE.promoteNameToValue(paramJsonReader);
      localObject = keyTypeAdapter.read(paramJsonReader);
      if (localMap.put(localObject, valueTypeAdapter.read(paramJsonReader)) != null) {
        throw new JsonSyntaxException("duplicate key: " + localObject);
      }
    }
    paramJsonReader.endObject();
    return localMap;
  }
  
  public void write(JsonWriter paramJsonWriter, Map<K, V> paramMap)
    throws IOException
  {
    if (paramMap == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    if (!MapTypeAdapterFactory.access$000(this$0))
    {
      paramJsonWriter.beginObject();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        paramJsonWriter.name(String.valueOf(((Map.Entry)localObject).getKey()));
        valueTypeAdapter.write(paramJsonWriter, ((Map.Entry)localObject).getValue());
      }
      paramJsonWriter.endObject();
      return;
    }
    int i = 0;
    Object localObject = new ArrayList(paramMap.size());
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      JsonElement localJsonElement = keyTypeAdapter.toJsonTree(localEntry.getKey());
      ((List)localObject).add(localJsonElement);
      localArrayList.add(localEntry.getValue());
      if ((localJsonElement.isJsonArray()) || (localJsonElement.isJsonObject())) {}
      for (int j = 1;; j = 0)
      {
        i |= j;
        break;
      }
    }
    if (i != 0)
    {
      paramJsonWriter.beginArray();
      i = 0;
      while (i < ((List)localObject).size())
      {
        paramJsonWriter.beginArray();
        Streams.write((JsonElement)((List)localObject).get(i), paramJsonWriter);
        valueTypeAdapter.write(paramJsonWriter, localArrayList.get(i));
        paramJsonWriter.endArray();
        i += 1;
      }
      paramJsonWriter.endArray();
      return;
    }
    paramJsonWriter.beginObject();
    i = 0;
    while (i < ((List)localObject).size())
    {
      paramJsonWriter.name(keyToString((JsonElement)((List)localObject).get(i)));
      valueTypeAdapter.write(paramJsonWriter, localArrayList.get(i));
      i += 1;
    }
    paramJsonWriter.endObject();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */