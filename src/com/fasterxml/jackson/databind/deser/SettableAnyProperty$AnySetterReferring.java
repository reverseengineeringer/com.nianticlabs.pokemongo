package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;

class SettableAnyProperty$AnySetterReferring
  extends ReadableObjectId.Referring
{
  private final SettableAnyProperty _parent;
  private final Object _pojo;
  private final String _propName;
  
  public SettableAnyProperty$AnySetterReferring(SettableAnyProperty paramSettableAnyProperty, UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass, Object paramObject, String paramString)
  {
    super(paramUnresolvedForwardReference, paramClass);
    _parent = paramSettableAnyProperty;
    _pojo = paramObject;
    _propName = paramString;
  }
  
  public void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
    throws IOException
  {
    if (!hasId(paramObject1)) {
      throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + paramObject1.toString() + "] that wasn't previously registered.");
    }
    _parent.set(_pojo, _propName, paramObject2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.SettableAnyProperty.AnySetterReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */