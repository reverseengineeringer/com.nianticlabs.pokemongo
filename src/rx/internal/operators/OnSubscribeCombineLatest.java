package rx.internal.operators;

import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;

public final class OnSubscribeCombineLatest<T, R>
  implements Observable.OnSubscribe<R>
{
  final FuncN<? extends R> combinator;
  final List<? extends Observable<? extends T>> sources;
  
  public OnSubscribeCombineLatest(List<? extends Observable<? extends T>> paramList, FuncN<? extends R> paramFuncN)
  {
    sources = paramList;
    combinator = paramFuncN;
    if (paramList.size() > RxRingBuffer.SIZE) {
      throw new IllegalArgumentException("More than RxRingBuffer.SIZE sources to combineLatest is not supported.");
    }
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    if (sources.isEmpty())
    {
      paramSubscriber.onCompleted();
      return;
    }
    if (sources.size() == 1)
    {
      paramSubscriber.setProducer(new SingleSourceProducer(paramSubscriber, (Observable)sources.get(0), combinator));
      return;
    }
    paramSubscriber.setProducer(new MultiSourceProducer(paramSubscriber, sources, combinator));
  }
  
  static final class MultiSourceProducer<T, R>
    implements Producer
  {
    private static final AtomicLongFieldUpdater<MultiSourceProducer> WIP = AtomicLongFieldUpdater.newUpdater(MultiSourceProducer.class, "counter");
    private final RxRingBuffer buffer = RxRingBuffer.getSpmcInstance();
    private final Subscriber<? super R> child;
    private final Object[] collectedValues;
    private final FuncN<? extends R> combinator;
    private final BitSet completion;
    private volatile int completionCount;
    private volatile long counter;
    private final BitSet haveValues;
    private volatile int haveValuesCount;
    private final AtomicLong requested = new AtomicLong();
    private final List<? extends Observable<? extends T>> sources;
    private final AtomicBoolean started = new AtomicBoolean();
    private final OnSubscribeCombineLatest.MultiSourceRequestableSubscriber<T, R>[] subscribers;
    
    public MultiSourceProducer(Subscriber<? super R> paramSubscriber, List<? extends Observable<? extends T>> paramList, FuncN<? extends R> paramFuncN)
    {
      sources = paramList;
      child = paramSubscriber;
      combinator = paramFuncN;
      int i = paramList.size();
      subscribers = new OnSubscribeCombineLatest.MultiSourceRequestableSubscriber[i];
      collectedValues = new Object[i];
      haveValues = new BitSet(i);
      completion = new BitSet(i);
    }
    
    /* Error */
    public void onCompleted(int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_2
      //   1: ifne +11 -> 12
      //   4: aload_0
      //   5: getfield 79	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:child	Lrx/Subscriber;
      //   8: invokevirtual 110	rx/Subscriber:onCompleted	()V
      //   11: return
      //   12: iconst_0
      //   13: istore_3
      //   14: aload_0
      //   15: monitorenter
      //   16: aload_0
      //   17: getfield 102	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:completion	Ljava/util/BitSet;
      //   20: iload_1
      //   21: invokevirtual 114	java/util/BitSet:get	(I)Z
      //   24: ifne +35 -> 59
      //   27: aload_0
      //   28: getfield 102	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:completion	Ljava/util/BitSet;
      //   31: iload_1
      //   32: invokevirtual 117	java/util/BitSet:set	(I)V
      //   35: aload_0
      //   36: aload_0
      //   37: getfield 119	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:completionCount	I
      //   40: iconst_1
      //   41: iadd
      //   42: putfield 119	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:completionCount	I
      //   45: aload_0
      //   46: getfield 119	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:completionCount	I
      //   49: aload_0
      //   50: getfield 93	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:collectedValues	[Ljava/lang/Object;
      //   53: arraylength
      //   54: if_icmpne +23 -> 77
      //   57: iconst_1
      //   58: istore_3
      //   59: aload_0
      //   60: monitorexit
      //   61: iload_3
      //   62: ifeq -51 -> 11
      //   65: aload_0
      //   66: getfield 75	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:buffer	Lrx/internal/util/RxRingBuffer;
      //   69: invokevirtual 120	rx/internal/util/RxRingBuffer:onCompleted	()V
      //   72: aload_0
      //   73: invokevirtual 123	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:tick	()V
      //   76: return
      //   77: iconst_0
      //   78: istore_3
      //   79: goto -20 -> 59
      //   82: astore 4
      //   84: aload_0
      //   85: monitorexit
      //   86: aload 4
      //   88: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	89	0	this	MultiSourceProducer
      //   0	89	1	paramInt	int
      //   0	89	2	paramBoolean	boolean
      //   13	66	3	i	int
      //   82	5	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   16	57	82	finally
      //   59	61	82	finally
      //   84	86	82	finally
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    /* Error */
    public boolean onNext(int paramInt, T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 100	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:haveValues	Ljava/util/BitSet;
      //   6: iload_1
      //   7: invokevirtual 114	java/util/BitSet:get	(I)Z
      //   10: ifne +21 -> 31
      //   13: aload_0
      //   14: getfield 100	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:haveValues	Ljava/util/BitSet;
      //   17: iload_1
      //   18: invokevirtual 117	java/util/BitSet:set	(I)V
      //   21: aload_0
      //   22: aload_0
      //   23: getfield 135	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:haveValuesCount	I
      //   26: iconst_1
      //   27: iadd
      //   28: putfield 135	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:haveValuesCount	I
      //   31: aload_0
      //   32: getfield 93	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:collectedValues	[Ljava/lang/Object;
      //   35: iload_1
      //   36: aload_2
      //   37: aastore
      //   38: aload_0
      //   39: getfield 135	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:haveValuesCount	I
      //   42: aload_0
      //   43: getfield 93	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:collectedValues	[Ljava/lang/Object;
      //   46: arraylength
      //   47: if_icmpeq +7 -> 54
      //   50: aload_0
      //   51: monitorexit
      //   52: iconst_0
      //   53: ireturn
      //   54: aload_0
      //   55: getfield 75	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:buffer	Lrx/internal/util/RxRingBuffer;
      //   58: aload_0
      //   59: getfield 81	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:combinator	Lrx/functions/FuncN;
      //   62: aload_0
      //   63: getfield 93	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:collectedValues	[Ljava/lang/Object;
      //   66: invokeinterface 141 2 0
      //   71: invokevirtual 144	rx/internal/util/RxRingBuffer:onNext	(Ljava/lang/Object;)V
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_0
      //   77: invokevirtual 123	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:tick	()V
      //   80: iconst_1
      //   81: ireturn
      //   82: astore_2
      //   83: aload_0
      //   84: aload_2
      //   85: invokevirtual 145	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:onError	(Ljava/lang/Throwable;)V
      //   88: goto -14 -> 74
      //   91: astore_2
      //   92: aload_0
      //   93: monitorexit
      //   94: aload_2
      //   95: athrow
      //   96: astore_2
      //   97: aload_0
      //   98: aload_2
      //   99: invokevirtual 145	rx/internal/operators/OnSubscribeCombineLatest$MultiSourceProducer:onError	(Ljava/lang/Throwable;)V
      //   102: goto -28 -> 74
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	105	0	this	MultiSourceProducer
      //   0	105	1	paramInt	int
      //   0	105	2	paramT	T
      // Exception table:
      //   from	to	target	type
      //   54	74	82	rx/exceptions/MissingBackpressureException
      //   2	31	91	finally
      //   31	52	91	finally
      //   54	74	91	finally
      //   74	76	91	finally
      //   83	88	91	finally
      //   92	94	91	finally
      //   97	102	91	finally
      //   54	74	96	java/lang/Throwable
    }
    
    public void request(long paramLong)
    {
      BackpressureUtils.getAndAddRequest(requested, paramLong);
      if ((!started.get()) && (started.compareAndSet(false, true)))
      {
        int m = RxRingBuffer.SIZE / sources.size();
        int n = RxRingBuffer.SIZE;
        int i1 = sources.size();
        int i = 0;
        while (i < sources.size())
        {
          Observable localObservable = (Observable)sources.get(i);
          int j = m;
          int k = j;
          if (i == sources.size() - 1) {
            k = j + n % i1;
          }
          OnSubscribeCombineLatest.MultiSourceRequestableSubscriber localMultiSourceRequestableSubscriber = new OnSubscribeCombineLatest.MultiSourceRequestableSubscriber(i, k, child, this);
          subscribers[i] = localMultiSourceRequestableSubscriber;
          localObservable.unsafeSubscribe(localMultiSourceRequestableSubscriber);
          i += 1;
        }
      }
      tick();
    }
    
    void tick()
    {
      if (WIP.getAndIncrement(this) == 0L)
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (requested.get() > 0L)
        {
          localObject = buffer.poll();
          i = j;
          if (localObject != null)
          {
            if (!buffer.isCompleted(localObject)) {
              break label116;
            }
            child.onCompleted();
            i = j;
          }
        }
        for (;;)
        {
          j = i;
          if (WIP.decrementAndGet(this) > 0L) {
            break;
          }
          if (i <= 0) {
            return;
          }
          localObject = subscribers;
          int k = localObject.length;
          j = 0;
          while (j < k)
          {
            localObject[j].requestUpTo(i);
            j += 1;
          }
          label116:
          buffer.accept(localObject, child);
          i = j + 1;
          requested.decrementAndGet();
        }
      }
    }
  }
  
  static final class MultiSourceRequestableSubscriber<T, R>
    extends Subscriber<T>
  {
    final AtomicLong emitted = new AtomicLong();
    boolean hasValue = false;
    final int index;
    final OnSubscribeCombineLatest.MultiSourceProducer<T, R> producer;
    
    public MultiSourceRequestableSubscriber(int paramInt1, int paramInt2, Subscriber<? super R> paramSubscriber, OnSubscribeCombineLatest.MultiSourceProducer<T, R> paramMultiSourceProducer)
    {
      super();
      index = paramInt1;
      producer = paramMultiSourceProducer;
      request(paramInt2);
    }
    
    public void onCompleted()
    {
      producer.onCompleted(index, hasValue);
    }
    
    public void onError(Throwable paramThrowable)
    {
      producer.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      hasValue = true;
      emitted.incrementAndGet();
      if (!producer.onNext(index, paramT)) {
        request(1L);
      }
    }
    
    public void requestUpTo(long paramLong)
    {
      long l1;
      long l2;
      do
      {
        l1 = emitted.get();
        l2 = Math.min(l1, paramLong);
      } while (!emitted.compareAndSet(l1, l1 - l2));
      request(l2);
    }
  }
  
  static final class SingleSourceProducer<T, R>
    implements Producer
  {
    final Subscriber<? super R> child;
    final FuncN<? extends R> combinator;
    final Observable<? extends T> source;
    final AtomicBoolean started = new AtomicBoolean();
    final OnSubscribeCombineLatest.SingleSourceRequestableSubscriber<T, R> subscriber;
    
    public SingleSourceProducer(Subscriber<? super R> paramSubscriber, Observable<? extends T> paramObservable, FuncN<? extends R> paramFuncN)
    {
      source = paramObservable;
      child = paramSubscriber;
      combinator = paramFuncN;
      subscriber = new OnSubscribeCombineLatest.SingleSourceRequestableSubscriber(paramSubscriber, paramFuncN);
    }
    
    public void request(long paramLong)
    {
      subscriber.requestMore(paramLong);
      if (started.compareAndSet(false, true)) {
        source.unsafeSubscribe(subscriber);
      }
    }
  }
  
  static final class SingleSourceRequestableSubscriber<T, R>
    extends Subscriber<T>
  {
    private final Subscriber<? super R> child;
    private final FuncN<? extends R> combinator;
    
    SingleSourceRequestableSubscriber(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN)
    {
      super();
      child = paramSubscriber;
      combinator = paramFuncN;
    }
    
    public void onCompleted()
    {
      child.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      child.onNext(combinator.call(new Object[] { paramT }));
    }
    
    public void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */