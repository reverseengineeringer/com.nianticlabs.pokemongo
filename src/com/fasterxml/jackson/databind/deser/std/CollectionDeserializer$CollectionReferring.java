package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class CollectionDeserializer$CollectionReferring
  extends ReadableObjectId.Referring
{
  private final CollectionDeserializer.CollectionReferringAccumulator _parent;
  public final List<Object> next = new ArrayList();
  
  CollectionDeserializer$CollectionReferring(CollectionDeserializer.CollectionReferringAccumulator paramCollectionReferringAccumulator, UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass)
  {
    super(paramUnresolvedForwardReference, paramClass);
    _parent = paramCollectionReferringAccumulator;
  }
  
  public void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
    throws IOException
  {
    _parent.resolveForwardReference(paramObject1, paramObject2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.CollectionReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */