package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ByteBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.FloatBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.IntBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.LongBuilder;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ShortBuilder;
import java.io.IOException;

public abstract class PrimitiveArrayDeserializers<T>
  extends StdDeserializer<T>
{
  protected PrimitiveArrayDeserializers(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public static JsonDeserializer<?> forType(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return IntDeser.instance;
    }
    if (paramClass == Long.TYPE) {
      return LongDeser.instance;
    }
    if (paramClass == Byte.TYPE) {
      return new ByteDeser();
    }
    if (paramClass == Short.TYPE) {
      return new ShortDeser();
    }
    if (paramClass == Float.TYPE) {
      return new FloatDeser();
    }
    if (paramClass == Double.TYPE) {
      return new DoubleDeser();
    }
    if (paramClass == Boolean.TYPE) {
      return new BooleanDeser();
    }
    if (paramClass == Character.TYPE) {
      return new CharDeser();
    }
    throw new IllegalStateException();
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  @JacksonStdImpl
  static final class BooleanDeser
    extends PrimitiveArrayDeserializers<boolean[]>
  {
    private static final long serialVersionUID = 1L;
    
    public BooleanDeser()
    {
      super();
    }
    
    private final boolean[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      return new boolean[] { _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public boolean[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.BooleanBuilder localBooleanBuilder = paramDeserializationContext.getArrayBuilders().getBooleanBuilder();
      Object localObject = (boolean[])localBooleanBuilder.resetAndStart();
      int i = 0;
      for (;;)
      {
        try
        {
          if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
          {
            boolean bool = _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext);
            if (i >= localObject.length)
            {
              boolean[] arrayOfBoolean = (boolean[])localBooleanBuilder.appendCompletedChunk(localObject, i);
              i = 0;
              localObject = arrayOfBoolean;
              int j = i + 1;
              localObject[i] = bool;
              i = j;
            }
          }
          else
          {
            return (boolean[])localBooleanBuilder.completeAndClearBuffer(localObject, i);
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localBooleanBuilder.bufferedSize() + i);
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class ByteDeser
    extends PrimitiveArrayDeserializers<byte[]>
  {
    private static final long serialVersionUID = 1L;
    
    public ByteDeser()
    {
      super();
    }
    
    private final byte[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {}
      for (int i = paramJsonParser.getByteValue();; i = 0)
      {
        return new byte[] { i };
        if (localJsonToken != JsonToken.VALUE_NULL) {
          throw paramDeserializationContext.mappingException(_valueClass.getComponentType());
        }
      }
    }
    
    public byte[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      Object localObject1 = paramJsonParser.getCurrentToken();
      if (localObject1 == JsonToken.VALUE_STRING) {
        return paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
      }
      if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        localObject1 = paramJsonParser.getEmbeddedObject();
        if (localObject1 == null) {
          return null;
        }
        if ((localObject1 instanceof byte[])) {
          return (byte[])localObject1;
        }
      }
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.ByteBuilder localByteBuilder = paramDeserializationContext.getArrayBuilders().getByteBuilder();
      localObject1 = (byte[])localByteBuilder.resetAndStart();
      int j = 0;
      label216:
      label221:
      label234:
      for (;;)
      {
        try
        {
          Object localObject2 = paramJsonParser.nextToken();
          if (localObject2 == JsonToken.END_ARRAY) {
            break label221;
          }
          if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT))
          {
            i = paramJsonParser.getByteValue();
            if (j < localObject1.length) {
              break label234;
            }
            localObject2 = (byte[])localByteBuilder.appendCompletedChunk(localObject1, j);
            j = 0;
            localObject1 = localObject2;
            int k = j + 1;
            localObject1[j] = i;
            j = k;
            continue;
          }
          if (localObject2 == JsonToken.VALUE_NULL) {
            break label216;
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject1, localByteBuilder.bufferedSize() + j);
        }
        throw paramDeserializationContext.mappingException(_valueClass.getComponentType());
        int i = 0;
        continue;
        return (byte[])localByteBuilder.completeAndClearBuffer(localObject1, j);
      }
    }
  }
  
  @JacksonStdImpl
  static final class CharDeser
    extends PrimitiveArrayDeserializers<char[]>
  {
    private static final long serialVersionUID = 1L;
    
    public CharDeser()
    {
      super();
    }
    
    public char[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      Object localObject1 = paramJsonParser.getCurrentToken();
      if (localObject1 == JsonToken.VALUE_STRING)
      {
        paramDeserializationContext = paramJsonParser.getTextCharacters();
        int i = paramJsonParser.getTextOffset();
        int j = paramJsonParser.getTextLength();
        paramJsonParser = new char[j];
        System.arraycopy(paramDeserializationContext, i, paramJsonParser, 0, j);
        return paramJsonParser;
      }
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        localObject1 = new StringBuilder(64);
        for (;;)
        {
          Object localObject2 = paramJsonParser.nextToken();
          if (localObject2 == JsonToken.END_ARRAY) {
            break;
          }
          if (localObject2 != JsonToken.VALUE_STRING) {
            throw paramDeserializationContext.mappingException(Character.TYPE);
          }
          localObject2 = paramJsonParser.getText();
          if (((String)localObject2).length() != 1) {
            throw JsonMappingException.from(paramJsonParser, "Can not convert a JSON String of length " + ((String)localObject2).length() + " into a char element of char array");
          }
          ((StringBuilder)localObject1).append(((String)localObject2).charAt(0));
        }
        return ((StringBuilder)localObject1).toString().toCharArray();
      }
      if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        paramJsonParser = paramJsonParser.getEmbeddedObject();
        if (paramJsonParser == null) {
          return null;
        }
        if ((paramJsonParser instanceof char[])) {
          return (char[])paramJsonParser;
        }
        if ((paramJsonParser instanceof String)) {
          return ((String)paramJsonParser).toCharArray();
        }
        if ((paramJsonParser instanceof byte[])) {
          return Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false).toCharArray();
        }
      }
      throw paramDeserializationContext.mappingException(_valueClass);
    }
  }
  
  @JacksonStdImpl
  static final class DoubleDeser
    extends PrimitiveArrayDeserializers<double[]>
  {
    private static final long serialVersionUID = 1L;
    
    public DoubleDeser()
    {
      super();
    }
    
    private final double[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      return new double[] { _parseDoublePrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public double[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.DoubleBuilder localDoubleBuilder = paramDeserializationContext.getArrayBuilders().getDoubleBuilder();
      Object localObject = (double[])localDoubleBuilder.resetAndStart();
      int i = 0;
      for (;;)
      {
        try
        {
          if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
          {
            double d = _parseDoublePrimitive(paramJsonParser, paramDeserializationContext);
            if (i >= localObject.length)
            {
              double[] arrayOfDouble = (double[])localDoubleBuilder.appendCompletedChunk(localObject, i);
              i = 0;
              localObject = arrayOfDouble;
              int j = i + 1;
              localObject[i] = d;
              i = j;
            }
          }
          else
          {
            return (double[])localDoubleBuilder.completeAndClearBuffer(localObject, i);
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localDoubleBuilder.bufferedSize() + i);
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class FloatDeser
    extends PrimitiveArrayDeserializers<float[]>
  {
    private static final long serialVersionUID = 1L;
    
    public FloatDeser()
    {
      super();
    }
    
    private final float[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      return new float[] { _parseFloatPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public float[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.FloatBuilder localFloatBuilder = paramDeserializationContext.getArrayBuilders().getFloatBuilder();
      Object localObject = (float[])localFloatBuilder.resetAndStart();
      int i = 0;
      for (;;)
      {
        try
        {
          if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
          {
            float f = _parseFloatPrimitive(paramJsonParser, paramDeserializationContext);
            if (i >= localObject.length)
            {
              float[] arrayOfFloat = (float[])localFloatBuilder.appendCompletedChunk(localObject, i);
              i = 0;
              localObject = arrayOfFloat;
              int j = i + 1;
              localObject[i] = f;
              i = j;
            }
          }
          else
          {
            return (float[])localFloatBuilder.completeAndClearBuffer(localObject, i);
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localFloatBuilder.bufferedSize() + i);
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class IntDeser
    extends PrimitiveArrayDeserializers<int[]>
  {
    public static final IntDeser instance = new IntDeser();
    private static final long serialVersionUID = 1L;
    
    public IntDeser()
    {
      super();
    }
    
    private final int[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      return new int[] { _parseIntPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public int[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.IntBuilder localIntBuilder = paramDeserializationContext.getArrayBuilders().getIntBuilder();
      Object localObject = (int[])localIntBuilder.resetAndStart();
      int i = 0;
      for (;;)
      {
        try
        {
          if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
          {
            int k = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
            if (i >= localObject.length)
            {
              int[] arrayOfInt = (int[])localIntBuilder.appendCompletedChunk(localObject, i);
              i = 0;
              localObject = arrayOfInt;
              int j = i + 1;
              localObject[i] = k;
              i = j;
            }
          }
          else
          {
            return (int[])localIntBuilder.completeAndClearBuffer(localObject, i);
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localIntBuilder.bufferedSize() + i);
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class LongDeser
    extends PrimitiveArrayDeserializers<long[]>
  {
    public static final LongDeser instance = new LongDeser();
    private static final long serialVersionUID = 1L;
    
    public LongDeser()
    {
      super();
    }
    
    private final long[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      return new long[] { _parseLongPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public long[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.LongBuilder localLongBuilder = paramDeserializationContext.getArrayBuilders().getLongBuilder();
      Object localObject = (long[])localLongBuilder.resetAndStart();
      int i = 0;
      for (;;)
      {
        try
        {
          if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
          {
            long l = _parseLongPrimitive(paramJsonParser, paramDeserializationContext);
            if (i >= localObject.length)
            {
              long[] arrayOfLong = (long[])localLongBuilder.appendCompletedChunk(localObject, i);
              i = 0;
              localObject = arrayOfLong;
              int j = i + 1;
              localObject[i] = l;
              i = j;
            }
          }
          else
          {
            return (long[])localLongBuilder.completeAndClearBuffer(localObject, i);
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localLongBuilder.bufferedSize() + i);
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class ShortDeser
    extends PrimitiveArrayDeserializers<short[]>
  {
    private static final long serialVersionUID = 1L;
    
    public ShortDeser()
    {
      super();
    }
    
    private final short[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(_valueClass);
      }
      return new short[] { _parseShortPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public short[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        return handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      ArrayBuilders.ShortBuilder localShortBuilder = paramDeserializationContext.getArrayBuilders().getShortBuilder();
      Object localObject = (short[])localShortBuilder.resetAndStart();
      int j = 0;
      for (;;)
      {
        try
        {
          if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
          {
            int i = _parseShortPrimitive(paramJsonParser, paramDeserializationContext);
            if (j >= localObject.length)
            {
              short[] arrayOfShort = (short[])localShortBuilder.appendCompletedChunk(localObject, j);
              j = 0;
              localObject = arrayOfShort;
              int k = j + 1;
              localObject[j] = i;
              j = k;
            }
          }
          else
          {
            return (short[])localShortBuilder.completeAndClearBuffer(localObject, j);
          }
        }
        catch (Exception paramJsonParser)
        {
          throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localShortBuilder.bufferedSize() + j);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */