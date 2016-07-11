package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class AbstractDeserializer
  extends JsonDeserializer<Object>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final boolean _acceptBoolean;
  protected final boolean _acceptDouble;
  protected final boolean _acceptInt;
  protected final boolean _acceptString;
  protected final Map<String, SettableBeanProperty> _backRefProperties;
  protected final JavaType _baseType;
  protected final ObjectIdReader _objectIdReader;
  
  protected AbstractDeserializer(BeanDescription paramBeanDescription)
  {
    _baseType = paramBeanDescription.getType();
    _objectIdReader = null;
    _backRefProperties = null;
    paramBeanDescription = _baseType.getRawClass();
    _acceptString = paramBeanDescription.isAssignableFrom(String.class);
    if ((paramBeanDescription == Boolean.TYPE) || (paramBeanDescription.isAssignableFrom(Boolean.class)))
    {
      bool1 = true;
      _acceptBoolean = bool1;
      if ((paramBeanDescription != Integer.TYPE) && (!paramBeanDescription.isAssignableFrom(Integer.class))) {
        break label119;
      }
    }
    label119:
    for (boolean bool1 = true;; bool1 = false)
    {
      _acceptInt = bool1;
      if (paramBeanDescription != Double.TYPE)
      {
        bool1 = bool2;
        if (!paramBeanDescription.isAssignableFrom(Double.class)) {}
      }
      else
      {
        bool1 = true;
      }
      _acceptDouble = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public AbstractDeserializer(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, Map<String, SettableBeanProperty> paramMap)
  {
    _baseType = paramBeanDescription.getType();
    _objectIdReader = paramBeanDeserializerBuilder.getObjectIdReader();
    _backRefProperties = paramMap;
    paramBeanDeserializerBuilder = _baseType.getRawClass();
    _acceptString = paramBeanDeserializerBuilder.isAssignableFrom(String.class);
    if ((paramBeanDeserializerBuilder == Boolean.TYPE) || (paramBeanDeserializerBuilder.isAssignableFrom(Boolean.class)))
    {
      bool1 = true;
      _acceptBoolean = bool1;
      if ((paramBeanDeserializerBuilder != Integer.TYPE) && (!paramBeanDeserializerBuilder.isAssignableFrom(Integer.class))) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = true;; bool1 = false)
    {
      _acceptInt = bool1;
      if (paramBeanDeserializerBuilder != Double.TYPE)
      {
        bool1 = bool2;
        if (!paramBeanDeserializerBuilder.isAssignableFrom(Double.class)) {}
      }
      else
      {
        bool1 = true;
      }
      _acceptDouble = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static AbstractDeserializer constructForNonPOJO(BeanDescription paramBeanDescription)
  {
    return new AbstractDeserializer(paramBeanDescription);
  }
  
  protected Object _deserializeFromObjectId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1 = _objectIdReader.readObjectReference(paramJsonParser, paramDeserializationContext);
    paramDeserializationContext = paramDeserializationContext.findObjectId(localObject1, _objectIdReader.generator, _objectIdReader.resolver);
    Object localObject2 = paramDeserializationContext.resolve();
    if (localObject2 == null) {
      throw new UnresolvedForwardReference("Could not resolve Object Id [" + localObject1 + "] -- unresolved forward-reference?", paramJsonParser.getCurrentLocation(), paramDeserializationContext);
    }
    return localObject2;
  }
  
  protected Object _deserializeIfNatural(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (!_acceptString);
            return paramJsonParser.getText();
          } while (!_acceptInt);
          return Integer.valueOf(paramJsonParser.getIntValue());
        } while (!_acceptDouble);
        return Double.valueOf(paramJsonParser.getDoubleValue());
      } while (!_acceptBoolean);
      return Boolean.TRUE;
    } while (!_acceptBoolean);
    return Boolean.FALSE;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    throw paramDeserializationContext.instantiationException(_baseType.getRawClass(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    Object localObject1;
    if (_objectIdReader != null)
    {
      localObject1 = paramJsonParser.getCurrentToken();
      if ((localObject1 != null) && (((JsonToken)localObject1).isScalarValue())) {
        localObject1 = _deserializeFromObjectId(paramJsonParser, paramDeserializationContext);
      }
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = _deserializeIfNatural(paramJsonParser, paramDeserializationContext);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public SettableBeanProperty findBackReference(String paramString)
  {
    if (_backRefProperties == null) {
      return null;
    }
    return (SettableBeanProperty)_backRefProperties.get(paramString);
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return _objectIdReader;
  }
  
  public Class<?> handledType()
  {
    return _baseType.getRawClass();
  }
  
  public boolean isCachable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.AbstractDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */