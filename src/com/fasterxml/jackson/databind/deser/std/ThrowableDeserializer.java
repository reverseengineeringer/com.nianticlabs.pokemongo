package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.HashSet;

public class ThrowableDeserializer
  extends BeanDeserializer
{
  protected static final String PROP_NAME_MESSAGE = "message";
  private static final long serialVersionUID = 1L;
  
  public ThrowableDeserializer(BeanDeserializer paramBeanDeserializer)
  {
    super(paramBeanDeserializer);
    _vanillaProcessing = false;
  }
  
  protected ThrowableDeserializer(BeanDeserializer paramBeanDeserializer, NameTransformer paramNameTransformer)
  {
    super(paramBeanDeserializer, paramNameTransformer);
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (_propertyBasedCreator != null) {
      paramJsonParser = _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    boolean bool1;
    Object localObject2;
    Object localObject1;
    int i;
    int j;
    do
    {
      return paramJsonParser;
      if (_delegateDeserializer != null) {
        return _valueInstantiator.createUsingDelegate(paramDeserializationContext, _delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      }
      if (_beanType.isAbstract()) {
        throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + _beanType + " (need to add/enable type information?)");
      }
      bool1 = _valueInstantiator.canCreateFromString();
      boolean bool2 = _valueInstantiator.canCreateUsingDefault();
      if ((!bool1) && (!bool2)) {
        throw new JsonMappingException("Can not deserialize Throwable of type " + _beanType + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
      }
      localObject2 = null;
      localObject1 = null;
      i = 0;
      if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
      {
        Object localObject3 = paramJsonParser.getCurrentName();
        Object localObject4 = _beanProperties.find((String)localObject3);
        paramJsonParser.nextToken();
        if (localObject4 != null) {
          if (localObject2 != null)
          {
            ((SettableBeanProperty)localObject4).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
            j = i;
            localObject3 = localObject1;
          }
        }
        for (;;)
        {
          paramJsonParser.nextToken();
          localObject1 = localObject3;
          i = j;
          break;
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            j = _beanProperties.size();
            localObject3 = new Object[j + j];
          }
          int k = i + 1;
          localObject3[i] = localObject4;
          j = k + 1;
          localObject3[k] = ((SettableBeanProperty)localObject4).deserialize(paramJsonParser, paramDeserializationContext);
          continue;
          if (("message".equals(localObject3)) && (bool1))
          {
            localObject4 = _valueInstantiator.createFromString(paramDeserializationContext, paramJsonParser.getText());
            localObject3 = localObject1;
            j = i;
            localObject2 = localObject4;
            if (localObject1 != null)
            {
              j = 0;
              while (j < i)
              {
                ((SettableBeanProperty)localObject1[j]).set(localObject4, localObject1[(j + 1)]);
                j += 2;
              }
              localObject3 = null;
              j = i;
              localObject2 = localObject4;
            }
          }
          else if ((_ignorableProps != null) && (_ignorableProps.contains(localObject3)))
          {
            paramJsonParser.skipChildren();
            localObject3 = localObject1;
            j = i;
          }
          else if (_anySetter != null)
          {
            _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject3);
            localObject3 = localObject1;
            j = i;
          }
          else
          {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject3);
            localObject3 = localObject1;
            j = i;
          }
        }
      }
      paramJsonParser = (JsonParser)localObject2;
    } while (localObject2 != null);
    if (bool1) {}
    for (paramDeserializationContext = _valueInstantiator.createFromString(paramDeserializationContext, null);; paramDeserializationContext = _valueInstantiator.createUsingDefault(paramDeserializationContext))
    {
      paramJsonParser = paramDeserializationContext;
      if (localObject1 == null) {
        break;
      }
      j = 0;
      for (;;)
      {
        paramJsonParser = paramDeserializationContext;
        if (j >= i) {
          break;
        }
        ((SettableBeanProperty)localObject1[j]).set(paramDeserializationContext, localObject1[(j + 1)]);
        j += 2;
      }
    }
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer)
  {
    if (getClass() != ThrowableDeserializer.class) {
      return this;
    }
    return new ThrowableDeserializer(this, paramNameTransformer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */