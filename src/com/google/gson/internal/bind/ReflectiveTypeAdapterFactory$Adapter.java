package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory$Adapter<T>
  extends TypeAdapter<T>
{
  private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
  private final ObjectConstructor<T> constructor;
  
  private ReflectiveTypeAdapterFactory$Adapter(ObjectConstructor<T> paramObjectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> paramMap)
  {
    constructor = paramObjectConstructor;
    boundFields = paramMap;
  }
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    Object localObject1 = constructor.construct();
    try
    {
      paramJsonReader.beginObject();
      for (;;)
      {
        if (!paramJsonReader.hasNext()) {
          break label103;
        }
        localObject2 = paramJsonReader.nextName();
        localObject2 = (ReflectiveTypeAdapterFactory.BoundField)boundFields.get(localObject2);
        if ((localObject2 != null) && (deserialized)) {
          break;
        }
        paramJsonReader.skipValue();
      }
    }
    catch (IllegalStateException paramJsonReader)
    {
      for (;;)
      {
        Object localObject2;
        throw new JsonSyntaxException(paramJsonReader);
        ((ReflectiveTypeAdapterFactory.BoundField)localObject2).read(paramJsonReader, localObject1);
      }
    }
    catch (IllegalAccessException paramJsonReader)
    {
      throw new AssertionError(paramJsonReader);
    }
    label103:
    paramJsonReader.endObject();
    return (T)localObject1;
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginObject();
    try
    {
      Iterator localIterator = boundFields.values().iterator();
      while (localIterator.hasNext())
      {
        ReflectiveTypeAdapterFactory.BoundField localBoundField = (ReflectiveTypeAdapterFactory.BoundField)localIterator.next();
        if (serialized)
        {
          paramJsonWriter.name(name);
          localBoundField.write(paramJsonWriter, paramT);
        }
      }
      paramJsonWriter.endObject();
    }
    catch (IllegalAccessException paramJsonWriter)
    {
      throw new AssertionError();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */