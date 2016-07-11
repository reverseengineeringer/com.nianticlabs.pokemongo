package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Method;

public class EnumDeserializer$FactoryBasedDeserializer
  extends StdDeserializer<Object>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JsonDeserializer<?> _deser;
  protected final Method _factory;
  protected final Class<?> _inputType;
  
  protected EnumDeserializer$FactoryBasedDeserializer(FactoryBasedDeserializer paramFactoryBasedDeserializer, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(_valueClass);
    _inputType = _inputType;
    _factory = _factory;
    _deser = paramJsonDeserializer;
  }
  
  public EnumDeserializer$FactoryBasedDeserializer(Class<?> paramClass1, AnnotatedMethod paramAnnotatedMethod, Class<?> paramClass2)
  {
    super(paramClass1);
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.EnumDeserializer.FactoryBasedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */