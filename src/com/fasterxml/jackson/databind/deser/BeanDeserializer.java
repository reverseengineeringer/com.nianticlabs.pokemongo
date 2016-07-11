package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

public class BeanDeserializer
  extends BeanDeserializerBase
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  protected BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase)
  {
    super(paramBeanDeserializerBase, _ignoreAllUnknown);
  }
  
  public BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, ObjectIdReader paramObjectIdReader)
  {
    super(paramBeanDeserializerBase, paramObjectIdReader);
  }
  
  protected BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, NameTransformer paramNameTransformer)
  {
    super(paramBeanDeserializerBase, paramNameTransformer);
  }
  
  public BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, HashSet<String> paramHashSet)
  {
    super(paramBeanDeserializerBase, paramHashSet);
  }
  
  protected BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, boolean paramBoolean)
  {
    super(paramBeanDeserializerBase, paramBoolean);
  }
  
  public BeanDeserializer(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBeanDeserializerBuilder, paramBeanDescription, paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean1, paramBoolean2);
  }
  
  private final Object vanillaDeserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonToken paramJsonToken)
    throws IOException
  {
    Object localObject2 = _valueInstantiator.createUsingDefault(paramDeserializationContext);
    paramJsonParser.setCurrentValue(localObject2);
    Object localObject1;
    if (paramJsonParser.hasTokenId(5))
    {
      paramJsonToken = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = _beanProperties.find(paramJsonToken);
      if (localObject1 == null) {
        break label90;
      }
    }
    for (;;)
    {
      try
      {
        ((SettableBeanProperty)localObject1).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
        localObject1 = paramJsonParser.nextFieldName();
        paramJsonToken = (JsonToken)localObject1;
        if (localObject1 != null) {
          break;
        }
        return localObject2;
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, localObject2, paramJsonToken, paramDeserializationContext);
        continue;
      }
      label90:
      handleUnknownVanilla(paramJsonParser, paramDeserializationContext, localObject2, paramJsonToken);
    }
  }
  
  protected final Object _deserializeOther(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonToken paramJsonToken)
    throws IOException
  {
    switch (paramJsonToken)
    {
    default: 
      throw paramDeserializationContext.mappingException(handledType());
    case ???: 
      return deserializeFromString(paramJsonParser, paramDeserializationContext);
    case ???: 
      return deserializeFromNumber(paramJsonParser, paramDeserializationContext);
    case ???: 
      return deserializeFromDouble(paramJsonParser, paramDeserializationContext);
    case ???: 
      return deserializeFromEmbedded(paramJsonParser, paramDeserializationContext);
    case ???: 
    case ???: 
      return deserializeFromBoolean(paramJsonParser, paramDeserializationContext);
    case ???: 
      return deserializeFromArray(paramJsonParser, paramDeserializationContext);
    }
    if (_vanillaProcessing) {
      return vanillaDeserialize(paramJsonParser, paramDeserializationContext, paramJsonToken);
    }
    if (_objectIdReader != null) {
      return deserializeWithObjectId(paramJsonParser, paramDeserializationContext);
    }
    return deserializeFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  protected Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, _objectIdReader);
    Object localObject1 = null;
    Object localObject5 = paramJsonParser.getCurrentToken();
    Object localObject3;
    if (localObject5 == JsonToken.FIELD_NAME)
    {
      localObject5 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = localPropertyBasedCreator.findCreatorProperty((String)localObject5);
      if (localSettableBeanProperty != null)
      {
        Object localObject2 = localObject1;
        if (!localPropertyValueBuffer.assignParameter(localSettableBeanProperty, _deserializeWithErrorWrapping(paramJsonParser, paramDeserializationContext, localSettableBeanProperty))) {
          break label205;
        }
        paramJsonParser.nextToken();
        try
        {
          localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
          if (localObject2 == null) {
            throw paramDeserializationContext.instantiationException(_beanType.getRawClass(), "JSON Creator returned null");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            wrapInstantiationProblem(localException1, paramDeserializationContext);
            localObject3 = null;
          }
          paramJsonParser.setCurrentValue(localObject3);
          if (localObject3.getClass() == _beanType.getRawClass()) {
            break label165;
          }
        }
        localObject3 = handlePolymorphic(paramJsonParser, paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
      }
    }
    for (;;)
    {
      return localObject3;
      label165:
      localObject5 = localObject3;
      if (localObject1 != null) {
        localObject5 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
      }
      return deserialize(paramJsonParser, paramDeserializationContext, localObject5);
      if (localPropertyValueBuffer.readIdProperty((String)localObject5)) {
        localObject3 = localObject1;
      }
      label205:
      Object localObject4;
      for (;;)
      {
        localObject5 = paramJsonParser.nextToken();
        localObject1 = localObject3;
        break;
        localObject3 = _beanProperties.find((String)localObject5);
        if (localObject3 != null)
        {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, _deserializeWithErrorWrapping(paramJsonParser, paramDeserializationContext, (SettableBeanProperty)localObject3));
          localObject3 = localObject1;
        }
        else if ((_ignorableProps != null) && (_ignorableProps.contains(localObject5)))
        {
          handleIgnoredProperty(paramJsonParser, paramDeserializationContext, handledType(), (String)localObject5);
          localObject3 = localObject1;
        }
        else if (_anySetter != null)
        {
          try
          {
            localPropertyValueBuffer.bufferAnyProperty(_anySetter, (String)localObject5, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
            localObject3 = localObject1;
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, _beanType.getRawClass(), (String)localObject5, paramDeserializationContext);
            localObject4 = localObject1;
          }
        }
        else
        {
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new TokenBuffer(paramJsonParser, paramDeserializationContext);
          }
          ((TokenBuffer)localObject4).writeFieldName((String)localObject5);
          ((TokenBuffer)localObject4).copyCurrentStructure(paramJsonParser);
        }
      }
      try
      {
        paramJsonParser = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
        localObject4 = paramJsonParser;
        if (localObject1 != null) {
          if (paramJsonParser.getClass() != _beanType.getRawClass()) {
            return handlePolymorphic(null, paramDeserializationContext, paramJsonParser, (TokenBuffer)localObject1);
          }
        }
      }
      catch (Exception paramJsonParser)
      {
        for (;;)
        {
          wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
          paramJsonParser = null;
        }
      }
    }
    return handleUnknownProperties(paramDeserializationContext, paramJsonParser, (TokenBuffer)localObject1);
  }
  
  protected final Object _deserializeWithErrorWrapping(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, SettableBeanProperty paramSettableBeanProperty)
    throws IOException
  {
    try
    {
      paramJsonParser = paramSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext);
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      wrapAndThrow(paramJsonParser, _beanType.getRawClass(), paramSettableBeanProperty.getName(), paramDeserializationContext);
    }
    return null;
  }
  
  protected Object _missingToken(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    throw paramDeserializationContext.endOfInputException(handledType());
  }
  
  protected BeanDeserializerBase asArrayDeserializer()
  {
    return new BeanAsArrayDeserializer(this, _beanProperties.getPropertiesInInsertionOrder());
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.isExpectedStartObjectToken())
    {
      if (_vanillaProcessing) {
        return vanillaDeserialize(paramJsonParser, paramDeserializationContext, paramJsonParser.nextToken());
      }
      paramJsonParser.nextToken();
      if (_objectIdReader != null) {
        return deserializeWithObjectId(paramJsonParser, paramDeserializationContext);
      }
      return deserializeFromObject(paramJsonParser, paramDeserializationContext);
    }
    return _deserializeOther(paramJsonParser, paramDeserializationContext, paramJsonParser.getCurrentToken());
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    paramJsonParser.setCurrentValue(paramObject);
    if (_injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    if (_unwrappedPropertyHandler != null) {
      localObject1 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext, paramObject);
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (_externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, paramObject);
      }
      if (!paramJsonParser.isExpectedStartObjectToken()) {
        break;
      }
      localObject2 = paramJsonParser.nextFieldName();
      localObject1 = paramObject;
    } while (localObject2 == null);
    for (Object localObject1 = localObject2;; localObject1 = paramJsonParser.getCurrentName())
    {
      localObject2 = localObject1;
      if (!_needViewProcesing) {
        break label133;
      }
      Class localClass = paramDeserializationContext.getActiveView();
      localObject2 = localObject1;
      if (localClass == null) {
        break label133;
      }
      return deserializeWithView(paramJsonParser, paramDeserializationContext, paramObject, localClass);
      localObject1 = paramObject;
      if (!paramJsonParser.hasTokenId(5)) {
        break;
      }
    }
    label133:
    paramJsonParser.nextToken();
    localObject1 = _beanProperties.find((String)localObject2);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        ((SettableBeanProperty)localObject1).deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
        localObject1 = paramJsonParser.nextFieldName();
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        return paramObject;
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject2, paramDeserializationContext);
        continue;
      }
      handleUnknownVanilla(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject2);
    }
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((_objectIdReader != null) && (_objectIdReader.maySerializeAsObject()) && (paramJsonParser.hasTokenId(5)) && (_objectIdReader.isValidReferencePropertyName(paramJsonParser.getCurrentName(), paramJsonParser))) {
      localObject1 = deserializeFromObjectId(paramJsonParser, paramDeserializationContext);
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        if (!_nonStandardCreation) {
          break;
        }
        if (_unwrappedPropertyHandler != null) {
          return deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext);
        }
        if (_externalTypeIdHandler != null) {
          return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext);
        }
        paramJsonParser = deserializeFromObjectUsingNonDefault(paramJsonParser, paramDeserializationContext);
        localObject1 = paramJsonParser;
      } while (_injectables == null);
      injectValues(paramDeserializationContext, paramJsonParser);
      return paramJsonParser;
      localObject2 = _valueInstantiator.createUsingDefault(paramDeserializationContext);
      paramJsonParser.setCurrentValue(localObject2);
      if (paramJsonParser.canReadObjectId())
      {
        localObject1 = paramJsonParser.getObjectId();
        if (localObject1 != null) {
          _handleTypedObjectId(paramJsonParser, paramDeserializationContext, localObject2, localObject1);
        }
      }
      if (_injectables != null) {
        injectValues(paramDeserializationContext, localObject2);
      }
      if (_needViewProcesing)
      {
        localObject1 = paramDeserializationContext.getActiveView();
        if (localObject1 != null) {
          return deserializeWithView(paramJsonParser, paramDeserializationContext, localObject2, (Class)localObject1);
        }
      }
      localObject1 = localObject2;
    } while (!paramJsonParser.hasTokenId(5));
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    Object localObject3 = _beanProperties.find((String)localObject1);
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        ((SettableBeanProperty)localObject3).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
        localObject3 = paramJsonParser.nextFieldName();
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        return localObject2;
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, localObject2, (String)localObject1, paramDeserializationContext);
        continue;
      }
      handleUnknownVanilla(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
    }
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    ExternalTypeHandler localExternalTypeHandler = _externalTypeIdHandler.start();
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, _objectIdReader);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = localPropertyBasedCreator.findCreatorProperty(str);
      if (localObject1 != null) {
        if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, null)) {}
      }
      for (;;)
      {
        localObject1 = paramJsonParser.nextToken();
        break;
        if (localPropertyValueBuffer.assignParameter((SettableBeanProperty)localObject1, _deserializeWithErrorWrapping(paramJsonParser, paramDeserializationContext, (SettableBeanProperty)localObject1)))
        {
          localObject1 = paramJsonParser.nextToken();
          Object localObject2;
          try
          {
            localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, _beanType.getRawClass(), str, paramDeserializationContext);
          }
          if (localObject2.getClass() != _beanType.getRawClass()) {
            throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
          }
          return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localObject2);
          if (!localPropertyValueBuffer.readIdProperty(str))
          {
            SettableBeanProperty localSettableBeanProperty = _beanProperties.find(str);
            if (localSettableBeanProperty != null) {
              localPropertyValueBuffer.bufferProperty(localSettableBeanProperty, localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext));
            } else if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, null)) {
              if ((_ignorableProps != null) && (_ignorableProps.contains(str))) {
                handleIgnoredProperty(paramJsonParser, paramDeserializationContext, handledType(), str);
              } else if (_anySetter != null) {
                localPropertyValueBuffer.bufferAnyProperty(_anySetter, str, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
              }
            }
          }
        }
      }
    }
    try
    {
      paramJsonParser = localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localPropertyValueBuffer, localPropertyBasedCreator);
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, _objectIdReader);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      Object localObject3 = localPropertyBasedCreator.findCreatorProperty((String)localObject1);
      if (localObject3 != null) {
        if (localPropertyValueBuffer.assignParameter((SettableBeanProperty)localObject3, _deserializeWithErrorWrapping(paramJsonParser, paramDeserializationContext, (SettableBeanProperty)localObject3)))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
            paramJsonParser.setCurrentValue(localObject3);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
              continue;
              localObject2 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException1)
          {
            wrapInstantiationProblem(localException1, paramDeserializationContext);
          }
        }
      }
      for (;;)
      {
        break;
        localTokenBuffer.writeEndObject();
        if (localObject3.getClass() != _beanType.getRawClass())
        {
          localTokenBuffer.close();
          throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
        }
        return _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject3, localTokenBuffer);
        if (!localPropertyValueBuffer.readIdProperty((String)localObject2))
        {
          localObject3 = _beanProperties.find((String)localObject2);
          if (localObject3 != null)
          {
            localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, _deserializeWithErrorWrapping(paramJsonParser, paramDeserializationContext, (SettableBeanProperty)localObject3));
          }
          else if ((_ignorableProps != null) && (_ignorableProps.contains(localObject2)))
          {
            handleIgnoredProperty(paramJsonParser, paramDeserializationContext, handledType(), (String)localObject2);
          }
          else
          {
            localTokenBuffer.writeFieldName((String)localObject2);
            localTokenBuffer.copyCurrentStructure(paramJsonParser);
            if (_anySetter != null) {
              try
              {
                localPropertyValueBuffer.bufferAnyProperty(_anySetter, (String)localObject2, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
              }
              catch (Exception localException2)
              {
                wrapAndThrow(localException2, _beanType.getRawClass(), (String)localObject2, paramDeserializationContext);
              }
            }
          }
        }
      }
    }
    try
    {
      localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
      return _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject2, localTokenBuffer);
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithExternalTypeId(paramJsonParser, paramDeserializationContext);
    }
    return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, _valueInstantiator.createUsingDefault(paramDeserializationContext));
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    Class localClass;
    ExternalTypeHandler localExternalTypeHandler;
    Object localObject;
    label28:
    SettableBeanProperty localSettableBeanProperty;
    if (_needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      localExternalTypeHandler = _externalTypeIdHandler.start();
      localObject = paramJsonParser.getCurrentToken();
      if (localObject != JsonToken.FIELD_NAME) {
        break label237;
      }
      localObject = paramJsonParser.getCurrentName();
      JsonToken localJsonToken = paramJsonParser.nextToken();
      localSettableBeanProperty = _beanProperties.find((String)localObject);
      if (localSettableBeanProperty == null) {
        break label144;
      }
      if (localJsonToken.isScalarValue()) {
        localExternalTypeHandler.handleTypePropertyValue(paramJsonParser, paramDeserializationContext, (String)localObject, paramObject);
      }
      if ((localClass == null) || (localSettableBeanProperty.visibleInView(localClass))) {
        break label118;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      localObject = paramJsonParser.nextToken();
      break label28;
      localClass = null;
      break;
      try
      {
        label118:
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, paramObject, (String)localObject, paramDeserializationContext);
      }
      continue;
      label144:
      if ((_ignorableProps != null) && (_ignorableProps.contains(localObject))) {
        handleIgnoredProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject);
      } else if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, (String)localObject, paramObject)) {
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject);
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, paramObject, (String)localObject, paramDeserializationContext);
          }
        } else {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject);
        }
      }
    }
    label237:
    return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(paramDeserializationContext, _delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(paramJsonParser, paramDeserializationContext);
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    Object localObject = _valueInstantiator.createUsingDefault(paramDeserializationContext);
    paramJsonParser.setCurrentValue(localObject);
    if (_injectables != null) {
      injectValues(paramDeserializationContext, localObject);
    }
    Class localClass;
    String str;
    label111:
    SettableBeanProperty localSettableBeanProperty;
    if (_needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      if (!paramJsonParser.hasTokenId(5)) {
        break label169;
      }
      str = paramJsonParser.getCurrentName();
      if (str == null) {
        break label280;
      }
      paramJsonParser.nextToken();
      localSettableBeanProperty = _beanProperties.find(str);
      if (localSettableBeanProperty == null) {
        break label201;
      }
      if ((localClass == null) || (localSettableBeanProperty.visibleInView(localClass))) {
        break label174;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      str = paramJsonParser.nextFieldName();
      break label111;
      localClass = null;
      break;
      label169:
      str = null;
      break label111;
      try
      {
        label174:
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, localObject, str, paramDeserializationContext);
      }
      continue;
      label201:
      if ((_ignorableProps != null) && (_ignorableProps.contains(str)))
      {
        handleIgnoredProperty(paramJsonParser, paramDeserializationContext, localObject, str);
      }
      else
      {
        localTokenBuffer.writeFieldName(str);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject, str);
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, localObject, str, paramDeserializationContext);
          }
        }
      }
    }
    label280:
    localTokenBuffer.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject, localTokenBuffer);
    return localObject;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    SettableBeanProperty localSettableBeanProperty;
    if (_needViewProcesing)
    {
      localObject2 = paramDeserializationContext.getActiveView();
      if (localObject1 != JsonToken.FIELD_NAME) {
        break label215;
      }
      localObject1 = paramJsonParser.getCurrentName();
      localSettableBeanProperty = _beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localSettableBeanProperty == null) {
        break label149;
      }
      if ((localObject2 == null) || (localSettableBeanProperty.visibleInView((Class)localObject2))) {
        break label123;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      localObject1 = paramJsonParser.nextToken();
      break;
      localObject2 = null;
      break;
      try
      {
        label123:
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
      }
      continue;
      label149:
      if ((_ignorableProps != null) && (_ignorableProps.contains(localObject1)))
      {
        handleIgnoredProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
      }
      else
      {
        localTokenBuffer.writeFieldName((String)localObject1);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        if (_anySetter != null) {
          _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
        }
      }
    }
    label215:
    localTokenBuffer.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, paramObject, localTokenBuffer);
    return paramObject;
  }
  
  protected final Object deserializeWithView(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, Class<?> paramClass)
    throws IOException
  {
    Object localObject1;
    Object localObject2;
    if (paramJsonParser.hasTokenId(5))
    {
      localObject1 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject2 = _beanProperties.find((String)localObject1);
      if (localObject2 == null) {
        break label93;
      }
      if (((SettableBeanProperty)localObject2).visibleInView(paramClass)) {
        break label67;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      localObject2 = paramJsonParser.nextFieldName();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return paramObject;
      try
      {
        label67:
        ((SettableBeanProperty)localObject2).deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
      }
      continue;
      label93:
      handleUnknownVanilla(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
    }
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer)
  {
    if (getClass() != BeanDeserializer.class) {
      return this;
    }
    return new BeanDeserializer(this, paramNameTransformer);
  }
  
  public BeanDeserializer withIgnorableProperties(HashSet<String> paramHashSet)
  {
    return new BeanDeserializer(this, paramHashSet);
  }
  
  public BeanDeserializer withObjectIdReader(ObjectIdReader paramObjectIdReader)
  {
    return new BeanDeserializer(this, paramObjectIdReader);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.BeanDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */