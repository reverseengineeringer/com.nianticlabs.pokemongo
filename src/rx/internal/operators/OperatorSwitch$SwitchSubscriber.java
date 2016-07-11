package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

final class OperatorSwitch$SwitchSubscriber<T>
  extends Subscriber<Observable<? extends T>>
{
  boolean active;
  SwitchSubscriber<T>.InnerSubscriber currentSubscriber;
  boolean emitting;
  final Object guard = new Object();
  int index;
  volatile boolean infinite = false;
  long initialRequested;
  boolean mainDone;
  final NotificationLite<?> nl = NotificationLite.instance();
  List<Object> queue;
  final SerializedSubscriber<T> s;
  final SerialSubscription ssub;
  
  public OperatorSwitch$SwitchSubscriber(Subscriber<? super T> paramSubscriber)
  {
    s = new SerializedSubscriber(paramSubscriber);
    ssub = new SerialSubscription();
    paramSubscriber.add(ssub);
    paramSubscriber.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        if (infinite) {
          return;
        }
        if (paramAnonymousLong == Long.MAX_VALUE) {
          infinite = true;
        }
        for (;;)
        {
          synchronized (guard)
          {
            OperatorSwitch.SwitchSubscriber.InnerSubscriber localInnerSubscriber = currentSubscriber;
            if (currentSubscriber == null)
            {
              l = initialRequested + paramAnonymousLong;
              if (l < 0L)
              {
                infinite = true;
                if (localInnerSubscriber == null) {
                  break;
                }
                if (!infinite) {
                  break label173;
                }
                localInnerSubscriber.requestMore(Long.MAX_VALUE);
                return;
              }
              initialRequested = l;
            }
          }
          long l = OperatorSwitch.SwitchSubscriber.InnerSubscriber.access$100(currentSubscriber) + paramAnonymousLong;
          if (l < 0L) {
            infinite = true;
          } else {
            OperatorSwitch.SwitchSubscriber.InnerSubscriber.access$102(currentSubscriber, l);
          }
        }
        label173:
        ((OperatorSwitch.SwitchSubscriber.InnerSubscriber)localObject2).requestMore(paramAnonymousLong);
      }
    });
  }
  
  void complete(int paramInt)
  {
    synchronized (guard)
    {
      if (paramInt != index) {
        return;
      }
      active = false;
      if (!mainDone) {
        return;
      }
    }
    if (emitting)
    {
      if (queue == null) {
        queue = new ArrayList();
      }
      queue.add(nl.completed());
      return;
    }
    List localList = queue;
    queue = null;
    emitting = true;
    drain(localList);
    s.onCompleted();
    unsubscribe();
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
        if (nl.isCompleted(localObject))
        {
          s.onCompleted();
          return;
        }
        if (nl.isError(localObject))
        {
          s.onError(nl.getError(localObject));
          return;
        }
        s.onNext(localObject);
      }
    }
  }
  
  /* Error */
  void emit(T arg1, int paramInt, SwitchSubscriber<T>.InnerSubscriber paramSwitchSubscriber)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	rx/internal/operators/OperatorSwitch$SwitchSubscriber:guard	Ljava/lang/Object;
    //   4: astore 11
    //   6: aload 11
    //   8: monitorenter
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 87	rx/internal/operators/OperatorSwitch$SwitchSubscriber:index	I
    //   14: if_icmpeq +7 -> 21
    //   17: aload 11
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 93	rx/internal/operators/OperatorSwitch$SwitchSubscriber:emitting	Z
    //   25: ifeq +58 -> 83
    //   28: aload_0
    //   29: getfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   32: ifnonnull +14 -> 46
    //   35: aload_0
    //   36: new 97	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 98	java/util/ArrayList:<init>	()V
    //   43: putfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   46: aload_3
    //   47: invokestatic 155	rx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber:access$100	(Lrx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber;)J
    //   50: ldc2_w 156
    //   53: lcmp
    //   54: ifeq +8 -> 62
    //   57: aload_3
    //   58: invokestatic 160	rx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber:access$110	(Lrx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber;)J
    //   61: pop2
    //   62: aload_0
    //   63: getfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   66: aload_1
    //   67: invokeinterface 107 2 0
    //   72: pop
    //   73: aload 11
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload 11
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: aload_0
    //   84: getfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   87: astore 10
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 93	rx/internal/operators/OperatorSwitch$SwitchSubscriber:emitting	Z
    //   99: aload 11
    //   101: monitorexit
    //   102: iconst_1
    //   103: istore 5
    //   105: iconst_0
    //   106: istore 7
    //   108: iconst_0
    //   109: istore 8
    //   111: iconst_0
    //   112: istore 6
    //   114: iload 7
    //   116: istore_2
    //   117: aload_0
    //   118: aload 10
    //   120: invokevirtual 111	rx/internal/operators/OperatorSwitch$SwitchSubscriber:drain	(Ljava/util/List;)V
    //   123: iload 5
    //   125: istore 4
    //   127: iload 5
    //   129: ifeq +51 -> 180
    //   132: iconst_0
    //   133: istore 4
    //   135: iload 7
    //   137: istore_2
    //   138: aload_0
    //   139: getfield 48	rx/internal/operators/OperatorSwitch$SwitchSubscriber:guard	Ljava/lang/Object;
    //   142: astore 10
    //   144: iload 7
    //   146: istore_2
    //   147: aload 10
    //   149: monitorenter
    //   150: aload_3
    //   151: invokestatic 155	rx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber:access$100	(Lrx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber;)J
    //   154: ldc2_w 156
    //   157: lcmp
    //   158: ifeq +8 -> 166
    //   161: aload_3
    //   162: invokestatic 160	rx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber:access$110	(Lrx/internal/operators/OperatorSwitch$SwitchSubscriber$InnerSubscriber;)J
    //   165: pop2
    //   166: aload 10
    //   168: monitorexit
    //   169: iload 7
    //   171: istore_2
    //   172: aload_0
    //   173: getfield 64	rx/internal/operators/OperatorSwitch$SwitchSubscriber:s	Lrx/observers/SerializedSubscriber;
    //   176: aload_1
    //   177: invokevirtual 148	rx/observers/SerializedSubscriber:onNext	(Ljava/lang/Object;)V
    //   180: iload 7
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 48	rx/internal/operators/OperatorSwitch$SwitchSubscriber:guard	Ljava/lang/Object;
    //   187: astore 11
    //   189: iload 7
    //   191: istore_2
    //   192: aload 11
    //   194: monitorenter
    //   195: iload 8
    //   197: istore_2
    //   198: aload_0
    //   199: getfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   202: astore 10
    //   204: iload 8
    //   206: istore_2
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 95	rx/internal/operators/OperatorSwitch$SwitchSubscriber:queue	Ljava/util/List;
    //   212: aload 10
    //   214: ifnonnull +76 -> 290
    //   217: iload 8
    //   219: istore_2
    //   220: aload_0
    //   221: iconst_0
    //   222: putfield 93	rx/internal/operators/OperatorSwitch$SwitchSubscriber:emitting	Z
    //   225: iconst_1
    //   226: istore_2
    //   227: iconst_1
    //   228: istore 4
    //   230: aload 11
    //   232: monitorexit
    //   233: iload 4
    //   235: istore_2
    //   236: iload_2
    //   237: ifne +97 -> 334
    //   240: aload_0
    //   241: getfield 48	rx/internal/operators/OperatorSwitch$SwitchSubscriber:guard	Ljava/lang/Object;
    //   244: astore_1
    //   245: aload_1
    //   246: monitorenter
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 93	rx/internal/operators/OperatorSwitch$SwitchSubscriber:emitting	Z
    //   252: aload_1
    //   253: monitorexit
    //   254: return
    //   255: astore_3
    //   256: aload_1
    //   257: monitorexit
    //   258: aload_3
    //   259: athrow
    //   260: astore_1
    //   261: aload 10
    //   263: monitorexit
    //   264: iload 7
    //   266: istore_2
    //   267: aload_1
    //   268: athrow
    //   269: astore_3
    //   270: iload_2
    //   271: ifne +17 -> 288
    //   274: aload_0
    //   275: getfield 48	rx/internal/operators/OperatorSwitch$SwitchSubscriber:guard	Ljava/lang/Object;
    //   278: astore_1
    //   279: aload_1
    //   280: monitorenter
    //   281: aload_0
    //   282: iconst_0
    //   283: putfield 93	rx/internal/operators/OperatorSwitch$SwitchSubscriber:emitting	Z
    //   286: aload_1
    //   287: monitorexit
    //   288: aload_3
    //   289: athrow
    //   290: iload 8
    //   292: istore_2
    //   293: aload 11
    //   295: monitorexit
    //   296: iload 7
    //   298: istore_2
    //   299: aload_0
    //   300: getfield 64	rx/internal/operators/OperatorSwitch$SwitchSubscriber:s	Lrx/observers/SerializedSubscriber;
    //   303: invokevirtual 163	rx/observers/SerializedSubscriber:isUnsubscribed	()Z
    //   306: istore 9
    //   308: iload 4
    //   310: istore 5
    //   312: iload 9
    //   314: ifeq -200 -> 114
    //   317: iload 6
    //   319: istore_2
    //   320: goto -84 -> 236
    //   323: astore_1
    //   324: aload 11
    //   326: monitorexit
    //   327: aload_1
    //   328: athrow
    //   329: astore_3
    //   330: aload_1
    //   331: monitorexit
    //   332: aload_3
    //   333: athrow
    //   334: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	SwitchSubscriber
    //   0	335	2	paramInt	int
    //   0	335	3	paramSwitchSubscriber	SwitchSubscriber<T>.InnerSubscriber
    //   125	184	4	i	int
    //   103	208	5	j	int
    //   112	206	6	k	int
    //   106	191	7	m	int
    //   109	182	8	n	int
    //   306	7	9	bool	boolean
    //   87	175	10	localObject1	Object
    //   4	321	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	20	77	finally
    //   21	46	77	finally
    //   46	62	77	finally
    //   62	76	77	finally
    //   78	81	77	finally
    //   83	102	77	finally
    //   247	254	255	finally
    //   256	258	255	finally
    //   150	166	260	finally
    //   166	169	260	finally
    //   261	264	260	finally
    //   117	123	269	finally
    //   138	144	269	finally
    //   147	150	269	finally
    //   172	180	269	finally
    //   183	189	269	finally
    //   192	195	269	finally
    //   267	269	269	finally
    //   299	308	269	finally
    //   327	329	269	finally
    //   198	204	323	finally
    //   207	212	323	finally
    //   220	225	323	finally
    //   230	233	323	finally
    //   293	296	323	finally
    //   324	327	323	finally
    //   281	288	329	finally
    //   330	332	329	finally
  }
  
  void error(Throwable paramThrowable, int paramInt)
  {
    synchronized (guard)
    {
      if (paramInt != index) {
        return;
      }
      if (emitting)
      {
        if (queue == null) {
          queue = new ArrayList();
        }
        queue.add(nl.error(paramThrowable));
        return;
      }
    }
    List localList = queue;
    queue = null;
    emitting = true;
    drain(localList);
    s.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onCompleted()
  {
    synchronized (guard)
    {
      mainDone = true;
      if (active) {
        return;
      }
      if (emitting)
      {
        if (queue == null) {
          queue = new ArrayList();
        }
        queue.add(nl.completed());
        return;
      }
    }
    List localList = queue;
    queue = null;
    emitting = true;
    drain(localList);
    s.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    s.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    for (;;)
    {
      synchronized (guard)
      {
        int i = index + 1;
        index = i;
        active = true;
        long l;
        if (infinite)
        {
          l = Long.MAX_VALUE;
          currentSubscriber = new InnerSubscriber(i, l);
          InnerSubscriber.access$102(currentSubscriber, l);
          ssub.set(currentSubscriber);
          paramObservable.unsafeSubscribe(currentSubscriber);
          return;
        }
        if (currentSubscriber == null) {
          l = initialRequested;
        } else {
          l = currentSubscriber.requested;
        }
      }
    }
  }
  
  final class InnerSubscriber
    extends Subscriber<T>
  {
    private final int id;
    private final long initialRequested;
    private long requested = 0L;
    
    public InnerSubscriber(int paramInt, long paramLong)
    {
      id = paramInt;
      initialRequested = paramLong;
    }
    
    public void onCompleted()
    {
      complete(id);
    }
    
    public void onError(Throwable paramThrowable)
    {
      error(paramThrowable, id);
    }
    
    public void onNext(T paramT)
    {
      emit(paramT, id, this);
    }
    
    public void onStart()
    {
      requestMore(initialRequested);
    }
    
    public void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitch.SwitchSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */