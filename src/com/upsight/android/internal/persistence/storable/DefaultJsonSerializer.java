package com.upsight.android.internal.persistence.storable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightException;
import com.upsight.android.persistence.UpsightStorableSerializer;
import java.io.IOException;

public class DefaultJsonSerializer<T>
  implements UpsightStorableSerializer<T>
{
  private final Class<T> mClass;
  private final ObjectMapper mObjectMapper;
  
  public DefaultJsonSerializer(ObjectMapper paramObjectMapper, Class<T> paramClass)
  {
    mObjectMapper = paramObjectMapper;
    mClass = paramClass;
  }
  
  public T fromString(String paramString)
    throws UpsightException
  {
    try
    {
      paramString = mObjectMapper.treeToValue(mObjectMapper.readTree(paramString), mClass);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UpsightException(paramString);
    }
  }
  
  public String toString(T paramT)
  {
    return mObjectMapper.valueToTree(paramT).toString();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.DefaultJsonSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */