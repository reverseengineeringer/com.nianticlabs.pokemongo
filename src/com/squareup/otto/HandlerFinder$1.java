package com.squareup.otto;

import java.util.Map;
import java.util.Set;

final class HandlerFinder$1
  implements HandlerFinder
{
  public Map<Class<?>, EventProducer> findAllProducers(Object paramObject)
  {
    return AnnotatedHandlerFinder.findAllProducers(paramObject);
  }
  
  public Map<Class<?>, Set<EventHandler>> findAllSubscribers(Object paramObject)
  {
    return AnnotatedHandlerFinder.findAllSubscribers(paramObject);
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.HandlerFinder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */