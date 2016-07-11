package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithTime$ExactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  boolean emitting;
  final Object guard;
  List<Object> queue;
  volatile OperatorWindowWithTime.State<T> state;
  final Scheduler.Worker worker;
  
  public OperatorWindowWithTime$ExactSubscriber(final Subscriber<? super Observable<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    child = new SerializedSubscriber(paramWorker);
    Scheduler.Worker localWorker;
    worker = localWorker;
    guard = new Object();
    state = OperatorWindowWithTime.State.empty();
    paramWorker.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        if (state.consumer == null) {
          unsubscribe();
        }
      }
    }));
  }
  
  void complete()
  {
    Observer localObserver = state.consumer;
    state = state.clear();
    if (localObserver != null) {
      localObserver.onCompleted();
    }
    child.onCompleted();
    unsubscribe();
  }
  
  boolean drain(List<Object> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        while (!paramList.hasNext())
        {
          return true;
          paramList = paramList.iterator();
        }
        localObject = paramList.next();
        if (localObject != OperatorWindowWithTime.NEXT_SUBJECT) {
          break;
        }
      } while (replaceSubject());
      return false;
      if (OperatorWindowWithTime.nl.isError(localObject))
      {
        error(OperatorWindowWithTime.nl.getError(localObject));
        return true;
      }
      if (OperatorWindowWithTime.nl.isCompleted(localObject))
      {
        complete();
        return true;
      }
    } while (emitValue(localObject));
    return false;
  }
  
  boolean emitValue(T paramT)
  {
    OperatorWindowWithTime.State localState2 = state;
    OperatorWindowWithTime.State localState1 = localState2;
    if (consumer == null)
    {
      if (!replaceSubject()) {
        return false;
      }
      localState1 = state;
    }
    consumer.onNext(paramT);
    if (count == this$0.size - 1) {
      consumer.onCompleted();
    }
    for (paramT = localState1.clear();; paramT = localState1.next())
    {
      state = paramT;
      return true;
    }
  }
  
  void error(Throwable paramThrowable)
  {
    Observer localObserver = state.consumer;
    state = state.clear();
    if (localObserver != null) {
      localObserver.onError(paramThrowable);
    }
    child.onError(paramThrowable);
    unsubscribe();
  }
  
  void nextWindow()
  {
    int k;
    int j;
    int i;
    synchronized (guard)
    {
      if (emitting)
      {
        if (queue == null) {
          queue = new ArrayList();
        }
        queue.add(OperatorWindowWithTime.NEXT_SUBJECT);
        return;
      }
      emitting = true;
      k = 0;
      j = 0;
      i = k;
    }
    try
    {
      boolean bool = replaceSubject();
      if (!bool)
      {
        if (0 == 0)
        {
          synchronized (guard)
          {
            emitting = false;
            return;
          }
          localObject3 = finally;
          throw ((Throwable)localObject3);
        }
      }
      else {
        for (;;)
        {
          i = k;
          ??? = guard;
          i = k;
          i = j;
          try
          {
            List localList1 = queue;
            if (localList1 == null)
            {
              i = j;
              emitting = false;
              i = 1;
              if (1 == 0) {
                synchronized (guard)
                {
                  emitting = false;
                  return;
                }
              }
            }
            else
            {
              i = j;
              queue = null;
              i = j;
              i = k;
              bool = drain(localList2);
              if (!bool) {
                if (0 == 0)
                {
                  synchronized (guard)
                  {
                    emitting = false;
                    return;
                  }
                  localObject6 = finally;
                }
              }
            }
          }
          finally {}
        }
      }
      return;
    }
    finally
    {
      if (i == 0) {}
      synchronized (guard)
      {
        emitting = false;
        throw ((Throwable)localObject6);
      }
    }
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
        queue.add(OperatorWindowWithTime.nl.completed());
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
        queue = Collections.singletonList(OperatorWindowWithTime.nl.error(paramThrowable));
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
    int k;
    int j;
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
      emitting = true;
      k = 0;
      j = 0;
      i = k;
    }
    try
    {
      boolean bool = emitValue(???);
      if (!bool)
      {
        if (0 == 0)
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
      else {
        for (;;)
        {
          i = k;
          ??? = guard;
          i = k;
          i = j;
          try
          {
            List localList1 = queue;
            if (localList1 == null)
            {
              i = j;
              emitting = false;
              i = 1;
              if (1 == 0) {
                synchronized (guard)
                {
                  emitting = false;
                  return;
                }
              }
            }
            else
            {
              i = j;
              queue = null;
              i = j;
              i = k;
              bool = drain(localList2);
              if (!bool) {
                if (0 == 0)
                {
                  synchronized (guard)
                  {
                    emitting = false;
                    return;
                  }
                  localObject5 = finally;
                }
              }
            }
          }
          finally {}
        }
      }
      return;
    }
    finally
    {
      if (i == 0) {}
      synchronized (guard)
      {
        emitting = false;
        throw ((Throwable)localObject5);
      }
    }
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
  
  boolean replaceSubject()
  {
    Object localObject = state.consumer;
    if (localObject != null) {
      ((Observer)localObject).onCompleted();
    }
    if (child.isUnsubscribed())
    {
      state = state.clear();
      unsubscribe();
      return false;
    }
    localObject = BufferUntilSubscriber.create();
    state = state.create((Observer)localObject, (Observable)localObject);
    child.onNext(localObject);
    return true;
  }
  
  void scheduleExact()
  {
    worker.schedulePeriodically(new Action0()
    {
      public void call()
      {
        nextWindow();
      }
    }, 0L, this$0.timespan, this$0.unit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.ExactSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */