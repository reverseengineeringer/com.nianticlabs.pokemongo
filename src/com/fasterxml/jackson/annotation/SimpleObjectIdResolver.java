package com.fasterxml.jackson.annotation;

import java.util.HashMap;
import java.util.Map;

public class SimpleObjectIdResolver
  implements ObjectIdResolver
{
  protected Map<ObjectIdGenerator.IdKey, Object> _items;
  
  public void bindItem(ObjectIdGenerator.IdKey paramIdKey, Object paramObject)
  {
    if (_items == null) {
      _items = new HashMap();
    }
    while (!_items.containsKey(paramIdKey))
    {
      _items.put(paramIdKey, paramObject);
      return;
    }
    throw new IllegalStateException("Already had POJO for id (" + key.getClass().getName() + ") [" + paramIdKey + "]");
  }
  
  public boolean canUseFor(ObjectIdResolver paramObjectIdResolver)
  {
    return paramObjectIdResolver.getClass() == getClass();
  }
  
  public ObjectIdResolver newForDeserialization(Object paramObject)
  {
    return new SimpleObjectIdResolver();
  }
  
  public Object resolveId(ObjectIdGenerator.IdKey paramIdKey)
  {
    if (_items == null) {
      return null;
    }
    return _items.get(paramIdKey);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.SimpleObjectIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */