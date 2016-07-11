package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DefaultSerializerProvider
  extends SerializerProvider
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected transient ArrayList<ObjectIdGenerator<?>> _objectIdGenerators;
  protected transient Map<Object, WritableObjectId> _seenObjectIds;
  
  protected DefaultSerializerProvider() {}
  
  protected DefaultSerializerProvider(SerializerProvider paramSerializerProvider, SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    super(paramSerializerProvider, paramSerializationConfig, paramSerializerFactory);
  }
  
  protected DefaultSerializerProvider(DefaultSerializerProvider paramDefaultSerializerProvider)
  {
    super(paramDefaultSerializerProvider);
  }
  
  protected Map<Object, WritableObjectId> _createObjectIdMap()
  {
    if (isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID)) {
      return new HashMap();
    }
    return new IdentityHashMap();
  }
  
  protected void _serializeNull(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    Object localObject = getDefaultNullValueSerializer();
    try
    {
      ((JsonSerializer)localObject).serialize(null, paramJsonGenerator, this);
      return;
    }
    catch (IOException paramJsonGenerator)
    {
      throw paramJsonGenerator;
    }
    catch (Exception localException)
    {
      localObject = localException.getMessage();
      paramJsonGenerator = (JsonGenerator)localObject;
      if (localObject == null) {
        paramJsonGenerator = "[no message for " + localException.getClass().getName() + "]";
      }
      throw new JsonMappingException(paramJsonGenerator, localException);
    }
  }
  
  public void acceptJsonFormatVisitor(JavaType paramJavaType, JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper)
    throws JsonMappingException
  {
    if (paramJavaType == null) {
      throw new IllegalArgumentException("A class must be provided");
    }
    paramJsonFormatVisitorWrapper.setProvider(this);
    findValueSerializer(paramJavaType, null).acceptJsonFormatVisitor(paramJsonFormatVisitorWrapper, paramJavaType);
  }
  
  public int cachedSerializersCount()
  {
    return _serializerCache.size();
  }
  
  public DefaultSerializerProvider copy()
  {
    throw new IllegalStateException("DefaultSerializerProvider sub-class not overriding copy()");
  }
  
  public abstract DefaultSerializerProvider createInstance(SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory);
  
  public WritableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    if (_seenObjectIds == null) {
      _seenObjectIds = _createObjectIdMap();
    }
    Object localObject2;
    Object localObject1;
    do
    {
      localObject2 = null;
      if (_objectIdGenerators != null) {
        break;
      }
      _objectIdGenerators = new ArrayList(8);
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = paramObjectIdGenerator.newForSerialization(this);
        _objectIdGenerators.add(localObject2);
      }
      paramObjectIdGenerator = new WritableObjectId((ObjectIdGenerator)localObject2);
      _seenObjectIds.put(paramObject, paramObjectIdGenerator);
      return paramObjectIdGenerator;
      localObject1 = (WritableObjectId)_seenObjectIds.get(paramObject);
    } while (localObject1 == null);
    return (WritableObjectId)localObject1;
    int i = 0;
    int j = _objectIdGenerators.size();
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = (ObjectIdGenerator)_objectIdGenerators.get(i);
      if (((ObjectIdGenerator)localObject1).canUseFor(paramObjectIdGenerator)) {
        break;
      }
      i += 1;
    }
  }
  
  public void flushCachedSerializers()
  {
    _serializerCache.flush();
  }
  
  @Deprecated
  public JsonSchema generateJsonSchema(Class<?> paramClass)
    throws JsonMappingException
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("A class must be provided");
    }
    Object localObject = findValueSerializer(paramClass, null);
    if ((localObject instanceof SchemaAware)) {}
    for (localObject = ((SchemaAware)localObject).getSchema(this, null); !(localObject instanceof ObjectNode); localObject = JsonSchema.getDefaultSchemaNode()) {
      throw new IllegalArgumentException("Class " + paramClass.getName() + " would not be serialized as a JSON object and therefore has no schema");
    }
    return new JsonSchema((ObjectNode)localObject);
  }
  
  public boolean hasSerializerFor(Class<?> paramClass, AtomicReference<Throwable> paramAtomicReference)
  {
    boolean bool = false;
    try
    {
      paramClass = _findExplicitUntypedSerializer(paramClass);
      if (paramClass != null) {
        bool = true;
      }
    }
    catch (JsonMappingException paramClass)
    {
      while (paramAtomicReference == null) {}
      paramAtomicReference.set(paramClass);
      return false;
    }
    catch (RuntimeException paramClass)
    {
      if (paramAtomicReference != null) {
        break label35;
      }
      throw paramClass;
      label35:
      paramAtomicReference.set(paramClass);
    }
    return bool;
    return false;
  }
  
  public void serializePolymorphic(JsonGenerator paramJsonGenerator, Object paramObject, JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    if (paramObject == null) {
      _serializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      return;
      if ((paramJavaType != null) && (!paramJavaType.getRawClass().isAssignableFrom(paramObject.getClass()))) {
        _reportIncompatibleRootType(paramObject, paramJavaType);
      }
      Object localObject = paramJsonSerializer;
      boolean bool1;
      if (paramJsonSerializer == null)
      {
        if ((paramJavaType != null) && (paramJavaType.isContainerType())) {
          localObject = findValueSerializer(paramJavaType, null);
        }
      }
      else
      {
        paramJavaType = _config.getFullRootName();
        if (paramJavaType != null) {
          break label162;
        }
        boolean bool2 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        bool1 = bool2;
        if (bool2)
        {
          paramJsonGenerator.writeStartObject();
          paramJsonGenerator.writeFieldName(_config.findRootName(paramObject.getClass()).simpleAsEncoded(_config));
          bool1 = bool2;
        }
      }
      try
      {
        ((JsonSerializer)localObject).serializeWithType(paramObject, paramJsonGenerator, this, paramTypeSerializer);
        if (!bool1) {
          continue;
        }
        paramJsonGenerator.writeEndObject();
        return;
      }
      catch (IOException paramJsonGenerator)
      {
        for (;;)
        {
          throw paramJsonGenerator;
          localObject = findValueSerializer(paramObject.getClass(), null);
          break;
          if (paramJavaType.isEmpty())
          {
            bool1 = false;
          }
          else
          {
            bool1 = true;
            paramJsonGenerator.writeStartObject();
            paramJsonGenerator.writeFieldName(paramJavaType.getSimpleName());
          }
        }
      }
      catch (Exception paramJavaType)
      {
        label162:
        paramObject = paramJavaType.getMessage();
        paramJsonGenerator = (JsonGenerator)paramObject;
        if (paramObject == null) {
          paramJsonGenerator = "[no message for " + paramJavaType.getClass().getName() + "]";
        }
        throw new JsonMappingException(paramJsonGenerator, paramJavaType);
      }
    }
  }
  
  @Deprecated
  public void serializePolymorphic(JsonGenerator paramJsonGenerator, Object paramObject, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    if (paramObject == null) {}
    for (JavaType localJavaType = null;; localJavaType = _config.constructType(paramObject.getClass()))
    {
      serializePolymorphic(paramJsonGenerator, paramObject, localJavaType, null, paramTypeSerializer);
      return;
    }
  }
  
  public void serializeValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException
  {
    if (paramObject == null) {
      _serializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      return;
      JsonSerializer localJsonSerializer = findTypedValueSerializer(paramObject.getClass(), true, null);
      PropertyName localPropertyName = _config.getFullRootName();
      boolean bool1;
      if (localPropertyName == null)
      {
        boolean bool2 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        bool1 = bool2;
        if (bool2)
        {
          paramJsonGenerator.writeStartObject();
          paramJsonGenerator.writeFieldName(_config.findRootName(paramObject.getClass()).simpleAsEncoded(_config));
          bool1 = bool2;
        }
      }
      try
      {
        localJsonSerializer.serialize(paramObject, paramJsonGenerator, this);
        if (!bool1) {
          continue;
        }
        paramJsonGenerator.writeEndObject();
        return;
      }
      catch (IOException paramJsonGenerator)
      {
        for (;;)
        {
          throw paramJsonGenerator;
          if (localPropertyName.isEmpty())
          {
            bool1 = false;
          }
          else
          {
            bool1 = true;
            paramJsonGenerator.writeStartObject();
            paramJsonGenerator.writeFieldName(localPropertyName.getSimpleName());
          }
        }
      }
      catch (Exception localException)
      {
        paramObject = localException.getMessage();
        paramJsonGenerator = (JsonGenerator)paramObject;
        if (paramObject == null) {
          paramJsonGenerator = "[no message for " + localException.getClass().getName() + "]";
        }
        throw new JsonMappingException(paramJsonGenerator, localException);
      }
    }
  }
  
  public void serializeValue(JsonGenerator paramJsonGenerator, Object paramObject, JavaType paramJavaType)
    throws IOException
  {
    if (paramObject == null) {
      _serializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      return;
      if (!paramJavaType.getRawClass().isAssignableFrom(paramObject.getClass())) {
        _reportIncompatibleRootType(paramObject, paramJavaType);
      }
      paramJavaType = findTypedValueSerializer(paramJavaType, true, null);
      PropertyName localPropertyName = _config.getFullRootName();
      boolean bool1;
      if (localPropertyName == null)
      {
        boolean bool2 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        bool1 = bool2;
        if (bool2)
        {
          paramJsonGenerator.writeStartObject();
          paramJsonGenerator.writeFieldName(_config.findRootName(paramObject.getClass()).simpleAsEncoded(_config));
          bool1 = bool2;
        }
      }
      try
      {
        paramJavaType.serialize(paramObject, paramJsonGenerator, this);
        if (!bool1) {
          continue;
        }
        paramJsonGenerator.writeEndObject();
        return;
      }
      catch (IOException paramJsonGenerator)
      {
        for (;;)
        {
          throw paramJsonGenerator;
          if (localPropertyName.isEmpty())
          {
            bool1 = false;
          }
          else
          {
            bool1 = true;
            paramJsonGenerator.writeStartObject();
            paramJsonGenerator.writeFieldName(localPropertyName.getSimpleName());
          }
        }
      }
      catch (Exception paramJavaType)
      {
        paramObject = paramJavaType.getMessage();
        paramJsonGenerator = (JsonGenerator)paramObject;
        if (paramObject == null) {
          paramJsonGenerator = "[no message for " + paramJavaType.getClass().getName() + "]";
        }
        throw new JsonMappingException(paramJsonGenerator, paramJavaType);
      }
    }
  }
  
  public void serializeValue(JsonGenerator paramJsonGenerator, Object paramObject, JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer)
    throws IOException
  {
    if (paramObject == null) {
      _serializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      return;
      if ((paramJavaType != null) && (!paramJavaType.getRawClass().isAssignableFrom(paramObject.getClass()))) {
        _reportIncompatibleRootType(paramObject, paramJavaType);
      }
      Object localObject = paramJsonSerializer;
      if (paramJsonSerializer == null) {
        localObject = findTypedValueSerializer(paramJavaType, true, null);
      }
      paramJsonSerializer = _config.getFullRootName();
      boolean bool1;
      if (paramJsonSerializer == null)
      {
        boolean bool2 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        bool1 = bool2;
        if (bool2)
        {
          paramJsonGenerator.writeStartObject();
          if (paramJavaType != null) {
            break label144;
          }
          paramJavaType = _config.findRootName(paramObject.getClass());
          paramJsonGenerator.writeFieldName(paramJavaType.simpleAsEncoded(_config));
          bool1 = bool2;
        }
      }
      try
      {
        ((JsonSerializer)localObject).serialize(paramObject, paramJsonGenerator, this);
        if (!bool1) {
          continue;
        }
        paramJsonGenerator.writeEndObject();
        return;
      }
      catch (IOException paramJsonGenerator)
      {
        for (;;)
        {
          throw paramJsonGenerator;
          paramJavaType = _config.findRootName(paramJavaType);
          break;
          if (paramJsonSerializer.isEmpty())
          {
            bool1 = false;
          }
          else
          {
            bool1 = true;
            paramJsonGenerator.writeStartObject();
            paramJsonGenerator.writeFieldName(paramJsonSerializer.getSimpleName());
          }
        }
      }
      catch (Exception paramJavaType)
      {
        label144:
        paramObject = paramJavaType.getMessage();
        paramJsonGenerator = (JsonGenerator)paramObject;
        if (paramObject == null) {
          paramJsonGenerator = "[no message for " + paramJavaType.getClass().getName() + "]";
        }
        throw new JsonMappingException(paramJsonGenerator, paramJavaType);
      }
    }
  }
  
  public JsonSerializer<Object> serializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException
  {
    if (paramObject == null) {}
    Class localClass;
    do
    {
      return null;
      if ((paramObject instanceof JsonSerializer))
      {
        paramAnnotated = (JsonSerializer)paramObject;
        return _handleResolvable(paramAnnotated);
      }
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + paramObject.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      localClass = (Class)paramObject;
    } while ((localClass == JsonSerializer.None.class) || (ClassUtil.isBogusClass(localClass)));
    if (!JsonSerializer.class.isAssignableFrom(localClass)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + localClass.getName() + "; expected Class<JsonSerializer>");
    }
    paramObject = _config.getHandlerInstantiator();
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = ((HandlerInstantiator)paramObject).serializerInstance(_config, paramAnnotated, localClass))
    {
      paramAnnotated = (Annotated)paramObject;
      if (paramObject != null) {
        break;
      }
      paramAnnotated = (JsonSerializer)ClassUtil.createInstance(localClass, _config.canOverrideAccessModifiers());
      break;
    }
  }
  
  public static final class Impl
    extends DefaultSerializerProvider
  {
    private static final long serialVersionUID = 1L;
    
    public Impl() {}
    
    protected Impl(SerializerProvider paramSerializerProvider, SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
    {
      super(paramSerializationConfig, paramSerializerFactory);
    }
    
    public Impl(Impl paramImpl)
    {
      super();
    }
    
    public DefaultSerializerProvider copy()
    {
      if (getClass() != Impl.class) {
        return super.copy();
      }
      return new Impl(this);
    }
    
    public Impl createInstance(SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
    {
      return new Impl(this, paramSerializationConfig, paramSerializerFactory);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.DefaultSerializerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */