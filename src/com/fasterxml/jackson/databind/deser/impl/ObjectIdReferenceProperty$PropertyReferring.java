package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;

public final class ObjectIdReferenceProperty$PropertyReferring
  extends ReadableObjectId.Referring
{
  private final ObjectIdReferenceProperty _parent;
  public final Object _pojo;
  
  public ObjectIdReferenceProperty$PropertyReferring(ObjectIdReferenceProperty paramObjectIdReferenceProperty, UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass, Object paramObject)
  {
    super(paramUnresolvedForwardReference, paramClass);
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */