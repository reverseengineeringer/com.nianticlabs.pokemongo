package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.SynchronizedQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

final class OperatorPublish$PublishSubscriber<T>
  extends Subscriber<T>
  implements Subscription
{
  static final OperatorPublish.InnerProducer[] EMPTY = new OperatorPublish.InnerProducer[0];
  static final OperatorPublish.InnerProducer[] TERMINATED = new OperatorPublish.InnerProducer[0];
  final AtomicReference<PublishSubscriber<T>> current;
  boolean emitting;
  boolean missed;
  final NotificationLite<T> nl;
  final AtomicReference<OperatorPublish.InnerProducer[]> producers;
  final Queue<Object> queue;
  final AtomicBoolean shouldConnect;
  volatile Object terminalEvent;
  
  public OperatorPublish$PublishSubscriber(AtomicReference<PublishSubscriber<T>> paramAtomicReference)
  {
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (Object localObject = new SpscArrayQueue(RxRingBuffer.SIZE);; localObject = new SynchronizedQueue(RxRingBuffer.SIZE))
    {
      queue = ((Queue)localObject);
      nl = NotificationLite.instance();
      producers = new AtomicReference(EMPTY);
      current = paramAtomicReference;
      shouldConnect = new AtomicBoolean();
      return;
    }
  }
  
  boolean add(OperatorPublish.InnerProducer<T> paramInnerProducer)
  {
    if (paramInnerProducer == null) {
      throw new NullPointerException();
    }
    OperatorPublish.InnerProducer[] arrayOfInnerProducer1;
    OperatorPublish.InnerProducer[] arrayOfInnerProducer2;
    do
    {
      arrayOfInnerProducer1 = (OperatorPublish.InnerProducer[])producers.get();
      if (arrayOfInnerProducer1 == TERMINATED) {
        return false;
      }
      int i = arrayOfInnerProducer1.length;
      arrayOfInnerProducer2 = new OperatorPublish.InnerProducer[i + 1];
      System.arraycopy(arrayOfInnerProducer1, 0, arrayOfInnerProducer2, 0, i);
      arrayOfInnerProducer2[i] = paramInnerProducer;
    } while (!producers.compareAndSet(arrayOfInnerProducer1, arrayOfInnerProducer2));
    return true;
  }
  
  boolean checkTerminated(Object paramObject, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      int j;
      int i;
      if (nl.isCompleted(paramObject))
      {
        if (paramBoolean)
        {
          current.compareAndSet(this, null);
          try
          {
            paramObject = (OperatorPublish.InnerProducer[])producers.getAndSet(TERMINATED);
            j = paramObject.length;
            i = 0;
            while (i < j)
            {
              child.onCompleted();
              i += 1;
            }
            return true;
          }
          finally
          {
            unsubscribe();
          }
        }
      }
      else
      {
        paramObject = nl.getError(paramObject);
        current.compareAndSet(this, null);
        try
        {
          OperatorPublish.InnerProducer[] arrayOfInnerProducer = (OperatorPublish.InnerProducer[])producers.getAndSet(TERMINATED);
          j = arrayOfInnerProducer.length;
          i = 0;
          while (i < j)
          {
            child.onError((Throwable)paramObject);
            i += 1;
          }
          return true;
        }
        finally
        {
          unsubscribe();
        }
      }
    }
    return false;
  }
  
  /* Error */
  void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 148	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 148	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   27: aload_0
    //   28: monitorexit
    //   29: iconst_0
    //   30: istore 5
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 150	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   42: astore 16
    //   44: iload 4
    //   46: istore_1
    //   47: aload_0
    //   48: getfield 65	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   51: invokeinterface 155 1 0
    //   56: istore 8
    //   58: iload 4
    //   60: istore_1
    //   61: aload_0
    //   62: aload 16
    //   64: iload 8
    //   66: invokevirtual 157	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   69: istore 9
    //   71: iload 9
    //   73: ifeq +31 -> 104
    //   76: iconst_1
    //   77: ifne +522 -> 599
    //   80: aload_0
    //   81: monitorenter
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore 16
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 16
    //   96: athrow
    //   97: astore 16
    //   99: aload_0
    //   100: monitorexit
    //   101: aload 16
    //   103: athrow
    //   104: iload 8
    //   106: ifne +303 -> 409
    //   109: iload 4
    //   111: istore_1
    //   112: aload_0
    //   113: getfield 80	rx/internal/operators/OperatorPublish$PublishSubscriber:producers	Ljava/util/concurrent/atomic/AtomicReference;
    //   116: invokevirtual 101	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   119: checkcast 102	[Lrx/internal/operators/OperatorPublish$InnerProducer;
    //   122: astore 16
    //   124: iload 4
    //   126: istore_1
    //   127: aload 16
    //   129: arraylength
    //   130: istore 6
    //   132: ldc2_w 158
    //   135: lstore 10
    //   137: iconst_0
    //   138: istore_3
    //   139: iload 4
    //   141: istore_1
    //   142: aload 16
    //   144: arraylength
    //   145: istore 7
    //   147: iconst_0
    //   148: istore_2
    //   149: iload_2
    //   150: iload 7
    //   152: if_icmpge +39 -> 191
    //   155: iload 4
    //   157: istore_1
    //   158: aload 16
    //   160: iload_2
    //   161: aaload
    //   162: invokevirtual 162	rx/internal/operators/OperatorPublish$InnerProducer:get	()J
    //   165: lstore 14
    //   167: lload 14
    //   169: lconst_0
    //   170: lcmp
    //   171: iflt +442 -> 613
    //   174: iload 4
    //   176: istore_1
    //   177: lload 10
    //   179: lload 14
    //   181: invokestatic 168	java/lang/Math:min	(JJ)J
    //   184: lstore 12
    //   186: iload_3
    //   187: istore_1
    //   188: goto +412 -> 600
    //   191: iload 6
    //   193: iload_3
    //   194: if_icmpne +104 -> 298
    //   197: iload 4
    //   199: istore_1
    //   200: aload_0
    //   201: getfield 150	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   204: astore 16
    //   206: iload 4
    //   208: istore_1
    //   209: aload_0
    //   210: getfield 65	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   213: invokeinterface 171 1 0
    //   218: ifnonnull +45 -> 263
    //   221: iconst_1
    //   222: istore 8
    //   224: iload 4
    //   226: istore_1
    //   227: aload_0
    //   228: aload 16
    //   230: iload 8
    //   232: invokevirtual 157	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   235: istore 8
    //   237: iload 8
    //   239: ifeq +30 -> 269
    //   242: iconst_1
    //   243: ifne +356 -> 599
    //   246: aload_0
    //   247: monitorenter
    //   248: aload_0
    //   249: iconst_0
    //   250: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   253: aload_0
    //   254: monitorexit
    //   255: return
    //   256: astore 16
    //   258: aload_0
    //   259: monitorexit
    //   260: aload 16
    //   262: athrow
    //   263: iconst_0
    //   264: istore 8
    //   266: goto -42 -> 224
    //   269: iload 4
    //   271: istore_1
    //   272: aload_0
    //   273: lconst_1
    //   274: invokevirtual 175	rx/internal/operators/OperatorPublish$PublishSubscriber:request	(J)V
    //   277: goto -242 -> 35
    //   280: astore 16
    //   282: iload_1
    //   283: ifne +12 -> 295
    //   286: aload_0
    //   287: monitorenter
    //   288: aload_0
    //   289: iconst_0
    //   290: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   293: aload_0
    //   294: monitorexit
    //   295: aload 16
    //   297: athrow
    //   298: iconst_0
    //   299: istore_2
    //   300: iload_2
    //   301: i2l
    //   302: lload 10
    //   304: lcmp
    //   305: ifge +84 -> 389
    //   308: iload 4
    //   310: istore_1
    //   311: aload_0
    //   312: getfield 150	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   315: astore 17
    //   317: iload 4
    //   319: istore_1
    //   320: aload_0
    //   321: getfield 65	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   324: invokeinterface 171 1 0
    //   329: astore 18
    //   331: aload 18
    //   333: ifnonnull +45 -> 378
    //   336: iconst_1
    //   337: istore 8
    //   339: iload 4
    //   341: istore_1
    //   342: aload_0
    //   343: aload 17
    //   345: iload 8
    //   347: invokevirtual 157	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   350: istore 9
    //   352: iload 9
    //   354: ifeq +30 -> 384
    //   357: iconst_1
    //   358: ifne +241 -> 599
    //   361: aload_0
    //   362: monitorenter
    //   363: aload_0
    //   364: iconst_0
    //   365: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   368: aload_0
    //   369: monitorexit
    //   370: return
    //   371: astore 16
    //   373: aload_0
    //   374: monitorexit
    //   375: aload 16
    //   377: athrow
    //   378: iconst_0
    //   379: istore 8
    //   381: goto -42 -> 339
    //   384: iload 8
    //   386: ifeq +71 -> 457
    //   389: iload_2
    //   390: ifle +249 -> 639
    //   393: iload_2
    //   394: i2l
    //   395: lstore 12
    //   397: iload 4
    //   399: istore_1
    //   400: aload_0
    //   401: lload 12
    //   403: invokevirtual 175	rx/internal/operators/OperatorPublish$PublishSubscriber:request	(J)V
    //   406: goto +233 -> 639
    //   409: iload 4
    //   411: istore_1
    //   412: aload_0
    //   413: monitorenter
    //   414: iload 5
    //   416: istore_1
    //   417: aload_0
    //   418: getfield 148	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   421: ifne +148 -> 569
    //   424: iload 5
    //   426: istore_1
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   432: iconst_1
    //   433: istore_1
    //   434: aload_0
    //   435: monitorexit
    //   436: iconst_1
    //   437: ifne +162 -> 599
    //   440: aload_0
    //   441: monitorenter
    //   442: aload_0
    //   443: iconst_0
    //   444: putfield 146	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   447: aload_0
    //   448: monitorexit
    //   449: return
    //   450: astore 16
    //   452: aload_0
    //   453: monitorexit
    //   454: aload 16
    //   456: athrow
    //   457: iload 4
    //   459: istore_1
    //   460: aload_0
    //   461: getfield 73	rx/internal/operators/OperatorPublish$PublishSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   464: aload 18
    //   466: invokevirtual 178	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   469: astore 17
    //   471: iload 4
    //   473: istore_1
    //   474: aload 16
    //   476: arraylength
    //   477: istore 6
    //   479: iconst_0
    //   480: istore_3
    //   481: iload_3
    //   482: iload 6
    //   484: if_icmpge +78 -> 562
    //   487: aload 16
    //   489: iload_3
    //   490: aaload
    //   491: astore 18
    //   493: iload 4
    //   495: istore_1
    //   496: aload 18
    //   498: invokevirtual 162	rx/internal/operators/OperatorPublish$InnerProducer:get	()J
    //   501: lstore 12
    //   503: lload 12
    //   505: lconst_0
    //   506: lcmp
    //   507: ifle +147 -> 654
    //   510: iload 4
    //   512: istore_1
    //   513: aload 18
    //   515: getfield 127	rx/internal/operators/OperatorPublish$InnerProducer:child	Lrx/Subscriber;
    //   518: aload 17
    //   520: invokevirtual 181	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   523: iload 4
    //   525: istore_1
    //   526: aload 18
    //   528: lconst_1
    //   529: invokevirtual 185	rx/internal/operators/OperatorPublish$InnerProducer:produced	(J)J
    //   532: pop2
    //   533: goto +121 -> 654
    //   536: astore 19
    //   538: iload 4
    //   540: istore_1
    //   541: aload 18
    //   543: invokevirtual 186	rx/internal/operators/OperatorPublish$InnerProducer:unsubscribe	()V
    //   546: iload 4
    //   548: istore_1
    //   549: aload 18
    //   551: getfield 127	rx/internal/operators/OperatorPublish$InnerProducer:child	Lrx/Subscriber;
    //   554: aload 19
    //   556: invokevirtual 141	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   559: goto +95 -> 654
    //   562: iload_2
    //   563: iconst_1
    //   564: iadd
    //   565: istore_2
    //   566: goto -266 -> 300
    //   569: iload 5
    //   571: istore_1
    //   572: aload_0
    //   573: iconst_0
    //   574: putfield 148	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   577: iload 5
    //   579: istore_1
    //   580: aload_0
    //   581: monitorexit
    //   582: goto -547 -> 35
    //   585: astore 16
    //   587: aload_0
    //   588: monitorexit
    //   589: aload 16
    //   591: athrow
    //   592: astore 16
    //   594: aload_0
    //   595: monitorexit
    //   596: aload 16
    //   598: athrow
    //   599: return
    //   600: iload_2
    //   601: iconst_1
    //   602: iadd
    //   603: istore_2
    //   604: lload 12
    //   606: lstore 10
    //   608: iload_1
    //   609: istore_3
    //   610: goto -461 -> 149
    //   613: lload 10
    //   615: lstore 12
    //   617: iload_3
    //   618: istore_1
    //   619: lload 14
    //   621: ldc2_w 187
    //   624: lcmp
    //   625: ifne -25 -> 600
    //   628: iload_3
    //   629: iconst_1
    //   630: iadd
    //   631: istore_1
    //   632: lload 10
    //   634: lstore 12
    //   636: goto -36 -> 600
    //   639: lload 10
    //   641: lconst_0
    //   642: lcmp
    //   643: ifeq -234 -> 409
    //   646: iload 8
    //   648: ifeq -613 -> 35
    //   651: goto -242 -> 409
    //   654: iload_3
    //   655: iconst_1
    //   656: iadd
    //   657: istore_3
    //   658: goto -177 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	PublishSubscriber
    //   37	595	1	i	int
    //   148	456	2	j	int
    //   138	520	3	k	int
    //   33	514	4	m	int
    //   30	548	5	n	int
    //   130	355	6	i1	int
    //   145	8	7	i2	int
    //   56	591	8	bool1	boolean
    //   69	284	9	bool2	boolean
    //   135	505	10	l1	long
    //   184	451	12	l2	long
    //   165	455	14	l3	long
    //   42	21	16	localObject1	Object
    //   90	5	16	localObject2	Object
    //   97	5	16	localObject3	Object
    //   122	107	16	localObject4	Object
    //   256	5	16	localObject5	Object
    //   280	16	16	localObject6	Object
    //   371	5	16	localObject7	Object
    //   450	38	16	localObject8	Object
    //   585	5	16	localObject9	Object
    //   592	5	16	localObject10	Object
    //   315	204	17	localObject11	Object
    //   329	221	18	localObject12	Object
    //   536	19	19	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   82	89	90	finally
    //   92	94	90	finally
    //   2	16	97	finally
    //   17	29	97	finally
    //   99	101	97	finally
    //   248	255	256	finally
    //   258	260	256	finally
    //   38	44	280	finally
    //   47	58	280	finally
    //   61	71	280	finally
    //   112	124	280	finally
    //   127	132	280	finally
    //   142	147	280	finally
    //   158	167	280	finally
    //   177	186	280	finally
    //   200	206	280	finally
    //   209	221	280	finally
    //   227	237	280	finally
    //   272	277	280	finally
    //   311	317	280	finally
    //   320	331	280	finally
    //   342	352	280	finally
    //   400	406	280	finally
    //   412	414	280	finally
    //   460	471	280	finally
    //   474	479	280	finally
    //   496	503	280	finally
    //   513	523	280	finally
    //   526	533	280	finally
    //   541	546	280	finally
    //   549	559	280	finally
    //   589	592	280	finally
    //   363	370	371	finally
    //   373	375	371	finally
    //   442	449	450	finally
    //   452	454	450	finally
    //   513	523	536	java/lang/Throwable
    //   417	424	585	finally
    //   427	432	585	finally
    //   434	436	585	finally
    //   572	577	585	finally
    //   580	582	585	finally
    //   587	589	585	finally
    //   288	295	592	finally
    //   594	596	592	finally
  }
  
  void init()
  {
    add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        producers.getAndSet(OperatorPublish.PublishSubscriber.TERMINATED);
        current.compareAndSet(OperatorPublish.PublishSubscriber.this, null);
      }
    }));
  }
  
  public void onCompleted()
  {
    if (terminalEvent == null)
    {
      terminalEvent = nl.completed();
      dispatch();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (terminalEvent == null)
    {
      terminalEvent = nl.error(paramThrowable);
      dispatch();
    }
  }
  
  public void onNext(T paramT)
  {
    if (!queue.offer(nl.next(paramT)))
    {
      onError(new MissingBackpressureException());
      return;
    }
    dispatch();
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  void remove(OperatorPublish.InnerProducer<T> paramInnerProducer)
  {
    OperatorPublish.InnerProducer[] arrayOfInnerProducer2 = (OperatorPublish.InnerProducer[])producers.get();
    if ((arrayOfInnerProducer2 == EMPTY) || (arrayOfInnerProducer2 == TERMINATED)) {}
    int m;
    int i;
    label39:
    int j;
    do
    {
      return;
      int k = -1;
      m = arrayOfInnerProducer2.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!arrayOfInnerProducer2[i].equals(paramInnerProducer)) {
          break;
        }
        j = i;
      }
    } while (j < 0);
    OperatorPublish.InnerProducer[] arrayOfInnerProducer1;
    if (m == 1) {
      arrayOfInnerProducer1 = EMPTY;
    }
    while (producers.compareAndSet(arrayOfInnerProducer2, arrayOfInnerProducer1))
    {
      return;
      i += 1;
      break label39;
      arrayOfInnerProducer1 = new OperatorPublish.InnerProducer[m - 1];
      System.arraycopy(arrayOfInnerProducer2, 0, arrayOfInnerProducer1, 0, j);
      System.arraycopy(arrayOfInnerProducer2, j + 1, arrayOfInnerProducer1, j, m - j - 1);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish.PublishSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */