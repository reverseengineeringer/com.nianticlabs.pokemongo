package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OperatorMapNotification<T, R>
  implements Observable.Operator<R, T>
{
  private final Func0<? extends R> onCompleted;
  private final Func1<? super Throwable, ? extends R> onError;
  private final Func1<? super T, ? extends R> onNext;
  
  public OperatorMapNotification(Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
  {
    onNext = paramFunc1;
    onError = paramFunc11;
    onCompleted = paramFunc0;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super R> paramSubscriber)
  {
    Subscriber local1 = new Subscriber()
    {
      OperatorMapNotification.SingleEmitter<R> emitter;
      
      public void onCompleted()
      {
        try
        {
          emitter.offerAndComplete(onCompleted.call());
          return;
        }
        catch (Throwable localThrowable)
        {
          paramSubscriber.onError(localThrowable);
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        try
        {
          emitter.offerAndComplete(onError.call(paramAnonymousThrowable));
          return;
        }
        catch (Throwable localThrowable)
        {
          paramSubscriber.onError(paramAnonymousThrowable);
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        try
        {
          emitter.offer(onNext.call(paramAnonymousT));
          return;
        }
        catch (Throwable localThrowable)
        {
          paramSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymousT));
        }
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        emitter = new OperatorMapNotification.SingleEmitter(paramSubscriber, paramAnonymousProducer, this);
        paramSubscriber.setProducer(emitter);
      }
    };
    paramSubscriber.add(local1);
    return local1;
  }
  
  static final class SingleEmitter<T>
    extends AtomicLong
    implements Producer, Subscription
  {
    private static final long serialVersionUID = -249869671366010660L;
    final Subscription cancel;
    final Subscriber<? super T> child;
    volatile boolean complete;
    boolean emitting;
    boolean missed;
    final NotificationLite<T> nl;
    final Producer producer;
    final Queue<Object> queue;
    
    public SingleEmitter(Subscriber<? super T> paramSubscriber, Producer paramProducer, Subscription paramSubscription)
    {
      child = paramSubscriber;
      producer = paramProducer;
      cancel = paramSubscription;
      if (UnsafeAccess.isUnsafeAvailable()) {}
      for (paramSubscriber = new SpscArrayQueue(2);; paramSubscriber = new ConcurrentLinkedQueue())
      {
        queue = paramSubscriber;
        nl = NotificationLite.instance();
        return;
      }
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   6: ifeq +11 -> 17
      //   9: aload_0
      //   10: iconst_1
      //   11: putfield 76	rx/internal/operators/OperatorMapNotification$SingleEmitter:missed	Z
      //   14: aload_0
      //   15: monitorexit
      //   16: return
      //   17: aload_0
      //   18: iconst_1
      //   19: putfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   22: aload_0
      //   23: iconst_0
      //   24: putfield 76	rx/internal/operators/OperatorMapNotification$SingleEmitter:missed	Z
      //   27: aload_0
      //   28: monitorexit
      //   29: iconst_0
      //   30: istore_3
      //   31: iconst_0
      //   32: istore_2
      //   33: iload_3
      //   34: istore_1
      //   35: aload_0
      //   36: invokevirtual 80	rx/internal/operators/OperatorMapNotification$SingleEmitter:get	()J
      //   39: lstore 4
      //   41: iload_3
      //   42: istore_1
      //   43: aload_0
      //   44: getfield 82	rx/internal/operators/OperatorMapNotification$SingleEmitter:complete	Z
      //   47: istore 6
      //   49: iload_3
      //   50: istore_1
      //   51: aload_0
      //   52: getfield 57	rx/internal/operators/OperatorMapNotification$SingleEmitter:queue	Ljava/util/Queue;
      //   55: invokeinterface 87 1 0
      //   60: istore 7
      //   62: iload 6
      //   64: ifeq +45 -> 109
      //   67: iload 7
      //   69: ifeq +40 -> 109
      //   72: iload_3
      //   73: istore_1
      //   74: aload_0
      //   75: getfield 40	rx/internal/operators/OperatorMapNotification$SingleEmitter:child	Lrx/Subscriber;
      //   78: invokevirtual 92	rx/Subscriber:onCompleted	()V
      //   81: iconst_1
      //   82: ifne +205 -> 287
      //   85: aload_0
      //   86: monitorenter
      //   87: aload_0
      //   88: iconst_0
      //   89: putfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   92: aload_0
      //   93: monitorexit
      //   94: return
      //   95: astore 8
      //   97: aload_0
      //   98: monitorexit
      //   99: aload 8
      //   101: athrow
      //   102: astore 8
      //   104: aload_0
      //   105: monitorexit
      //   106: aload 8
      //   108: athrow
      //   109: lload 4
      //   111: lconst_0
      //   112: lcmp
      //   113: ifle +46 -> 159
      //   116: iload_3
      //   117: istore_1
      //   118: aload_0
      //   119: getfield 57	rx/internal/operators/OperatorMapNotification$SingleEmitter:queue	Ljava/util/Queue;
      //   122: invokeinterface 96 1 0
      //   127: astore 8
      //   129: aload 8
      //   131: ifnull +75 -> 206
      //   134: iload_3
      //   135: istore_1
      //   136: aload_0
      //   137: getfield 40	rx/internal/operators/OperatorMapNotification$SingleEmitter:child	Lrx/Subscriber;
      //   140: aload_0
      //   141: getfield 65	rx/internal/operators/OperatorMapNotification$SingleEmitter:nl	Lrx/internal/operators/NotificationLite;
      //   144: aload 8
      //   146: invokevirtual 100	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
      //   149: invokevirtual 104	rx/Subscriber:onNext	(Ljava/lang/Object;)V
      //   152: iload_3
      //   153: istore_1
      //   154: aload_0
      //   155: lconst_1
      //   156: invokevirtual 108	rx/internal/operators/OperatorMapNotification$SingleEmitter:produced	(J)V
      //   159: iload_3
      //   160: istore_1
      //   161: aload_0
      //   162: monitorenter
      //   163: iload_2
      //   164: istore_1
      //   165: aload_0
      //   166: getfield 76	rx/internal/operators/OperatorMapNotification$SingleEmitter:missed	Z
      //   169: ifne +72 -> 241
      //   172: iconst_1
      //   173: istore_2
      //   174: iload_2
      //   175: istore_1
      //   176: aload_0
      //   177: iconst_0
      //   178: putfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   181: iload_2
      //   182: istore_1
      //   183: aload_0
      //   184: monitorexit
      //   185: iconst_1
      //   186: ifne +101 -> 287
      //   189: aload_0
      //   190: monitorenter
      //   191: aload_0
      //   192: iconst_0
      //   193: putfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   196: aload_0
      //   197: monitorexit
      //   198: return
      //   199: astore 8
      //   201: aload_0
      //   202: monitorexit
      //   203: aload 8
      //   205: athrow
      //   206: iload 6
      //   208: ifeq -49 -> 159
      //   211: iload_3
      //   212: istore_1
      //   213: aload_0
      //   214: getfield 40	rx/internal/operators/OperatorMapNotification$SingleEmitter:child	Lrx/Subscriber;
      //   217: invokevirtual 92	rx/Subscriber:onCompleted	()V
      //   220: iconst_1
      //   221: ifne +66 -> 287
      //   224: aload_0
      //   225: monitorenter
      //   226: aload_0
      //   227: iconst_0
      //   228: putfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   231: aload_0
      //   232: monitorexit
      //   233: return
      //   234: astore 8
      //   236: aload_0
      //   237: monitorexit
      //   238: aload 8
      //   240: athrow
      //   241: iload_2
      //   242: istore_1
      //   243: aload_0
      //   244: iconst_0
      //   245: putfield 76	rx/internal/operators/OperatorMapNotification$SingleEmitter:missed	Z
      //   248: iload_2
      //   249: istore_1
      //   250: aload_0
      //   251: monitorexit
      //   252: goto -219 -> 33
      //   255: astore 8
      //   257: aload_0
      //   258: monitorexit
      //   259: aload 8
      //   261: athrow
      //   262: astore 8
      //   264: iload_1
      //   265: ifne +12 -> 277
      //   268: aload_0
      //   269: monitorenter
      //   270: aload_0
      //   271: iconst_0
      //   272: putfield 74	rx/internal/operators/OperatorMapNotification$SingleEmitter:emitting	Z
      //   275: aload_0
      //   276: monitorexit
      //   277: aload 8
      //   279: athrow
      //   280: astore 8
      //   282: aload_0
      //   283: monitorexit
      //   284: aload 8
      //   286: athrow
      //   287: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	288	0	this	SingleEmitter
      //   34	231	1	i	int
      //   32	217	2	j	int
      //   30	182	3	k	int
      //   39	71	4	l	long
      //   47	160	6	bool1	boolean
      //   60	8	7	bool2	boolean
      //   95	5	8	localObject1	Object
      //   102	5	8	localObject2	Object
      //   127	18	8	localObject3	Object
      //   199	5	8	localObject4	Object
      //   234	5	8	localObject5	Object
      //   255	5	8	localObject6	Object
      //   262	16	8	localObject7	Object
      //   280	5	8	localObject8	Object
      // Exception table:
      //   from	to	target	type
      //   87	94	95	finally
      //   97	99	95	finally
      //   2	16	102	finally
      //   17	29	102	finally
      //   104	106	102	finally
      //   191	198	199	finally
      //   201	203	199	finally
      //   226	233	234	finally
      //   236	238	234	finally
      //   165	172	255	finally
      //   176	181	255	finally
      //   183	185	255	finally
      //   243	248	255	finally
      //   250	252	255	finally
      //   257	259	255	finally
      //   35	41	262	finally
      //   43	49	262	finally
      //   51	62	262	finally
      //   74	81	262	finally
      //   118	129	262	finally
      //   136	152	262	finally
      //   154	159	262	finally
      //   161	163	262	finally
      //   213	220	262	finally
      //   259	262	262	finally
      //   270	277	280	finally
      //   282	284	280	finally
    }
    
    public boolean isUnsubscribed()
    {
      return get() < 0L;
    }
    
    public void offer(T paramT)
    {
      if (!queue.offer(paramT))
      {
        child.onError(new MissingBackpressureException());
        unsubscribe();
        return;
      }
      drain();
    }
    
    public void offerAndComplete(T paramT)
    {
      if (!queue.offer(paramT))
      {
        child.onError(new MissingBackpressureException());
        unsubscribe();
        return;
      }
      complete = true;
      drain();
    }
    
    void produced(long paramLong)
    {
      long l1;
      long l2;
      do
      {
        l1 = get();
        if (l1 < 0L) {
          return;
        }
        l2 = l1 - paramLong;
        if (l2 < 0L) {
          throw new IllegalStateException("More produced (" + paramLong + ") than requested (" + l1 + ")");
        }
      } while (!compareAndSet(l1, l2));
    }
    
    public void request(long paramLong)
    {
      long l3;
      long l1;
      do
      {
        l3 = get();
        if (l3 < 0L) {
          return;
        }
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = Long.MAX_VALUE;
        }
      } while (!compareAndSet(l3, l1));
      producer.request(paramLong);
      drain();
    }
    
    public void unsubscribe()
    {
      if ((get() != Long.MIN_VALUE) && (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE)) {
        cancel.unsubscribe();
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMapNotification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */