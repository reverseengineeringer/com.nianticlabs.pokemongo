package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;

public class UnresolvedId
{
  private final Object _id;
  private final JsonLocation _location;
  private final Class<?> _type;
  
  public UnresolvedId(Object paramObject, Class<?> paramClass, JsonLocation paramJsonLocation)
  {
    _id = paramObject;
    _type = paramClass;
    _location = paramJsonLocation;
  }
  
  public Object getId()
  {
    return _id;
  }
  
  public JsonLocation getLocation()
  {
    return _location;
  }
  
  public Class<?> getType()
  {
    return _type;
  }
  
  public String toString()
  {
    Object localObject = _id;
    if (_type == null) {}
    for (String str = "NULL";; str = _type.getName()) {
      return String.format("Object id [%s] (for %s) at %s", new Object[] { localObject, str, _location });
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.UnresolvedId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */