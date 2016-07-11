package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SimpleMixInResolver
  implements ClassIntrospector.MixInResolver, Serializable
{
  private static final long serialVersionUID = 1L;
  protected Map<ClassKey, Class<?>> _localMixIns;
  protected final ClassIntrospector.MixInResolver _overrides;
  
  public SimpleMixInResolver(ClassIntrospector.MixInResolver paramMixInResolver)
  {
    _overrides = paramMixInResolver;
  }
  
  protected SimpleMixInResolver(ClassIntrospector.MixInResolver paramMixInResolver, Map<ClassKey, Class<?>> paramMap)
  {
    _overrides = paramMixInResolver;
    _localMixIns = paramMap;
  }
  
  public void addLocalDefinition(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (_localMixIns == null) {
      _localMixIns = new HashMap();
    }
    _localMixIns.put(new ClassKey(paramClass1), paramClass2);
  }
  
  public SimpleMixInResolver copy()
  {
    ClassIntrospector.MixInResolver localMixInResolver;
    if (_overrides == null)
    {
      localMixInResolver = null;
      if (_localMixIns != null) {
        break label41;
      }
    }
    label41:
    for (Object localObject = null;; localObject = new HashMap(_localMixIns))
    {
      return new SimpleMixInResolver(localMixInResolver, (Map)localObject);
      localMixInResolver = _overrides.copy();
      break;
    }
  }
  
  public Class<?> findMixInClassFor(Class<?> paramClass)
  {
    if (_overrides == null) {}
    for (Class localClass1 = null;; localClass1 = _overrides.findMixInClassFor(paramClass))
    {
      Class localClass2 = localClass1;
      if (localClass1 == null)
      {
        localClass2 = localClass1;
        if (_localMixIns != null) {
          localClass2 = (Class)_localMixIns.get(new ClassKey(paramClass));
        }
      }
      return localClass2;
    }
  }
  
  public int localSize()
  {
    if (_localMixIns == null) {
      return 0;
    }
    return _localMixIns.size();
  }
  
  public void setLocalDefinitions(Map<Class<?>, Class<?>> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      _localMixIns = null;
    }
    HashMap localHashMap = new HashMap(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localHashMap.put(new ClassKey((Class)localEntry.getKey()), localEntry.getValue());
    }
    _localMixIns = localHashMap;
  }
  
  public SimpleMixInResolver withOverrides(ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return new SimpleMixInResolver(paramMixInResolver, _localMixIns);
  }
  
  public SimpleMixInResolver withoutLocalDefinitions()
  {
    return new SimpleMixInResolver(_overrides, null);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.SimpleMixInResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */