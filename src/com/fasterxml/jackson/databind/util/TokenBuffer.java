package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

public class TokenBuffer
  extends JsonGenerator
{
  protected static final int DEFAULT_GENERATOR_FEATURES = ;
  protected int _appendAt;
  protected boolean _closed;
  protected Segment _first;
  protected boolean _forceBigDecimal;
  protected int _generatorFeatures;
  protected boolean _hasNativeId = false;
  protected boolean _hasNativeObjectIds;
  protected boolean _hasNativeTypeIds;
  protected Segment _last;
  protected boolean _mayHaveNativeIds;
  protected ObjectCodec _objectCodec;
  protected Object _objectId;
  protected Object _typeId;
  protected JsonWriteContext _writeContext;
  
  public TokenBuffer(JsonParser paramJsonParser)
  {
    this(paramJsonParser, null);
  }
  
  public TokenBuffer(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    _objectCodec = paramJsonParser.getCodec();
    _generatorFeatures = DEFAULT_GENERATOR_FEATURES;
    _writeContext = JsonWriteContext.createRootContext(null);
    Segment localSegment = new Segment();
    _last = localSegment;
    _first = localSegment;
    _appendAt = 0;
    _hasNativeTypeIds = paramJsonParser.canReadTypeId();
    _hasNativeObjectIds = paramJsonParser.canReadObjectId();
    _mayHaveNativeIds = (_hasNativeTypeIds | _hasNativeObjectIds);
    if (paramDeserializationContext == null) {}
    for (;;)
    {
      _forceBigDecimal = bool;
      return;
      bool = paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    }
  }
  
  @Deprecated
  public TokenBuffer(ObjectCodec paramObjectCodec)
  {
    this(paramObjectCodec, false);
  }
  
  public TokenBuffer(ObjectCodec paramObjectCodec, boolean paramBoolean)
  {
    _objectCodec = paramObjectCodec;
    _generatorFeatures = DEFAULT_GENERATOR_FEATURES;
    _writeContext = JsonWriteContext.createRootContext(null);
    paramObjectCodec = new Segment();
    _last = paramObjectCodec;
    _first = paramObjectCodec;
    _appendAt = 0;
    _hasNativeTypeIds = paramBoolean;
    _hasNativeObjectIds = paramBoolean;
    _mayHaveNativeIds = (_hasNativeTypeIds | _hasNativeObjectIds);
  }
  
  private final void _appendNativeIds(StringBuilder paramStringBuilder)
  {
    Object localObject = _last.findObjectId(_appendAt - 1);
    if (localObject != null) {
      paramStringBuilder.append("[objectId=").append(String.valueOf(localObject)).append(']');
    }
    localObject = _last.findTypeId(_appendAt - 1);
    if (localObject != null) {
      paramStringBuilder.append("[typeId=").append(String.valueOf(localObject)).append(']');
    }
  }
  
  private final void _checkNativeIds(JsonParser paramJsonParser)
    throws IOException
  {
    Object localObject = paramJsonParser.getTypeId();
    _typeId = localObject;
    if (localObject != null) {
      _hasNativeId = true;
    }
    paramJsonParser = paramJsonParser.getObjectId();
    _objectId = paramJsonParser;
    if (paramJsonParser != null) {
      _hasNativeId = true;
    }
  }
  
  protected final void _append(JsonToken paramJsonToken)
  {
    if (_hasNativeId) {}
    for (paramJsonToken = _last.append(_appendAt, paramJsonToken, _objectId, _typeId); paramJsonToken == null; paramJsonToken = _last.append(_appendAt, paramJsonToken))
    {
      _appendAt += 1;
      return;
    }
    _last = paramJsonToken;
    _appendAt = 1;
  }
  
  protected final void _append(JsonToken paramJsonToken, Object paramObject)
  {
    if (_hasNativeId) {}
    for (paramJsonToken = _last.append(_appendAt, paramJsonToken, paramObject, _objectId, _typeId); paramJsonToken == null; paramJsonToken = _last.append(_appendAt, paramJsonToken, paramObject))
    {
      _appendAt += 1;
      return;
    }
    _last = paramJsonToken;
    _appendAt = 1;
  }
  
  protected final void _appendRaw(int paramInt, Object paramObject)
  {
    if (_hasNativeId) {}
    for (paramObject = _last.appendRaw(_appendAt, paramInt, paramObject, _objectId, _typeId); paramObject == null; paramObject = _last.appendRaw(_appendAt, paramInt, paramObject))
    {
      _appendAt += 1;
      return;
    }
    _last = ((Segment)paramObject);
    _appendAt = 1;
  }
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
  }
  
  public TokenBuffer append(TokenBuffer paramTokenBuffer)
    throws IOException
  {
    if (!_hasNativeTypeIds) {
      _hasNativeTypeIds = paramTokenBuffer.canWriteTypeId();
    }
    if (!_hasNativeObjectIds) {
      _hasNativeObjectIds = paramTokenBuffer.canWriteObjectId();
    }
    _mayHaveNativeIds = (_hasNativeTypeIds | _hasNativeObjectIds);
    paramTokenBuffer = paramTokenBuffer.asParser();
    while (paramTokenBuffer.nextToken() != null) {
      copyCurrentStructure(paramTokenBuffer);
    }
    return this;
  }
  
  public JsonParser asParser()
  {
    return asParser(_objectCodec);
  }
  
  public JsonParser asParser(JsonParser paramJsonParser)
  {
    Parser localParser = new Parser(_first, paramJsonParser.getCodec(), _hasNativeTypeIds, _hasNativeObjectIds);
    localParser.setLocation(paramJsonParser.getTokenLocation());
    return localParser;
  }
  
  public JsonParser asParser(ObjectCodec paramObjectCodec)
  {
    return new Parser(_first, paramObjectCodec, _hasNativeTypeIds, _hasNativeObjectIds);
  }
  
  public boolean canWriteBinaryNatively()
  {
    return true;
  }
  
  public boolean canWriteObjectId()
  {
    return _hasNativeObjectIds;
  }
  
  public boolean canWriteTypeId()
  {
    return _hasNativeTypeIds;
  }
  
  public void close()
    throws IOException
  {
    _closed = true;
  }
  
  public void copyCurrentEvent(JsonParser paramJsonParser)
    throws IOException
  {
    if (_mayHaveNativeIds) {
      _checkNativeIds(paramJsonParser);
    }
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    default: 
      throw new RuntimeException("Internal error: should never end up through this code path");
    case 1: 
      writeStartObject();
      return;
    case 2: 
      writeEndObject();
      return;
    case 3: 
      writeStartArray();
      return;
    case 4: 
      writeEndArray();
      return;
    case 5: 
      writeFieldName(paramJsonParser.getCurrentName());
      return;
    case 6: 
      if (paramJsonParser.hasTextCharacters())
      {
        writeString(paramJsonParser.getTextCharacters(), paramJsonParser.getTextOffset(), paramJsonParser.getTextLength());
        return;
      }
      writeString(paramJsonParser.getText());
      return;
    case 7: 
      switch (paramJsonParser.getNumberType())
      {
      default: 
        writeNumber(paramJsonParser.getLongValue());
        return;
      case ???: 
        writeNumber(paramJsonParser.getIntValue());
        return;
      }
      writeNumber(paramJsonParser.getBigIntegerValue());
      return;
    case 8: 
      if (_forceBigDecimal)
      {
        writeNumber(paramJsonParser.getDecimalValue());
        return;
      }
      switch (paramJsonParser.getNumberType())
      {
      default: 
        writeNumber(paramJsonParser.getDoubleValue());
        return;
      case ???: 
        writeNumber(paramJsonParser.getDecimalValue());
        return;
      }
      writeNumber(paramJsonParser.getFloatValue());
      return;
    case 9: 
      writeBoolean(true);
      return;
    case 10: 
      writeBoolean(false);
      return;
    case 11: 
      writeNull();
      return;
    }
    writeObject(paramJsonParser.getEmbeddedObject());
  }
  
  public void copyCurrentStructure(JsonParser paramJsonParser)
    throws IOException
  {
    JsonToken localJsonToken2 = paramJsonParser.getCurrentToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME)
    {
      if (_mayHaveNativeIds) {
        _checkNativeIds(paramJsonParser);
      }
      writeFieldName(paramJsonParser.getCurrentName());
      localJsonToken1 = paramJsonParser.nextToken();
    }
    if (_mayHaveNativeIds) {
      _checkNativeIds(paramJsonParser);
    }
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localJsonToken1.ordinal()])
    {
    case 2: 
    default: 
      copyCurrentEvent(paramJsonParser);
      return;
    case 3: 
      writeStartArray();
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        copyCurrentStructure(paramJsonParser);
      }
      writeEndArray();
      return;
    }
    writeStartObject();
    while (paramJsonParser.nextToken() != JsonToken.END_OBJECT) {
      copyCurrentStructure(paramJsonParser);
    }
    writeEndObject();
  }
  
  public TokenBuffer deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.getCurrentTokenId() != JsonToken.FIELD_NAME.id())
    {
      copyCurrentStructure(paramJsonParser);
      return this;
    }
    writeStartObject();
    JsonToken localJsonToken;
    do
    {
      copyCurrentStructure(paramJsonParser);
      localJsonToken = paramJsonParser.nextToken();
    } while (localJsonToken == JsonToken.FIELD_NAME);
    if (localJsonToken != JsonToken.END_OBJECT) {
      throw paramDeserializationContext.mappingException("Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + localJsonToken);
    }
    writeEndObject();
    return this;
  }
  
  public JsonGenerator disable(JsonGenerator.Feature paramFeature)
  {
    _generatorFeatures &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public JsonGenerator enable(JsonGenerator.Feature paramFeature)
  {
    _generatorFeatures |= paramFeature.getMask();
    return this;
  }
  
  public JsonToken firstToken()
  {
    if (_first != null) {
      return _first.type(0);
    }
    return null;
  }
  
  public void flush()
    throws IOException
  {}
  
  public TokenBuffer forceUseOfBigDecimal(boolean paramBoolean)
  {
    _forceBigDecimal = paramBoolean;
    return this;
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public int getFeatureMask()
  {
    return _generatorFeatures;
  }
  
  public final JsonWriteContext getOutputContext()
  {
    return _writeContext;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    return (_generatorFeatures & paramFeature.getMask()) != 0;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    Object localObject2 = _first;
    int j = -1;
    boolean bool = _mayHaveNativeIds;
    int i;
    if ((bool) && (((Segment)localObject2).hasIds())) {
      i = 1;
    }
    for (;;)
    {
      int k = j + 1;
      j = k;
      Object localObject1 = localObject2;
      if (k >= 16)
      {
        j = 0;
        localObject1 = ((Segment)localObject2).next();
        if (localObject1 == null)
        {
          return;
          i = 0;
          continue;
        }
        if ((!bool) || (!((Segment)localObject1).hasIds())) {
          break label218;
        }
      }
      label218:
      for (i = 1;; i = 0)
      {
        localObject2 = ((Segment)localObject1).type(j);
        if (localObject2 == null) {
          break;
        }
        if (i != 0)
        {
          Object localObject3 = ((Segment)localObject1).findObjectId(j);
          if (localObject3 != null) {
            paramJsonGenerator.writeObjectId(localObject3);
          }
          localObject3 = ((Segment)localObject1).findTypeId(j);
          if (localObject3 != null) {
            paramJsonGenerator.writeTypeId(localObject3);
          }
        }
        switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localObject2.ordinal()])
        {
        default: 
          throw new RuntimeException("Internal error: should never end up through this code path");
        }
      }
      paramJsonGenerator.writeStartObject();
      localObject2 = localObject1;
      continue;
      paramJsonGenerator.writeEndObject();
      localObject2 = localObject1;
      continue;
      paramJsonGenerator.writeStartArray();
      localObject2 = localObject1;
      continue;
      paramJsonGenerator.writeEndArray();
      localObject2 = localObject1;
      continue;
      localObject2 = ((Segment)localObject1).get(j);
      if ((localObject2 instanceof SerializableString))
      {
        paramJsonGenerator.writeFieldName((SerializableString)localObject2);
        localObject2 = localObject1;
      }
      else
      {
        paramJsonGenerator.writeFieldName((String)localObject2);
        localObject2 = localObject1;
        continue;
        localObject2 = ((Segment)localObject1).get(j);
        if ((localObject2 instanceof SerializableString))
        {
          paramJsonGenerator.writeString((SerializableString)localObject2);
          localObject2 = localObject1;
        }
        else
        {
          paramJsonGenerator.writeString((String)localObject2);
          localObject2 = localObject1;
          continue;
          localObject2 = ((Segment)localObject1).get(j);
          if ((localObject2 instanceof Integer))
          {
            paramJsonGenerator.writeNumber(((Integer)localObject2).intValue());
            localObject2 = localObject1;
          }
          else if ((localObject2 instanceof BigInteger))
          {
            paramJsonGenerator.writeNumber((BigInteger)localObject2);
            localObject2 = localObject1;
          }
          else if ((localObject2 instanceof Long))
          {
            paramJsonGenerator.writeNumber(((Long)localObject2).longValue());
            localObject2 = localObject1;
          }
          else if ((localObject2 instanceof Short))
          {
            paramJsonGenerator.writeNumber(((Short)localObject2).shortValue());
            localObject2 = localObject1;
          }
          else
          {
            paramJsonGenerator.writeNumber(((Number)localObject2).intValue());
            localObject2 = localObject1;
            continue;
            localObject2 = ((Segment)localObject1).get(j);
            if ((localObject2 instanceof Double))
            {
              paramJsonGenerator.writeNumber(((Double)localObject2).doubleValue());
              localObject2 = localObject1;
            }
            else if ((localObject2 instanceof BigDecimal))
            {
              paramJsonGenerator.writeNumber((BigDecimal)localObject2);
              localObject2 = localObject1;
            }
            else if ((localObject2 instanceof Float))
            {
              paramJsonGenerator.writeNumber(((Float)localObject2).floatValue());
              localObject2 = localObject1;
            }
            else if (localObject2 == null)
            {
              paramJsonGenerator.writeNull();
              localObject2 = localObject1;
            }
            else if ((localObject2 instanceof String))
            {
              paramJsonGenerator.writeNumber((String)localObject2);
              localObject2 = localObject1;
            }
            else
            {
              throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + localObject2.getClass().getName() + ", can not serialize");
              paramJsonGenerator.writeBoolean(true);
              localObject2 = localObject1;
              continue;
              paramJsonGenerator.writeBoolean(false);
              localObject2 = localObject1;
              continue;
              paramJsonGenerator.writeNull();
              localObject2 = localObject1;
              continue;
              localObject2 = ((Segment)localObject1).get(j);
              if ((localObject2 instanceof RawValue))
              {
                ((RawValue)localObject2).serialize(paramJsonGenerator);
                localObject2 = localObject1;
              }
              else
              {
                paramJsonGenerator.writeObject(localObject2);
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
  }
  
  public JsonGenerator setCodec(ObjectCodec paramObjectCodec)
  {
    _objectCodec = paramObjectCodec;
    return this;
  }
  
  public JsonGenerator setFeatureMask(int paramInt)
  {
    _generatorFeatures = paramInt;
    return this;
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: new 121	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 511
    //   12: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 197	com/fasterxml/jackson/databind/util/TokenBuffer:asParser	()Lcom/fasterxml/jackson/core/JsonParser;
    //   20: astore 4
    //   22: iconst_0
    //   23: istore_2
    //   24: aload_0
    //   25: getfield 84	com/fasterxml/jackson/databind/util/TokenBuffer:_hasNativeTypeIds	Z
    //   28: ifne +10 -> 38
    //   31: aload_0
    //   32: getfield 89	com/fasterxml/jackson/databind/util/TokenBuffer:_hasNativeObjectIds	Z
    //   35: ifeq +56 -> 91
    //   38: iconst_1
    //   39: istore_1
    //   40: aload 4
    //   42: invokevirtual 201	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnonnull +47 -> 96
    //   52: iload_2
    //   53: bipush 100
    //   55: if_icmplt +24 -> 79
    //   58: aload_3
    //   59: ldc_w 513
    //   62: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_2
    //   66: bipush 100
    //   68: isub
    //   69: invokevirtual 516	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc_w 518
    //   75: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: bipush 93
    //   82: invokevirtual 134	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: areturn
    //   91: iconst_0
    //   92: istore_1
    //   93: goto -53 -> 40
    //   96: iload_1
    //   97: ifeq +8 -> 105
    //   100: aload_0
    //   101: aload_3
    //   102: invokespecial 520	com/fasterxml/jackson/databind/util/TokenBuffer:_appendNativeIds	(Ljava/lang/StringBuilder;)V
    //   105: iload_2
    //   106: bipush 100
    //   108: if_icmpge +57 -> 165
    //   111: iload_2
    //   112: ifle +11 -> 123
    //   115: aload_3
    //   116: ldc_w 522
    //   119: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: aload 5
    //   126: invokevirtual 523	com/fasterxml/jackson/core/JsonToken:toString	()Ljava/lang/String;
    //   129: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: getstatic 354	com/fasterxml/jackson/core/JsonToken:FIELD_NAME	Lcom/fasterxml/jackson/core/JsonToken;
    //   138: if_acmpne +27 -> 165
    //   141: aload_3
    //   142: bipush 40
    //   144: invokevirtual 134	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: aload 4
    //   151: invokevirtual 259	com/fasterxml/jackson/core/JsonParser:getCurrentName	()Ljava/lang/String;
    //   154: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_3
    //   159: bipush 41
    //   161: invokevirtual 134	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: iload_2
    //   166: iconst_1
    //   167: iadd
    //   168: istore_2
    //   169: goto -129 -> 40
    //   172: astore_3
    //   173: new 525	java/lang/IllegalStateException
    //   176: dup
    //   177: aload_3
    //   178: invokespecial 528	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	TokenBuffer
    //   39	58	1	i	int
    //   23	146	2	j	int
    //   7	152	3	localStringBuilder	StringBuilder
    //   172	6	3	localIOException	IOException
    //   20	130	4	localJsonParser	JsonParser
    //   45	89	5	localJsonToken	JsonToken
    // Exception table:
    //   from	to	target	type
    //   40	47	172	java/io/IOException
    //   100	105	172	java/io/IOException
    //   115	123	172	java/io/IOException
    //   123	165	172	java/io/IOException
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    return this;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramBase64Variant = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, paramBase64Variant, 0, paramInt2);
    writeObject(paramBase64Variant);
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (JsonToken localJsonToken = JsonToken.VALUE_TRUE;; localJsonToken = JsonToken.VALUE_FALSE)
    {
      _append(localJsonToken);
      return;
    }
  }
  
  public final void writeEndArray()
    throws IOException
  {
    _append(JsonToken.END_ARRAY);
    JsonWriteContext localJsonWriteContext = _writeContext.getParent();
    if (localJsonWriteContext != null) {
      _writeContext = localJsonWriteContext;
    }
  }
  
  public final void writeEndObject()
    throws IOException
  {
    _append(JsonToken.END_OBJECT);
    JsonWriteContext localJsonWriteContext = _writeContext.getParent();
    if (localJsonWriteContext != null) {
      _writeContext = localJsonWriteContext;
    }
  }
  
  public void writeFieldName(SerializableString paramSerializableString)
    throws IOException
  {
    _append(JsonToken.FIELD_NAME, paramSerializableString);
    _writeContext.writeFieldName(paramSerializableString.getValue());
  }
  
  public final void writeFieldName(String paramString)
    throws IOException
  {
    _append(JsonToken.FIELD_NAME, paramString);
    _writeContext.writeFieldName(paramString);
  }
  
  public void writeNull()
    throws IOException
  {
    _append(JsonToken.VALUE_NULL);
  }
  
  public void writeNumber(double paramDouble)
    throws IOException
  {
    _append(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(paramDouble));
  }
  
  public void writeNumber(float paramFloat)
    throws IOException
  {
    _append(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(paramFloat));
  }
  
  public void writeNumber(int paramInt)
    throws IOException
  {
    _append(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(paramInt));
  }
  
  public void writeNumber(long paramLong)
    throws IOException
  {
    _append(JsonToken.VALUE_NUMBER_INT, Long.valueOf(paramLong));
  }
  
  public void writeNumber(String paramString)
    throws IOException
  {
    _append(JsonToken.VALUE_NUMBER_FLOAT, paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException
  {
    if (paramBigDecimal == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_NUMBER_FLOAT, paramBigDecimal);
  }
  
  public void writeNumber(BigInteger paramBigInteger)
    throws IOException
  {
    if (paramBigInteger == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_NUMBER_INT, paramBigInteger);
  }
  
  public void writeNumber(short paramShort)
    throws IOException
  {
    _append(JsonToken.VALUE_NUMBER_INT, Short.valueOf(paramShort));
  }
  
  public void writeObject(Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      writeNull();
      return;
    }
    if ((paramObject.getClass() == byte[].class) || ((paramObject instanceof RawValue)))
    {
      _append(JsonToken.VALUE_EMBEDDED_OBJECT, paramObject);
      return;
    }
    if (_objectCodec == null)
    {
      _append(JsonToken.VALUE_EMBEDDED_OBJECT, paramObject);
      return;
    }
    _objectCodec.writeValue(this, paramObject);
  }
  
  public void writeObjectId(Object paramObject)
  {
    _objectId = paramObject;
    _hasNativeId = true;
  }
  
  public void writeRaw(char paramChar)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(SerializableString paramSerializableString)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String paramString)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawValue(String paramString)
    throws IOException
  {
    _append(JsonToken.VALUE_EMBEDDED_OBJECT, new RawValue(paramString));
  }
  
  public void writeRawValue(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    String str;
    if (paramInt1 <= 0)
    {
      str = paramString;
      if (paramInt2 == paramString.length()) {}
    }
    else
    {
      str = paramString.substring(paramInt1, paramInt1 + paramInt2);
    }
    _append(JsonToken.VALUE_EMBEDDED_OBJECT, new RawValue(str));
  }
  
  public void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    _append(JsonToken.VALUE_EMBEDDED_OBJECT, new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public final void writeStartArray()
    throws IOException
  {
    _append(JsonToken.START_ARRAY);
    _writeContext = _writeContext.createChildArrayContext();
  }
  
  public final void writeStartObject()
    throws IOException
  {
    _append(JsonToken.START_OBJECT);
    _writeContext = _writeContext.createChildObjectContext();
  }
  
  public void writeString(SerializableString paramSerializableString)
    throws IOException
  {
    if (paramSerializableString == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_STRING, paramSerializableString);
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    if (paramString == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_STRING, paramString);
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    writeString(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public void writeTree(TreeNode paramTreeNode)
    throws IOException
  {
    if (paramTreeNode == null)
    {
      writeNull();
      return;
    }
    if (_objectCodec == null)
    {
      _append(JsonToken.VALUE_EMBEDDED_OBJECT, paramTreeNode);
      return;
    }
    _objectCodec.writeTree(this, paramTreeNode);
  }
  
  public void writeTypeId(Object paramObject)
  {
    _typeId = paramObject;
    _hasNativeId = true;
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  protected static final class Parser
    extends ParserMinimalBase
  {
    protected transient ByteArrayBuilder _byteBuilder;
    protected boolean _closed;
    protected ObjectCodec _codec;
    protected final boolean _hasNativeIds;
    protected final boolean _hasNativeObjectIds;
    protected final boolean _hasNativeTypeIds;
    protected JsonLocation _location = null;
    protected JsonReadContext _parsingContext;
    protected TokenBuffer.Segment _segment;
    protected int _segmentPtr;
    
    public Parser(TokenBuffer.Segment paramSegment, ObjectCodec paramObjectCodec, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      _segment = paramSegment;
      _segmentPtr = -1;
      _codec = paramObjectCodec;
      _parsingContext = JsonReadContext.createRootContext(null);
      _hasNativeTypeIds = paramBoolean1;
      _hasNativeObjectIds = paramBoolean2;
      _hasNativeIds = (paramBoolean1 | paramBoolean2);
    }
    
    protected final void _checkIsNumber()
      throws JsonParseException
    {
      if ((_currToken == null) || (!_currToken.isNumeric())) {
        throw _constructError("Current token (" + _currToken + ") not numeric, can not use numeric value accessors");
      }
    }
    
    protected final Object _currentObject()
    {
      return _segment.get(_segmentPtr);
    }
    
    protected void _handleEOF()
      throws JsonParseException
    {
      _throwInternal();
    }
    
    public boolean canReadObjectId()
    {
      return _hasNativeObjectIds;
    }
    
    public boolean canReadTypeId()
    {
      return _hasNativeTypeIds;
    }
    
    public void close()
      throws IOException
    {
      if (!_closed) {
        _closed = true;
      }
    }
    
    public BigInteger getBigIntegerValue()
      throws IOException
    {
      Number localNumber = getNumberValue();
      if ((localNumber instanceof BigInteger)) {
        return (BigInteger)localNumber;
      }
      if (getNumberType() == JsonParser.NumberType.BIG_DECIMAL) {
        return ((BigDecimal)localNumber).toBigInteger();
      }
      return BigInteger.valueOf(localNumber.longValue());
    }
    
    public byte[] getBinaryValue(Base64Variant paramBase64Variant)
      throws IOException, JsonParseException
    {
      if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        localObject = _currentObject();
        if ((localObject instanceof byte[])) {
          return (byte[])localObject;
        }
      }
      if (_currToken != JsonToken.VALUE_STRING) {
        throw _constructError("Current token (" + _currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
      }
      String str = getText();
      if (str == null) {
        return null;
      }
      Object localObject = _byteBuilder;
      if (localObject == null)
      {
        localObject = new ByteArrayBuilder(100);
        _byteBuilder = ((ByteArrayBuilder)localObject);
      }
      for (;;)
      {
        _decodeBase64(str, (ByteArrayBuilder)localObject, paramBase64Variant);
        return ((ByteArrayBuilder)localObject).toByteArray();
        _byteBuilder.reset();
      }
    }
    
    public ObjectCodec getCodec()
    {
      return _codec;
    }
    
    public JsonLocation getCurrentLocation()
    {
      if (_location == null) {
        return JsonLocation.NA;
      }
      return _location;
    }
    
    public String getCurrentName()
    {
      if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
        return _parsingContext.getParent().getCurrentName();
      }
      return _parsingContext.getCurrentName();
    }
    
    public BigDecimal getDecimalValue()
      throws IOException
    {
      Number localNumber = getNumberValue();
      if ((localNumber instanceof BigDecimal)) {
        return (BigDecimal)localNumber;
      }
      switch (TokenBuffer.1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[getNumberType().ordinal()])
      {
      case 3: 
      case 4: 
      default: 
        return BigDecimal.valueOf(localNumber.doubleValue());
      case 1: 
      case 5: 
        return BigDecimal.valueOf(localNumber.longValue());
      }
      return new BigDecimal((BigInteger)localNumber);
    }
    
    public double getDoubleValue()
      throws IOException
    {
      return getNumberValue().doubleValue();
    }
    
    public Object getEmbeddedObject()
    {
      if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
        return _currentObject();
      }
      return null;
    }
    
    public float getFloatValue()
      throws IOException
    {
      return getNumberValue().floatValue();
    }
    
    public int getIntValue()
      throws IOException
    {
      if (_currToken == JsonToken.VALUE_NUMBER_INT) {
        return ((Number)_currentObject()).intValue();
      }
      return getNumberValue().intValue();
    }
    
    public long getLongValue()
      throws IOException
    {
      return getNumberValue().longValue();
    }
    
    public JsonParser.NumberType getNumberType()
      throws IOException
    {
      Number localNumber = getNumberValue();
      if ((localNumber instanceof Integer)) {
        return JsonParser.NumberType.INT;
      }
      if ((localNumber instanceof Long)) {
        return JsonParser.NumberType.LONG;
      }
      if ((localNumber instanceof Double)) {
        return JsonParser.NumberType.DOUBLE;
      }
      if ((localNumber instanceof BigDecimal)) {
        return JsonParser.NumberType.BIG_DECIMAL;
      }
      if ((localNumber instanceof BigInteger)) {
        return JsonParser.NumberType.BIG_INTEGER;
      }
      if ((localNumber instanceof Float)) {
        return JsonParser.NumberType.FLOAT;
      }
      if ((localNumber instanceof Short)) {
        return JsonParser.NumberType.INT;
      }
      return null;
    }
    
    public final Number getNumberValue()
      throws IOException
    {
      _checkIsNumber();
      Object localObject = _currentObject();
      if ((localObject instanceof Number)) {
        return (Number)localObject;
      }
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        if (((String)localObject).indexOf('.') >= 0) {
          return Double.valueOf(Double.parseDouble((String)localObject));
        }
        return Long.valueOf(Long.parseLong((String)localObject));
      }
      if (localObject == null) {
        return null;
      }
      throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + localObject.getClass().getName());
    }
    
    public Object getObjectId()
    {
      return _segment.findObjectId(_segmentPtr);
    }
    
    public JsonStreamContext getParsingContext()
    {
      return _parsingContext;
    }
    
    public String getText()
    {
      Object localObject2 = null;
      Object localObject3;
      Object localObject1;
      if ((_currToken == JsonToken.VALUE_STRING) || (_currToken == JsonToken.FIELD_NAME))
      {
        localObject3 = _currentObject();
        if ((localObject3 instanceof String)) {
          localObject1 = (String)localObject3;
        }
      }
      do
      {
        do
        {
          do
          {
            return (String)localObject1;
            localObject1 = localObject2;
          } while (localObject3 == null);
          return localObject3.toString();
          localObject1 = localObject2;
        } while (_currToken == null);
        switch (TokenBuffer.1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[_currToken.ordinal()])
        {
        default: 
          return _currToken.asString();
        }
        localObject3 = _currentObject();
        localObject1 = localObject2;
      } while (localObject3 == null);
      return localObject3.toString();
    }
    
    public char[] getTextCharacters()
    {
      String str = getText();
      if (str == null) {
        return null;
      }
      return str.toCharArray();
    }
    
    public int getTextLength()
    {
      String str = getText();
      if (str == null) {
        return 0;
      }
      return str.length();
    }
    
    public int getTextOffset()
    {
      return 0;
    }
    
    public JsonLocation getTokenLocation()
    {
      return getCurrentLocation();
    }
    
    public Object getTypeId()
    {
      return _segment.findTypeId(_segmentPtr);
    }
    
    public boolean hasTextCharacters()
    {
      return false;
    }
    
    public boolean isClosed()
    {
      return _closed;
    }
    
    public String nextFieldName()
      throws IOException
    {
      if ((_closed) || (_segment == null)) {}
      do
      {
        return null;
        int i = _segmentPtr + 1;
        if ((i < 16) && (_segment.type(i) == JsonToken.FIELD_NAME))
        {
          _segmentPtr = i;
          Object localObject = _segment.get(i);
          if ((localObject instanceof String)) {}
          for (localObject = (String)localObject;; localObject = localObject.toString())
          {
            _parsingContext.setCurrentName((String)localObject);
            return (String)localObject;
          }
        }
      } while (nextToken() != JsonToken.FIELD_NAME);
      return getCurrentName();
    }
    
    public JsonToken nextToken()
      throws IOException
    {
      if ((_closed) || (_segment == null)) {}
      do
      {
        return null;
        int i = _segmentPtr + 1;
        _segmentPtr = i;
        if (i < 16) {
          break;
        }
        _segmentPtr = 0;
        _segment = _segment.next();
      } while (_segment == null);
      _currToken = _segment.type(_segmentPtr);
      Object localObject;
      if (_currToken == JsonToken.FIELD_NAME)
      {
        localObject = _currentObject();
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          _parsingContext.setCurrentName((String)localObject);
        }
      }
      for (;;)
      {
        return _currToken;
        localObject = localObject.toString();
        break;
        if (_currToken == JsonToken.START_OBJECT)
        {
          _parsingContext = _parsingContext.createChildObjectContext(-1, -1);
        }
        else if (_currToken == JsonToken.START_ARRAY)
        {
          _parsingContext = _parsingContext.createChildArrayContext(-1, -1);
        }
        else if ((_currToken == JsonToken.END_OBJECT) || (_currToken == JsonToken.END_ARRAY))
        {
          _parsingContext = _parsingContext.getParent();
          if (_parsingContext == null) {
            _parsingContext = JsonReadContext.createRootContext(null);
          }
        }
      }
    }
    
    public void overrideCurrentName(String paramString)
    {
      JsonReadContext localJsonReadContext2 = _parsingContext;
      JsonReadContext localJsonReadContext1;
      if (_currToken != JsonToken.START_OBJECT)
      {
        localJsonReadContext1 = localJsonReadContext2;
        if (_currToken != JsonToken.START_ARRAY) {}
      }
      else
      {
        localJsonReadContext1 = localJsonReadContext2.getParent();
      }
      try
      {
        localJsonReadContext1.setCurrentName(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
    
    public JsonToken peekNextToken()
      throws IOException
    {
      if (_closed) {}
      for (;;)
      {
        return null;
        TokenBuffer.Segment localSegment2 = _segment;
        int j = _segmentPtr + 1;
        int i = j;
        TokenBuffer.Segment localSegment1 = localSegment2;
        if (j >= 16)
        {
          i = 0;
          if (localSegment2 != null) {
            break label52;
          }
        }
        label52:
        for (localSegment1 = null; localSegment1 != null; localSegment1 = localSegment2.next()) {
          return localSegment1.type(i);
        }
      }
    }
    
    public int readBinaryValue(Base64Variant paramBase64Variant, OutputStream paramOutputStream)
      throws IOException
    {
      int i = 0;
      paramBase64Variant = getBinaryValue(paramBase64Variant);
      if (paramBase64Variant != null)
      {
        paramOutputStream.write(paramBase64Variant, 0, paramBase64Variant.length);
        i = paramBase64Variant.length;
      }
      return i;
    }
    
    public void setCodec(ObjectCodec paramObjectCodec)
    {
      _codec = paramObjectCodec;
    }
    
    public void setLocation(JsonLocation paramJsonLocation)
    {
      _location = paramJsonLocation;
    }
    
    public Version version()
    {
      return PackageVersion.VERSION;
    }
  }
  
  protected static final class Segment
  {
    public static final int TOKENS_PER_SEGMENT = 16;
    private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
    protected TreeMap<Integer, Object> _nativeIds;
    protected Segment _next;
    protected long _tokenTypes;
    protected final Object[] _tokens = new Object[16];
    
    static
    {
      JsonToken[] arrayOfJsonToken = JsonToken.values();
      System.arraycopy(arrayOfJsonToken, 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, arrayOfJsonToken.length - 1));
    }
    
    private final int _objectIdIndex(int paramInt)
    {
      return paramInt + paramInt + 1;
    }
    
    private final int _typeIdIndex(int paramInt)
    {
      return paramInt + paramInt;
    }
    
    private final void assignNativeIds(int paramInt, Object paramObject1, Object paramObject2)
    {
      if (_nativeIds == null) {
        _nativeIds = new TreeMap();
      }
      if (paramObject1 != null) {
        _nativeIds.put(Integer.valueOf(_objectIdIndex(paramInt)), paramObject1);
      }
      if (paramObject2 != null) {
        _nativeIds.put(Integer.valueOf(_typeIdIndex(paramInt)), paramObject2);
      }
    }
    
    private void set(int paramInt1, int paramInt2, Object paramObject)
    {
      _tokens[paramInt1] = paramObject;
      long l2 = paramInt2;
      long l1 = l2;
      if (paramInt1 > 0) {
        l1 = l2 << (paramInt1 << 2);
      }
      _tokenTypes |= l1;
    }
    
    private void set(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      _tokens[paramInt1] = paramObject1;
      long l2 = paramInt2;
      long l1 = l2;
      if (paramInt1 > 0) {
        l1 = l2 << (paramInt1 << 2);
      }
      _tokenTypes |= l1;
      assignNativeIds(paramInt1, paramObject2, paramObject3);
    }
    
    private void set(int paramInt, JsonToken paramJsonToken)
    {
      long l2 = paramJsonToken.ordinal();
      long l1 = l2;
      if (paramInt > 0) {
        l1 = l2 << (paramInt << 2);
      }
      _tokenTypes |= l1;
    }
    
    private void set(int paramInt, JsonToken paramJsonToken, Object paramObject)
    {
      _tokens[paramInt] = paramObject;
      long l2 = paramJsonToken.ordinal();
      long l1 = l2;
      if (paramInt > 0) {
        l1 = l2 << (paramInt << 2);
      }
      _tokenTypes |= l1;
    }
    
    private void set(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2)
    {
      long l2 = paramJsonToken.ordinal();
      long l1 = l2;
      if (paramInt > 0) {
        l1 = l2 << (paramInt << 2);
      }
      _tokenTypes |= l1;
      assignNativeIds(paramInt, paramObject1, paramObject2);
    }
    
    private void set(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      _tokens[paramInt] = paramObject1;
      long l2 = paramJsonToken.ordinal();
      long l1 = l2;
      if (paramInt > 0) {
        l1 = l2 << (paramInt << 2);
      }
      _tokenTypes |= l1;
      assignNativeIds(paramInt, paramObject2, paramObject3);
    }
    
    public Segment append(int paramInt, JsonToken paramJsonToken)
    {
      if (paramInt < 16)
      {
        set(paramInt, paramJsonToken);
        return null;
      }
      _next = new Segment();
      _next.set(0, paramJsonToken);
      return _next;
    }
    
    public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject)
    {
      if (paramInt < 16)
      {
        set(paramInt, paramJsonToken, paramObject);
        return null;
      }
      _next = new Segment();
      _next.set(0, paramJsonToken, paramObject);
      return _next;
    }
    
    public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2)
    {
      if (paramInt < 16)
      {
        set(paramInt, paramJsonToken, paramObject1, paramObject2);
        return null;
      }
      _next = new Segment();
      _next.set(0, paramJsonToken, paramObject1, paramObject2);
      return _next;
    }
    
    public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramInt < 16)
      {
        set(paramInt, paramJsonToken, paramObject1, paramObject2, paramObject3);
        return null;
      }
      _next = new Segment();
      _next.set(0, paramJsonToken, paramObject1, paramObject2, paramObject3);
      return _next;
    }
    
    public Segment appendRaw(int paramInt1, int paramInt2, Object paramObject)
    {
      if (paramInt1 < 16)
      {
        set(paramInt1, paramInt2, paramObject);
        return null;
      }
      _next = new Segment();
      _next.set(0, paramInt2, paramObject);
      return _next;
    }
    
    public Segment appendRaw(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramInt1 < 16)
      {
        set(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3);
        return null;
      }
      _next = new Segment();
      _next.set(0, paramInt2, paramObject1, paramObject2, paramObject3);
      return _next;
    }
    
    public Object findObjectId(int paramInt)
    {
      if (_nativeIds == null) {
        return null;
      }
      return _nativeIds.get(Integer.valueOf(_objectIdIndex(paramInt)));
    }
    
    public Object findTypeId(int paramInt)
    {
      if (_nativeIds == null) {
        return null;
      }
      return _nativeIds.get(Integer.valueOf(_typeIdIndex(paramInt)));
    }
    
    public Object get(int paramInt)
    {
      return _tokens[paramInt];
    }
    
    public boolean hasIds()
    {
      return _nativeIds != null;
    }
    
    public Segment next()
    {
      return _next;
    }
    
    public int rawType(int paramInt)
    {
      long l2 = _tokenTypes;
      long l1 = l2;
      if (paramInt > 0) {
        l1 = l2 >> (paramInt << 2);
      }
      return (int)l1 & 0xF;
    }
    
    public JsonToken type(int paramInt)
    {
      long l2 = _tokenTypes;
      long l1 = l2;
      if (paramInt > 0) {
        l1 = l2 >> (paramInt << 2);
      }
      paramInt = (int)l1;
      return TOKEN_TYPES_BY_INDEX[(paramInt & 0xF)];
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.TokenBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */