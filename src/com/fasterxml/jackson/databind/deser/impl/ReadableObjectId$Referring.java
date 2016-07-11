package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;

public abstract class ReadableObjectId$Referring
{
  private final Class<?> _beanType;
  private final UnresolvedForwardReference _reference;
  
  public ReadableObjectId$Referring(UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass)
  {
    _reference = paramUnresolvedForwardReference;
    _beanType = paramClass;
  }
  
  public Class<?> getBeanType()
  {
    return _beanType;
  }
  
  public JsonLocation getLocation()
  {
    return _reference.getLocation();
  }
  
  public abstract void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
    throws IOException;
  
  public boolean hasId(Object paramObject)
  {
    return paramObject.equals(_reference.getUnresolvedId());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */