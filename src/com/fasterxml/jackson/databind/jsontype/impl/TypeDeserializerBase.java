package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TypeDeserializerBase
  extends TypeDeserializer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _baseType;
  protected final JavaType _defaultImpl;
  protected JsonDeserializer<Object> _defaultImplDeserializer;
  protected final Map<String, JsonDeserializer<Object>> _deserializers;
  protected final TypeIdResolver _idResolver;
  protected final BeanProperty _property;
  protected final boolean _typeIdVisible;
  protected final String _typePropertyName;
  
  protected TypeDeserializerBase(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, String paramString, boolean paramBoolean, Class<?> paramClass)
  {
    _baseType = paramJavaType;
    _idResolver = paramTypeIdResolver;
    _typePropertyName = paramString;
    _typeIdVisible = paramBoolean;
    _deserializers = new ConcurrentHashMap(16, 0.75F, 4);
    if (paramClass == null) {}
    for (_defaultImpl = null;; _defaultImpl = paramJavaType.forcedNarrowBy(paramClass))
    {
      _property = null;
      return;
    }
  }
  
  protected TypeDeserializerBase(TypeDeserializerBase paramTypeDeserializerBase, BeanProperty paramBeanProperty)
  {
    _baseType = _baseType;
    _idResolver = _idResolver;
    _typePropertyName = _typePropertyName;
    _typeIdVisible = _typeIdVisible;
    _deserializers = _deserializers;
    _defaultImpl = _defaultImpl;
    _defaultImplDeserializer = _defaultImplDeserializer;
    _property = paramBeanProperty;
  }
  
  @Deprecated
  protected Object _deserializeWithNativeTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return _deserializeWithNativeTypeId(paramJsonParser, paramDeserializationContext, paramJsonParser.getTypeId());
  }
  
  protected Object _deserializeWithNativeTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      JsonDeserializer localJsonDeserializer = _findDefaultImplDeserializer(paramDeserializationContext);
      paramObject = localJsonDeserializer;
      if (localJsonDeserializer == null) {
        throw paramDeserializationContext.mappingException("No (native) type id found when one was expected for polymorphic type handling");
      }
    }
    else
    {
      if (!(paramObject instanceof String)) {
        break label52;
      }
    }
    label52:
    for (paramObject = (String)paramObject;; paramObject = String.valueOf(paramObject))
    {
      paramObject = _findDeserializer(paramDeserializationContext, (String)paramObject);
      return ((JsonDeserializer)paramObject).deserialize(paramJsonParser, paramDeserializationContext);
    }
  }
  
  protected final JsonDeserializer<Object> _findDefaultImplDeserializer(DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (_defaultImpl == null)
    {
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
        return NullifyingDeserializer.instance;
      }
      return null;
    }
    if (ClassUtil.isBogusClass(_defaultImpl.getRawClass())) {
      return NullifyingDeserializer.instance;
    }
    synchronized (_defaultImpl)
    {
      if (_defaultImplDeserializer == null) {
        _defaultImplDeserializer = paramDeserializationContext.findContextualValueDeserializer(_defaultImpl, _property);
      }
      paramDeserializationContext = _defaultImplDeserializer;
      return paramDeserializationContext;
    }
  }
  
  protected final JsonDeserializer<Object> _findDeserializer(DeserializationContext paramDeserializationContext, String paramString)
    throws IOException
  {
    Object localObject2 = (JsonDeserializer)_deserializers.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = _idResolver.typeFromId(paramDeserializationContext, paramString);
      if (localObject2 != null) {
        break label85;
      }
      localObject2 = _findDefaultImplDeserializer(paramDeserializationContext);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = _handleUnknownTypeId(paramDeserializationContext, paramString, _idResolver, _baseType);; localObject1 = paramDeserializationContext.findContextualValueDeserializer((JavaType)localObject1, _property))
    {
      _deserializers.put(paramString, localObject1);
      return (JsonDeserializer<Object>)localObject1;
      label85:
      localObject1 = localObject2;
      if (_baseType != null)
      {
        localObject1 = localObject2;
        if (_baseType.getClass() == localObject2.getClass()) {
          localObject1 = paramDeserializationContext.getTypeFactory().constructSpecializedType(_baseType, ((JavaType)localObject2).getRawClass());
        }
      }
    }
  }
  
  protected JsonDeserializer<Object> _handleUnknownTypeId(DeserializationContext paramDeserializationContext, String paramString, TypeIdResolver paramTypeIdResolver, JavaType paramJavaType)
    throws IOException
  {
    if ((paramTypeIdResolver instanceof TypeIdResolverBase))
    {
      paramTypeIdResolver = ((TypeIdResolverBase)paramTypeIdResolver).getDescForKnownTypeIds();
      if (paramTypeIdResolver == null) {
        paramTypeIdResolver = "known type ids are not statically known";
      }
    }
    for (;;)
    {
      throw paramDeserializationContext.unknownTypeException(_baseType, paramString, paramTypeIdResolver);
      paramTypeIdResolver = "known type ids = " + paramTypeIdResolver;
      continue;
      paramTypeIdResolver = null;
    }
  }
  
  public String baseTypeName()
  {
    return _baseType.getRawClass().getName();
  }
  
  public abstract TypeDeserializer forProperty(BeanProperty paramBeanProperty);
  
  public Class<?> getDefaultImpl()
  {
    if (_defaultImpl == null) {
      return null;
    }
    return _defaultImpl.getRawClass();
  }
  
  public final String getPropertyName()
  {
    return _typePropertyName;
  }
  
  public TypeIdResolver getTypeIdResolver()
  {
    return _idResolver;
  }
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[').append(getClass().getName());
    localStringBuilder.append("; base-type:").append(_baseType);
    localStringBuilder.append("; id-resolver: ").append(_idResolver);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */