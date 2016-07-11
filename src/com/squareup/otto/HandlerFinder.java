package com.squareup.otto;

import java.util.Map;
import java.util.Set;

abstract interface HandlerFinder
{
  public static final HandlerFinder ANNOTATED = new HandlerFinder()
  {
    public Map<Class<?>, EventProducer> findAllProducers(Object paramAnonymousObject)
    {
      return AnnotatedHandlerFinder.findAllProducers(paramAnonymousObject);
    }
    
    public Map<Class<?>, Set<EventHandler>> findAllSubscribers(Object paramAnonymousObject)
    {
      return AnnotatedHandlerFinder.findAllSubscribers(paramAnonymousObject);
    }
  };
  
  public abstract Map<Class<?>, EventProducer> findAllProducers(Object paramObject);
  
  public abstract Map<Class<?>, Set<EventHandler>> findAllSubscribers(Object paramObject);
}

/* Location:
 * Qualified Name:     com.squareup.otto.HandlerFinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */