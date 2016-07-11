package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ContextAttributes
{
  public static ContextAttributes getEmpty()
  {
    return Impl.getEmpty();
  }
  
  public abstract Object getAttribute(Object paramObject);
  
  public abstract ContextAttributes withPerCallAttribute(Object paramObject1, Object paramObject2);
  
  public abstract ContextAttributes withSharedAttribute(Object paramObject1, Object paramObject2);
  
  public abstract ContextAttributes withSharedAttributes(Map<Object, Object> paramMap);
  
  public abstract ContextAttributes withoutSharedAttribute(Object paramObject);
  
  public static class Impl
    extends ContextAttributes
    implements Serializable
  {
    protected static final Impl EMPTY = new Impl(Collections.emptyMap());
    protected static final Object NULL_SURROGATE = new Object();
    private static final long serialVersionUID = 1L;
    protected transient Map<Object, Object> _nonShared;
    protected final Map<Object, Object> _shared;
    
    protected Impl(Map<Object, Object> paramMap)
    {
      _shared = paramMap;
      _nonShared = null;
    }
    
    protected Impl(Map<Object, Object> paramMap1, Map<Object, Object> paramMap2)
    {
      _shared = paramMap1;
      _nonShared = paramMap2;
    }
    
    private Map<Object, Object> _copy(Map<Object, Object> paramMap)
    {
      return new HashMap(paramMap);
    }
    
    public static ContextAttributes getEmpty()
    {
      return EMPTY;
    }
    
    public Object getAttribute(Object paramObject)
    {
      if (_nonShared != null)
      {
        Object localObject = _nonShared.get(paramObject);
        if (localObject != null)
        {
          paramObject = localObject;
          if (localObject == NULL_SURROGATE) {
            paramObject = null;
          }
          return paramObject;
        }
      }
      return _shared.get(paramObject);
    }
    
    protected ContextAttributes nonSharedInstance(Object paramObject1, Object paramObject2)
    {
      HashMap localHashMap = new HashMap();
      Object localObject = paramObject2;
      if (paramObject2 == null) {
        localObject = NULL_SURROGATE;
      }
      localHashMap.put(paramObject1, localObject);
      return new Impl(_shared, localHashMap);
    }
    
    public ContextAttributes withPerCallAttribute(Object paramObject1, Object paramObject2)
    {
      Object localObject = paramObject2;
      if (paramObject2 == null)
      {
        paramObject2 = this;
        if (_shared.containsKey(paramObject1)) {
          localObject = NULL_SURROGATE;
        }
      }
      else
      {
        if (_nonShared != null) {
          break label41;
        }
        paramObject2 = nonSharedInstance(paramObject1, localObject);
      }
      return (ContextAttributes)paramObject2;
      label41:
      _nonShared.put(paramObject1, localObject);
      return this;
    }
    
    public ContextAttributes withSharedAttribute(Object paramObject1, Object paramObject2)
    {
      if (this == EMPTY) {}
      for (Object localObject = new HashMap(8);; localObject = _copy(_shared))
      {
        ((Map)localObject).put(paramObject1, paramObject2);
        return new Impl((Map)localObject);
      }
    }
    
    public ContextAttributes withSharedAttributes(Map<Object, Object> paramMap)
    {
      return new Impl(paramMap);
    }
    
    public ContextAttributes withoutSharedAttribute(Object paramObject)
    {
      if (_shared.isEmpty()) {}
      while (!_shared.containsKey(paramObject)) {
        return this;
      }
      if (_shared.size() == 1) {
        return EMPTY;
      }
      Map localMap = _copy(_shared);
      localMap.remove(paramObject);
      return new Impl(localMap);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.cfg.ContextAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */