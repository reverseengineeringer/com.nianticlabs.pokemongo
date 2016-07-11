package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TreeTypeAdapter<T>
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  private final JsonDeserializer<T> deserializer;
  private final Gson gson;
  private final JsonSerializer<T> serializer;
  private final TypeAdapterFactory skipPast;
  private final TypeToken<T> typeToken;
  
  private TreeTypeAdapter(JsonSerializer<T> paramJsonSerializer, JsonDeserializer<T> paramJsonDeserializer, Gson paramGson, TypeToken<T> paramTypeToken, TypeAdapterFactory paramTypeAdapterFactory)
  {
    serializer = paramJsonSerializer;
    deserializer = paramJsonDeserializer;
    gson = paramGson;
    typeToken = paramTypeToken;
    skipPast = paramTypeAdapterFactory;
  }
  
  private TypeAdapter<T> delegate()
  {
    TypeAdapter localTypeAdapter = delegate;
    if (localTypeAdapter != null) {
      return localTypeAdapter;
    }
    localTypeAdapter = gson.getDelegateAdapter(skipPast, typeToken);
    delegate = localTypeAdapter;
    return localTypeAdapter;
  }
  
  public static TypeAdapterFactory newFactory(TypeToken<?> paramTypeToken, Object paramObject)
  {
    return new SingleTypeFactory(paramObject, paramTypeToken, false, null, null);
  }
  
  public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> paramTypeToken, Object paramObject)
  {
    if (paramTypeToken.getType() == paramTypeToken.getRawType()) {}
    for (boolean bool = true;; bool = false) {
      return new SingleTypeFactory(paramObject, paramTypeToken, bool, null, null);
    }
  }
  
  public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> paramClass, Object paramObject)
  {
    return new SingleTypeFactory(paramObject, null, false, paramClass, null);
  }
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (deserializer == null) {
      return (T)delegate().read(paramJsonReader);
    }
    paramJsonReader = Streams.parse(paramJsonReader);
    if (paramJsonReader.isJsonNull()) {
      return null;
    }
    return (T)deserializer.deserialize(paramJsonReader, typeToken.getType(), gson.deserializationContext);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (serializer == null)
    {
      delegate().write(paramJsonWriter, paramT);
      return;
    }
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    Streams.write(serializer.serialize(paramT, typeToken.getType(), gson.serializationContext), paramJsonWriter);
  }
  
  private static class SingleTypeFactory
    implements TypeAdapterFactory
  {
    private final JsonDeserializer<?> deserializer;
    private final TypeToken<?> exactType;
    private final Class<?> hierarchyType;
    private final boolean matchRawType;
    private final JsonSerializer<?> serializer;
    
    private SingleTypeFactory(Object paramObject, TypeToken<?> paramTypeToken, boolean paramBoolean, Class<?> paramClass)
    {
      JsonSerializer localJsonSerializer;
      if ((paramObject instanceof JsonSerializer))
      {
        localJsonSerializer = (JsonSerializer)paramObject;
        serializer = localJsonSerializer;
        if (!(paramObject instanceof JsonDeserializer)) {
          break label85;
        }
        paramObject = (JsonDeserializer)paramObject;
        label35:
        deserializer = ((JsonDeserializer)paramObject);
        if ((serializer == null) && (deserializer == null)) {
          break label90;
        }
      }
      label85:
      label90:
      for (boolean bool = true;; bool = false)
      {
        .Gson.Preconditions.checkArgument(bool);
        exactType = paramTypeToken;
        matchRawType = paramBoolean;
        hierarchyType = paramClass;
        return;
        localJsonSerializer = null;
        break;
        paramObject = null;
        break label35;
      }
    }
    
    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
    {
      boolean bool;
      if (exactType != null) {
        if ((exactType.equals(paramTypeToken)) || ((matchRawType) && (exactType.getType() == paramTypeToken.getRawType()))) {
          bool = true;
        }
      }
      while (bool)
      {
        return new TreeTypeAdapter(serializer, deserializer, paramGson, paramTypeToken, this, null);
        bool = false;
        continue;
        bool = hierarchyType.isAssignableFrom(paramTypeToken.getRawType());
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.TreeTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */