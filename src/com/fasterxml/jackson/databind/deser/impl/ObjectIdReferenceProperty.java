package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class ObjectIdReferenceProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  private final SettableBeanProperty _forward;
  
  public ObjectIdReferenceProperty(SettableBeanProperty paramSettableBeanProperty, ObjectIdInfo paramObjectIdInfo)
  {
    super(paramSettableBeanProperty);
    _forward = paramSettableBeanProperty;
    _objectIdInfo = paramObjectIdInfo;
  }
  
  public ObjectIdReferenceProperty(ObjectIdReferenceProperty paramObjectIdReferenceProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramObjectIdReferenceProperty, paramJsonDeserializer);
    _forward = _forward;
    _objectIdInfo = _objectIdInfo;
  }
  
  public ObjectIdReferenceProperty(ObjectIdReferenceProperty paramObjectIdReferenceProperty, PropertyName paramPropertyName)
  {
    super(paramObjectIdReferenceProperty, paramPropertyName);
    _forward = _forward;
    _objectIdInfo = _objectIdInfo;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    try
    {
      paramDeserializationContext = setAndReturn(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
      return paramDeserializationContext;
    }
    catch (UnresolvedForwardReference paramDeserializationContext)
    {
      if ((_objectIdInfo != null) || (_valueDeserializer.getObjectIdReader() != null)) {}
      for (int i = 1; i == 0; i = 0) {
        throw JsonMappingException.from(paramJsonParser, "Unresolved forward reference but no identity info.", paramDeserializationContext);
      }
      paramDeserializationContext.getRoid().appendReferring(new PropertyReferring(this, paramDeserializationContext, _type.getRawClass(), paramObject));
    }
    return null;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return _forward.getAnnotation(paramClass);
  }
  
  public int getCreatorIndex()
  {
    return _forward.getCreatorIndex();
  }
  
  public AnnotatedMember getMember()
  {
    return _forward.getMember();
  }
  
  public void set(Object paramObject1, Object paramObject2)
    throws IOException
  {
    _forward.set(paramObject1, paramObject2);
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
    throws IOException
  {
    return _forward.setAndReturn(paramObject1, paramObject2);
  }
  
  public SettableBeanProperty withName(PropertyName paramPropertyName)
  {
    return new ObjectIdReferenceProperty(this, paramPropertyName);
  }
  
  public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new ObjectIdReferenceProperty(this, paramJsonDeserializer);
  }
  
  public static final class PropertyReferring
    extends ReadableObjectId.Referring
  {
    private final ObjectIdReferenceProperty _parent;
    public final Object _pojo;
    
    public PropertyReferring(ObjectIdReferenceProperty paramObjectIdReferenceProperty, UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass, Object paramObject)
    {
      super(paramClass);
      _parent = paramObjectIdReferenceProperty;
      _pojo = paramObject;
    }
    
    public void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
      throws IOException
    {
      if (!hasId(paramObject1)) {
        throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + paramObject1 + "] that wasn't previously seen as unresolved.");
      }
      _parent.set(_pojo, paramObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */