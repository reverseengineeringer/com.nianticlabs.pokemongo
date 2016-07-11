package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class DeserializerCache
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 4);
  protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);
  
  private boolean _hasCustomValueHandler(JavaType paramJavaType)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJavaType.isContainerType())
    {
      paramJavaType = paramJavaType.getContentType();
      bool1 = bool2;
      if (paramJavaType != null) {
        if (paramJavaType.getValueHandler() == null)
        {
          bool1 = bool2;
          if (paramJavaType.getTypeHandler() == null) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private Class<?> _verifyAsClass(Object paramObject, String paramString, Class<?> paramClass)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      return (Class<?>)paramObject;
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector." + paramString + "() returned value of type " + paramObject.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      paramString = (Class)paramObject;
      if (paramString == paramClass) {
        break;
      }
      paramObject = paramString;
    } while (!ClassUtil.isBogusClass(paramString));
    return null;
  }
  
  private JavaType modifyTypeByAnnotation(DeserializationContext paramDeserializationContext, Annotated paramAnnotated, JavaType paramJavaType)
    throws JsonMappingException
  {
    Object localObject3 = paramDeserializationContext.getAnnotationIntrospector();
    Object localObject2 = ((AnnotationIntrospector)localObject3).findDeserializationType(paramAnnotated, paramJavaType);
    Object localObject1 = paramJavaType;
    if (localObject2 != null) {}
    try
    {
      localObject1 = paramDeserializationContext.getTypeFactory().constructSpecializedType(paramJavaType, (Class)localObject2);
      localObject2 = localObject1;
      if (((JavaType)localObject1).isContainerType())
      {
        localObject2 = ((AnnotationIntrospector)localObject3).findDeserializationKeyType(paramAnnotated, ((JavaType)localObject1).getKeyType());
        paramJavaType = (JavaType)localObject1;
        if (localObject2 != null) {
          if (!(localObject1 instanceof MapLikeType)) {
            throw new JsonMappingException("Illegal key-type annotation: type " + localObject1 + " is not a Map(-like) type");
          }
        }
      }
    }
    catch (IllegalArgumentException paramDeserializationContext)
    {
      throw new JsonMappingException("Failed to narrow type " + paramJavaType + " with concrete-type annotation (value " + ((Class)localObject2).getName() + "), method '" + paramAnnotated.getName() + "': " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
    }
    for (;;)
    {
      try
      {
        paramJavaType = ((MapLikeType)localObject1).narrowKey((Class)localObject2);
        localObject2 = paramJavaType.getKeyType();
        localObject1 = paramJavaType;
        if (localObject2 != null)
        {
          localObject1 = paramJavaType;
          if (((JavaType)localObject2).getValueHandler() == null)
          {
            localObject2 = ((AnnotationIntrospector)localObject3).findKeyDeserializer(paramAnnotated);
            localObject1 = paramJavaType;
            if (localObject2 != null)
            {
              localObject2 = paramDeserializationContext.keyDeserializerInstance(paramAnnotated, localObject2);
              localObject1 = paramJavaType;
              if (localObject2 != null)
              {
                localObject1 = ((MapLikeType)paramJavaType).withKeyValueHandler(localObject2);
                ((JavaType)localObject1).getKeyType();
              }
            }
          }
        }
        localObject2 = ((AnnotationIntrospector)localObject3).findDeserializationContentType(paramAnnotated, ((JavaType)localObject1).getContentType());
        paramJavaType = (JavaType)localObject1;
        if (localObject2 != null) {}
        localObject2 = _verifyAsClass(localObject3, "findContentDeserializer", JsonDeserializer.None.class);
      }
      catch (IllegalArgumentException paramDeserializationContext)
      {
        try
        {
          paramJavaType = ((JavaType)localObject1).narrowContentsBy((Class)localObject2);
          localObject2 = paramJavaType;
          if (paramJavaType.getContentType().getValueHandler() == null)
          {
            localObject3 = ((AnnotationIntrospector)localObject3).findContentDeserializer(paramAnnotated);
            localObject2 = paramJavaType;
            if (localObject3 != null)
            {
              localObject1 = null;
              if (!(localObject3 instanceof JsonDeserializer)) {
                break label468;
              }
              paramDeserializationContext = (JsonDeserializer)localObject3;
              localObject2 = paramJavaType;
              if (localObject1 != null) {
                localObject2 = paramJavaType.withContentValueHandler(localObject1);
              }
            }
          }
          return (JavaType)localObject2;
        }
        catch (IllegalArgumentException paramDeserializationContext)
        {
          throw new JsonMappingException("Failed to narrow content type " + localObject1 + " with content-type annotation (" + ((Class)localObject2).getName() + "): " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
        }
        paramDeserializationContext = paramDeserializationContext;
        throw new JsonMappingException("Failed to narrow key type " + localObject1 + " with key-type annotation (" + ((Class)localObject2).getName() + "): " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
      }
      label468:
      if (localObject2 != null) {
        localObject1 = paramDeserializationContext.deserializerInstance(paramAnnotated, localObject2);
      }
    }
  }
  
  protected JsonDeserializer<Object> _createAndCache2(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
    throws JsonMappingException
  {
    try
    {
      paramDeserializerFactory = _createDeserializer(paramDeserializationContext, paramDeserializerFactory, paramJavaType);
      if (paramDeserializerFactory == null)
      {
        paramDeserializationContext = null;
        return paramDeserializationContext;
      }
    }
    catch (IllegalArgumentException paramDeserializationContext)
    {
      throw new JsonMappingException(paramDeserializationContext.getMessage(), null, paramDeserializationContext);
    }
    boolean bool = paramDeserializerFactory instanceof ResolvableDeserializer;
    if ((!_hasCustomValueHandler(paramJavaType)) && (paramDeserializerFactory.isCachable())) {}
    for (int i = 1;; i = 0)
    {
      if (bool)
      {
        _incompleteDeserializers.put(paramJavaType, paramDeserializerFactory);
        ((ResolvableDeserializer)paramDeserializerFactory).resolve(paramDeserializationContext);
        _incompleteDeserializers.remove(paramJavaType);
      }
      paramDeserializationContext = paramDeserializerFactory;
      if (i == 0) {
        break;
      }
      _cachedDeserializers.put(paramJavaType, paramDeserializerFactory);
      return paramDeserializerFactory;
    }
  }
  
  protected JsonDeserializer<Object> _createAndCacheValueDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
    throws JsonMappingException
  {
    synchronized (_incompleteDeserializers)
    {
      JsonDeserializer localJsonDeserializer = _findCachedDeserializer(paramJavaType);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
      i = _incompleteDeserializers.size();
      if (i > 0)
      {
        localJsonDeserializer = (JsonDeserializer)_incompleteDeserializers.get(paramJavaType);
        if (localJsonDeserializer != null) {
          return localJsonDeserializer;
        }
      }
    }
  }
  
  protected JsonDeserializer<Object> _createDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
    throws JsonMappingException
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    if ((!paramJavaType.isAbstract()) && (!paramJavaType.isMapLikeType()))
    {
      localObject1 = paramJavaType;
      if (!paramJavaType.isCollectionLikeType()) {}
    }
    else
    {
      localObject1 = paramDeserializerFactory.mapAbstractType(localDeserializationConfig, paramJavaType);
    }
    paramJavaType = localDeserializationConfig.introspect((JavaType)localObject1);
    Object localObject2 = findDeserializerFromAnnotation(paramDeserializationContext, paramJavaType.getClassInfo());
    if (localObject2 != null) {
      return (JsonDeserializer<Object>)localObject2;
    }
    JavaType localJavaType = modifyTypeByAnnotation(paramDeserializationContext, paramJavaType.getClassInfo(), (JavaType)localObject1);
    localObject2 = localObject1;
    if (localJavaType != localObject1)
    {
      localObject2 = localJavaType;
      paramJavaType = localDeserializationConfig.introspect(localJavaType);
    }
    Object localObject1 = paramJavaType.findPOJOBuilder();
    if (localObject1 != null) {
      return paramDeserializerFactory.createBuilderBasedDeserializer(paramDeserializationContext, (JavaType)localObject2, paramJavaType, (Class)localObject1);
    }
    localObject1 = paramJavaType.findDeserializationConverter();
    if (localObject1 == null) {
      return _createDeserializer2(paramDeserializationContext, paramDeserializerFactory, (JavaType)localObject2, paramJavaType);
    }
    localJavaType = ((Converter)localObject1).getInputType(paramDeserializationContext.getTypeFactory());
    if (!localJavaType.hasRawClass(((JavaType)localObject2).getRawClass())) {
      paramJavaType = localDeserializationConfig.introspect(localJavaType);
    }
    return new StdDelegatingDeserializer((Converter)localObject1, localJavaType, _createDeserializer2(paramDeserializationContext, paramDeserializerFactory, localJavaType, paramJavaType));
  }
  
  protected JsonDeserializer<?> _createDeserializer2(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    if (paramJavaType.isEnumType()) {
      return paramDeserializerFactory.createEnumDeserializer(paramDeserializationContext, paramJavaType, paramBeanDescription);
    }
    if (paramJavaType.isContainerType())
    {
      if (paramJavaType.isArrayType()) {
        return paramDeserializerFactory.createArrayDeserializer(paramDeserializationContext, (ArrayType)paramJavaType, paramBeanDescription);
      }
      if (paramJavaType.isMapLikeType())
      {
        paramJavaType = (MapLikeType)paramJavaType;
        if (paramJavaType.isTrueMapType()) {
          return paramDeserializerFactory.createMapDeserializer(paramDeserializationContext, (MapType)paramJavaType, paramBeanDescription);
        }
        return paramDeserializerFactory.createMapLikeDeserializer(paramDeserializationContext, paramJavaType, paramBeanDescription);
      }
      if (paramJavaType.isCollectionLikeType())
      {
        JsonFormat.Value localValue = paramBeanDescription.findExpectedFormat(null);
        if ((localValue == null) || (localValue.getShape() != JsonFormat.Shape.OBJECT))
        {
          paramJavaType = (CollectionLikeType)paramJavaType;
          if (paramJavaType.isTrueCollectionType()) {
            return paramDeserializerFactory.createCollectionDeserializer(paramDeserializationContext, (CollectionType)paramJavaType, paramBeanDescription);
          }
          return paramDeserializerFactory.createCollectionLikeDeserializer(paramDeserializationContext, paramJavaType, paramBeanDescription);
        }
      }
    }
    if (JsonNode.class.isAssignableFrom(paramJavaType.getRawClass())) {
      return paramDeserializerFactory.createTreeDeserializer(localDeserializationConfig, paramJavaType, paramBeanDescription);
    }
    return paramDeserializerFactory.createBeanDeserializer(paramDeserializationContext, paramJavaType, paramBeanDescription);
  }
  
  protected JsonDeserializer<Object> _findCachedDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {
      throw new IllegalArgumentException("Null JavaType passed");
    }
    if (_hasCustomValueHandler(paramJavaType)) {
      return null;
    }
    return (JsonDeserializer)_cachedDeserializers.get(paramJavaType);
  }
  
  protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + paramJavaType);
  }
  
  protected JsonDeserializer<Object> _handleUnknownValueDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    if (!ClassUtil.isConcrete(paramJavaType.getRawClass())) {
      throw new JsonMappingException("Can not find a Value deserializer for abstract type " + paramJavaType);
    }
    throw new JsonMappingException("Can not find a Value deserializer for type " + paramJavaType);
  }
  
  public int cachedDeserializersCount()
  {
    return _cachedDeserializers.size();
  }
  
  protected Converter<Object, Object> findConverter(DeserializationContext paramDeserializationContext, Annotated paramAnnotated)
    throws JsonMappingException
  {
    Object localObject = paramDeserializationContext.getAnnotationIntrospector().findDeserializationConverter(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return paramDeserializationContext.converterInstance(paramAnnotated, localObject);
  }
  
  protected JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext paramDeserializationContext, Annotated paramAnnotated, JsonDeserializer<Object> paramJsonDeserializer)
    throws JsonMappingException
  {
    paramAnnotated = findConverter(paramDeserializationContext, paramAnnotated);
    if (paramAnnotated == null) {
      return paramJsonDeserializer;
    }
    return new StdDelegatingDeserializer(paramAnnotated, paramAnnotated.getInputType(paramDeserializationContext.getTypeFactory()), paramJsonDeserializer);
  }
  
  protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext paramDeserializationContext, Annotated paramAnnotated)
    throws JsonMappingException
  {
    Object localObject = paramDeserializationContext.getAnnotationIntrospector().findDeserializer(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return findConvertingDeserializer(paramDeserializationContext, paramAnnotated, paramDeserializationContext.deserializerInstance(paramAnnotated, localObject));
  }
  
  public KeyDeserializer findKeyDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
    throws JsonMappingException
  {
    KeyDeserializer localKeyDeserializer = paramDeserializerFactory.createKeyDeserializer(paramDeserializationContext, paramJavaType);
    if (localKeyDeserializer == null) {
      paramDeserializerFactory = _handleUnknownKeyDeserializer(paramJavaType);
    }
    do
    {
      return paramDeserializerFactory;
      paramDeserializerFactory = localKeyDeserializer;
    } while (!(localKeyDeserializer instanceof ResolvableDeserializer));
    ((ResolvableDeserializer)localKeyDeserializer).resolve(paramDeserializationContext);
    return localKeyDeserializer;
  }
  
  public JsonDeserializer<Object> findValueDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer = _findCachedDeserializer(paramJavaType);
    Object localObject = localJsonDeserializer;
    if (localJsonDeserializer == null)
    {
      paramDeserializationContext = _createAndCacheValueDeserializer(paramDeserializationContext, paramDeserializerFactory, paramJavaType);
      localObject = paramDeserializationContext;
      if (paramDeserializationContext == null) {
        localObject = _handleUnknownValueDeserializer(paramJavaType);
      }
    }
    return (JsonDeserializer<Object>)localObject;
  }
  
  public void flushCachedDeserializers()
  {
    _cachedDeserializers.clear();
  }
  
  public boolean hasValueDeserializerFor(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer2 = _findCachedDeserializer(paramJavaType);
    JsonDeserializer localJsonDeserializer1 = localJsonDeserializer2;
    if (localJsonDeserializer2 == null) {
      localJsonDeserializer1 = _createAndCacheValueDeserializer(paramDeserializationContext, paramDeserializerFactory, paramJavaType);
    }
    return localJsonDeserializer1 != null;
  }
  
  Object writeReplace()
  {
    _incompleteDeserializers.clear();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DeserializerCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */