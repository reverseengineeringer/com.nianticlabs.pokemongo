package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;

public final class SubscriptionRandomList<T extends Subscription>
  implements Subscription
{
  private Set<T> subscriptions;
  private boolean unsubscribed = false;
  
  private static <T extends Subscription> void unsubscribeFromAll(Collection<T> paramCollection)
  {
    if (paramCollection == null) {
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<T>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (Subscription)localIterator.next();
      try
      {
        ((Subscription)localObject).unsubscribe();
      }
      catch (Throwable localThrowable)
      {
        localObject = paramCollection;
        if (paramCollection == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localThrowable);
        paramCollection = (Collection<T>)localObject;
      }
    }
    Exceptions.throwIfAny(paramCollection);
  }
  
  /* Error */
  public void add(T paramT)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	rx/internal/util/SubscriptionRandomList:unsubscribed	Z
    //   8: ifeq +16 -> 24
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: ifnull +9 -> 23
    //   17: aload_1
    //   18: invokeinterface 42 1 0
    //   23: return
    //   24: aload_0
    //   25: getfield 62	rx/internal/util/SubscriptionRandomList:subscriptions	Ljava/util/Set;
    //   28: ifnonnull +15 -> 43
    //   31: aload_0
    //   32: new 64	java/util/HashSet
    //   35: dup
    //   36: iconst_4
    //   37: invokespecial 67	java/util/HashSet:<init>	(I)V
    //   40: putfield 62	rx/internal/util/SubscriptionRandomList:subscriptions	Ljava/util/Set;
    //   43: aload_0
    //   44: getfield 62	rx/internal/util/SubscriptionRandomList:subscriptions	Ljava/util/Set;
    //   47: aload_1
    //   48: invokeinterface 70 2 0
    //   53: pop
    //   54: aload_2
    //   55: astore_1
    //   56: goto -45 -> 11
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	SubscriptionRandomList
    //   0	64	1	paramT	T
    //   1	54	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	59	finally
    //   11	13	59	finally
    //   24	43	59	finally
    //   43	54	59	finally
    //   60	62	59	finally
  }
  
  public void clear()
  {
    try
    {
      if ((unsubscribed) || (subscriptions == null)) {
        return;
      }
      Set localSet = subscriptions;
      subscriptions = null;
      unsubscribeFromAll(localSet);
      return;
    }
    finally {}
  }
  
  public void forEach(Action1<T> paramAction1)
  {
    try
    {
      if ((unsubscribed) || (subscriptions == null)) {
        return;
      }
      Subscription[] arrayOfSubscription = (Subscription[])subscriptions.toArray(null);
      int j = arrayOfSubscription.length;
      int i = 0;
      while (i < j)
      {
        paramAction1.call(arrayOfSubscription[i]);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public boolean isUnsubscribed()
  {
    try
    {
      boolean bool = unsubscribed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void remove(Subscription paramSubscription)
  {
    try
    {
      if ((unsubscribed) || (subscriptions == null)) {
        return;
      }
      boolean bool = subscriptions.remove(paramSubscription);
      if (bool)
      {
        paramSubscription.unsubscribe();
        return;
      }
    }
    finally {}
  }
  
  public void unsubscribe()
  {
    try
    {
      if (unsubscribed) {
        return;
      }
      unsubscribed = true;
      Set localSet = subscriptions;
      subscriptions = null;
      unsubscribeFromAll(localSet);
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.SubscriptionRandomList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */