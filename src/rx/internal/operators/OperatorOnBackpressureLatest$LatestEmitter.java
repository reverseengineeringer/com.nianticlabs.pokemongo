package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OperatorOnBackpressureLatest$LatestEmitter<T>
  extends AtomicLong
  implements Producer, Subscription, Observer<T>
{
  static final Object EMPTY = new Object();
  static final long NOT_REQUESTED = -4611686018427387904L;
  private static final long serialVersionUID = -1364393685005146274L;
  final Subscriber<? super T> child;
  volatile boolean done;
  boolean emitting;
  boolean missed;
  OperatorOnBackpressureLatest.LatestSubscriber<? super T> parent;
  Throwable terminal;
  final AtomicReference<Object> value;
  
  public OperatorOnBackpressureLatest$LatestEmitter(Subscriber<? super T> paramSubscriber)
  {
    child = paramSubscriber;
    value = new AtomicReference(EMPTY);
    lazySet(-4611686018427387904L);
  }
  
  /* Error */
  void emit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 70	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 68	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 70	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   27: aload_0
    //   28: monitorexit
    //   29: iconst_0
    //   30: istore_3
    //   31: iconst_0
    //   32: istore_2
    //   33: iload_3
    //   34: istore_1
    //   35: aload_0
    //   36: invokevirtual 74	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:get	()J
    //   39: lstore 4
    //   41: lload 4
    //   43: ldc2_w 75
    //   46: lcmp
    //   47: ifne +31 -> 78
    //   50: iconst_1
    //   51: ifne +232 -> 283
    //   54: aload_0
    //   55: monitorenter
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 68	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore 6
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 6
    //   70: athrow
    //   71: astore 6
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 6
    //   77: athrow
    //   78: iload_3
    //   79: istore_1
    //   80: aload_0
    //   81: getfield 59	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:value	Ljava/util/concurrent/atomic/AtomicReference;
    //   84: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   87: astore 7
    //   89: aload 7
    //   91: astore 6
    //   93: lload 4
    //   95: lconst_0
    //   96: lcmp
    //   97: ifle +58 -> 155
    //   100: aload 7
    //   102: astore 6
    //   104: iload_3
    //   105: istore_1
    //   106: aload 7
    //   108: getstatic 47	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   111: if_acmpeq +44 -> 155
    //   114: iload_3
    //   115: istore_1
    //   116: aload_0
    //   117: getfield 52	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   120: aload 7
    //   122: invokevirtual 84	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   125: iload_3
    //   126: istore_1
    //   127: aload_0
    //   128: getfield 59	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:value	Ljava/util/concurrent/atomic/AtomicReference;
    //   131: aload 7
    //   133: getstatic 47	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   136: invokevirtual 88	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   139: pop
    //   140: iload_3
    //   141: istore_1
    //   142: aload_0
    //   143: lconst_1
    //   144: invokevirtual 92	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:produced	(J)J
    //   147: pop2
    //   148: iload_3
    //   149: istore_1
    //   150: getstatic 47	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   153: astore 6
    //   155: iload_3
    //   156: istore_1
    //   157: aload 6
    //   159: getstatic 47	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   162: if_acmpne +36 -> 198
    //   165: iload_3
    //   166: istore_1
    //   167: aload_0
    //   168: getfield 94	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:done	Z
    //   171: ifeq +27 -> 198
    //   174: iload_3
    //   175: istore_1
    //   176: aload_0
    //   177: getfield 96	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:terminal	Ljava/lang/Throwable;
    //   180: astore 6
    //   182: aload 6
    //   184: ifnull +66 -> 250
    //   187: iload_3
    //   188: istore_1
    //   189: aload_0
    //   190: getfield 52	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   193: aload 6
    //   195: invokevirtual 100	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   198: iload_3
    //   199: istore_1
    //   200: aload_0
    //   201: monitorenter
    //   202: iload_2
    //   203: istore_1
    //   204: aload_0
    //   205: getfield 70	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   208: ifne +54 -> 262
    //   211: iload_2
    //   212: istore_1
    //   213: aload_0
    //   214: iconst_0
    //   215: putfield 68	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   218: iconst_1
    //   219: istore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: goto -172 -> 50
    //   225: astore 6
    //   227: aload_0
    //   228: monitorexit
    //   229: aload 6
    //   231: athrow
    //   232: astore 6
    //   234: iload_1
    //   235: ifne +12 -> 247
    //   238: aload_0
    //   239: monitorenter
    //   240: aload_0
    //   241: iconst_0
    //   242: putfield 68	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   245: aload_0
    //   246: monitorexit
    //   247: aload 6
    //   249: athrow
    //   250: iload_3
    //   251: istore_1
    //   252: aload_0
    //   253: getfield 52	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   256: invokevirtual 103	rx/Subscriber:onCompleted	()V
    //   259: goto -61 -> 198
    //   262: iload_2
    //   263: istore_1
    //   264: aload_0
    //   265: iconst_0
    //   266: putfield 70	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   269: iload_2
    //   270: istore_1
    //   271: aload_0
    //   272: monitorexit
    //   273: goto -240 -> 33
    //   276: astore 6
    //   278: aload_0
    //   279: monitorexit
    //   280: aload 6
    //   282: athrow
    //   283: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	LatestEmitter
    //   34	237	1	i	int
    //   32	238	2	j	int
    //   30	221	3	k	int
    //   39	55	4	l	long
    //   64	5	6	localObject1	Object
    //   71	5	6	localObject2	Object
    //   91	103	6	localObject3	Object
    //   225	5	6	localObject4	Object
    //   232	16	6	localObject5	Object
    //   276	5	6	localObject6	Object
    //   87	45	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   56	63	64	finally
    //   66	68	64	finally
    //   2	16	71	finally
    //   17	29	71	finally
    //   73	75	71	finally
    //   204	211	225	finally
    //   213	218	225	finally
    //   220	222	225	finally
    //   227	229	225	finally
    //   264	269	225	finally
    //   271	273	225	finally
    //   35	41	232	finally
    //   80	89	232	finally
    //   106	114	232	finally
    //   116	125	232	finally
    //   127	140	232	finally
    //   142	148	232	finally
    //   150	155	232	finally
    //   157	165	232	finally
    //   167	174	232	finally
    //   176	182	232	finally
    //   189	198	232	finally
    //   200	202	232	finally
    //   229	232	232	finally
    //   252	259	232	finally
    //   240	247	276	finally
    //   278	280	276	finally
  }
  
  public boolean isUnsubscribed()
  {
    return get() == Long.MIN_VALUE;
  }
  
  public void onCompleted()
  {
    done = true;
    emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    terminal = paramThrowable;
    done = true;
    emit();
  }
  
  public void onNext(T paramT)
  {
    value.lazySet(paramT);
    emit();
  }
  
  long produced(long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = get();
      if (l1 < 0L) {
        return l1;
      }
      l2 = l1 - paramLong;
    } while (!compareAndSet(l1, l2));
    return l2;
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (;;)
    {
      long l3 = get();
      if (l3 == Long.MIN_VALUE) {
        return;
      }
      long l1;
      if (l3 == -4611686018427387904L) {
        l1 = paramLong;
      }
      while (compareAndSet(l3, l1))
      {
        if (l3 == -4611686018427387904L) {
          parent.requestMore(Long.MAX_VALUE);
        }
        emit();
        return;
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = Long.MAX_VALUE;
        }
      }
    }
  }
  
  public void unsubscribe()
  {
    if (get() >= 0L) {
      getAndSet(Long.MIN_VALUE);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */