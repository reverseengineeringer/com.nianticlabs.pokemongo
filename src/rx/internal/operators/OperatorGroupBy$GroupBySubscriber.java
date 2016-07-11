package rx.internal.operators;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.observables.GroupedObservable;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

final class OperatorGroupBy$GroupBySubscriber<K, T, R>
  extends Subscriber<T>
{
  static final AtomicLongFieldUpdater<GroupBySubscriber> BUFFERED_COUNT = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "bufferedCount");
  static final AtomicIntegerFieldUpdater<GroupBySubscriber> COMPLETION_EMITTED_UPDATER;
  private static final int MAX_QUEUE_SIZE = 1024;
  static final AtomicLongFieldUpdater<GroupBySubscriber> REQUESTED;
  static final AtomicIntegerFieldUpdater<GroupBySubscriber> TERMINATED_UPDATER;
  private static final int TERMINATED_WITH_COMPLETED = 1;
  private static final int TERMINATED_WITH_ERROR = 2;
  private static final int UNTERMINATED = 0;
  static final AtomicIntegerFieldUpdater<GroupBySubscriber> WIP_FOR_UNSUBSCRIBE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "wipForUnsubscribe");
  private static final NotificationLite<Object> nl = NotificationLite.instance();
  volatile long bufferedCount;
  final Subscriber<? super GroupedObservable<K, R>> child;
  volatile int completionEmitted;
  final Func1<? super T, ? extends R> elementSelector;
  private final ConcurrentHashMap<Object, GroupState<K, T>> groups = new ConcurrentHashMap();
  final Func1<? super T, ? extends K> keySelector;
  volatile long requested;
  final GroupBySubscriber<K, T, R> self = this;
  volatile int terminated = 0;
  volatile int wipForUnsubscribe = 1;
  
  static
  {
    COMPLETION_EMITTED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "completionEmitted");
    TERMINATED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "terminated");
    REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "requested");
  }
  
  public OperatorGroupBy$GroupBySubscriber(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends R> paramFunc11, Subscriber<? super GroupedObservable<K, R>> paramSubscriber)
  {
    keySelector = paramFunc1;
    elementSelector = paramFunc11;
    child = paramSubscriber;
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        if (OperatorGroupBy.GroupBySubscriber.WIP_FOR_UNSUBSCRIBE_UPDATER.decrementAndGet(self) == 0) {
          self.unsubscribe();
        }
      }
    }));
  }
  
  private void cleanupGroup(Object paramObject)
  {
    paramObject = (GroupState)groups.remove(paramObject);
    if (paramObject != null)
    {
      if (!buffer.isEmpty()) {
        BUFFERED_COUNT.addAndGet(self, -buffer.size());
      }
      completeInner();
      requestMoreIfNecessary();
    }
  }
  
  private void completeInner()
  {
    if (WIP_FOR_UNSUBSCRIBE_UPDATER.decrementAndGet(this) == 0) {
      unsubscribe();
    }
    while ((!groups.isEmpty()) || (terminated != 1) || (!COMPLETION_EMITTED_UPDATER.compareAndSet(this, 0, 1))) {
      return;
    }
    child.onCompleted();
  }
  
  private GroupState<K, T> createNewGroup(final Object paramObject)
  {
    final GroupState localGroupState = new GroupState(null);
    GroupedObservable localGroupedObservable = GroupedObservable.create(getKey(paramObject), new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super R> paramAnonymousSubscriber)
      {
        paramAnonymousSubscriber.setProducer(new Producer()
        {
          public void request(long paramAnonymous2Long)
          {
            requestFromGroupedObservable(paramAnonymous2Long, val$groupState);
          }
        });
        final AtomicBoolean localAtomicBoolean = new AtomicBoolean();
        localGroupState.getObservable().doOnUnsubscribe(new Action0()
        {
          public void call()
          {
            if (localAtomicBoolean.compareAndSet(false, true)) {
              OperatorGroupBy.GroupBySubscriber.this.cleanupGroup(val$key);
            }
          }
        }).unsafeSubscribe(new Subscriber(paramAnonymousSubscriber)
        {
          public void onCompleted()
          {
            paramAnonymousSubscriber.onCompleted();
            if (localAtomicBoolean.compareAndSet(false, true)) {
              OperatorGroupBy.GroupBySubscriber.this.cleanupGroup(val$key);
            }
          }
          
          public void onError(Throwable paramAnonymous2Throwable)
          {
            paramAnonymousSubscriber.onError(paramAnonymous2Throwable);
            if (localAtomicBoolean.compareAndSet(false, true)) {
              OperatorGroupBy.GroupBySubscriber.this.cleanupGroup(val$key);
            }
          }
          
          public void onNext(T paramAnonymous2T)
          {
            try
            {
              paramAnonymousSubscriber.onNext(elementSelector.call(paramAnonymous2T));
              return;
            }
            catch (Throwable localThrowable)
            {
              onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymous2T));
            }
          }
          
          public void onStart() {}
        });
      }
    });
    int i;
    do
    {
      i = wipForUnsubscribe;
      if (i <= 0) {
        return null;
      }
    } while (!WIP_FOR_UNSUBSCRIBE_UPDATER.compareAndSet(this, i, i + 1));
    if ((GroupState)groups.putIfAbsent(paramObject, localGroupState) != null) {
      throw new IllegalStateException("Group already existed while creating a new one");
    }
    child.onNext(localGroupedObservable);
    return localGroupState;
  }
  
  private void drainIfPossible(GroupState<K, T> paramGroupState)
  {
    while (requested.get() > 0L)
    {
      Object localObject = buffer.poll();
      if (localObject == null) {
        break;
      }
      Observer localObserver = paramGroupState.getObserver();
      nl.accept(localObserver, localObject);
      if (requested.get() != Long.MAX_VALUE) {
        requested.decrementAndGet();
      }
      BUFFERED_COUNT.decrementAndGet(this);
      requestMoreIfNecessary();
    }
  }
  
  private void emitItem(GroupState<K, T> paramGroupState, Object paramObject)
  {
    Queue localQueue = buffer;
    AtomicLong localAtomicLong = requested;
    REQUESTED.decrementAndGet(this);
    if ((localAtomicLong != null) && (localAtomicLong.get() > 0L) && ((localQueue == null) || (localQueue.isEmpty())))
    {
      paramGroupState = paramGroupState.getObserver();
      nl.accept(paramGroupState, paramObject);
      if (localAtomicLong.get() != Long.MAX_VALUE) {
        localAtomicLong.decrementAndGet();
      }
    }
    for (;;)
    {
      requestMoreIfNecessary();
      return;
      localQueue.add(paramObject);
      BUFFERED_COUNT.incrementAndGet(this);
      if (count.getAndIncrement() == 0L) {
        pollQueue(paramGroupState);
      }
    }
  }
  
  private K getKey(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == OperatorGroupBy.access$200()) {
      localObject = null;
    }
    return (K)localObject;
  }
  
  private Object groupedKey(K paramK)
  {
    Object localObject = paramK;
    if (paramK == null) {
      localObject = OperatorGroupBy.access$200();
    }
    return localObject;
  }
  
  private void pollQueue(GroupState<K, T> paramGroupState)
  {
    do
    {
      drainIfPossible(paramGroupState);
      if (count.decrementAndGet() > 1L) {
        count.set(1L);
      }
    } while (count.get() > 0L);
  }
  
  private void requestMoreIfNecessary()
  {
    if ((REQUESTED.get(this) == 0L) && (terminated == 0))
    {
      long l = 1024L - BUFFERED_COUNT.get(this);
      if ((l > 0L) && (REQUESTED.compareAndSet(this, 0L, l))) {
        request(l);
      }
    }
  }
  
  public void onCompleted()
  {
    if (TERMINATED_UPDATER.compareAndSet(this, 0, 1))
    {
      Iterator localIterator = groups.values().iterator();
      while (localIterator.hasNext()) {
        emitItem((GroupState)localIterator.next(), nl.completed());
      }
      if ((groups.isEmpty()) && (COMPLETION_EMITTED_UPDATER.compareAndSet(this, 0, 1))) {
        child.onCompleted();
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (TERMINATED_UPDATER.compareAndSet(this, 0, 2))
    {
      Iterator localIterator = groups.values().iterator();
      while (localIterator.hasNext()) {
        emitItem((GroupState)localIterator.next(), nl.error(paramThrowable));
      }
    }
    try
    {
      child.onError(paramThrowable);
      return;
    }
    finally
    {
      unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Object localObject = groupedKey(keySelector.call(paramT));
      GroupState localGroupState2 = (GroupState)groups.get(localObject);
      GroupState localGroupState1 = localGroupState2;
      if (localGroupState2 == null)
      {
        if (child.isUnsubscribed()) {
          return;
        }
        localGroupState1 = createNewGroup(localObject);
      }
      if (localGroupState1 != null)
      {
        emitItem(localGroupState1, nl.next(paramT));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
  
  public void onStart()
  {
    REQUESTED.set(this, 1024L);
    request(1024L);
  }
  
  void requestFromGroupedObservable(long paramLong, GroupState<K, T> paramGroupState)
  {
    BackpressureUtils.getAndAddRequest(requested, paramLong);
    if (count.getAndIncrement() == 0L) {
      pollQueue(paramGroupState);
    }
  }
  
  private static class GroupState<K, T>
  {
    private final Queue<Object> buffer = new ConcurrentLinkedQueue();
    private final AtomicLong count = new AtomicLong();
    private final AtomicLong requested = new AtomicLong();
    private final Subject<T, T> s = BufferUntilSubscriber.create();
    
    public Observable<T> getObservable()
    {
      return s;
    }
    
    public Observer<T> getObserver()
    {
      return s;
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */