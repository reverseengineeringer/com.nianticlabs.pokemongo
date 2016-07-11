package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SimpleFilterProvider
  extends FilterProvider
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected boolean _cfgFailOnUnknownId = true;
  protected PropertyFilter _defaultFilter;
  protected final Map<String, PropertyFilter> _filtersById;
  
  public SimpleFilterProvider()
  {
    this(new HashMap());
  }
  
  public SimpleFilterProvider(Map<String, ?> paramMap)
  {
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof PropertyFilter))
      {
        _filtersById = _convert(paramMap);
        return;
      }
    }
    _filtersById = paramMap;
  }
  
  private static final PropertyFilter _convert(BeanPropertyFilter paramBeanPropertyFilter)
  {
    return SimpleBeanPropertyFilter.from(paramBeanPropertyFilter);
  }
  
  private static final Map<String, PropertyFilter> _convert(Map<String, ?> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof PropertyFilter)) {
        localHashMap.put(localEntry.getKey(), (PropertyFilter)localObject);
      } else if ((localObject instanceof BeanPropertyFilter)) {
        localHashMap.put(localEntry.getKey(), _convert((BeanPropertyFilter)localObject));
      } else {
        throw new IllegalArgumentException("Unrecognized filter type (" + localObject.getClass().getName() + ")");
      }
    }
    return localHashMap;
  }
  
  @Deprecated
  public SimpleFilterProvider addFilter(String paramString, BeanPropertyFilter paramBeanPropertyFilter)
  {
    _filtersById.put(paramString, _convert(paramBeanPropertyFilter));
    return this;
  }
  
  public SimpleFilterProvider addFilter(String paramString, PropertyFilter paramPropertyFilter)
  {
    _filtersById.put(paramString, paramPropertyFilter);
    return this;
  }
  
  public SimpleFilterProvider addFilter(String paramString, SimpleBeanPropertyFilter paramSimpleBeanPropertyFilter)
  {
    _filtersById.put(paramString, paramSimpleBeanPropertyFilter);
    return this;
  }
  
  @Deprecated
  public BeanPropertyFilter findFilter(Object paramObject)
  {
    throw new UnsupportedOperationException("Access to deprecated filters not supported");
  }
  
  public PropertyFilter findPropertyFilter(Object paramObject1, Object paramObject2)
  {
    PropertyFilter localPropertyFilter = (PropertyFilter)_filtersById.get(paramObject1);
    paramObject2 = localPropertyFilter;
    if (localPropertyFilter == null)
    {
      localPropertyFilter = _defaultFilter;
      paramObject2 = localPropertyFilter;
      if (localPropertyFilter == null)
      {
        paramObject2 = localPropertyFilter;
        if (_cfgFailOnUnknownId) {
          throw new IllegalArgumentException("No filter configured with id '" + paramObject1 + "' (type " + paramObject1.getClass().getName() + ")");
        }
      }
    }
    return (PropertyFilter)paramObject2;
  }
  
  public PropertyFilter getDefaultFilter()
  {
    return _defaultFilter;
  }
  
  public PropertyFilter removeFilter(String paramString)
  {
    return (PropertyFilter)_filtersById.remove(paramString);
  }
  
  @Deprecated
  public SimpleFilterProvider setDefaultFilter(BeanPropertyFilter paramBeanPropertyFilter)
  {
    _defaultFilter = SimpleBeanPropertyFilter.from(paramBeanPropertyFilter);
    return this;
  }
  
  public SimpleFilterProvider setDefaultFilter(PropertyFilter paramPropertyFilter)
  {
    _defaultFilter = paramPropertyFilter;
    return this;
  }
  
  public SimpleFilterProvider setDefaultFilter(SimpleBeanPropertyFilter paramSimpleBeanPropertyFilter)
  {
    _defaultFilter = paramSimpleBeanPropertyFilter;
    return this;
  }
  
  public SimpleFilterProvider setFailOnUnknownId(boolean paramBoolean)
  {
    _cfgFailOnUnknownId = paramBoolean;
    return this;
  }
  
  public boolean willFailOnUnknownId()
  {
    return _cfgFailOnUnknownId;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */