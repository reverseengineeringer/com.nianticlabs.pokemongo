package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadableObjectId
{
  protected final ObjectIdGenerator.IdKey _key;
  protected LinkedList<Referring> _referringProperties;
  protected ObjectIdResolver _resolver;
  @Deprecated
  public final Object id;
  @Deprecated
  public Object item;
  
  public ReadableObjectId(ObjectIdGenerator.IdKey paramIdKey)
  {
    _key = paramIdKey;
    id = key;
  }
  
  @Deprecated
  public ReadableObjectId(Object paramObject)
  {
    id = paramObject;
    _key = null;
  }
  
  public void appendReferring(Referring paramReferring)
  {
    if (_referringProperties == null) {
      _referringProperties = new LinkedList();
    }
    _referringProperties.add(paramReferring);
  }
  
  public void bindItem(Object paramObject)
    throws IOException
  {
    _resolver.bindItem(_key, paramObject);
    item = paramObject;
    if (_referringProperties != null)
    {
      Iterator localIterator = _referringProperties.iterator();
      _referringProperties = null;
      while (localIterator.hasNext()) {
        ((Referring)localIterator.next()).handleResolvedForwardReference(id, paramObject);
      }
    }
  }
  
  public ObjectIdGenerator.IdKey getKey()
  {
    return _key;
  }
  
  public boolean hasReferringProperties()
  {
    return (_referringProperties != null) && (!_referringProperties.isEmpty());
  }
  
  public Iterator<Referring> referringProperties()
  {
    if (_referringProperties == null) {
      return Collections.emptyList().iterator();
    }
    return _referringProperties.iterator();
  }
  
  public Object resolve()
  {
    Object localObject = _resolver.resolveId(_key);
    item = localObject;
    return localObject;
  }
  
  public void setResolver(ObjectIdResolver paramObjectIdResolver)
  {
    _resolver = paramObjectIdResolver;
  }
  
  public String toString()
  {
    return String.valueOf(_key);
  }
  
  public boolean tryToResolveUnresolved(DeserializationContext paramDeserializationContext)
  {
    return false;
  }
  
  public static abstract class Referring
  {
    private final Class<?> _beanType;
    private final UnresolvedForwardReference _reference;
    
    public Referring(UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass)
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
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ReadableObjectId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */