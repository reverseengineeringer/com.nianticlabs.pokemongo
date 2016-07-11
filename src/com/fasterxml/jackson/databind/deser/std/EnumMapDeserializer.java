package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.EnumMap;

public class EnumMapDeserializer
  extends ContainerDeserializerBase<EnumMap<?, ?>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _enumClass;
  protected KeyDeserializer _keyDeserializer;
  protected final JavaType _mapType;
  protected JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public EnumMapDeserializer(JavaType paramJavaType, KeyDeserializer paramKeyDeserializer, JsonDeserializer<?> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    super(paramJavaType);
    _mapType = paramJavaType;
    _enumClass = paramJavaType.getKeyType().getRawClass();
    _keyDeserializer = paramKeyDeserializer;
    _valueDeserializer = paramJsonDeserializer;
    _valueTypeDeserializer = paramTypeDeserializer;
  }
  
  protected EnumMap<?, ?> constructMap()
  {
    return new EnumMap(_enumClass);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject2 = _keyDeserializer;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramDeserializationContext.findKeyDeserializer(_mapType.getKeyType(), paramBeanProperty);
    }
    localObject2 = _valueDeserializer;
    Object localObject3 = _mapType.getContentType();
    if (localObject2 == null) {}
    for (paramDeserializationContext = paramDeserializationContext.findContextualValueDeserializer((JavaType)localObject3, paramBeanProperty);; paramDeserializationContext = paramDeserializationContext.handleSecondaryContextualization((JsonDeserializer)localObject2, paramBeanProperty, (JavaType)localObject3))
    {
      localObject3 = _valueTypeDeserializer;
      localObject2 = localObject3;
      if (localObject3 != null) {
        localObject2 = ((TypeDeserializer)localObject3).forProperty(paramBeanProperty);
      }
      return withResolved((KeyDeserializer)localObject1, paramDeserializationContext, (TypeDeserializer)localObject2);
    }
  }
  
  public EnumMap<?, ?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      return (EnumMap)_deserializeFromEmpty(paramJsonParser, paramDeserializationContext);
    }
    localEnumMap = constructMap();
    JsonDeserializer localJsonDeserializer = _valueDeserializer;
    TypeDeserializer localTypeDeserializer = _valueTypeDeserializer;
    while (paramJsonParser.nextToken() == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      Enum localEnum = (Enum)_keyDeserializer.deserializeKey(str, paramDeserializationContext);
      if (localEnum == null)
      {
        if (!paramDeserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
          throw paramDeserializationContext.weirdStringException(str, _enumClass, "value not one of declared Enum instance names for " + _mapType.getKeyType());
        }
        paramJsonParser.nextToken();
        paramJsonParser.skipChildren();
        continue;
      }
      Object localObject = paramJsonParser.nextToken();
      try
      {
        if (localObject == JsonToken.VALUE_NULL) {
          localObject = localJsonDeserializer.getNullValue(paramDeserializationContext);
        }
        for (;;)
        {
          localEnumMap.put(localEnum, localObject);
          break;
          if (localTypeDeserializer == null) {
            localObject = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
          } else {
            localObject = localJsonDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
          }
        }
        return localEnumMap;
      }
      catch (Exception paramJsonParser)
      {
        wrapAndThrow(paramJsonParser, localEnumMap, str);
        return null;
      }
    }
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return _valueDeserializer;
  }
  
  public JavaType getContentType()
  {
    return _mapType.getContentType();
  }
  
  public boolean isCachable()
  {
    return (_valueDeserializer == null) && (_keyDeserializer == null) && (_valueTypeDeserializer == null);
  }
  
  public EnumMapDeserializer withResolved(KeyDeserializer paramKeyDeserializer, JsonDeserializer<?> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    if ((paramKeyDeserializer == _keyDeserializer) && (paramJsonDeserializer == _valueDeserializer) && (paramTypeDeserializer == _valueTypeDeserializer)) {
      return this;
    }
    return new EnumMapDeserializer(_mapType, paramKeyDeserializer, paramJsonDeserializer, _valueTypeDeserializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */