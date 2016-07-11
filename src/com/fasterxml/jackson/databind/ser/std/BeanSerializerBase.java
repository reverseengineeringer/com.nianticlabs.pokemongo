package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class BeanSerializerBase
  extends StdSerializer<Object>
  implements ContextualSerializer, ResolvableSerializer, JsonFormatVisitable, SchemaAware
{
  protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
  protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
  protected final AnyGetterWriter _anyGetterWriter;
  protected final BeanPropertyWriter[] _filteredProps;
  protected final ObjectIdWriter _objectIdWriter;
  protected final Object _propertyFilterId;
  protected final BeanPropertyWriter[] _props;
  protected final JsonFormat.Shape _serializationShape;
  protected final AnnotatedMember _typeId;
  
  protected BeanSerializerBase(JavaType paramJavaType, BeanSerializerBuilder paramBeanSerializerBuilder, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2)
  {
    super(paramJavaType);
    _props = paramArrayOfBeanPropertyWriter1;
    _filteredProps = paramArrayOfBeanPropertyWriter2;
    if (paramBeanSerializerBuilder == null)
    {
      _typeId = null;
      _anyGetterWriter = null;
      _propertyFilterId = null;
      _objectIdWriter = null;
      _serializationShape = null;
      return;
    }
    _typeId = paramBeanSerializerBuilder.getTypeId();
    _anyGetterWriter = paramBeanSerializerBuilder.getAnyGetter();
    _propertyFilterId = paramBeanSerializerBuilder.getFilterId();
    _objectIdWriter = paramBeanSerializerBuilder.getObjectIdWriter();
    paramJavaType = paramBeanSerializerBuilder.getBeanDescription().findExpectedFormat(null);
    if (paramJavaType == null) {}
    for (paramJavaType = (JavaType)localObject;; paramJavaType = paramJavaType.getShape())
    {
      _serializationShape = paramJavaType;
      return;
    }
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase)
  {
    this(paramBeanSerializerBase, _props, _filteredProps);
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter)
  {
    this(paramBeanSerializerBase, paramObjectIdWriter, _propertyFilterId);
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter, Object paramObject)
  {
    super(_handledType);
    _props = _props;
    _filteredProps = _filteredProps;
    _typeId = _typeId;
    _anyGetterWriter = _anyGetterWriter;
    _objectIdWriter = paramObjectIdWriter;
    _propertyFilterId = paramObject;
    _serializationShape = _serializationShape;
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, NameTransformer paramNameTransformer)
  {
    this(paramBeanSerializerBase, rename(_props, paramNameTransformer), rename(_filteredProps, paramNameTransformer));
  }
  
  public BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2)
  {
    super(_handledType);
    _props = paramArrayOfBeanPropertyWriter1;
    _filteredProps = paramArrayOfBeanPropertyWriter2;
    _typeId = _typeId;
    _anyGetterWriter = _anyGetterWriter;
    _objectIdWriter = _objectIdWriter;
    _propertyFilterId = _propertyFilterId;
    _serializationShape = _serializationShape;
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, String[] paramArrayOfString)
  {
    super(_handledType);
    HashSet localHashSet = ArrayBuilders.arrayToSet(paramArrayOfString);
    BeanPropertyWriter[] arrayOfBeanPropertyWriter1 = _props;
    BeanPropertyWriter[] arrayOfBeanPropertyWriter2 = _filteredProps;
    int j = arrayOfBeanPropertyWriter1.length;
    ArrayList localArrayList = new ArrayList(j);
    int i;
    label54:
    BeanPropertyWriter localBeanPropertyWriter;
    if (arrayOfBeanPropertyWriter2 == null)
    {
      paramArrayOfString = null;
      i = 0;
      if (i >= j) {
        break label124;
      }
      localBeanPropertyWriter = arrayOfBeanPropertyWriter1[i];
      if (!localHashSet.contains(localBeanPropertyWriter.getName())) {
        break label99;
      }
    }
    for (;;)
    {
      i += 1;
      break label54;
      paramArrayOfString = new ArrayList(j);
      break;
      label99:
      localArrayList.add(localBeanPropertyWriter);
      if (arrayOfBeanPropertyWriter2 != null) {
        paramArrayOfString.add(arrayOfBeanPropertyWriter2[i]);
      }
    }
    label124:
    _props = ((BeanPropertyWriter[])localArrayList.toArray(new BeanPropertyWriter[localArrayList.size()]));
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = (String[])localObject;; paramArrayOfString = (BeanPropertyWriter[])paramArrayOfString.toArray(new BeanPropertyWriter[paramArrayOfString.size()]))
    {
      _filteredProps = paramArrayOfString;
      _typeId = _typeId;
      _anyGetterWriter = _anyGetterWriter;
      _objectIdWriter = _objectIdWriter;
      _propertyFilterId = _propertyFilterId;
      _serializationShape = _serializationShape;
      return;
    }
  }
  
  private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] paramArrayOfBeanPropertyWriter, NameTransformer paramNameTransformer)
  {
    Object localObject;
    if ((paramArrayOfBeanPropertyWriter == null) || (paramArrayOfBeanPropertyWriter.length == 0) || (paramNameTransformer == null) || (paramNameTransformer == NameTransformer.NOP))
    {
      localObject = paramArrayOfBeanPropertyWriter;
      return (BeanPropertyWriter[])localObject;
    }
    int j = paramArrayOfBeanPropertyWriter.length;
    BeanPropertyWriter[] arrayOfBeanPropertyWriter = new BeanPropertyWriter[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfBeanPropertyWriter;
      if (i >= j) {
        break;
      }
      localObject = paramArrayOfBeanPropertyWriter[i];
      if (localObject != null) {
        arrayOfBeanPropertyWriter[i] = ((BeanPropertyWriter)localObject).rename(paramNameTransformer);
      }
      i += 1;
    }
  }
  
  protected final String _customTypeId(Object paramObject)
  {
    paramObject = _typeId.getValue(paramObject);
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.toString();
  }
  
  protected void _serializeObjectId(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer, WritableObjectId paramWritableObjectId)
    throws IOException
  {
    ObjectIdWriter localObjectIdWriter = _objectIdWriter;
    String str;
    if (_typeId == null)
    {
      str = null;
      if (str != null) {
        break label74;
      }
      paramTypeSerializer.writeTypePrefixForObject(paramObject, paramJsonGenerator);
      label28:
      paramWritableObjectId.writeAsField(paramJsonGenerator, paramSerializerProvider, localObjectIdWriter);
      if (_propertyFilterId == null) {
        break label86;
      }
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      if (str != null) {
        break label96;
      }
      paramTypeSerializer.writeTypeSuffixForObject(paramObject, paramJsonGenerator);
      return;
      str = _customTypeId(paramObject);
      break;
      label74:
      paramTypeSerializer.writeCustomTypePrefixForObject(paramObject, paramJsonGenerator, str);
      break label28;
      label86:
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    label96:
    paramTypeSerializer.writeCustomTypeSuffixForObject(paramObject, paramJsonGenerator, str);
  }
  
  protected final void _serializeWithObjectId(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    ObjectIdWriter localObjectIdWriter = _objectIdWriter;
    WritableObjectId localWritableObjectId = paramSerializerProvider.findObjectId(paramObject, generator);
    if (localWritableObjectId.writeAsId(paramJsonGenerator, paramSerializerProvider, localObjectIdWriter)) {
      return;
    }
    Object localObject = localWritableObjectId.generateId(paramObject);
    if (alwaysAsId)
    {
      serializer.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _serializeObjectId(paramObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer, localWritableObjectId);
  }
  
  protected final void _serializeWithObjectId(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, boolean paramBoolean)
    throws IOException
  {
    ObjectIdWriter localObjectIdWriter = _objectIdWriter;
    WritableObjectId localWritableObjectId = paramSerializerProvider.findObjectId(paramObject, generator);
    if (localWritableObjectId.writeAsId(paramJsonGenerator, paramSerializerProvider, localObjectIdWriter)) {}
    for (;;)
    {
      return;
      Object localObject = localWritableObjectId.generateId(paramObject);
      if (alwaysAsId)
      {
        serializer.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
        return;
      }
      if (paramBoolean) {
        paramJsonGenerator.writeStartObject();
      }
      localWritableObjectId.writeAsField(paramJsonGenerator, paramSerializerProvider, localObjectIdWriter);
      if (_propertyFilterId != null) {
        serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
      }
      while (paramBoolean)
      {
        paramJsonGenerator.writeEndObject();
        return;
        serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper == null) {}
    for (;;)
    {
      return;
      paramJavaType = paramJsonFormatVisitorWrapper.expectObjectFormat(paramJavaType);
      if (paramJavaType != null)
      {
        int i;
        if (_propertyFilterId != null)
        {
          PropertyFilter localPropertyFilter = findPropertyFilter(paramJsonFormatVisitorWrapper.getProvider(), _propertyFilterId, null);
          i = 0;
          while (i < _props.length)
          {
            localPropertyFilter.depositSchemaProperty(_props[i], paramJavaType, paramJsonFormatVisitorWrapper.getProvider());
            i += 1;
          }
        }
        else
        {
          i = 0;
          while (i < _props.length)
          {
            _props[i].depositSchemaProperty(paramJavaType);
            i += 1;
          }
        }
      }
    }
  }
  
  protected abstract BeanSerializerBase asArraySerializer();
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializerProvider.getAnnotationIntrospector();
    Object localObject3;
    Object localObject5;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject7;
    Object localObject6;
    String[] arrayOfString;
    if ((paramBeanProperty == null) || (localAnnotationIntrospector == null))
    {
      localObject3 = null;
      localObject5 = paramSerializerProvider.getConfig();
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = localAnnotationIntrospector.findFormat((Annotated)localObject3);
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject1 = ((JsonFormat.Value)localObject4).getShape();
          localObject2 = localObject1;
          if (localObject1 != _serializationShape)
          {
            localObject2 = localObject1;
            if (!_handledType.isEnum()) {}
          }
        }
      }
      switch (localObject1)
      {
      default: 
        localObject2 = localObject1;
        ObjectIdWriter localObjectIdWriter = _objectIdWriter;
        localObject5 = null;
        localObject7 = null;
        localObject4 = localObject7;
        localObject6 = localObjectIdWriter;
        if (localObject3 != null)
        {
          arrayOfString = localAnnotationIntrospector.findPropertiesToIgnore((Annotated)localObject3, true);
          localObject1 = localAnnotationIntrospector.findObjectIdInfo((Annotated)localObject3);
          if (localObject1 != null) {
            break label453;
          }
          localObject1 = localObjectIdWriter;
          if (localObjectIdWriter != null)
          {
            localObject1 = localAnnotationIntrospector.findObjectReferenceInfo((Annotated)localObject3, new ObjectIdInfo(NAME_FOR_OBJECT_REF, null, null, null));
            localObject1 = _objectIdWriter.withAlwaysAsId(((ObjectIdInfo)localObject1).getAlwaysAsId());
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject3 = localAnnotationIntrospector.findFilterId((Annotated)localObject3);
      localObject5 = arrayOfString;
      localObject4 = localObject7;
      localObject6 = localObject1;
      if (localObject3 != null) {
        if (_propertyFilterId != null)
        {
          localObject5 = arrayOfString;
          localObject4 = localObject7;
          localObject6 = localObject1;
          if (localObject3.equals(_propertyFilterId)) {}
        }
        else
        {
          localObject4 = localObject3;
          localObject6 = localObject1;
          localObject5 = arrayOfString;
        }
      }
      localObject3 = this;
      localObject1 = localObject3;
      if (localObject6 != null)
      {
        paramSerializerProvider = ((ObjectIdWriter)localObject6).withSerializer(paramSerializerProvider.findValueSerializer(idType, paramBeanProperty));
        localObject1 = localObject3;
        if (paramSerializerProvider != _objectIdWriter) {
          localObject1 = ((BeanSerializerBase)localObject3).withObjectIdWriter(paramSerializerProvider);
        }
      }
      paramBeanProperty = (BeanProperty)localObject1;
      if (localObject5 != null)
      {
        paramBeanProperty = (BeanProperty)localObject1;
        if (localObject5.length != 0) {
          paramBeanProperty = ((BeanSerializerBase)localObject1).withIgnorals((String[])localObject5);
        }
      }
      paramSerializerProvider = paramBeanProperty;
      if (localObject4 != null) {
        paramSerializerProvider = paramBeanProperty.withFilterId(localObject4);
      }
      paramBeanProperty = (BeanProperty)localObject2;
      if (localObject2 == null) {
        paramBeanProperty = _serializationShape;
      }
      localObject1 = paramSerializerProvider;
      if (paramBeanProperty == JsonFormat.Shape.ARRAY) {
        localObject1 = paramSerializerProvider.asArraySerializer();
      }
      return (JsonSerializer<?>)localObject1;
      localObject3 = paramBeanProperty.getMember();
      break;
      localObject1 = ((SerializationConfig)localObject5).introspectClassAnnotations(_handledType);
      return paramSerializerProvider.handlePrimaryContextualization(EnumSerializer.construct(_handledType, paramSerializerProvider.getConfig(), (BeanDescription)localObject1, (JsonFormat.Value)localObject4), paramBeanProperty);
      label453:
      localObject1 = localAnnotationIntrospector.findObjectReferenceInfo((Annotated)localObject3, (ObjectIdInfo)localObject1);
      localObject4 = ((ObjectIdInfo)localObject1).getGeneratorType();
      localObject5 = paramSerializerProvider.constructType((Type)localObject4);
      localObject5 = paramSerializerProvider.getTypeFactory().findTypeParameters(localObject5, ObjectIdGenerator.class)[0];
      if (localObject4 == ObjectIdGenerators.PropertyGenerator.class)
      {
        localObject5 = ((ObjectIdInfo)localObject1).getPropertyName().getSimpleName();
        int i = 0;
        int j = _props.length;
        for (;;)
        {
          if (i == j) {
            throw new IllegalArgumentException("Invalid Object Id definition for " + _handledType.getName() + ": can not find property with name '" + (String)localObject5 + "'");
          }
          localObject4 = _props[i];
          if (((String)localObject5).equals(((BeanPropertyWriter)localObject4).getName()))
          {
            if (i > 0)
            {
              System.arraycopy(_props, 0, _props, 1, i);
              _props[0] = localObject4;
              if (_filteredProps != null)
              {
                localObject5 = _filteredProps[i];
                System.arraycopy(_filteredProps, 0, _filteredProps, 1, i);
                _filteredProps[0] = localObject5;
              }
            }
            localObject5 = ((BeanPropertyWriter)localObject4).getType();
            localObject4 = new PropertyBasedObjectIdGenerator((ObjectIdInfo)localObject1, (BeanPropertyWriter)localObject4);
            localObject1 = ObjectIdWriter.construct((JavaType)localObject5, (PropertyName)null, (ObjectIdGenerator)localObject4, ((ObjectIdInfo)localObject1).getAlwaysAsId());
            break;
          }
          i += 1;
        }
      }
      localObject4 = paramSerializerProvider.objectIdGeneratorInstance((Annotated)localObject3, (ObjectIdInfo)localObject1);
      localObject1 = ObjectIdWriter.construct((JavaType)localObject5, ((ObjectIdInfo)localObject1).getPropertyName(), (ObjectIdGenerator)localObject4, ((ObjectIdInfo)localObject1).getAlwaysAsId());
    }
  }
  
  protected JsonSerializer<Object> findConvertingSerializer(SerializerProvider paramSerializerProvider, BeanPropertyWriter paramBeanPropertyWriter)
    throws JsonMappingException
  {
    JavaType localJavaType = null;
    Object localObject2 = null;
    Object localObject3 = paramSerializerProvider.getAnnotationIntrospector();
    Object localObject1 = localJavaType;
    if (localObject3 != null)
    {
      AnnotatedMember localAnnotatedMember = paramBeanPropertyWriter.getMember();
      localObject1 = localJavaType;
      if (localAnnotatedMember != null)
      {
        localObject3 = ((AnnotationIntrospector)localObject3).findSerializationConverter(localAnnotatedMember);
        localObject1 = localJavaType;
        if (localObject3 != null)
        {
          localObject1 = paramSerializerProvider.converterInstance(paramBeanPropertyWriter.getMember(), localObject3);
          localJavaType = ((Converter)localObject1).getOutputType(paramSerializerProvider.getTypeFactory());
          if (!localJavaType.isJavaLangObject()) {
            break label99;
          }
        }
      }
    }
    label99:
    for (paramSerializerProvider = (SerializerProvider)localObject2;; paramSerializerProvider = paramSerializerProvider.findValueSerializer(localJavaType, paramBeanPropertyWriter))
    {
      localObject1 = new StdDelegatingSerializer((Converter)localObject1, localJavaType, paramSerializerProvider);
      return (JsonSerializer<Object>)localObject1;
    }
  }
  
  @Deprecated
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    ObjectNode localObjectNode1 = createSchemaNode("object", true);
    paramType = (JsonSerializableSchema)_handledType.getAnnotation(JsonSerializableSchema.class);
    if (paramType != null)
    {
      paramType = paramType.id();
      if ((paramType != null) && (paramType.length() > 0)) {
        localObjectNode1.put("id", paramType);
      }
    }
    ObjectNode localObjectNode2 = localObjectNode1.objectNode();
    int i;
    label83:
    BeanPropertyWriter localBeanPropertyWriter;
    if (_propertyFilterId != null)
    {
      paramType = findPropertyFilter(paramSerializerProvider, _propertyFilterId, null);
      i = 0;
      if (i >= _props.length) {
        break label138;
      }
      localBeanPropertyWriter = _props[i];
      if (paramType != null) {
        break label124;
      }
      localBeanPropertyWriter.depositSchemaProperty(localObjectNode2, paramSerializerProvider);
    }
    for (;;)
    {
      i += 1;
      break label83;
      paramType = null;
      break;
      label124:
      paramType.depositSchemaProperty(localBeanPropertyWriter, localObjectNode2, paramSerializerProvider);
    }
    label138:
    localObjectNode1.set("properties", localObjectNode2);
    return localObjectNode1;
  }
  
  public Iterator<PropertyWriter> properties()
  {
    return Arrays.asList(_props).iterator();
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    int i;
    int j;
    label18:
    BeanPropertyWriter localBeanPropertyWriter;
    Object localObject1;
    Object localObject2;
    if (_filteredProps == null)
    {
      i = 0;
      j = 0;
      int k = _props.length;
      if (j >= k) {
        break label303;
      }
      localBeanPropertyWriter = _props[j];
      if ((!localBeanPropertyWriter.willSuppressNulls()) && (!localBeanPropertyWriter.hasNullSerializer()))
      {
        localObject1 = paramSerializerProvider.findNullValueSerializer(localBeanPropertyWriter);
        if (localObject1 != null)
        {
          localBeanPropertyWriter.assignNullSerializer((JsonSerializer)localObject1);
          if (j < i)
          {
            localObject2 = _filteredProps[j];
            if (localObject2 != null) {
              ((BeanPropertyWriter)localObject2).assignNullSerializer((JsonSerializer)localObject1);
            }
          }
        }
      }
      if (!localBeanPropertyWriter.hasSerializer()) {
        break label117;
      }
    }
    for (;;)
    {
      j += 1;
      break label18;
      i = _filteredProps.length;
      break;
      label117:
      localObject2 = findConvertingSerializer(paramSerializerProvider, localBeanPropertyWriter);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localBeanPropertyWriter.getSerializationType();
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = paramSerializerProvider.constructType(localBeanPropertyWriter.getGenericPropertyType());
          localObject2 = localObject1;
          if (!((JavaType)localObject1).isFinal())
          {
            if ((!((JavaType)localObject1).isContainerType()) && (((JavaType)localObject1).containedTypeCount() <= 0)) {
              continue;
            }
            localBeanPropertyWriter.setNonTrivialBaseType((JavaType)localObject1);
            continue;
          }
        }
        JsonSerializer localJsonSerializer = paramSerializerProvider.findValueSerializer((JavaType)localObject2, localBeanPropertyWriter);
        localObject1 = localJsonSerializer;
        if (((JavaType)localObject2).isContainerType())
        {
          localObject2 = (TypeSerializer)((JavaType)localObject2).getContentType().getTypeHandler();
          localObject1 = localJsonSerializer;
          if (localObject2 != null)
          {
            localObject1 = localJsonSerializer;
            if ((localJsonSerializer instanceof ContainerSerializer)) {
              localObject1 = ((ContainerSerializer)localJsonSerializer).withValueTypeSerializer((TypeSerializer)localObject2);
            }
          }
        }
      }
      localBeanPropertyWriter.assignSerializer((JsonSerializer)localObject1);
      if (j < i)
      {
        localObject2 = _filteredProps[j];
        if (localObject2 != null) {
          ((BeanPropertyWriter)localObject2).assignSerializer((JsonSerializer)localObject1);
        }
      }
    }
    label303:
    if (_anyGetterWriter != null) {
      _anyGetterWriter.resolve(paramSerializerProvider);
    }
  }
  
  public abstract void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  protected void serializeFields(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    if ((_filteredProps != null) && (paramSerializerProvider.getActiveView() != null)) {
      arrayOfBeanPropertyWriter = _filteredProps;
    }
    int k;
    for (;;)
    {
      int j = 0;
      k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        for (;;)
        {
          if (i < m)
          {
            BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
            if (localBeanPropertyWriter != null)
            {
              j = i;
              k = i;
              localBeanPropertyWriter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
            }
            i += 1;
            continue;
            arrayOfBeanPropertyWriter = _props;
            break;
          }
        }
        j = i;
        k = i;
        if (_anyGetterWriter != null)
        {
          j = i;
          k = i;
          _anyGetterWriter.getAndSerialize(paramObject, paramJsonGenerator, paramSerializerProvider);
        }
        return;
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          return;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)", paramJsonGenerator);
        if (k != arrayOfBeanPropertyWriter.length) {}
      }
    }
    for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName())
    {
      paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
      throw paramSerializerProvider;
    }
  }
  
  protected void serializeFieldsFiltered(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    PropertyFilter localPropertyFilter;
    if ((_filteredProps != null) && (paramSerializerProvider.getActiveView() != null))
    {
      arrayOfBeanPropertyWriter = _filteredProps;
      localPropertyFilter = findPropertyFilter(paramSerializerProvider, _propertyFilterId, paramObject);
      if (localPropertyFilter != null) {
        break label54;
      }
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      return;
      arrayOfBeanPropertyWriter = _props;
      break;
      label54:
      int j = 0;
      int k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        if (i < m)
        {
          BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
          if (localBeanPropertyWriter != null)
          {
            j = i;
            k = i;
            localPropertyFilter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider, localBeanPropertyWriter);
          }
        }
        else
        {
          j = i;
          k = i;
          if (_anyGetterWriter == null) {
            continue;
          }
          j = i;
          k = i;
          _anyGetterWriter.getAndFilter(paramObject, paramJsonGenerator, paramSerializerProvider, localPropertyFilter);
          return;
        }
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          return;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        for (;;)
        {
          paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)", paramJsonGenerator);
          if (k == arrayOfBeanPropertyWriter.length) {}
          for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName())
          {
            paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
            throw paramSerializerProvider;
          }
          i += 1;
        }
      }
    }
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    if (_objectIdWriter != null)
    {
      paramJsonGenerator.setCurrentValue(paramObject);
      _serializeWithObjectId(paramObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
      return;
    }
    String str;
    if (_typeId == null)
    {
      str = null;
      if (str != null) {
        break label86;
      }
      paramTypeSerializer.writeTypePrefixForObject(paramObject, paramJsonGenerator);
      label44:
      paramJsonGenerator.setCurrentValue(paramObject);
      if (_propertyFilterId == null) {
        break label98;
      }
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      if (str != null) {
        break label108;
      }
      paramTypeSerializer.writeTypeSuffixForObject(paramObject, paramJsonGenerator);
      return;
      str = _customTypeId(paramObject);
      break;
      label86:
      paramTypeSerializer.writeCustomTypePrefixForObject(paramObject, paramJsonGenerator, str);
      break label44;
      label98:
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    label108:
    paramTypeSerializer.writeCustomTypeSuffixForObject(paramObject, paramJsonGenerator, str);
  }
  
  public boolean usesObjectId()
  {
    return _objectIdWriter != null;
  }
  
  public abstract BeanSerializerBase withFilterId(Object paramObject);
  
  protected abstract BeanSerializerBase withIgnorals(String[] paramArrayOfString);
  
  public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter paramObjectIdWriter);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */