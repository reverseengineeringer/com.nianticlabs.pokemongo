package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@JacksonStdImpl
public class UntypedObjectDeserializer$Vanilla
  extends StdDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  public static final Vanilla std = new Vanilla();
  
  public UntypedObjectDeserializer$Vanilla()
  {
    super(Object.class);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 2: 
    case 4: 
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case 1: 
      if (paramJsonParser.nextToken() == JsonToken.END_OBJECT) {
        return new LinkedHashMap(2);
      }
    case 5: 
      return mapObject(paramJsonParser, paramDeserializationContext);
    case 3: 
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
      {
        if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
          return UntypedObjectDeserializer.NO_OBJECTS;
        }
        return new ArrayList(2);
      }
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
        return mapArrayToArray(paramJsonParser, paramDeserializationContext);
      }
      return mapArray(paramJsonParser, paramDeserializationContext);
    case 12: 
      return paramJsonParser.getEmbeddedObject();
    case 6: 
      return paramJsonParser.getText();
    case 7: 
      if (paramDeserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
        return _coerceIntegral(paramJsonParser, paramDeserializationContext);
      }
      return paramJsonParser.getNumberValue();
    case 8: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
    case 9: 
      return Boolean.TRUE;
    case 10: 
      return Boolean.FALSE;
    }
    return null;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 2: 
    case 4: 
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case 1: 
    case 3: 
    case 5: 
      return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    case 6: 
      return paramJsonParser.getText();
    case 7: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
        return paramJsonParser.getBigIntegerValue();
      }
      return paramJsonParser.getNumberValue();
    case 8: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
    case 9: 
      return Boolean.TRUE;
    case 10: 
      return Boolean.FALSE;
    case 12: 
      return paramJsonParser.getEmbeddedObject();
    }
    return null;
  }
  
  protected Object mapArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1 = deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
    {
      paramJsonParser = new ArrayList(2);
      paramJsonParser.add(localObject1);
      return paramJsonParser;
    }
    Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
    {
      paramJsonParser = new ArrayList(2);
      paramJsonParser.add(localObject1);
      paramJsonParser.add(localObject3);
      return paramJsonParser;
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject2 = localObjectBuffer.resetAndStart();
    int j = 0 + 1;
    localObject2[0] = localObject1;
    int i = j + 1;
    localObject2[j] = localObject3;
    j = i;
    for (;;)
    {
      localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
      int k = j + 1;
      j = i;
      localObject1 = localObject2;
      if (i >= localObject2.length)
      {
        localObject1 = localObjectBuffer.appendCompletedChunk((Object[])localObject2);
        j = 0;
      }
      i = j + 1;
      localObject1[j] = localObject3;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
      {
        paramJsonParser = new ArrayList(k);
        localObjectBuffer.completeAndClearBuffer((Object[])localObject1, i, paramJsonParser);
        return paramJsonParser;
      }
      j = k;
      localObject2 = localObject1;
    }
  }
  
  protected Object[] mapArrayToArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject1 = localObjectBuffer.resetAndStart();
    int i = 0;
    for (;;)
    {
      Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
      int j = i;
      Object localObject2 = localObject1;
      if (i >= localObject1.length)
      {
        localObject2 = localObjectBuffer.appendCompletedChunk((Object[])localObject1);
        j = 0;
      }
      i = j + 1;
      localObject2[j] = localObject3;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
        return localObjectBuffer.completeAndClearBuffer((Object[])localObject2, i);
      }
      localObject1 = localObject2;
    }
  }
  
  protected Object mapObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    String str2 = paramJsonParser.getText();
    paramJsonParser.nextToken();
    Object localObject1 = deserialize(paramJsonParser, paramDeserializationContext);
    String str3 = paramJsonParser.nextFieldName();
    if (str3 == null)
    {
      paramJsonParser = new LinkedHashMap(2);
      paramJsonParser.put(str2, localObject1);
      return paramJsonParser;
    }
    paramJsonParser.nextToken();
    Object localObject2 = deserialize(paramJsonParser, paramDeserializationContext);
    String str1 = paramJsonParser.nextFieldName();
    if (str1 == null)
    {
      paramJsonParser = new LinkedHashMap(4);
      paramJsonParser.put(str2, localObject1);
      paramJsonParser.put(str3, localObject2);
      return paramJsonParser;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(str2, localObject1);
    localLinkedHashMap.put(str3, localObject2);
    do
    {
      paramJsonParser.nextToken();
      localLinkedHashMap.put(str1, deserialize(paramJsonParser, paramDeserializationContext));
      str2 = paramJsonParser.nextFieldName();
      str1 = str2;
    } while (str2 != null);
    return localLinkedHashMap;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */