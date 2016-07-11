package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithTime<T>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Scheduler scheduler;
  final int size;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorWindowWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    timespan = paramLong1;
    timeshift = paramLong2;
    unit = paramTimeUnit;
    size = paramInt;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    if (timespan == timeshift)
    {
      paramSubscriber = new ExactSubscriber(paramSubscriber, localWorker);
      paramSubscriber.add(localWorker);
      paramSubscriber.scheduleExact();
      return paramSubscriber;
    }
    paramSubscriber = new InexactSubscriber(paramSubscriber, localWorker);
    paramSubscriber.add(localWorker);
    paramSubscriber.startNewChunk();
    paramSubscriber.scheduleChunk();
    return paramSubscriber;
  }
  
  static final class CountedSerializedSubject<T>
  {
    final Observer<T> consumer;
    int count;
    final Observable<T> producer;
    
    public CountedSerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      consumer = new SerializedObserver(paramObserver);
      producer = paramObservable;
    }
  }
  
  final class ExactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    boolean emitting;
    final Object guard;
    List<Object> queue;
    volatile OperatorWindowWithTime.State<T> state;
    final Scheduler.Worker worker;
    
    public ExactSubscriber(Scheduler.Worker paramWorker)
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
      if (count == size - 1) {
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
      }, 0L, timespan, unit);
    }
  }
  
  final class InexactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    final List<OperatorWindowWithTime.CountedSerializedSubject<T>> chunks;
    boolean done;
    final Object guard;
    final Scheduler.Worker worker;
    
    public InexactSubscriber(Scheduler.Worker paramWorker)
    {
      super();
      child = paramWorker;
      Scheduler.Worker localWorker;
      worker = localWorker;
      guard = new Object();
      chunks = new LinkedList();
    }
    
    OperatorWindowWithTime.CountedSerializedSubject<T> createCountedSerializedSubject()
    {
      BufferUntilSubscriber localBufferUntilSubscriber = BufferUntilSubscriber.create();
      return new OperatorWindowWithTime.CountedSerializedSubject(localBufferUntilSubscriber, localBufferUntilSubscriber);
    }
    
    public void onCompleted()
    {
      synchronized (guard)
      {
        if (done) {
          return;
        }
        done = true;
        ArrayList localArrayList = new ArrayList(chunks);
        chunks.clear();
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          nextconsumer.onCompleted();
        }
      }
      child.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      synchronized (guard)
      {
        if (done) {
          return;
        }
        done = true;
        ArrayList localArrayList = new ArrayList(chunks);
        chunks.clear();
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          nextconsumer.onError(paramThrowable);
        }
      }
      child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      Object localObject2;
      synchronized (guard)
      {
        if (done) {
          return;
        }
        localObject2 = new ArrayList(chunks);
        Iterator localIterator = chunks.iterator();
        while (localIterator.hasNext())
        {
          OperatorWindowWithTime.CountedSerializedSubject localCountedSerializedSubject = (OperatorWindowWithTime.CountedSerializedSubject)localIterator.next();
          int i = count + 1;
          count = i;
          if (i == size) {
            localIterator.remove();
          }
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next();
        consumer.onNext(paramT);
        if (count == size) {
          consumer.onCompleted();
        }
      }
    }
    
    public void onStart()
    {
      request(Long.MAX_VALUE);
    }
    
    void scheduleChunk()
    {
      worker.schedulePeriodically(new Action0()
      {
        public void call()
        {
          startNewChunk();
        }
      }, timeshift, timeshift, unit);
    }
    
    void startNewChunk()
    {
      final OperatorWindowWithTime.CountedSerializedSubject localCountedSerializedSubject = createCountedSerializedSubject();
      synchronized (guard)
      {
        if (done) {
          return;
        }
        chunks.add(localCountedSerializedSubject);
      }
    }
    
    void terminateChunk(OperatorWindowWithTime.CountedSerializedSubject<T> paramCountedSerializedSubject)
    {
      int j = 0;
      synchronized (guard)
      {
        if (done) {
          return;
        }
        Iterator localIterator = chunks.iterator();
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        } while ((OperatorWindowWithTime.CountedSerializedSubject)localIterator.next() != paramCountedSerializedSubject);
        int i = 1;
        localIterator.remove();
        if (i != 0)
        {
          consumer.onCompleted();
          return;
        }
      }
    }
  }
  
  static final class State<T>
  {
    static final State<Object> EMPTY = new State(null, null, 0);
    final Observer<T> consumer;
    final int count;
    final Observable<T> producer;
    
    public State(Observer<T> paramObserver, Observable<T> paramObservable, int paramInt)
    {
      consumer = paramObserver;
      producer = paramObservable;
      count = paramInt;
    }
    
    public static <T> State<T> empty()
    {
      return EMPTY;
    }
    
    public State<T> clear()
    {
      return empty();
    }
    
    public State<T> create(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      return new State(paramObserver, paramObservable, 0);
    }
    
    public State<T> next()
    {
      return new State(consumer, producer, count + 1);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */