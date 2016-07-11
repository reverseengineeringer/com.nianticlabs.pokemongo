package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.EnumSet;

public class EnumSetDeserializer
  extends StdDeserializer<EnumSet<?>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final Class<Enum> _enumClass;
  protected JsonDeserializer<Enum<?>> _enumDeserializer;
  protected final JavaType _enumType;
  
  public EnumSetDeserializer(JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(EnumSet.class);
    _enumType = paramJavaType;
    _enumClass = paramJavaType.getRawClass();
    if (!_enumClass.isEnum()) {
      throw new IllegalArgumentException("Type " + paramJavaType + " not Java Enum type");
    }
    _enumDeserializer = paramJsonDeserializer;
  }
  
  private EnumSet constructSet()
  {
    return EnumSet.noneOf(_enumClass);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer = _enumDeserializer;
    if (localJsonDeserializer == null) {}
    for (paramDeserializationContext = paramDeserializationContext.findContextualValueDeserializer(_enumType, paramBeanProperty);; paramDeserializationContext = paramDeserializationContext.handleSecondaryContextualization(localJsonDeserializer, paramBeanProperty, _enumType)) {
      return withDeserializer(paramDeserializationContext);
    }
  }
  
  public EnumSet<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      throw paramDeserializationContext.mappingException(EnumSet.class);
    }
    EnumSet localEnumSet = constructSet();
    for (;;)
    {
      try
      {
        localObject = paramJsonParser.nextToken();
        if (localObject == JsonToken.END_ARRAY) {
          break;
        }
        if (localObject == JsonToken.VALUE_NULL) {
          throw paramDeserializationContext.mappingException(_enumClass);
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localEnumSet, localEnumSet.size());
      }
      Object localObject = (Enum)_enumDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      if (localObject != null) {
        localEnumSet.add(localObject);
      }
    }
    return localEnumSet;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return _enumType.getValueHandler() == null;
  }
  
  public EnumSetDeserializer withDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    if (_enumDeserializer == paramJsonDeserializer) {
      return this;
    }
    return new EnumSetDeserializer(_enumType, paramJsonDeserializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */