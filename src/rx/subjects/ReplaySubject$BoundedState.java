package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.functions.Func1;
import rx.internal.operators.NotificationLite;

final class ReplaySubject$BoundedState<T>
  implements ReplaySubject.ReplayState<T, ReplaySubject.NodeList.Node<Object>>
{
  final Func1<Object, Object> enterTransform;
  final ReplaySubject.EvictionPolicy evictionPolicy;
  final Func1<Object, Object> leaveTransform;
  final ReplaySubject.NodeList<Object> list = new ReplaySubject.NodeList();
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile ReplaySubject.NodeList.Node<Object> tail = list.tail;
  volatile boolean terminated;
  
  public ReplaySubject$BoundedState(ReplaySubject.EvictionPolicy paramEvictionPolicy, Func1<Object, Object> paramFunc11, Func1<Object, Object> paramFunc12)
  {
    evictionPolicy = paramEvictionPolicy;
    enterTransform = paramFunc11;
    leaveTransform = paramFunc12;
  }
  
  public void accept(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode)
  {
    nl.accept(paramObserver, leaveTransform.call(value));
  }
  
  public void acceptTest(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode, long paramLong)
  {
    paramNode = value;
    if (!evictionPolicy.test(paramNode, paramLong)) {
      nl.accept(paramObserver, leaveTransform.call(paramNode));
    }
  }
  
  public void complete()
  {
    if (!terminated)
    {
      terminated = true;
      list.addLast(enterTransform.call(nl.completed()));
      evictionPolicy.evictFinal(list);
      tail = list.tail;
    }
  }
  
  public void error(Throwable paramThrowable)
  {
    if (!terminated)
    {
      terminated = true;
      list.addLast(enterTransform.call(nl.error(paramThrowable)));
      evictionPolicy.evictFinal(list);
      tail = list.tail;
    }
  }
  
  public ReplaySubject.NodeList.Node<Object> head()
  {
    return list.head;
  }
  
  public boolean isEmpty()
  {
    Object localObject = headnext;
    if (localObject == null) {}
    do
    {
      return true;
      localObject = leaveTransform.call(value);
    } while ((nl.isError(localObject)) || (nl.isCompleted(localObject)));
    return false;
  }
  
  public T latest()
  {
    Object localObject1 = headnext;
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return null;
      localObject2 = null;
      while (localObject1 != tail())
      {
        localObject2 = localObject1;
        localObject1 = next;
      }
      localObject1 = leaveTransform.call(value);
      if ((!nl.isError(localObject1)) && (!nl.isCompleted(localObject1))) {
        break;
      }
    } while (localObject2 == null);
    localObject1 = leaveTransform.call(value);
    return (T)nl.getValue(localObject1);
    return (T)nl.getValue(localObject1);
  }
  
  public void next(T paramT)
  {
    if (!terminated)
    {
      list.addLast(enterTransform.call(nl.next(paramT)));
      evictionPolicy.evict(list);
      tail = list.tail;
    }
  }
  
  public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    try
    {
      first = false;
      if (emitting) {
        return false;
      }
      paramSubjectObserver.index(replayObserverFromIndex((ReplaySubject.NodeList.Node)paramSubjectObserver.index(), paramSubjectObserver));
      return true;
    }
    finally {}
  }
  
  public ReplaySubject.NodeList.Node<Object> replayObserverFromIndex(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    while (paramNode != tail())
    {
      accept(paramSubjectObserver, next);
      paramNode = next;
    }
    return paramNode;
  }
  
  public ReplaySubject.NodeList.Node<Object> replayObserverFromIndexTest(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
  {
    while (paramNode != tail())
    {
      acceptTest(paramSubjectObserver, next, paramLong);
      paramNode = next;
    }
    return paramNode;
  }
  
  public int size()
  {
    int i = 0;
    Object localObject2 = head();
    for (Object localObject1 = next; localObject1 != null; localObject1 = next)
    {
      i += 1;
      localObject2 = localObject1;
    }
    int j = i;
    if (value != null)
    {
      localObject1 = leaveTransform.call(value);
      j = i;
      if (localObject1 != null) {
        if (!nl.isError(localObject1))
        {
          j = i;
          if (!nl.isCompleted(localObject1)) {}
        }
        else
        {
          j = i - 1;
        }
      }
    }
    return j;
  }
  
  public ReplaySubject.NodeList.Node<Object> tail()
  {
    return tail;
  }
  
  public boolean terminated()
  {
    return terminated;
  }
  
  public T[] toArray(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList();
    for (ReplaySubject.NodeList.Node localNode = headnext;; localNode = next)
    {
      Object localObject;
      if (localNode != null)
      {
        localObject = leaveTransform.call(value);
        if ((next != null) || ((!nl.isError(localObject)) && (!nl.isCompleted(localObject)))) {}
      }
      else
      {
        return localArrayList.toArray(paramArrayOfT);
      }
      localArrayList.add(localObject);
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.BoundedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */