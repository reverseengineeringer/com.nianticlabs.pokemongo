package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class AsArraySerializerBase<T>
  extends ContainerSerializer<T>
  implements ContextualSerializer
{
  protected PropertySerializerMap _dynamicSerializers;
  protected final JsonSerializer<Object> _elementSerializer;
  protected final JavaType _elementType;
  protected final BeanProperty _property;
  protected final boolean _staticTyping;
  protected final Boolean _unwrapSingle;
  protected final TypeSerializer _valueTypeSerializer;
  
  @Deprecated
  protected AsArraySerializerBase(AsArraySerializerBase<?> paramAsArraySerializerBase, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    this(paramAsArraySerializerBase, paramBeanProperty, paramTypeSerializer, paramJsonSerializer, _unwrapSingle);
  }
  
  protected AsArraySerializerBase(AsArraySerializerBase<?> paramAsArraySerializerBase, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer, Boolean paramBoolean)
  {
    super(paramAsArraySerializerBase);
    _elementType = _elementType;
    _staticTyping = _staticTyping;
    _valueTypeSerializer = paramTypeSerializer;
    _property = paramBeanProperty;
    _elementSerializer = paramJsonSerializer;
    _dynamicSerializers = _dynamicSerializers;
    _unwrapSingle = paramBoolean;
  }
  
  @Deprecated
  protected AsArraySerializerBase(Class<?> paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramClass, false);
    _elementType = paramJavaType;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (paramJavaType != null)
      {
        paramBoolean = bool;
        if (!paramJavaType.isFinal()) {}
      }
    }
    else
    {
      paramBoolean = true;
    }
    _staticTyping = paramBoolean;
    _valueTypeSerializer = paramTypeSerializer;
    _property = paramBeanProperty;
    _elementSerializer = paramJsonSerializer;
    _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    _unwrapSingle = null;
  }
  
  protected AsArraySerializerBase(Class<?> paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramClass, false);
    _elementType = paramJavaType;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (paramJavaType != null)
      {
        paramBoolean = bool;
        if (!paramJavaType.isFinal()) {}
      }
    }
    else
    {
      paramBoolean = true;
    }
    _staticTyping = paramBoolean;
    _valueTypeSerializer = paramTypeSerializer;
    _property = null;
    _elementSerializer = paramJsonSerializer;
    _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    _unwrapSingle = null;
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, JavaType paramJavaType, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    paramJavaType = paramPropertySerializerMap.findAndAddSecondarySerializer(paramJavaType, paramSerializerProvider, _property);
    if (paramPropertySerializerMap != map) {
      _dynamicSerializers = map;
    }
    return serializer;
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    paramClass = paramPropertySerializerMap.findAndAddSecondarySerializer(paramClass, paramSerializerProvider, _property);
    if (paramPropertySerializerMap != map) {
      _dynamicSerializers = map;
    }
    return serializer;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper == null) {}
    for (paramJavaType = null;; paramJavaType = paramJsonFormatVisitorWrapper.expectArrayFormat(paramJavaType))
    {
      if (paramJavaType != null)
      {
        JsonSerializer localJsonSerializer2 = _elementSerializer;
        JsonSerializer localJsonSerializer1 = localJsonSerializer2;
        if (localJsonSerializer2 == null) {
          localJsonSerializer1 = paramJsonFormatVisitorWrapper.getProvider().findValueSerializer(_elementType, _property);
        }
        paramJavaType.itemsFormat(localJsonSerializer1, _elementType);
      }
      return;
    }
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject1 = _valueTypeSerializer;
    Object localObject3 = localObject1;
    if (localObject1 != null) {
      localObject3 = ((TypeSerializer)localObject1).forProperty(paramBeanProperty);
    }
    Object localObject2 = null;
    JsonFormat.Value localValue = null;
    Object localObject5 = null;
    Object localObject4 = localObject5;
    if (paramBeanProperty != null)
    {
      localObject2 = paramSerializerProvider.getAnnotationIntrospector();
      localObject4 = paramBeanProperty.getMember();
      localObject1 = localValue;
      if (localObject4 != null)
      {
        Object localObject6 = ((AnnotationIntrospector)localObject2).findContentSerializer((Annotated)localObject4);
        localObject1 = localValue;
        if (localObject6 != null) {
          localObject1 = paramSerializerProvider.serializerInstance((Annotated)localObject4, localObject6);
        }
      }
      localValue = paramBeanProperty.findFormatOverrides((AnnotationIntrospector)localObject2);
      localObject2 = localObject1;
      localObject4 = localObject5;
      if (localValue != null)
      {
        localObject4 = localValue.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        localObject2 = localObject1;
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = _elementSerializer;
    }
    localObject2 = findConvertingContentSerializer(paramSerializerProvider, paramBeanProperty, (JsonSerializer)localObject1);
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (_elementType != null) {
        if ((!_staticTyping) || (_elementType.getRawClass() == Object.class))
        {
          localObject1 = localObject2;
          if (!hasContentTypeAnnotation(paramSerializerProvider, paramBeanProperty)) {
            break label197;
          }
        }
      }
    }
    for (localObject1 = paramSerializerProvider.findValueSerializer(_elementType, paramBeanProperty);; localObject1 = paramSerializerProvider.handleSecondaryContextualization((JsonSerializer)localObject2, paramBeanProperty))
    {
      label197:
      if ((localObject1 == _elementSerializer) && (paramBeanProperty == _property) && (_valueTypeSerializer == localObject3))
      {
        paramSerializerProvider = this;
        if (_unwrapSingle == localObject4) {}
      }
      else
      {
        paramSerializerProvider = withResolved(paramBeanProperty, (TypeSerializer)localObject3, (JsonSerializer)localObject1, (Boolean)localObject4);
      }
      return paramSerializerProvider;
    }
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return _elementSerializer;
  }
  
  public JavaType getContentType()
  {
    return _elementType;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    ObjectNode localObjectNode = createSchemaNode("array", true);
    Object localObject2 = _elementType;
    if (localObject2 != null)
    {
      Object localObject1 = null;
      paramType = (Type)localObject1;
      if (((JavaType)localObject2).getRawClass() != Object.class)
      {
        localObject2 = paramSerializerProvider.findValueSerializer((JavaType)localObject2, _property);
        paramType = (Type)localObject1;
        if ((localObject2 instanceof SchemaAware)) {
          paramType = ((SchemaAware)localObject2).getSchema(paramSerializerProvider, null);
        }
      }
      paramSerializerProvider = paramType;
      if (paramType == null) {
        paramSerializerProvider = JsonSchema.getDefaultSchemaNode();
      }
      localObjectNode.set("items", paramSerializerProvider);
    }
    return localObjectNode;
  }
  
  public void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if ((paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && (hasSingleElement(paramT)))
    {
      serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray();
    paramJsonGenerator.setCurrentValue(paramT);
    serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  protected abstract void serializeContents(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  public void serializeWithType(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    paramTypeSerializer.writeTypePrefixForArray(paramT, paramJsonGenerator);
    paramJsonGenerator.setCurrentValue(paramT);
    serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForArray(paramT, paramJsonGenerator);
  }
  
  @Deprecated
  public final AsArraySerializerBase<T> withResolved(BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    return withResolved(paramBeanProperty, paramTypeSerializer, paramJsonSerializer, _unwrapSingle);
  }
  
  public abstract AsArraySerializerBase<T> withResolved(BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer, Boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */