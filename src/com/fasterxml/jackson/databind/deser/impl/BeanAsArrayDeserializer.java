package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.HashSet;

public class BeanAsArrayDeserializer
  extends BeanDeserializerBase
{
  private static final long serialVersionUID = 1L;
  protected final BeanDeserializerBase _delegate;
  protected final SettableBeanProperty[] _orderedProperties;
  
  public BeanAsArrayDeserializer(BeanDeserializerBase paramBeanDeserializerBase, SettableBeanProperty[] paramArrayOfSettableBeanProperty)
  {
    super(paramBeanDeserializerBase);
    _delegate = paramBeanDeserializerBase;
    _orderedProperties = paramArrayOfSettableBeanProperty;
  }
  
  protected Object _deserializeFromNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", new Object[] { _beanType.getRawClass().getName(), paramJsonParser.getCurrentToken() });
  }
  
  protected Object _deserializeNonVanilla(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1;
    if (_nonStandardCreation)
    {
      localObject1 = _deserializeWithCreator(paramJsonParser, paramDeserializationContext);
      return localObject1;
    }
    Object localObject2 = _valueInstantiator.createUsingDefault(paramDeserializationContext);
    paramJsonParser.setCurrentValue(localObject2);
    if (_injectables != null) {
      injectValues(paramDeserializationContext, localObject2);
    }
    Class localClass;
    label61:
    SettableBeanProperty[] arrayOfSettableBeanProperty;
    int i;
    int j;
    if (_needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      arrayOfSettableBeanProperty = _orderedProperties;
      i = 0;
      j = arrayOfSettableBeanProperty.length;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
        break;
      }
      if (i == j)
      {
        if (_ignoreAllUnknown) {
          break label195;
        }
        throw paramDeserializationContext.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] { Integer.valueOf(j) });
        localClass = null;
        break label61;
      }
      localObject1 = arrayOfSettableBeanProperty[i];
      i += 1;
      if ((localObject1 != null) && ((localClass == null) || (((SettableBeanProperty)localObject1).visibleInView(localClass)))) {
        try
        {
          ((SettableBeanProperty)localObject1).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, localObject2, ((SettableBeanProperty)localObject1).getName(), paramDeserializationContext);
        }
      } else {
        paramJsonParser.skipChildren();
      }
    }
    for (;;)
    {
      label195:
      localObject1 = localObject2;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
        break;
      }
      paramJsonParser.skipChildren();
    }
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, _objectIdReader);
    SettableBeanProperty[] arrayOfSettableBeanProperty = _orderedProperties;
    int j = arrayOfSettableBeanProperty.length;
    int i = 0;
    Object localObject1 = null;
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
    {
      Object localObject2;
      label57:
      Object localObject3;
      if (i < j)
      {
        localObject2 = arrayOfSettableBeanProperty[i];
        if (localObject2 != null) {
          break label88;
        }
        paramJsonParser.skipChildren();
        localObject3 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject3;
        break;
        localObject2 = null;
        break label57;
        label88:
        Object localObject4;
        if (localObject1 != null)
        {
          try
          {
            ((SettableBeanProperty)localObject2).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject1);
            localObject3 = localObject1;
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, localObject1, ((SettableBeanProperty)localObject2).getName(), paramDeserializationContext);
            localObject4 = localObject1;
          }
        }
        else
        {
          String str = ((SettableBeanProperty)localObject2).getName();
          SettableBeanProperty localSettableBeanProperty = localPropertyBasedCreator.findCreatorProperty(str);
          if (localSettableBeanProperty != null)
          {
            localObject4 = localObject1;
            if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty, localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext))) {
              try
              {
                localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
                localObject1 = localObject2;
                paramJsonParser.setCurrentValue(localObject1);
                localObject4 = localObject1;
                if (localObject1.getClass() == _beanType.getRawClass()) {
                  continue;
                }
                throw paramDeserializationContext.mappingException("Can not support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[] { _beanType.getRawClass().getName(), localObject1.getClass().getName() });
              }
              catch (Exception localException1)
              {
                wrapAndThrow(localException1, _beanType.getRawClass(), str, paramDeserializationContext);
                localObject4 = localObject1;
              }
            }
          }
          else
          {
            localObject4 = localObject1;
            if (!localPropertyValueBuffer.readIdProperty(str))
            {
              localPropertyValueBuffer.bufferProperty(localException1, localException1.deserialize(paramJsonParser, paramDeserializationContext));
              localObject4 = localObject1;
            }
          }
        }
      }
    }
    paramJsonParser = (JsonParser)localObject1;
    if (localObject1 == null) {}
    try
    {
      paramJsonParser = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object _deserializeWithCreator(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(paramDeserializationContext, _delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (_propertyBasedCreator != null) {
      return _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    if (_beanType.isAbstract()) {
      throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + _beanType + " (need to add/enable type information?)");
    }
    throw JsonMappingException.from(paramJsonParser, "No suitable constructor found for type " + _beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
  }
  
  protected BeanDeserializerBase asArrayDeserializer()
  {
    return this;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1;
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      localObject1 = _deserializeFromNonArray(paramJsonParser, paramDeserializationContext);
    }
    Object localObject2;
    SettableBeanProperty[] arrayOfSettableBeanProperty;
    int i;
    int j;
    do
    {
      return localObject1;
      if (!_vanillaProcessing) {
        return _deserializeNonVanilla(paramJsonParser, paramDeserializationContext);
      }
      localObject2 = _valueInstantiator.createUsingDefault(paramDeserializationContext);
      paramJsonParser.setCurrentValue(localObject2);
      arrayOfSettableBeanProperty = _orderedProperties;
      i = 0;
      j = arrayOfSettableBeanProperty.length;
      localObject1 = localObject2;
    } while (paramJsonParser.nextToken() == JsonToken.END_ARRAY);
    if (i == j)
    {
      if (!_ignoreAllUnknown) {
        throw paramDeserializationContext.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] { Integer.valueOf(j) });
      }
    }
    else
    {
      localObject1 = arrayOfSettableBeanProperty[i];
      if (localObject1 != null) {}
      for (;;)
      {
        try
        {
          ((SettableBeanProperty)localObject1).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
          i += 1;
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, localObject2, ((SettableBeanProperty)localObject1).getName(), paramDeserializationContext);
          continue;
        }
        paramJsonParser.skipChildren();
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
        break;
      }
      paramJsonParser.skipChildren();
    }
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    paramJsonParser.setCurrentValue(paramObject);
    if (_injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    SettableBeanProperty[] arrayOfSettableBeanProperty = _orderedProperties;
    int i = 0;
    int j = arrayOfSettableBeanProperty.length;
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {}
    for (;;)
    {
      return paramObject;
      if (i == j)
      {
        if (!_ignoreAllUnknown) {
          throw paramDeserializationContext.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] { Integer.valueOf(j) });
        }
      }
      else
      {
        SettableBeanProperty localSettableBeanProperty = arrayOfSettableBeanProperty[i];
        if (localSettableBeanProperty != null) {}
        for (;;)
        {
          try
          {
            localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
            i += 1;
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, paramObject, localSettableBeanProperty.getName(), paramDeserializationContext);
            continue;
          }
          paramJsonParser.skipChildren();
        }
      }
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        paramJsonParser.skipChildren();
      }
    }
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return _deserializeFromNonArray(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer)
  {
    return _delegate.unwrappingDeserializer(paramNameTransformer);
  }
  
  public BeanAsArrayDeserializer withIgnorableProperties(HashSet<String> paramHashSet)
  {
    return new BeanAsArrayDeserializer(_delegate.withIgnorableProperties(paramHashSet), _orderedProperties);
  }
  
  public BeanAsArrayDeserializer withObjectIdReader(ObjectIdReader paramObjectIdReader)
  {
    return new BeanAsArrayDeserializer(_delegate.withObjectIdReader(paramObjectIdReader), _orderedProperties);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */