package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

final class OperatorZip$Zip<R>
{
  static final AtomicLongFieldUpdater<Zip> COUNTER_UPDATER = AtomicLongFieldUpdater.newUpdater(Zip.class, "counter");
  static final int THRESHOLD = (int)(RxRingBuffer.SIZE * 0.7D);
  private final Observer<? super R> child;
  private final CompositeSubscription childSubscription = new CompositeSubscription();
  volatile long counter;
  int emitted = 0;
  private Object[] observers;
  private AtomicLong requested;
  private final FuncN<? extends R> zipFunction;
  
  public OperatorZip$Zip(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN)
  {
    child = paramSubscriber;
    zipFunction = paramFuncN;
    paramSubscriber.add(childSubscription);
  }
  
  public void start(Observable[] paramArrayOfObservable, AtomicLong paramAtomicLong)
  {
    observers = new Object[paramArrayOfObservable.length];
    requested = paramAtomicLong;
    int i = 0;
    while (i < paramArrayOfObservable.length)
    {
      paramAtomicLong = new InnerSubscriber();
      observers[i] = paramAtomicLong;
      childSubscription.add(paramAtomicLong);
      i += 1;
    }
    i = 0;
    while (i < paramArrayOfObservable.length)
    {
      paramArrayOfObservable[i].unsafeSubscribe((InnerSubscriber)observers[i]);
      i += 1;
    }
  }
  
  void tick()
  {
    Object[] arrayOfObject = observers;
    if (arrayOfObject == null) {}
    while (COUNTER_UPDATER.getAndIncrement(this) != 0L) {
      return;
    }
    int k = arrayOfObject.length;
    Observer localObserver = child;
    AtomicLong localAtomicLong = requested;
    do
    {
      for (;;)
      {
        Object localObject1 = new Object[k];
        int j = 1;
        int i = 0;
        if (i < k)
        {
          RxRingBuffer localRxRingBuffer = items;
          Object localObject2 = localRxRingBuffer.peek();
          if (localObject2 == null) {
            j = 0;
          }
          for (;;)
          {
            i += 1;
            break;
            if (localRxRingBuffer.isCompleted(localObject2))
            {
              localObserver.onCompleted();
              childSubscription.unsubscribe();
              return;
            }
            localObject1[i] = localRxRingBuffer.getValue(localObject2);
          }
        }
        if ((localAtomicLong.get() <= 0L) || (j == 0)) {
          break;
        }
        for (;;)
        {
          try
          {
            localObserver.onNext(zipFunction.call((Object[])localObject1));
            localAtomicLong.decrementAndGet();
            emitted += 1;
            j = arrayOfObject.length;
            i = 0;
            if (i >= j) {
              break;
            }
            localObject1 = items;
            ((RxRingBuffer)localObject1).poll();
            if (((RxRingBuffer)localObject1).isCompleted(((RxRingBuffer)localObject1).peek()))
            {
              localObserver.onCompleted();
              childSubscription.unsubscribe();
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            localObserver.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, localObject1));
            return;
          }
          i += 1;
        }
        if (emitted > THRESHOLD)
        {
          j = localThrowable.length;
          i = 0;
          while (i < j)
          {
            ((InnerSubscriber)localThrowable[i]).requestMore(emitted);
            i += 1;
          }
          emitted = 0;
        }
      }
    } while (COUNTER_UPDATER.decrementAndGet(this) > 0L);
  }
  
  final class InnerSubscriber
    extends Subscriber
  {
    final RxRingBuffer items = RxRingBuffer.getSpmcInstance();
    
    InnerSubscriber() {}
    
    public void onCompleted()
    {
      items.onCompleted();
      tick();
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      try
      {
        items.onNext(paramObject);
        tick();
        return;
      }
      catch (MissingBackpressureException paramObject)
      {
        for (;;)
        {
          onError((Throwable)paramObject);
        }
      }
    }
    
    public void onStart()
    {
      request(RxRingBuffer.SIZE);
    }
    
    public void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZip.Zip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */