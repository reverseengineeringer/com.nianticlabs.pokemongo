package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;

public class AsPropertyTypeDeserializer
  extends AsArrayTypeDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JsonTypeInfo.As _inclusion;
  
  public AsPropertyTypeDeserializer(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, String paramString, boolean paramBoolean, Class<?> paramClass)
  {
    this(paramJavaType, paramTypeIdResolver, paramString, paramBoolean, paramClass, JsonTypeInfo.As.PROPERTY);
  }
  
  public AsPropertyTypeDeserializer(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, String paramString, boolean paramBoolean, Class<?> paramClass, JsonTypeInfo.As paramAs)
  {
    super(paramJavaType, paramTypeIdResolver, paramString, paramBoolean, paramClass);
    _inclusion = paramAs;
  }
  
  public AsPropertyTypeDeserializer(AsPropertyTypeDeserializer paramAsPropertyTypeDeserializer, BeanProperty paramBeanProperty)
  {
    super(paramAsPropertyTypeDeserializer, paramBeanProperty);
    _inclusion = _inclusion;
  }
  
  protected Object _deserializeTypedForId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TokenBuffer paramTokenBuffer)
    throws IOException
  {
    String str = paramJsonParser.getText();
    JsonDeserializer localJsonDeserializer = _findDeserializer(paramDeserializationContext, str);
    TokenBuffer localTokenBuffer = paramTokenBuffer;
    if (_typeIdVisible)
    {
      localTokenBuffer = paramTokenBuffer;
      if (paramTokenBuffer == null) {
        localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
      }
      localTokenBuffer.writeFieldName(paramJsonParser.getCurrentName());
      localTokenBuffer.writeString(str);
    }
    paramTokenBuffer = paramJsonParser;
    if (localTokenBuffer != null) {
      paramTokenBuffer = JsonParserSequence.createFlattened(localTokenBuffer.asParser(paramJsonParser), paramJsonParser);
    }
    paramTokenBuffer.nextToken();
    return localJsonDeserializer.deserialize(paramTokenBuffer, paramDeserializationContext);
  }
  
  protected Object _deserializeTypedUsingDefaultImpl(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TokenBuffer paramTokenBuffer)
    throws IOException
  {
    JsonDeserializer localJsonDeserializer = _findDefaultImplDeserializer(paramDeserializationContext);
    Object localObject;
    if (localJsonDeserializer != null)
    {
      localObject = paramJsonParser;
      if (paramTokenBuffer != null)
      {
        paramTokenBuffer.writeEndObject();
        localObject = paramTokenBuffer.asParser(paramJsonParser);
        ((JsonParser)localObject).nextToken();
      }
      paramTokenBuffer = localJsonDeserializer.deserialize((JsonParser)localObject, paramDeserializationContext);
    }
    do
    {
      return paramTokenBuffer;
      localObject = TypeDeserializer.deserializeIfNatural(paramJsonParser, paramDeserializationContext, _baseType);
      paramTokenBuffer = (TokenBuffer)localObject;
    } while (localObject != null);
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      return super.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    }
    throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.FIELD_NAME, "missing property '" + _typePropertyName + "' that is to contain type id  (for class " + baseTypeName() + ")");
  }
  
  public Object deserializeTypedFromAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      return super.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
    }
    return deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserializeTypedFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1;
    if (paramJsonParser.canReadTypeId())
    {
      localObject1 = paramJsonParser.getTypeId();
      if (localObject1 != null) {
        return _deserializeWithNativeTypeId(paramJsonParser, paramDeserializationContext, localObject1);
      }
    }
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject3;
    if (localObject2 == JsonToken.START_OBJECT)
    {
      localObject1 = paramJsonParser.nextToken();
      localObject2 = null;
      localObject3 = localObject1;
    }
    for (;;)
    {
      if (localObject3 != JsonToken.FIELD_NAME) {
        break label165;
      }
      localObject3 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      if (_typePropertyName.equals(localObject3))
      {
        return _deserializeTypedForId(paramJsonParser, paramDeserializationContext, (TokenBuffer)localObject2);
        if (localObject2 == JsonToken.START_ARRAY) {
          return _deserializeTypedUsingDefaultImpl(paramJsonParser, paramDeserializationContext, null);
        }
        localObject1 = localObject2;
        if (localObject2 == JsonToken.FIELD_NAME) {
          break;
        }
        return _deserializeTypedUsingDefaultImpl(paramJsonParser, paramDeserializationContext, null);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new TokenBuffer(paramJsonParser, paramDeserializationContext);
      }
      ((TokenBuffer)localObject1).writeFieldName((String)localObject3);
      ((TokenBuffer)localObject1).copyCurrentStructure(paramJsonParser);
      localObject3 = paramJsonParser.nextToken();
      localObject2 = localObject1;
    }
    label165:
    return _deserializeTypedUsingDefaultImpl(paramJsonParser, paramDeserializationContext, (TokenBuffer)localObject2);
  }
  
  public TypeDeserializer forProperty(BeanProperty paramBeanProperty)
  {
    if (paramBeanProperty == _property) {
      return this;
    }
    return new AsPropertyTypeDeserializer(this, paramBeanProperty);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return _inclusion;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */