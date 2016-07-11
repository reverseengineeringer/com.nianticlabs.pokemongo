package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class MapDeserializer$MapReferringAccumulator
{
  private List<MapDeserializer.MapReferring> _accumulator = new ArrayList();
  private Map<Object, Object> _result;
  private final Class<?> _valueType;
  
  public MapDeserializer$MapReferringAccumulator(Class<?> paramClass, Map<Object, Object> paramMap)
  {
    _valueType = paramClass;
    _result = paramMap;
  }
  
  public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference paramUnresolvedForwardReference, Object paramObject)
  {
    paramUnresolvedForwardReference = new MapDeserializer.MapReferring(this, paramUnresolvedForwardReference, _valueType, paramObject);
    _accumulator.add(paramUnresolvedForwardReference);
    return paramUnresolvedForwardReference;
  }
  
  public void put(Object paramObject1, Object paramObject2)
  {
    if (_accumulator.isEmpty())
    {
      _result.put(paramObject1, paramObject2);
      return;
    }
    _accumulator.get(_accumulator.size() - 1)).next.put(paramObject1, paramObject2);
  }
  
  public void resolveForwardReference(Object paramObject1, Object paramObject2)
    throws IOException
  {
    Iterator localIterator = _accumulator.iterator();
    MapDeserializer.MapReferring localMapReferring;
    for (Map localMap = _result; localIterator.hasNext(); localMap = next)
    {
      localMapReferring = (MapDeserializer.MapReferring)localIterator.next();
      if (localMapReferring.hasId(paramObject1))
      {
        localIterator.remove();
        localMap.put(key, paramObject2);
        localMap.putAll(next);
        return;
      }
    }
    throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + paramObject1 + "] that wasn't previously seen as unresolved.");
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.MapDeserializer.MapReferringAccumulator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */