package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class Bus
{
  public static final String DEFAULT_IDENTIFIER = "default";
  private final ThreadEnforcer enforcer;
  private final ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>> eventsToDispatch = new ThreadLocal()
  {
    protected ConcurrentLinkedQueue<Bus.EventWithHandler> initialValue()
    {
      return new ConcurrentLinkedQueue();
    }
  };
  private final ConcurrentMap<Class<?>, Set<Class<?>>> flattenHierarchyCache = new ConcurrentHashMap();
  private final HandlerFinder handlerFinder;
  private final ConcurrentMap<Class<?>, Set<EventHandler>> handlersByType = new ConcurrentHashMap();
  private final String identifier;
  private final ThreadLocal<Boolean> isDispatching = new ThreadLocal()
  {
    protected Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  };
  private final ConcurrentMap<Class<?>, EventProducer> producersByType = new ConcurrentHashMap();
  
  public Bus()
  {
    this("default");
  }
  
  public Bus(ThreadEnforcer paramThreadEnforcer)
  {
    this(paramThreadEnforcer, "default");
  }
  
  public Bus(ThreadEnforcer paramThreadEnforcer, String paramString)
  {
    this(paramThreadEnforcer, paramString, HandlerFinder.ANNOTATED);
  }
  
  Bus(ThreadEnforcer paramThreadEnforcer, String paramString, HandlerFinder paramHandlerFinder)
  {
    enforcer = paramThreadEnforcer;
    identifier = paramString;
    handlerFinder = paramHandlerFinder;
  }
  
  public Bus(String paramString)
  {
    this(ThreadEnforcer.MAIN, paramString);
  }
  
  private void dispatchProducerResultToHandler(EventHandler paramEventHandler, EventProducer paramEventProducer)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramEventProducer.produceEvent();
      paramEventProducer = (EventProducer)localObject2;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        throwRuntimeException("Producer " + paramEventProducer + " threw an exception.", localInvocationTargetException);
        paramEventProducer = (EventProducer)localObject1;
      }
      dispatch(paramEventProducer, paramEventHandler);
    }
    if (paramEventProducer == null) {
      return;
    }
  }
  
  private Set<Class<?>> getClassesFor(Class<?> paramClass)
  {
    LinkedList localLinkedList = new LinkedList();
    HashSet localHashSet = new HashSet();
    localLinkedList.add(paramClass);
    while (!localLinkedList.isEmpty())
    {
      paramClass = (Class)localLinkedList.remove(0);
      localHashSet.add(paramClass);
      paramClass = paramClass.getSuperclass();
      if (paramClass != null) {
        localLinkedList.add(paramClass);
      }
    }
    return localHashSet;
  }
  
  private static void throwRuntimeException(String paramString, InvocationTargetException paramInvocationTargetException)
  {
    Throwable localThrowable = paramInvocationTargetException.getCause();
    if (localThrowable != null) {
      throw new RuntimeException(paramString + ": " + localThrowable.getMessage(), localThrowable);
    }
    throw new RuntimeException(paramString + ": " + paramInvocationTargetException.getMessage(), paramInvocationTargetException);
  }
  
  protected void dispatch(Object paramObject, EventHandler paramEventHandler)
  {
    try
    {
      paramEventHandler.handleEvent(paramObject);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throwRuntimeException("Could not dispatch event: " + paramObject.getClass() + " to handler " + paramEventHandler, localInvocationTargetException);
    }
  }
  
  /* Error */
  protected void dispatchQueuedEvents()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/squareup/otto/Bus:isDispatching	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 185	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 187	java/lang/Boolean
    //   10: invokevirtual 190	java/lang/Boolean:booleanValue	()Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 67	com/squareup/otto/Bus:isDispatching	Ljava/lang/ThreadLocal;
    //   21: iconst_1
    //   22: invokestatic 194	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   25: invokevirtual 197	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 64	com/squareup/otto/Bus:eventsToDispatch	Ljava/lang/ThreadLocal;
    //   32: invokevirtual 185	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   35: checkcast 199	java/util/concurrent/ConcurrentLinkedQueue
    //   38: invokevirtual 202	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   41: checkcast 10	com/squareup/otto/Bus$EventWithHandler
    //   44: astore_1
    //   45: aload_1
    //   46: ifnonnull +15 -> 61
    //   49: aload_0
    //   50: getfield 67	com/squareup/otto/Bus:isDispatching	Ljava/lang/ThreadLocal;
    //   53: iconst_0
    //   54: invokestatic 194	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: invokevirtual 197	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   60: return
    //   61: aload_1
    //   62: getfield 206	com/squareup/otto/Bus$EventWithHandler:handler	Lcom/squareup/otto/EventHandler;
    //   65: invokevirtual 209	com/squareup/otto/EventHandler:isValid	()Z
    //   68: ifeq -40 -> 28
    //   71: aload_0
    //   72: aload_1
    //   73: getfield 213	com/squareup/otto/Bus$EventWithHandler:event	Ljava/lang/Object;
    //   76: aload_1
    //   77: getfield 206	com/squareup/otto/Bus$EventWithHandler:handler	Lcom/squareup/otto/EventHandler;
    //   80: invokevirtual 116	com/squareup/otto/Bus:dispatch	(Ljava/lang/Object;Lcom/squareup/otto/EventHandler;)V
    //   83: goto -55 -> 28
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 67	com/squareup/otto/Bus:isDispatching	Ljava/lang/ThreadLocal;
    //   91: iconst_0
    //   92: invokestatic 194	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   95: invokevirtual 197	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	Bus
    //   44	33	1	localEventWithHandler	EventWithHandler
    //   86	13	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	45	86	finally
    //   61	83	86	finally
  }
  
  protected void enqueueEvent(Object paramObject, EventHandler paramEventHandler)
  {
    ((ConcurrentLinkedQueue)eventsToDispatch.get()).offer(new EventWithHandler(paramObject, paramEventHandler));
  }
  
  Set<Class<?>> flattenHierarchy(Class<?> paramClass)
  {
    Set localSet = (Set)flattenHierarchyCache.get(paramClass);
    Object localObject = localSet;
    if (localSet == null)
    {
      localSet = getClassesFor(paramClass);
      paramClass = (Set)flattenHierarchyCache.putIfAbsent(paramClass, localSet);
      localObject = paramClass;
      if (paramClass == null) {
        localObject = localSet;
      }
    }
    return (Set<Class<?>>)localObject;
  }
  
  Set<EventHandler> getHandlersForEventType(Class<?> paramClass)
  {
    return (Set)handlersByType.get(paramClass);
  }
  
  EventProducer getProducerForEventType(Class<?> paramClass)
  {
    return (EventProducer)producersByType.get(paramClass);
  }
  
  public void post(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Event to post must not be null.");
    }
    enforcer.enforce(this);
    Object localObject1 = flattenHierarchy(paramObject.getClass());
    int i = 0;
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = getHandlersForEventType((Class)((Iterator)localObject1).next());
      if ((localObject2 != null) && (!((Set)localObject2).isEmpty()))
      {
        int j = 1;
        localObject2 = ((Set)localObject2).iterator();
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          enqueueEvent(paramObject, (EventHandler)((Iterator)localObject2).next());
        }
      }
    }
    if ((i == 0) && (!(paramObject instanceof DeadEvent))) {
      post(new DeadEvent(this, paramObject));
    }
    dispatchQueuedEvents();
  }
  
  public void register(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Object to register must not be null.");
    }
    enforcer.enforce(this);
    Object localObject1 = handlerFinder.findAllProducers(paramObject);
    Object localObject2 = ((Map)localObject1).keySet().iterator();
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Class)((Iterator)localObject2).next();
      localObject3 = (EventProducer)((Map)localObject1).get(localObject4);
      localObject5 = (EventProducer)producersByType.putIfAbsent(localObject4, localObject3);
      if (localObject5 != null) {
        throw new IllegalArgumentException("Producer method for type " + localObject4 + " found on type " + target.getClass() + ", but already registered by type " + target.getClass() + ".");
      }
      localObject4 = (Set)handlersByType.get(localObject4);
      if ((localObject4 != null) && (!((Set)localObject4).isEmpty()))
      {
        localObject4 = ((Set)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          dispatchProducerResultToHandler((EventHandler)((Iterator)localObject4).next(), (EventProducer)localObject3);
        }
      }
    }
    Object localObject3 = handlerFinder.findAllSubscribers(paramObject);
    Object localObject4 = ((Map)localObject3).keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Class)((Iterator)localObject4).next();
      localObject1 = (Set)handlersByType.get(localObject5);
      paramObject = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new CopyOnWriteArraySet();
        localObject2 = (Set)handlersByType.putIfAbsent(localObject5, localObject1);
        paramObject = localObject2;
        if (localObject2 == null) {
          paramObject = localObject1;
        }
      }
      if (!((Set)paramObject).addAll((Set)((Map)localObject3).get(localObject5))) {
        throw new IllegalArgumentException("Object already registered.");
      }
    }
    paramObject = ((Map)localObject3).entrySet().iterator();
    label500:
    while (((Iterator)paramObject).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)paramObject).next();
      localObject1 = (Class)((Map.Entry)localObject2).getKey();
      localObject1 = (EventProducer)producersByType.get(localObject1);
      if ((localObject1 != null) && (((EventProducer)localObject1).isValid()))
      {
        localObject2 = ((Set)((Map.Entry)localObject2).getValue()).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label500;
          }
          localObject3 = (EventHandler)((Iterator)localObject2).next();
          if (!((EventProducer)localObject1).isValid()) {
            break;
          }
          if (((EventHandler)localObject3).isValid()) {
            dispatchProducerResultToHandler((EventHandler)localObject3, (EventProducer)localObject1);
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "[Bus \"" + identifier + "\"]";
  }
  
  public void unregister(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Object to unregister must not be null.");
    }
    enforcer.enforce(this);
    Iterator localIterator = handlerFinder.findAllProducers(paramObject).entrySet().iterator();
    Object localObject3;
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject3 = (Map.Entry)localIterator.next();
      localObject1 = (Class)((Map.Entry)localObject3).getKey();
      localObject2 = getProducerForEventType((Class)localObject1);
      localObject3 = (EventProducer)((Map.Entry)localObject3).getValue();
      if ((localObject3 == null) || (!((EventProducer)localObject3).equals(localObject2))) {
        throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + paramObject.getClass() + " registered?");
      }
      ((EventProducer)producersByType.remove(localObject1)).invalidate();
    }
    localIterator = handlerFinder.findAllSubscribers(paramObject).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = getHandlersForEventType((Class)((Map.Entry)localObject2).getKey());
      localObject2 = (Collection)((Map.Entry)localObject2).getValue();
      if ((localObject1 == null) || (!((Set)localObject1).containsAll((Collection)localObject2))) {
        throw new IllegalArgumentException("Missing event handler for an annotated method. Is " + paramObject.getClass() + " registered?");
      }
      localObject3 = ((Set)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        EventHandler localEventHandler = (EventHandler)((Iterator)localObject3).next();
        if (((Collection)localObject2).contains(localEventHandler)) {
          localEventHandler.invalidate();
        }
      }
      ((Set)localObject1).removeAll((Collection)localObject2);
    }
  }
  
  static class EventWithHandler
  {
    final Object event;
    final EventHandler handler;
    
    public EventWithHandler(Object paramObject, EventHandler paramEventHandler)
    {
      event = paramObject;
      handler = paramEventHandler;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.Bus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */