package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDeserializer
  extends CollectionDeserializer
{
  private static final long serialVersionUID = 1L;
  
  public ArrayBlockingQueueDeserializer(JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer1, TypeDeserializer paramTypeDeserializer, ValueInstantiator paramValueInstantiator, JsonDeserializer<Object> paramJsonDeserializer2)
  {
    super(paramJavaType, paramJsonDeserializer1, paramTypeDeserializer, paramValueInstantiator, paramJsonDeserializer2);
  }
  
  protected ArrayBlockingQueueDeserializer(ArrayBlockingQueueDeserializer paramArrayBlockingQueueDeserializer)
  {
    super(paramArrayBlockingQueueDeserializer);
  }
  
  public Collection<Object> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return (Collection)_valueInstantiator.createUsingDelegate(paramDeserializationContext, _delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      String str = paramJsonParser.getText();
      if (str.length() == 0) {
        return (Collection)_valueInstantiator.createFromString(paramDeserializationContext, str);
      }
    }
    return deserialize(paramJsonParser, paramDeserializationContext, null);
  }
  
  public Collection<Object> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection<Object> paramCollection)
    throws IOException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext, new ArrayBlockingQueue(1));
    }
    ArrayList localArrayList = new ArrayList();
    JsonDeserializer localJsonDeserializer = _valueDeserializer;
    TypeDeserializer localTypeDeserializer = _valueTypeDeserializer;
    for (;;)
    {
      try
      {
        localObject = paramJsonParser.nextToken();
        if (localObject == JsonToken.END_ARRAY) {
          break;
        }
        if (localObject == JsonToken.VALUE_NULL)
        {
          localObject = localJsonDeserializer.getNullValue(paramDeserializationContext);
          localArrayList.add(localObject);
          continue;
        }
        if (localTypeDeserializer != null) {
          break label114;
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localArrayList, localArrayList.size());
      }
      Object localObject = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      continue;
      label114:
      localObject = localJsonDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
    }
    if (paramCollection != null)
    {
      paramCollection.addAll(localArrayList);
      return paramCollection;
    }
    return new ArrayBlockingQueue(localArrayList.size(), false, localArrayList);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  protected ArrayBlockingQueueDeserializer withResolved(JsonDeserializer<?> paramJsonDeserializer1, JsonDeserializer<?> paramJsonDeserializer2, TypeDeserializer paramTypeDeserializer)
  {
    if ((paramJsonDeserializer1 == _delegateDeserializer) && (paramJsonDeserializer2 == _valueDeserializer) && (paramTypeDeserializer == _valueTypeDeserializer)) {
      return this;
    }
    return new ArrayBlockingQueueDeserializer(_collectionType, paramJsonDeserializer2, paramTypeDeserializer, _valueInstantiator, paramJsonDeserializer1);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */