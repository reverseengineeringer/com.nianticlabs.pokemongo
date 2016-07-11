package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

final class MapDeserializer$MapReferring
  extends ReadableObjectId.Referring
{
  private final MapDeserializer.MapReferringAccumulator _parent;
  public final Object key;
  public final Map<Object, Object> next = new LinkedHashMap();
  
  MapDeserializer$MapReferring(MapDeserializer.MapReferringAccumulator paramMapReferringAccumulator, UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass, Object paramObject)
  {
    super(paramUnresolvedForwardReference, paramClass);
    _parent = paramMapReferringAccumulator;
    key = paramObject;
  }
  
  public void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
    throws IOException
  {
    _parent.resolveForwardReference(paramObject1, paramObject2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.MapDeserializer.MapReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */