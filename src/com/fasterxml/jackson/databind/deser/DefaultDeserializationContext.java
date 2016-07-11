package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerator<*>;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer.None;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class DefaultDeserializationContext
  extends DeserializationContext
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<ObjectIdResolver> _objectIdResolvers;
  protected transient LinkedHashMap<ObjectIdGenerator.IdKey, ReadableObjectId> _objectIds;
  
  protected DefaultDeserializationContext(DefaultDeserializationContext paramDefaultDeserializationContext)
  {
    super(paramDefaultDeserializationContext);
  }
  
  protected DefaultDeserializationContext(DefaultDeserializationContext paramDefaultDeserializationContext, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    super(paramDefaultDeserializationContext, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
  }
  
  protected DefaultDeserializationContext(DefaultDeserializationContext paramDefaultDeserializationContext, DeserializerFactory paramDeserializerFactory)
  {
    super(paramDefaultDeserializationContext, paramDeserializerFactory);
  }
  
  protected DefaultDeserializationContext(DeserializerFactory paramDeserializerFactory, DeserializerCache paramDeserializerCache)
  {
    super(paramDeserializerFactory, paramDeserializerCache);
  }
  
  public void checkUnresolvedObjectId()
    throws UnresolvedForwardReference
  {
    if (_objectIds == null) {}
    Object localObject2;
    do
    {
      do
      {
        return;
      } while (!isEnabled(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS));
      localObject2 = null;
      Iterator localIterator = _objectIds.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject4 = (ReadableObjectId)((Map.Entry)localIterator.next()).getValue();
        if ((((ReadableObjectId)localObject4).hasReferringProperties()) && (!tryToResolveUnresolvedObjectId((ReadableObjectId)localObject4)))
        {
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new UnresolvedForwardReference("Unresolved forward references for: ");
          }
          Object localObject3 = getKeykey;
          localObject4 = ((ReadableObjectId)localObject4).referringProperties();
          for (;;)
          {
            localObject2 = localObject1;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject2 = (ReadableObjectId.Referring)((Iterator)localObject4).next();
            ((UnresolvedForwardReference)localObject1).addUnresolvedId(localObject3, ((ReadableObjectId.Referring)localObject2).getBeanType(), ((ReadableObjectId.Referring)localObject2).getLocation());
          }
        }
      }
    } while (localObject2 == null);
    throw ((Throwable)localObject2);
  }
  
  public DefaultDeserializationContext copy()
  {
    throw new IllegalStateException("DefaultDeserializationContext sub-class not overriding copy()");
  }
  
  public abstract DefaultDeserializationContext createInstance(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues);
  
  public JsonDeserializer<Object> deserializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramObject == null) {
      paramObject = localObject2;
    }
    Class localClass;
    do
    {
      do
      {
        do
        {
          return (JsonDeserializer<Object>)paramObject;
          if (!(paramObject instanceof JsonDeserializer)) {
            break;
          }
          paramAnnotated = (JsonDeserializer)paramObject;
          paramObject = paramAnnotated;
        } while (!(paramAnnotated instanceof ResolvableDeserializer));
        ((ResolvableDeserializer)paramAnnotated).resolve(this);
        return paramAnnotated;
        if (!(paramObject instanceof Class)) {
          throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + paramObject.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
        }
        localClass = (Class)paramObject;
        paramObject = localObject2;
      } while (localClass == JsonDeserializer.None.class);
      paramObject = localObject2;
    } while (ClassUtil.isBogusClass(localClass));
    if (!JsonDeserializer.class.isAssignableFrom(localClass)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + localClass.getName() + "; expected Class<JsonDeserializer>");
    }
    paramObject = _config.getHandlerInstantiator();
    if (paramObject == null) {}
    for (paramObject = localObject1;; paramObject = ((HandlerInstantiator)paramObject).deserializerInstance(_config, paramAnnotated, localClass))
    {
      paramAnnotated = (Annotated)paramObject;
      if (paramObject != null) {
        break;
      }
      paramAnnotated = (JsonDeserializer)ClassUtil.createInstance(localClass, _config.canOverrideAccessModifiers());
      break;
    }
  }
  
  @Deprecated
  public ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    return findObjectId(paramObject, paramObjectIdGenerator, new SimpleObjectIdResolver());
  }
  
  public ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator, ObjectIdResolver paramObjectIdResolver)
  {
    if (paramObject == null) {
      return null;
    }
    ObjectIdGenerator.IdKey localIdKey = paramObjectIdGenerator.key(paramObject);
    if (_objectIds == null)
    {
      _objectIds = new LinkedHashMap();
      paramObjectIdGenerator = null;
      if (_objectIdResolvers != null) {
        break label127;
      }
      _objectIdResolvers = new ArrayList(8);
      paramObject = paramObjectIdGenerator;
    }
    for (;;)
    {
      paramObjectIdGenerator = (ObjectIdGenerator<?>)paramObject;
      if (paramObject == null)
      {
        paramObjectIdGenerator = paramObjectIdResolver.newForDeserialization(this);
        _objectIdResolvers.add(paramObjectIdGenerator);
      }
      paramObject = new ReadableObjectId(localIdKey);
      ((ReadableObjectId)paramObject).setResolver(paramObjectIdGenerator);
      _objectIds.put(localIdKey, paramObject);
      return (ReadableObjectId)paramObject;
      paramObject = (ReadableObjectId)_objectIds.get(localIdKey);
      if (paramObject == null) {
        break;
      }
      return (ReadableObjectId)paramObject;
      label127:
      Iterator localIterator = _objectIdResolvers.iterator();
      do
      {
        paramObject = paramObjectIdGenerator;
        if (!localIterator.hasNext()) {
          break;
        }
        paramObject = (ObjectIdResolver)localIterator.next();
      } while (!((ObjectIdResolver)paramObject).canUseFor(paramObjectIdResolver));
    }
  }
  
  public final KeyDeserializer keyDeserializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramObject == null) {
      paramObject = localObject2;
    }
    Class localClass;
    do
    {
      do
      {
        do
        {
          return (KeyDeserializer)paramObject;
          if (!(paramObject instanceof KeyDeserializer)) {
            break;
          }
          paramAnnotated = (KeyDeserializer)paramObject;
          paramObject = paramAnnotated;
        } while (!(paramAnnotated instanceof ResolvableDeserializer));
        ((ResolvableDeserializer)paramAnnotated).resolve(this);
        return paramAnnotated;
        if (!(paramObject instanceof Class)) {
          throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + paramObject.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        localClass = (Class)paramObject;
        paramObject = localObject2;
      } while (localClass == KeyDeserializer.None.class);
      paramObject = localObject2;
    } while (ClassUtil.isBogusClass(localClass));
    if (!KeyDeserializer.class.isAssignableFrom(localClass)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + localClass.getName() + "; expected Class<KeyDeserializer>");
    }
    paramObject = _config.getHandlerInstantiator();
    if (paramObject == null) {}
    for (paramObject = localObject1;; paramObject = ((HandlerInstantiator)paramObject).keyDeserializerInstance(_config, paramAnnotated, localClass))
    {
      paramAnnotated = (Annotated)paramObject;
      if (paramObject != null) {
        break;
      }
      paramAnnotated = (KeyDeserializer)ClassUtil.createInstance(localClass, _config.canOverrideAccessModifiers());
      break;
    }
  }
  
  protected boolean tryToResolveUnresolvedObjectId(ReadableObjectId paramReadableObjectId)
  {
    return paramReadableObjectId.tryToResolveUnresolved(this);
  }
  
  public abstract DefaultDeserializationContext with(DeserializerFactory paramDeserializerFactory);
  
  public static final class Impl
    extends DefaultDeserializationContext
  {
    private static final long serialVersionUID = 1L;
    
    protected Impl(Impl paramImpl)
    {
      super();
    }
    
    protected Impl(Impl paramImpl, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
    {
      super(paramDeserializationConfig, paramJsonParser, paramInjectableValues);
    }
    
    protected Impl(Impl paramImpl, DeserializerFactory paramDeserializerFactory)
    {
      super(paramDeserializerFactory);
    }
    
    public Impl(DeserializerFactory paramDeserializerFactory)
    {
      super(null);
    }
    
    public DefaultDeserializationContext copy()
    {
      if (getClass() != Impl.class) {
        return super.copy();
      }
      return new Impl(this);
    }
    
    public DefaultDeserializationContext createInstance(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
    {
      return new Impl(this, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
    }
    
    public DefaultDeserializationContext with(DeserializerFactory paramDeserializerFactory)
    {
      return new Impl(this, paramDeserializerFactory);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */