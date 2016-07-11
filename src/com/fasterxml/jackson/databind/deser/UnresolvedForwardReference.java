package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class UnresolvedForwardReference
  extends JsonMappingException
{
  private static final long serialVersionUID = 1L;
  private ReadableObjectId _roid;
  private List<UnresolvedId> _unresolvedIds;
  
  public UnresolvedForwardReference(String paramString)
  {
    super(paramString);
    _unresolvedIds = new ArrayList();
  }
  
  public UnresolvedForwardReference(String paramString, JsonLocation paramJsonLocation, ReadableObjectId paramReadableObjectId)
  {
    super(paramString, paramJsonLocation);
    _roid = paramReadableObjectId;
  }
  
  public void addUnresolvedId(Object paramObject, Class<?> paramClass, JsonLocation paramJsonLocation)
  {
    _unresolvedIds.add(new UnresolvedId(paramObject, paramClass, paramJsonLocation));
  }
  
  public String getMessage()
  {
    Object localObject = super.getMessage();
    if (_unresolvedIds == null) {
      return (String)localObject;
    }
    localObject = new StringBuilder((String)localObject);
    Iterator localIterator = _unresolvedIds.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append(((UnresolvedId)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(", ");
      }
    }
    ((StringBuilder)localObject).append('.');
    return ((StringBuilder)localObject).toString();
  }
  
  public ReadableObjectId getRoid()
  {
    return _roid;
  }
  
  public Object getUnresolvedId()
  {
    return _roid.getKey().key;
  }
  
  public List<UnresolvedId> getUnresolvedIds()
  {
    return _unresolvedIds;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.UnresolvedForwardReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */