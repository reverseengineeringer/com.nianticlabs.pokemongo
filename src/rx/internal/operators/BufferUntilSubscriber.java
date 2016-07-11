package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class BufferUntilSubscriber<T>
  extends Subject<T, T>
{
  private static final Observer EMPTY_OBSERVER = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private boolean forward = false;
  final State<T> state;
  
  private BufferUntilSubscriber(State<T> paramState)
  {
    super(new OnSubscribeAction(paramState));
    state = paramState;
  }
  
  public static <T> BufferUntilSubscriber<T> create()
  {
    return new BufferUntilSubscriber(new State());
  }
  
  private void emit(Object paramObject)
  {
    synchronized (state.guard)
    {
      state.buffer.add(paramObject);
      if ((state.observerRef != null) && (!state.emitting))
      {
        forward = true;
        state.emitting = true;
      }
      if (forward)
      {
        paramObject = state.buffer.poll();
        if (paramObject != null) {
          state.nl.accept(state.observerRef, paramObject);
        }
      }
    }
  }
  
  public boolean hasObservers()
  {
    for (;;)
    {
      synchronized (state.guard)
      {
        if (state.observerRef != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void onCompleted()
  {
    if (forward)
    {
      state.observerRef.onCompleted();
      return;
    }
    emit(state.nl.completed());
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (forward)
    {
      state.observerRef.onError(paramThrowable);
      return;
    }
    emit(state.nl.error(paramThrowable));
  }
  
  public void onNext(T paramT)
  {
    if (forward)
    {
      state.observerRef.onNext(paramT);
      return;
    }
    emit(state.nl.next(paramT));
  }
  
  static final class OnSubscribeAction<T>
    implements Observable.OnSubscribe<T>
  {
    final BufferUntilSubscriber.State<T> state;
    
    public OnSubscribeAction(BufferUntilSubscriber.State<T> paramState)
    {
      state = paramState;
    }
    
    public void call(Subscriber<? super T> arg1)
    {
      if (state.casObserverRef(null, ???))
      {
        ???.add(Subscriptions.create(new Action0()
        {
          public void call()
          {
            state.observerRef = BufferUntilSubscriber.EMPTY_OBSERVER;
          }
        }));
        int i = 0;
        for (;;)
        {
          synchronized (state.guard)
          {
            if (!state.emitting)
            {
              state.emitting = true;
              i = 1;
            }
            if (i == 0) {
              break;
            }
            ??? = NotificationLite.instance();
            Object localObject1 = state.buffer.poll();
            if (localObject1 != null) {
              ???.accept(state.observerRef, localObject1);
            }
          }
          synchronized (state.guard)
          {
            if (state.buffer.isEmpty())
            {
              state.emitting = false;
              return;
            }
          }
        }
      }
      ???.onError(new IllegalStateException("Only one subscriber allowed!"));
    }
  }
  
  static final class State<T>
  {
    static final AtomicReferenceFieldUpdater<State, Observer> OBSERVER_UPDATER = AtomicReferenceFieldUpdater.newUpdater(State.class, Observer.class, "observerRef");
    final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue();
    boolean emitting = false;
    Object guard = new Object();
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile Observer<? super T> observerRef = null;
    
    boolean casObserverRef(Observer<? super T> paramObserver1, Observer<? super T> paramObserver2)
    {
      return OBSERVER_UPDATER.compareAndSet(this, paramObserver1, paramObserver2);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */