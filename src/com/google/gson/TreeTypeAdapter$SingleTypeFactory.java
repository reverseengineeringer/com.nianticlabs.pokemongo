package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.reflect.TypeToken;

class TreeTypeAdapter$SingleTypeFactory
  implements TypeAdapterFactory
{
  private final JsonDeserializer<?> deserializer;
  private final TypeToken<?> exactType;
  private final Class<?> hierarchyType;
  private final boolean matchRawType;
  private final JsonSerializer<?> serializer;
  
  private TreeTypeAdapter$SingleTypeFactory(Object paramObject, TypeToken<?> paramTypeToken, boolean paramBoolean, Class<?> paramClass)
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

/* Location:
 * Qualified Name:     com.google.gson.TreeTypeAdapter.SingleTypeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */