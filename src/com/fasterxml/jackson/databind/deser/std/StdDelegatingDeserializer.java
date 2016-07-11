package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;

public class StdDelegatingDeserializer<T>
  extends StdDeserializer<T>
  implements ContextualDeserializer, ResolvableDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final Converter<Object, T> _converter;
  protected final JsonDeserializer<Object> _delegateDeserializer;
  protected final JavaType _delegateType;
  
  protected StdDelegatingDeserializer(StdDelegatingDeserializer<T> paramStdDelegatingDeserializer)
  {
    super(paramStdDelegatingDeserializer);
    _converter = _converter;
    _delegateType = _delegateType;
    _delegateDeserializer = _delegateDeserializer;
  }
  
  public StdDelegatingDeserializer(Converter<?, T> paramConverter)
  {
    super(Object.class);
    _converter = paramConverter;
    _delegateType = null;
    _delegateDeserializer = null;
  }
  
  public StdDelegatingDeserializer(Converter<Object, T> paramConverter, JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramJavaType);
    _converter = paramConverter;
    _delegateType = paramJavaType;
    _delegateDeserializer = paramJsonDeserializer;
  }
  
  protected Object _handleIncompatibleUpdateValue(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    throw new UnsupportedOperationException(String.format("Can not update object of type %s (using deserializer for type %s)" + paramObject.getClass().getName(), new Object[] { _delegateType }));
  }
  
  protected T convertValue(Object paramObject)
  {
    return (T)_converter.convert(paramObject);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (_delegateDeserializer != null)
    {
      paramBeanProperty = paramDeserializationContext.handleSecondaryContextualization(_delegateDeserializer, paramBeanProperty, _delegateType);
      paramDeserializationContext = this;
      if (paramBeanProperty != _delegateDeserializer) {
        paramDeserializationContext = withDelegate(_converter, _delegateType, paramBeanProperty);
      }
      return paramDeserializationContext;
    }
    JavaType localJavaType = _converter.getInputType(paramDeserializationContext.getTypeFactory());
    return withDelegate(_converter, localJavaType, paramDeserializationContext.findContextualValueDeserializer(localJavaType, paramBeanProperty));
  }
  
  public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    paramJsonParser = _delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {
      return null;
    }
    return (T)convertValue(paramJsonParser);
  }
  
  public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    if (_delegateType.getRawClass().isAssignableFrom(paramObject.getClass())) {
      return (T)_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext, paramObject);
    }
    return (T)_handleIncompatibleUpdateValue(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    paramJsonParser = _delegateDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, paramTypeDeserializer);
    if (paramJsonParser == null) {
      return null;
    }
    return convertValue(paramJsonParser);
  }
  
  public JsonDeserializer<?> getDelegatee()
  {
    return _delegateDeserializer;
  }
  
  public Class<?> handledType()
  {
    return _delegateDeserializer.handledType();
  }
  
  public void resolve(DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    if ((_delegateDeserializer != null) && ((_delegateDeserializer instanceof ResolvableDeserializer))) {
      ((ResolvableDeserializer)_delegateDeserializer).resolve(paramDeserializationContext);
    }
  }
  
  protected StdDelegatingDeserializer<T> withDelegate(Converter<Object, T> paramConverter, JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    if (getClass() != StdDelegatingDeserializer.class) {
      throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }
    return new StdDelegatingDeserializer(paramConverter, paramJavaType, paramJsonDeserializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */