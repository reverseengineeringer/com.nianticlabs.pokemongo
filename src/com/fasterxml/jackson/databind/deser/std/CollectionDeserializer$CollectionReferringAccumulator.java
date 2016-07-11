package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class CollectionDeserializer$CollectionReferringAccumulator
{
  private List<CollectionDeserializer.CollectionReferring> _accumulator = new ArrayList();
  private final Class<?> _elementType;
  private final Collection<Object> _result;
  
  public CollectionDeserializer$CollectionReferringAccumulator(Class<?> paramClass, Collection<Object> paramCollection)
  {
    _elementType = paramClass;
    _result = paramCollection;
  }
  
  public void add(Object paramObject)
  {
    if (_accumulator.isEmpty())
    {
      _result.add(paramObject);
      return;
    }
    _accumulator.get(_accumulator.size() - 1)).next.add(paramObject);
  }
  
  public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference paramUnresolvedForwardReference)
  {
    paramUnresolvedForwardReference = new CollectionDeserializer.CollectionReferring(this, paramUnresolvedForwardReference, _elementType);
    _accumulator.add(paramUnresolvedForwardReference);
    return paramUnresolvedForwardReference;
  }
  
  public void resolveForwardReference(Object paramObject1, Object paramObject2)
    throws IOException
  {
    Iterator localIterator = _accumulator.iterator();
    CollectionDeserializer.CollectionReferring localCollectionReferring;
    for (Object localObject = _result; localIterator.hasNext(); localObject = next)
    {
      localCollectionReferring = (CollectionDeserializer.CollectionReferring)localIterator.next();
      if (localCollectionReferring.hasId(paramObject1))
      {
        localIterator.remove();
        ((Collection)localObject).add(paramObject2);
        ((Collection)localObject).addAll(next);
        return;
      }
    }
    throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + paramObject1 + "] that wasn't previously seen as unresolved.");
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.CollectionReferringAccumulator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */