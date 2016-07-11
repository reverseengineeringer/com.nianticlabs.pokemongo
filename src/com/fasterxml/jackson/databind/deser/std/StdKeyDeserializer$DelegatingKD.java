package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.IOException;
import java.io.Serializable;

final class StdKeyDeserializer$DelegatingKD
  extends KeyDeserializer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final JsonDeserializer<?> _delegate;
  protected final Class<?> _keyClass;
  
  protected StdKeyDeserializer$DelegatingKD(Class<?> paramClass, JsonDeserializer<?> paramJsonDeserializer)
  {
    _keyClass = paramClass;
    _delegate = paramJsonDeserializer;
  }
  
  public final Object deserializeKey(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = _delegate.deserialize(paramDeserializationContext.getParser(), paramDeserializationContext);
        localObject1 = localObject2;
        if (localObject2 != null) {
          continue;
        }
        throw paramDeserializationContext.weirdKeyException(_keyClass, paramString, "not a valid representation");
      }
      catch (Exception localException)
      {
        throw paramDeserializationContext.weirdKeyException(_keyClass, paramString, "not a valid representation: " + localException.getMessage());
      }
    }
  }
  
  public Class<?> getKeyClass()
  {
    return _keyClass;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.DelegatingKD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */