package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.IOException;
import java.lang.reflect.Method;

@JacksonStdImpl
public class EnumDeserializer
  extends StdScalarDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  protected final CompactStringObjectMap _enumLookup;
  protected Object[] _enumsByIndex;
  
  public EnumDeserializer(EnumResolver paramEnumResolver)
  {
    super(paramEnumResolver.getEnumClass());
    _enumLookup = paramEnumResolver.constructLookup();
    _enumsByIndex = paramEnumResolver.getRawEnums();
  }
  
  private final Object _deserializeAltString(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, String paramString)
    throws IOException
  {
    paramJsonParser = paramString.trim();
    if (paramJsonParser.length() == 0) {
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
        break label82;
      }
    }
    label82:
    while (paramDeserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL))
    {
      return null;
      int i = paramJsonParser.charAt(0);
      if ((i >= 48) && (i <= 57)) {
        try
        {
          i = Integer.parseInt(paramJsonParser);
          _checkFailOnNumber(paramDeserializationContext);
          if ((i >= 0) && (i <= _enumsByIndex.length))
          {
            paramString = _enumsByIndex[i];
            return paramString;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    }
    throw paramDeserializationContext.weirdStringException(paramJsonParser, _enumClass(), "value not one of declared Enum instance names: " + _enumLookup.keys());
  }
  
  public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig paramDeserializationConfig, Class<?> paramClass, AnnotatedMethod paramAnnotatedMethod)
  {
    Class localClass = paramAnnotatedMethod.getRawParameterType(0);
    if (paramDeserializationConfig.canOverrideAccessModifiers()) {
      ClassUtil.checkAndFixAccess(paramAnnotatedMethod.getMember());
    }
    return new FactoryBasedDeserializer(paramClass, paramAnnotatedMethod, localClass);
  }
  
  protected void _checkFailOnNumber(DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
      throw paramDeserializationContext.mappingException("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
    }
  }
  
  protected Object _deserializeOther(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    paramJsonParser.getCurrentToken();
    Object localObject;
    if ((paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) && (paramJsonParser.isExpectedStartArrayToken()))
    {
      paramJsonParser.nextToken();
      localObject = deserialize(paramJsonParser, paramDeserializationContext);
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _enumClass().getName() + "' value but there was more than a single value in the array");
      }
    }
    else
    {
      throw paramDeserializationContext.mappingException(_enumClass());
    }
    return localObject;
  }
  
  protected Class<?> _enumClass()
  {
    return handledType();
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1 = paramJsonParser.getCurrentToken();
    if ((localObject1 == JsonToken.VALUE_STRING) || (localObject1 == JsonToken.FIELD_NAME))
    {
      String str = paramJsonParser.getText();
      Object localObject2 = _enumLookup.find(str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = _deserializeAltString(paramJsonParser, paramDeserializationContext, str);
      }
      return localObject1;
    }
    if (localObject1 == JsonToken.VALUE_NUMBER_INT)
    {
      _checkFailOnNumber(paramDeserializationContext);
      int i = paramJsonParser.getIntValue();
      if ((i >= 0) && (i <= _enumsByIndex.length)) {
        return _enumsByIndex[i];
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
        throw paramDeserializationContext.weirdNumberException(Integer.valueOf(i), _enumClass(), "index value outside legal index range [0.." + (_enumsByIndex.length - 1) + "]");
      }
      return null;
    }
    return _deserializeOther(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  protected static class FactoryBasedDeserializer
    extends StdDeserializer<Object>
    implements ContextualDeserializer
  {
    private static final long serialVersionUID = 1L;
    protected final JsonDeserializer<?> _deser;
    protected final Method _factory;
    protected final Class<?> _inputType;
    
    protected FactoryBasedDeserializer(FactoryBasedDeserializer paramFactoryBasedDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    {
      super();
      _inputType = _inputType;
      _factory = _factory;
      _deser = paramJsonDeserializer;
    }
    
    public FactoryBasedDeserializer(Class<?> paramClass1, AnnotatedMethod paramAnnotatedMethod, Class<?> paramClass2)
    {
      super();
      _factory = paramAnnotatedMethod.getAnnotated();
      _inputType = paramClass2;
      _deser = null;
    }
    
    public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
      throws JsonMappingException
    {
      FactoryBasedDeserializer localFactoryBasedDeserializer = this;
      if (_deser == null)
      {
        localFactoryBasedDeserializer = this;
        if (_inputType != String.class) {
          localFactoryBasedDeserializer = new FactoryBasedDeserializer(this, paramDeserializationContext.findContextualValueDeserializer(paramDeserializationContext.constructType(_inputType), paramBeanProperty));
        }
      }
      return localFactoryBasedDeserializer;
    }
    
    public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if (_deser != null) {
        paramJsonParser = _deser.deserialize(paramJsonParser, paramDeserializationContext);
      }
      for (;;)
      {
        try
        {
          paramJsonParser = _factory.invoke(_valueClass, new Object[] { paramJsonParser });
          return paramJsonParser;
        }
        catch (Exception paramJsonParser)
        {
          JsonToken localJsonToken;
          paramJsonParser = ClassUtil.getRootCause(paramJsonParser);
          if (!(paramJsonParser instanceof IOException)) {
            continue;
          }
          throw ((IOException)paramJsonParser);
          throw paramDeserializationContext.instantiationException(_valueClass, paramJsonParser);
        }
        localJsonToken = paramJsonParser.getCurrentToken();
        if ((localJsonToken == JsonToken.VALUE_STRING) || (localJsonToken == JsonToken.FIELD_NAME)) {
          paramJsonParser = paramJsonParser.getText();
        } else {
          paramJsonParser = paramJsonParser.getValueAsString();
        }
      }
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException
    {
      if (_deser == null) {
        return deserialize(paramJsonParser, paramDeserializationContext);
      }
      return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.EnumDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */