package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorWindowWithObservable<T, U>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Observable<U> other;
  
  public OperatorWindowWithObservable(Observable<U> paramObservable)
  {
    other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    SourceSubscriber localSourceSubscriber = new SourceSubscriber(paramSubscriber);
    BoundarySubscriber localBoundarySubscriber = new BoundarySubscriber(paramSubscriber, localSourceSubscriber);
    paramSubscriber.add(localSourceSubscriber);
    paramSubscriber.add(localBoundarySubscriber);
    localSourceSubscriber.replaceWindow();
    other.unsafeSubscribe(localBoundarySubscriber);
    return localSourceSubscriber;
  }
  
  static final class BoundarySubscriber<T, U>
    extends Subscriber<U>
  {
    final OperatorWindowWithObservable.SourceSubscriber<T> sub;
    
    public BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservable.SourceSubscriber<T> paramSourceSubscriber)
    {
      sub = paramSourceSubscriber;
    }
    
    public void onCompleted()
    {
      sub.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      sub.onError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      sub.replaceWindow();
    }
    
    public void onStart()
    {
      request(Long.MAX_VALUE);
    }
  }
  
  static final class SourceSubscriber<T>
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    Observer<T> consumer;
    boolean emitting;
    final Object guard;
    Observable<T> producer;
    List<Object> queue;
    
    public SourceSubscriber(Subscriber<? super Observable<T>> paramSubscriber)
    {
      child = new SerializedSubscriber(paramSubscriber);
      guard = new Object();
    }
    
    void complete()
    {
      Observer localObserver = consumer;
      consumer = null;
      producer = null;
      if (localObserver != null) {
        localObserver.onCompleted();
      }
      child.onCompleted();
      unsubscribe();
    }
    
    void createNewWindow()
    {
      BufferUntilSubscriber localBufferUntilSubscriber = BufferUntilSubscriber.create();
      consumer = localBufferUntilSubscriber;
      producer = localBufferUntilSubscriber;
    }
    
    void drain(List<Object> paramList)
    {
      if (paramList == null) {}
      for (;;)
      {
        return;
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = paramList.next();
          if (localObject == OperatorWindowWithObservable.NEXT_SUBJECT)
          {
            replaceSubject();
          }
          else
          {
            if (OperatorWindowWithObservable.nl.isError(localObject))
            {
              error(OperatorWindowWithObservable.nl.getError(localObject));
              return;
            }
            if (OperatorWindowWithObservable.nl.isCompleted(localObject))
            {
              complete();
              return;
            }
            emitValue(localObject);
          }
        }
      }
    }
    
    void emitValue(T paramT)
    {
      Observer localObserver = consumer;
      if (localObserver != null) {
        localObserver.onNext(paramT);
      }
    }
    
    void error(Throwable paramThrowable)
    {
      Observer localObserver = consumer;
      consumer = null;
      producer = null;
      if (localObserver != null) {
        localObserver.onError(paramThrowable);
      }
      child.onError(paramThrowable);
      unsubscribe();
    }
    
    public void onCompleted()
    {
      List localList;
      synchronized (guard)
      {
        if (emitting)
        {
          if (queue == null) {
            queue = new ArrayList();
          }
          queue.add(OperatorWindowWithObservable.nl.completed());
          return;
        }
        localList = queue;
        queue = null;
        emitting = true;
      }
      try
      {
        drain(localList);
        complete();
        return;
      }
      catch (Throwable localThrowable)
      {
        error(localThrowable);
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    
    public void onError(Throwable paramThrowable)
    {
      synchronized (guard)
      {
        if (emitting)
        {
          queue = Collections.singletonList(OperatorWindowWithObservable.nl.error(paramThrowable));
          return;
        }
        queue = null;
        emitting = true;
        error(paramThrowable);
        return;
      }
    }
    
    public void onNext(T arg1)
    {
      for (;;)
      {
        List localList;
        int k;
        int n;
        int m;
        int i;
        synchronized (guard)
        {
          if (emitting)
          {
            if (queue == null) {
              queue = new ArrayList();
            }
            queue.add(???);
            return;
          }
          localList = queue;
          queue = null;
          emitting = true;
          k = 1;
          n = 0;
          m = 0;
          i = n;
        }
        try
        {
          drain(localList);
          int j = k;
          if (k != 0)
          {
            j = 0;
            i = n;
            emitValue(???);
          }
          i = n;
          ??? = guard;
          i = n;
          i = m;
          try
          {
            localList = queue;
            i = m;
            queue = null;
            if (localList == null)
            {
              i = m;
              emitting = false;
              i = 1;
              if (1 == 0)
              {
                synchronized (guard)
                {
                  emitting = false;
                  return;
                }
                ??? = finally;
                throw ???;
              }
            }
            else
            {
              i = m;
              i = n;
              boolean bool = child.isUnsubscribed();
              k = j;
              if (!bool) {
                continue;
              }
              if (0 == 0)
              {
                synchronized (guard)
                {
                  emitting = false;
                  return;
                }
                localObject3 = finally;
              }
            }
          }
          finally {}
          return;
        }
        finally
        {
          if (i == 0) {}
          synchronized (guard)
          {
            emitting = false;
            throw ((Throwable)localObject3);
          }
        }
      }
    }
    
    public void onStart()
    {
      request(Long.MAX_VALUE);
    }
    
    void replaceSubject()
    {
      Observer localObserver = consumer;
      if (localObserver != null) {
        localObserver.onCompleted();
      }
      createNewWindow();
      child.onNext(producer);
    }
    
    void replaceWindow()
    {
      for (;;)
      {
        int k;
        int n;
        int m;
        int i;
        synchronized (guard)
        {
          if (emitting)
          {
            if (queue == null) {
              queue = new ArrayList();
            }
            queue.add(OperatorWindowWithObservable.NEXT_SUBJECT);
            return;
          }
          ??? = queue;
          queue = null;
          emitting = true;
          k = 1;
          n = 0;
          m = 0;
          i = n;
        }
        try
        {
          drain((List)???);
          int j = k;
          if (k != 0)
          {
            j = 0;
            i = n;
            replaceSubject();
          }
          i = n;
          ??? = guard;
          i = n;
          i = m;
          try
          {
            ??? = queue;
            i = m;
            queue = null;
            if (??? == null)
            {
              i = m;
              emitting = false;
              i = 1;
              if (1 == 0)
              {
                synchronized (guard)
                {
                  emitting = false;
                  return;
                }
                localObject2 = finally;
                throw ((Throwable)localObject2);
              }
            }
            else
            {
              i = m;
              i = n;
              boolean bool = child.isUnsubscribed();
              k = j;
              if (!bool) {
                continue;
              }
              if (0 == 0)
              {
                synchronized (guard)
                {
                  emitting = false;
                  return;
                }
                localObject9 = finally;
              }
            }
          }
          finally {}
          return;
        }
        finally
        {
          if (i == 0) {}
          synchronized (guard)
          {
            emitting = false;
            throw ((Throwable)localObject9);
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */