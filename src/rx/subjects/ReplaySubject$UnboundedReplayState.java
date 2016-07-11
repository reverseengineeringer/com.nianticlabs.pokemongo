package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observer;
import rx.internal.operators.NotificationLite;

final class ReplaySubject$UnboundedReplayState<T>
  implements ReplaySubject.ReplayState<T, Integer>
{
  static final AtomicIntegerFieldUpdater<UnboundedReplayState> INDEX_UPDATER = AtomicIntegerFieldUpdater.newUpdater(UnboundedReplayState.class, "index");
  volatile int index;
  private final ArrayList<Object> list;
  private final NotificationLite<T> nl = NotificationLite.instance();
  private volatile boolean terminated;
  
  public ReplaySubject$UnboundedReplayState(int paramInt)
  {
    list = new ArrayList(paramInt);
  }
  
  public void accept(Observer<? super T> paramObserver, int paramInt)
  {
    nl.accept(paramObserver, list.get(paramInt));
  }
  
  public void complete()
  {
    if (!terminated)
    {
      terminated = true;
      list.add(nl.completed());
      INDEX_UPDATER.getAndIncrement(this);
    }
  }
  
  public void error(Throwable paramThrowable)
  {
    if (!terminated)
    {
      terminated = true;
      list.add(nl.error(paramThrowable));
      INDEX_UPDATER.getAndIncrement(this);
    }
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public T latest()
  {
    Object localObject2 = null;
    int i = index;
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = list.get(i - 1);
      if ((!nl.isCompleted(localObject1)) && (!nl.isError(localObject1))) {
        break label73;
      }
      localObject1 = localObject2;
      if (i > 1) {
        localObject1 = nl.getValue(list.get(i - 2));
      }
    }
    return (T)localObject1;
    label73:
    return (T)nl.getValue(localObject1);
  }
  
  public void next(T paramT)
  {
    if (!terminated)
    {
      list.add(nl.next(paramT));
      INDEX_UPDATER.getAndIncrement(this);
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
      Integer localInteger = (Integer)paramSubjectObserver.index();
      if (localInteger != null)
      {
        paramSubjectObserver.index(Integer.valueOf(replayObserverFromIndex(localInteger, paramSubjectObserver).intValue()));
        return true;
      }
    }
    finally {}
    throw new IllegalStateException("failed to find lastEmittedLink for: " + paramSubjectObserver);
  }
  
  public Integer replayObserverFromIndex(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    int i = paramInteger.intValue();
    while (i < index)
    {
      accept(paramSubjectObserver, i);
      i += 1;
    }
    return Integer.valueOf(i);
  }
  
  public Integer replayObserverFromIndexTest(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
  {
    return replayObserverFromIndex(paramInteger, paramSubjectObserver);
  }
  
  public int size()
  {
    int j = index;
    int i = j;
    if (j > 0)
    {
      Object localObject = list.get(j - 1);
      if (!nl.isCompleted(localObject))
      {
        i = j;
        if (!nl.isError(localObject)) {}
      }
      else
      {
        i = j - 1;
      }
    }
    return i;
  }
  
  public boolean terminated()
  {
    return terminated;
  }
  
  public T[] toArray(T[] paramArrayOfT)
  {
    int j = size();
    Object localObject2;
    if (j > 0)
    {
      Object localObject1 = paramArrayOfT;
      if (j > paramArrayOfT.length) {
        localObject1 = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
      }
      int i = 0;
      while (i < j)
      {
        localObject1[i] = list.get(i);
        i += 1;
      }
      localObject2 = localObject1;
      if (localObject1.length > j)
      {
        localObject1[j] = null;
        localObject2 = localObject1;
      }
    }
    do
    {
      return (T[])localObject2;
      localObject2 = paramArrayOfT;
    } while (paramArrayOfT.length <= 0);
    paramArrayOfT[0] = null;
    return paramArrayOfT;
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.UnboundedReplayState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */