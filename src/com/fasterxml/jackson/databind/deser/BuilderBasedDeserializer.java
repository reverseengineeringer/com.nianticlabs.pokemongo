package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;

public class BuilderBasedDeserializer
  extends BeanDeserializerBase
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedMethod _buildMethod;
  
  public BuilderBasedDeserializer(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBeanDeserializerBuilder, paramBeanDescription, paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean1, paramBoolean2);
    _buildMethod = paramBeanDeserializerBuilder.getBuildMethod();
    if (_objectIdReader != null) {
      throw new IllegalArgumentException("Can not use Object Id with Builder-based deserialization (type " + paramBeanDescription.getType() + ")");
    }
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer)
  {
    this(paramBuilderBasedDeserializer, _ignoreAllUnknown);
  }
  
  public BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, ObjectIdReader paramObjectIdReader)
  {
    super(paramBuilderBasedDeserializer, paramObjectIdReader);
    _buildMethod = _buildMethod;
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, NameTransformer paramNameTransformer)
  {
    super(paramBuilderBasedDeserializer, paramNameTransformer);
    _buildMethod = _buildMethod;
  }
  
  public BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, HashSet<String> paramHashSet)
  {
    super(paramBuilderBasedDeserializer, paramHashSet);
    _buildMethod = _buildMethod;
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, boolean paramBoolean)
  {
    super(paramBuilderBasedDeserializer, paramBoolean);
    _buildMethod = _buildMethod;
  }
  
  private final Object vanillaDeserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonToken paramJsonToken)
    throws IOException, JsonProcessingException
  {
    paramJsonToken = _valueInstantiator.createUsingDefault(paramDeserializationContext);
    if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      Object localObject = _beanProperties.find(str);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = ((SettableBeanProperty)localObject).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramJsonToken);
          paramJsonToken = (JsonToken)localObject;
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramJsonToken, str, paramDeserializationContext);
          continue;
        }
        paramJsonParser.nextToken();
        break;
        handleUnknownVanilla(paramJsonParser, paramDeserializationContext, paramJsonToken, str);
      }
    }
    return paramJsonToken;
  }
  
  protected final Object _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    if (_injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    if (_unwrappedPropertyHandler != null) {
      return deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext, paramObject);
    }
    if (_externalTypeIdHandler != null) {
      return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, paramObject);
    }
    if (_needViewProcesing)
    {
      localObject1 = paramDeserializationContext.getActiveView();
      if (localObject1 != null) {
        return deserializeWithView(paramJsonParser, paramDeserializationContext, paramObject, (Class)localObject1);
      }
    }
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    Object localObject1 = localJsonToken;
    Object localObject2 = paramObject;
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      localObject1 = paramJsonParser.nextToken();
      localObject2 = paramObject;
    }
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      paramObject = _beanProperties.find((String)localObject1);
      if (paramObject != null) {}
      for (;;)
      {
        try
        {
          paramObject = ((SettableBeanProperty)paramObject).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, localObject2);
          localObject2 = paramObject;
        }
        catch (Exception paramObject)
        {
          wrapAndThrow((Throwable)paramObject, localObject2, (String)localObject1, paramDeserializationContext);
          continue;
        }
        localObject1 = paramJsonParser.nextToken();
        break;
        handleUnknownVanilla(paramJsonParser, paramDeserializationContext, handledType(), (String)localObject1);
      }
    }
    return localObject2;
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, _objectIdReader);
    Object localObject1 = null;
    Object localObject4 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject4 == JsonToken.FIELD_NAME)
    {
      localObject4 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = localPropertyBasedCreator.findCreatorProperty((String)localObject4);
      if (localSettableBeanProperty != null)
      {
        localObject2 = localObject1;
        if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty, localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext))) {
          paramJsonParser.nextToken();
        }
      }
    }
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
        if (localObject2.getClass() != _beanType.getRawClass())
        {
          paramJsonParser = handlePolymorphic(paramJsonParser, paramDeserializationContext, localObject2, (TokenBuffer)localObject1);
          return paramJsonParser;
        }
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, _beanType.getRawClass(), (String)localObject4, paramDeserializationContext);
        localObject3 = localObject1;
      }
      for (;;)
      {
        localObject4 = paramJsonParser.nextToken();
        localObject1 = localObject3;
        break;
        localObject4 = localObject3;
        if (localObject1 != null) {
          localObject4 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
        }
        return _deserialize(paramJsonParser, paramDeserializationContext, localObject4);
        localObject3 = localObject1;
        if (!localPropertyValueBuffer.readIdProperty((String)localObject4))
        {
          localObject3 = _beanProperties.find((String)localObject4);
          if (localObject3 != null)
          {
            localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, ((SettableBeanProperty)localObject3).deserialize(paramJsonParser, paramDeserializationContext));
            localObject3 = localObject1;
          }
          else if ((_ignorableProps != null) && (_ignorableProps.contains(localObject4)))
          {
            handleIgnoredProperty(paramJsonParser, paramDeserializationContext, handledType(), (String)localObject4);
            localObject3 = localObject1;
          }
          else if (_anySetter != null)
          {
            localPropertyValueBuffer.bufferAnyProperty(_anySetter, (String)localObject4, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
            localObject3 = localObject1;
          }
          else
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new TokenBuffer(paramJsonParser, paramDeserializationContext);
            }
            ((TokenBuffer)localObject3).writeFieldName((String)localObject4);
            ((TokenBuffer)localObject3).copyCurrentStructure(paramJsonParser);
          }
        }
      }
      try
      {
        localObject3 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
        paramJsonParser = (JsonParser)localObject3;
        if (localObject1 != null) {
          if (localObject3.getClass() != _beanType.getRawClass()) {
            return handlePolymorphic(null, paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
          }
        }
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
        return null;
      }
    }
    return handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
  }
  
  protected BeanAsArrayBuilderDeserializer asArrayDeserializer()
  {
    return new BeanAsArrayBuilderDeserializer(this, _beanProperties.getPropertiesInInsertionOrder(), _buildMethod);
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      localJsonToken = paramJsonParser.nextToken();
      if (_vanillaProcessing) {
        return finishBuild(paramDeserializationContext, vanillaDeserialize(paramJsonParser, paramDeserializationContext, localJsonToken));
      }
      return finishBuild(paramDeserializationContext, deserializeFromObject(paramJsonParser, paramDeserializationContext));
    }
    switch (localJsonToken)
    {
    default: 
      throw paramDeserializationContext.mappingException(handledType());
    case ???: 
      return finishBuild(paramDeserializationContext, deserializeFromString(paramJsonParser, paramDeserializationContext));
    case ???: 
      return finishBuild(paramDeserializationContext, deserializeFromNumber(paramJsonParser, paramDeserializationContext));
    case ???: 
      return finishBuild(paramDeserializationContext, deserializeFromDouble(paramJsonParser, paramDeserializationContext));
    case ???: 
      return paramJsonParser.getEmbeddedObject();
    case ???: 
    case ???: 
      return finishBuild(paramDeserializationContext, deserializeFromBoolean(paramJsonParser, paramDeserializationContext));
    case ???: 
      return finishBuild(paramDeserializationContext, deserializeFromArray(paramJsonParser, paramDeserializationContext));
    }
    return finishBuild(paramDeserializationContext, deserializeFromObject(paramJsonParser, paramDeserializationContext));
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    return finishBuild(paramDeserializationContext, _deserialize(paramJsonParser, paramDeserializationContext, paramObject));
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_nonStandardCreation) {
      if (_unwrappedPropertyHandler != null) {
        localObject2 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext);
      }
    }
    Object localObject1;
    do
    {
      return localObject2;
      if (_externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext);
      }
      return deserializeFromObjectUsingNonDefault(paramJsonParser, paramDeserializationContext);
      localObject2 = _valueInstantiator.createUsingDefault(paramDeserializationContext);
      if (_injectables != null) {
        injectValues(paramDeserializationContext, localObject2);
      }
      localObject1 = localObject2;
      if (_needViewProcesing)
      {
        localObject3 = paramDeserializationContext.getActiveView();
        localObject1 = localObject2;
        if (localObject3 != null) {
          return deserializeWithView(paramJsonParser, paramDeserializationContext, localObject2, (Class)localObject3);
        }
      }
      localObject2 = localObject1;
    } while (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT);
    Object localObject3 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    Object localObject2 = _beanProperties.find((String)localObject3);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = ((SettableBeanProperty)localObject2).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, localObject1);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, localObject1, (String)localObject3, paramDeserializationContext);
        continue;
      }
      paramJsonParser.nextToken();
      break;
      handleUnknownVanilla(paramJsonParser, paramDeserializationContext, localObject1, (String)localObject3);
    }
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    throw new IllegalStateException("Deserialization with Builder, External type id, @JsonCreator not yet implemented");
  }
  
  protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, _objectIdReader);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = localPropertyBasedCreator.findCreatorProperty(str);
      Object localObject3;
      if (localObject1 != null) {
        if (localPropertyValueBuffer.assignParameter((SettableBeanProperty)localObject1, ((SettableBeanProperty)localObject1).deserialize(paramJsonParser, paramDeserializationContext)))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
              continue;
              localObject2 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, _beanType.getRawClass(), str, paramDeserializationContext);
          }
        }
      }
      for (;;)
      {
        break;
        localTokenBuffer.writeEndObject();
        if (localObject3.getClass() != _beanType.getRawClass()) {
          throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
        }
        return _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject3, localTokenBuffer);
        if (!localPropertyValueBuffer.readIdProperty(str))
        {
          localObject2 = _beanProperties.find(str);
          if (localObject2 != null)
          {
            localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject2, ((SettableBeanProperty)localObject2).deserialize(paramJsonParser, paramDeserializationContext));
          }
          else if ((_ignorableProps != null) && (_ignorableProps.contains(str)))
          {
            handleIgnoredProperty(paramJsonParser, paramDeserializationContext, handledType(), str);
          }
          else
          {
            localTokenBuffer.writeFieldName(str);
            localTokenBuffer.copyCurrentStructure(paramJsonParser);
            if (_anySetter != null) {
              localPropertyValueBuffer.bufferAnyProperty(_anySetter, str, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
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
    throws IOException, JsonProcessingException
  {
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithExternalTypeId(paramJsonParser, paramDeserializationContext);
    }
    return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, _valueInstantiator.createUsingDefault(paramDeserializationContext));
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    Class localClass;
    ExternalTypeHandler localExternalTypeHandler;
    label22:
    String str;
    Object localObject1;
    if (_needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      localExternalTypeHandler = _externalTypeIdHandler.start();
      if (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
        break label238;
      }
      str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = _beanProperties.find(str);
      if (localObject1 == null) {
        break label130;
      }
      if ((localClass == null) || (((SettableBeanProperty)localObject1).visibleInView(localClass))) {
        break label99;
      }
      paramJsonParser.skipChildren();
      localObject1 = paramObject;
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      paramObject = localObject1;
      break label22;
      localClass = null;
      break;
      label99:
      Object localObject2;
      try
      {
        localObject1 = ((SettableBeanProperty)localObject1).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, paramObject, str, paramDeserializationContext);
        localObject2 = paramObject;
      }
      continue;
      label130:
      if ((_ignorableProps != null) && (_ignorableProps.contains(str)))
      {
        handleIgnoredProperty(paramJsonParser, paramDeserializationContext, paramObject, str);
        localObject2 = paramObject;
      }
      else
      {
        localObject2 = paramObject;
        if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, paramObject))
        {
          Object localObject3;
          if (_anySetter != null)
          {
            try
            {
              _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, str);
              localObject2 = paramObject;
            }
            catch (Exception localException2)
            {
              wrapAndThrow(localException2, paramObject, str, paramDeserializationContext);
              localObject3 = paramObject;
            }
          }
          else
          {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, str);
            localObject3 = paramObject;
          }
        }
      }
    }
    label238:
    return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(paramDeserializationContext, _delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(paramJsonParser, paramDeserializationContext);
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    Object localObject1 = _valueInstantiator.createUsingDefault(paramDeserializationContext);
    if (_injectables != null) {
      injectValues(paramDeserializationContext, localObject1);
    }
    Class localClass;
    String str;
    Object localObject2;
    if (_needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      if (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
        break label301;
      }
      str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject2 = _beanProperties.find(str);
      if (localObject2 == null) {
        break label201;
      }
      if ((localClass == null) || (((SettableBeanProperty)localObject2).visibleInView(localClass))) {
        break label167;
      }
      paramJsonParser.skipChildren();
      localObject2 = localObject1;
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      localObject1 = localObject2;
      break;
      localClass = null;
      break;
      label167:
      Object localObject3;
      try
      {
        localObject2 = ((SettableBeanProperty)localObject2).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, localObject1);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, localObject1, str, paramDeserializationContext);
        localObject3 = localObject1;
      }
      continue;
      label201:
      if ((_ignorableProps != null) && (_ignorableProps.contains(str)))
      {
        handleIgnoredProperty(paramJsonParser, paramDeserializationContext, localObject1, str);
        localObject3 = localObject1;
      }
      else
      {
        localTokenBuffer.writeFieldName(str);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        localObject3 = localObject1;
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject1, str);
            localObject3 = localObject1;
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, localObject1, str, paramDeserializationContext);
            Object localObject4 = localObject1;
          }
        }
      }
    }
    label301:
    localTokenBuffer.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject1, localTokenBuffer);
    return localObject1;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartObject();
    Object localObject3;
    if (_needViewProcesing)
    {
      localObject2 = paramDeserializationContext.getActiveView();
      if (localObject1 != JsonToken.FIELD_NAME) {
        break label235;
      }
      localObject1 = paramJsonParser.getCurrentName();
      localObject3 = _beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localObject3 == null) {
        break label160;
      }
      if ((localObject2 == null) || (((SettableBeanProperty)localObject3).visibleInView((Class)localObject2))) {
        break label129;
      }
      paramJsonParser.skipChildren();
      localObject3 = paramObject;
    }
    for (;;)
    {
      localObject1 = paramJsonParser.nextToken();
      paramObject = localObject3;
      break;
      localObject2 = null;
      break;
      label129:
      Object localObject4;
      try
      {
        localObject3 = ((SettableBeanProperty)localObject3).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
        localObject4 = paramObject;
      }
      continue;
      label160:
      if ((_ignorableProps != null) && (_ignorableProps.contains(localObject1)))
      {
        handleIgnoredProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
        localObject4 = paramObject;
      }
      else
      {
        localTokenBuffer.writeFieldName((String)localObject1);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        localObject4 = paramObject;
        if (_anySetter != null)
        {
          _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
          localObject4 = paramObject;
        }
      }
    }
    label235:
    localTokenBuffer.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, paramObject, localTokenBuffer);
    return paramObject;
  }
  
  protected final Object deserializeWithView(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, Class<?> paramClass)
    throws IOException, JsonProcessingException
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject = _beanProperties.find(str);
      if (localObject != null) {
        if (!((SettableBeanProperty)localObject).visibleInView(paramClass)) {
          paramJsonParser.skipChildren();
        }
      }
      for (;;)
      {
        localObject = paramJsonParser.nextToken();
        break;
        try
        {
          localObject = ((SettableBeanProperty)localObject).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
          paramObject = localObject;
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramObject, str, paramDeserializationContext);
        }
        continue;
        handleUnknownVanilla(paramJsonParser, paramDeserializationContext, paramObject, str);
      }
    }
    return paramObject;
  }
  
  protected final Object finishBuild(DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    if (_buildMethod == null) {
      return paramObject;
    }
    try
    {
      paramObject = _buildMethod.getMember().invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      wrapInstantiationProblem((Throwable)paramObject, paramDeserializationContext);
    }
    return null;
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer)
  {
    return new BuilderBasedDeserializer(this, paramNameTransformer);
  }
  
  public BuilderBasedDeserializer withIgnorableProperties(HashSet<String> paramHashSet)
  {
    return new BuilderBasedDeserializer(this, paramHashSet);
  }
  
  public BuilderBasedDeserializer withObjectIdReader(ObjectIdReader paramObjectIdReader)
  {
    return new BuilderBasedDeserializer(this, paramObjectIdReader);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */