package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Scheduler;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.NotificationLite;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Timestamped;

public final class ReplaySubject<T>
  extends Subject<T, T>
{
  final SubjectSubscriptionManager<T> ssm;
  final ReplayState<T, ?> state;
  
  ReplaySubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager, ReplayState<T, ?> paramReplayState)
  {
    super(paramOnSubscribe);
    ssm = paramSubjectSubscriptionManager;
    state = paramReplayState;
  }
  
  private boolean caughtUp(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    boolean bool = true;
    if (!caughtUp)
    {
      if (state.replayObserver(paramSubjectObserver))
      {
        caughtUp = true;
        paramSubjectObserver.index(null);
      }
      bool = false;
    }
    return bool;
  }
  
  public static <T> ReplaySubject<T> create()
  {
    return create(16);
  }
  
  public static <T> ReplaySubject<T> create(int paramInt)
  {
    UnboundedReplayState localUnboundedReplayState = new UnboundedReplayState(paramInt);
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    onStart = new Action1()
    {
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        paramAnonymousSubjectObserver.index(Integer.valueOf(val$state.replayObserverFromIndex(Integer.valueOf(0), paramAnonymousSubjectObserver).intValue()));
      }
    };
    onAdded = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        // Byte code:
        //   0: aload_1
        //   1: monitorenter
        //   2: aload_1
        //   3: getfield 33	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
        //   6: ifeq +10 -> 16
        //   9: aload_1
        //   10: getfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   13: ifeq +6 -> 19
        //   16: aload_1
        //   17: monitorexit
        //   18: return
        //   19: aload_1
        //   20: iconst_0
        //   21: putfield 33	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
        //   24: aload_1
        //   25: iconst_1
        //   26: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   29: aload_1
        //   30: monitorexit
        //   31: iconst_0
        //   32: istore 4
        //   34: iconst_0
        //   35: istore_3
        //   36: iload 4
        //   38: istore_2
        //   39: aload_1
        //   40: invokevirtual 40	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
        //   43: checkcast 42	java/lang/Integer
        //   46: invokevirtual 46	java/lang/Integer:intValue	()I
        //   49: istore 6
        //   51: iload 4
        //   53: istore_2
        //   54: aload_0
        //   55: getfield 18	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
        //   58: getfield 51	rx/subjects/ReplaySubject$UnboundedReplayState:index	I
        //   61: istore 5
        //   63: iload 6
        //   65: iload 5
        //   67: if_icmpeq +23 -> 90
        //   70: iload 4
        //   72: istore_2
        //   73: aload_1
        //   74: aload_0
        //   75: getfield 18	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
        //   78: iload 6
        //   80: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   83: aload_1
        //   84: invokevirtual 59	rx/subjects/ReplaySubject$UnboundedReplayState:replayObserverFromIndex	(Ljava/lang/Integer;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Ljava/lang/Integer;
        //   87: invokevirtual 61	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
        //   90: iload 4
        //   92: istore_2
        //   93: aload_1
        //   94: monitorenter
        //   95: iload_3
        //   96: istore_2
        //   97: iload 5
        //   99: aload_0
        //   100: getfield 18	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
        //   103: getfield 51	rx/subjects/ReplaySubject$UnboundedReplayState:index	I
        //   106: if_icmpne +42 -> 148
        //   109: iload_3
        //   110: istore_2
        //   111: aload_1
        //   112: iconst_0
        //   113: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   116: iconst_1
        //   117: istore_2
        //   118: aload_1
        //   119: monitorexit
        //   120: iconst_1
        //   121: ifne +66 -> 187
        //   124: aload_1
        //   125: monitorenter
        //   126: aload_1
        //   127: iconst_0
        //   128: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   131: aload_1
        //   132: monitorexit
        //   133: return
        //   134: astore 7
        //   136: aload_1
        //   137: monitorexit
        //   138: aload 7
        //   140: athrow
        //   141: astore 7
        //   143: aload_1
        //   144: monitorexit
        //   145: aload 7
        //   147: athrow
        //   148: iload_3
        //   149: istore_2
        //   150: aload_1
        //   151: monitorexit
        //   152: goto -116 -> 36
        //   155: astore 7
        //   157: aload_1
        //   158: monitorexit
        //   159: aload 7
        //   161: athrow
        //   162: astore 7
        //   164: iload_2
        //   165: ifne +12 -> 177
        //   168: aload_1
        //   169: monitorenter
        //   170: aload_1
        //   171: iconst_0
        //   172: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   175: aload_1
        //   176: monitorexit
        //   177: aload 7
        //   179: athrow
        //   180: astore 7
        //   182: aload_1
        //   183: monitorexit
        //   184: aload 7
        //   186: athrow
        //   187: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	188	0	this	2
        //   0	188	1	paramAnonymousSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
        //   38	127	2	i	int
        //   35	114	3	j	int
        //   32	59	4	k	int
        //   61	46	5	m	int
        //   49	30	6	n	int
        //   134	5	7	localObject1	Object
        //   141	5	7	localObject2	Object
        //   155	5	7	localObject3	Object
        //   162	16	7	localObject4	Object
        //   180	5	7	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   126	133	134	finally
        //   136	138	134	finally
        //   2	16	141	finally
        //   16	18	141	finally
        //   19	31	141	finally
        //   143	145	141	finally
        //   97	109	155	finally
        //   111	116	155	finally
        //   118	120	155	finally
        //   150	152	155	finally
        //   157	159	155	finally
        //   39	51	162	finally
        //   54	63	162	finally
        //   73	90	162	finally
        //   93	95	162	finally
        //   159	162	162	finally
        //   170	177	180	finally
        //   182	184	180	finally
      }
    };
    onTerminated = new Action1()
    {
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        Integer localInteger2 = (Integer)paramAnonymousSubjectObserver.index();
        Integer localInteger1 = localInteger2;
        if (localInteger2 == null) {
          localInteger1 = Integer.valueOf(0);
        }
        val$state.replayObserverFromIndex(localInteger1, paramAnonymousSubjectObserver);
      }
    };
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, localUnboundedReplayState);
  }
  
  static <T> ReplaySubject<T> createUnbounded()
  {
    BoundedState localBoundedState = new BoundedState(new EmptyEvictionPolicy(), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new DefaultOnAdd(localBoundedState));
  }
  
  public static <T> ReplaySubject<T> createWithSize(int paramInt)
  {
    BoundedState localBoundedState = new BoundedState(new SizeEvictionPolicy(paramInt), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new DefaultOnAdd(localBoundedState));
  }
  
  static final <T> ReplaySubject<T> createWithState(BoundedState<T> paramBoundedState, Action1<SubjectSubscriptionManager.SubjectObserver<T>> paramAction1)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    onStart = paramAction1;
    onAdded = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        // Byte code:
        //   0: aload_1
        //   1: monitorenter
        //   2: aload_1
        //   3: getfield 33	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
        //   6: ifeq +10 -> 16
        //   9: aload_1
        //   10: getfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   13: ifeq +6 -> 19
        //   16: aload_1
        //   17: monitorexit
        //   18: return
        //   19: aload_1
        //   20: iconst_0
        //   21: putfield 33	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
        //   24: aload_1
        //   25: iconst_1
        //   26: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   29: aload_1
        //   30: monitorexit
        //   31: iconst_0
        //   32: istore 4
        //   34: iconst_0
        //   35: istore_3
        //   36: iload 4
        //   38: istore_2
        //   39: aload_1
        //   40: invokevirtual 40	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
        //   43: checkcast 42	rx/subjects/ReplaySubject$NodeList$Node
        //   46: astore 5
        //   48: iload 4
        //   50: istore_2
        //   51: aload_0
        //   52: getfield 18	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
        //   55: invokevirtual 48	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
        //   58: astore 6
        //   60: aload 5
        //   62: aload 6
        //   64: if_acmpeq +20 -> 84
        //   67: iload 4
        //   69: istore_2
        //   70: aload_1
        //   71: aload_0
        //   72: getfield 18	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
        //   75: aload 5
        //   77: aload_1
        //   78: invokevirtual 52	rx/subjects/ReplaySubject$BoundedState:replayObserverFromIndex	(Lrx/subjects/ReplaySubject$NodeList$Node;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Lrx/subjects/ReplaySubject$NodeList$Node;
        //   81: invokevirtual 54	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
        //   84: iload 4
        //   86: istore_2
        //   87: aload_1
        //   88: monitorenter
        //   89: iload_3
        //   90: istore_2
        //   91: aload 6
        //   93: aload_0
        //   94: getfield 18	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
        //   97: invokevirtual 48	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
        //   100: if_acmpne +42 -> 142
        //   103: iload_3
        //   104: istore_2
        //   105: aload_1
        //   106: iconst_0
        //   107: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   110: iconst_1
        //   111: istore_2
        //   112: aload_1
        //   113: monitorexit
        //   114: iconst_1
        //   115: ifne +66 -> 181
        //   118: aload_1
        //   119: monitorenter
        //   120: aload_1
        //   121: iconst_0
        //   122: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   125: aload_1
        //   126: monitorexit
        //   127: return
        //   128: astore 5
        //   130: aload_1
        //   131: monitorexit
        //   132: aload 5
        //   134: athrow
        //   135: astore 5
        //   137: aload_1
        //   138: monitorexit
        //   139: aload 5
        //   141: athrow
        //   142: iload_3
        //   143: istore_2
        //   144: aload_1
        //   145: monitorexit
        //   146: goto -110 -> 36
        //   149: astore 5
        //   151: aload_1
        //   152: monitorexit
        //   153: aload 5
        //   155: athrow
        //   156: astore 5
        //   158: iload_2
        //   159: ifne +12 -> 171
        //   162: aload_1
        //   163: monitorenter
        //   164: aload_1
        //   165: iconst_0
        //   166: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
        //   169: aload_1
        //   170: monitorexit
        //   171: aload 5
        //   173: athrow
        //   174: astore 5
        //   176: aload_1
        //   177: monitorexit
        //   178: aload 5
        //   180: athrow
        //   181: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	182	0	this	4
        //   0	182	1	paramAnonymousSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
        //   38	121	2	i	int
        //   35	108	3	j	int
        //   32	53	4	k	int
        //   46	30	5	localNode1	ReplaySubject.NodeList.Node
        //   128	5	5	localObject1	Object
        //   135	5	5	localObject2	Object
        //   149	5	5	localObject3	Object
        //   156	16	5	localObject4	Object
        //   174	5	5	localObject5	Object
        //   58	34	6	localNode2	ReplaySubject.NodeList.Node
        // Exception table:
        //   from	to	target	type
        //   120	127	128	finally
        //   130	132	128	finally
        //   2	16	135	finally
        //   16	18	135	finally
        //   19	31	135	finally
        //   137	139	135	finally
        //   91	103	149	finally
        //   105	110	149	finally
        //   112	114	149	finally
        //   144	146	149	finally
        //   151	153	149	finally
        //   39	48	156	finally
        //   51	60	156	finally
        //   70	84	156	finally
        //   87	89	156	finally
        //   153	156	156	finally
        //   164	171	174	finally
        //   176	178	174	finally
      }
    };
    onTerminated = new Action1()
    {
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        ReplaySubject.NodeList.Node localNode2 = (ReplaySubject.NodeList.Node)paramAnonymousSubjectObserver.index();
        ReplaySubject.NodeList.Node localNode1 = localNode2;
        if (localNode2 == null) {
          localNode1 = val$state.head();
        }
        val$state.replayObserverFromIndex(localNode1, paramAnonymousSubjectObserver);
      }
    };
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, paramBoundedState);
  }
  
  public static <T> ReplaySubject<T> createWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    paramTimeUnit = new BoundedState(new TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler), new AddTimestamped(paramScheduler), new RemoveTimestamped());
    return createWithState(paramTimeUnit, new TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  public static <T> ReplaySubject<T> createWithTimeAndSize(long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    paramTimeUnit = new BoundedState(new PairEvictionPolicy(new SizeEvictionPolicy(paramInt), new TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler)), new AddTimestamped(paramScheduler), new RemoveTimestamped());
    return createWithState(paramTimeUnit, new TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  @Experimental
  public Throwable getThrowable()
  {
    NotificationLite localNotificationLite = ssm.nl;
    Object localObject = ssm.get();
    if (localNotificationLite.isError(localObject)) {
      return localNotificationLite.getError(localObject);
    }
    return null;
  }
  
  public T getValue()
  {
    return (T)state.latest();
  }
  
  @Experimental
  public T[] getValues(T[] paramArrayOfT)
  {
    return state.toArray(paramArrayOfT);
  }
  
  @Experimental
  public boolean hasAnyValue()
  {
    return !state.isEmpty();
  }
  
  @Experimental
  public boolean hasCompleted()
  {
    NotificationLite localNotificationLite = ssm.nl;
    Object localObject = ssm.get();
    return (localObject != null) && (!localNotificationLite.isError(localObject));
  }
  
  public boolean hasObservers()
  {
    return ssm.observers().length > 0;
  }
  
  @Experimental
  public boolean hasThrowable()
  {
    return ssm.nl.isError(ssm.get());
  }
  
  @Experimental
  public boolean hasValue()
  {
    return hasAnyValue();
  }
  
  public void onCompleted()
  {
    if (ssm.active)
    {
      state.complete();
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = ssm.terminate(NotificationLite.instance().completed());
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        if (caughtUp(localSubjectObserver)) {
          localSubjectObserver.onCompleted();
        }
        i += 1;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (ssm.active)
    {
      state.error(paramThrowable);
      Object localObject1 = null;
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = ssm.terminate(NotificationLite.instance().error(paramThrowable));
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      Object localObject2;
      for (;;)
      {
        if (i >= j) {
          break label123;
        }
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        localObject2 = localObject1;
        try
        {
          if (caughtUp(localSubjectObserver))
          {
            localSubjectObserver.onError(paramThrowable);
            localObject2 = localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((List)localObject2).add(localThrowable);
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      label123:
      Exceptions.throwIfAny((List)localObject1);
    }
  }
  
  public void onNext(T paramT)
  {
    if (ssm.active)
    {
      state.next(paramT);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = ssm.observers();
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        if (caughtUp(localSubjectObserver)) {
          localSubjectObserver.onNext(paramT);
        }
        i += 1;
      }
    }
  }
  
  @Experimental
  public int size()
  {
    return state.size();
  }
  
  int subscriberCount()
  {
    return ssm.state.observers.length;
  }
  
  static final class AddTimestamped
    implements Func1<Object, Object>
  {
    final Scheduler scheduler;
    
    public AddTimestamped(Scheduler paramScheduler)
    {
      scheduler = paramScheduler;
    }
    
    public Object call(Object paramObject)
    {
      return new Timestamped(scheduler.now(), paramObject);
    }
  }
  
  static final class BoundedState<T>
    implements ReplaySubject.ReplayState<T, ReplaySubject.NodeList.Node<Object>>
  {
    final Func1<Object, Object> enterTransform;
    final ReplaySubject.EvictionPolicy evictionPolicy;
    final Func1<Object, Object> leaveTransform;
    final ReplaySubject.NodeList<Object> list = new ReplaySubject.NodeList();
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile ReplaySubject.NodeList.Node<Object> tail = list.tail;
    volatile boolean terminated;
    
    public BoundedState(ReplaySubject.EvictionPolicy paramEvictionPolicy, Func1<Object, Object> paramFunc11, Func1<Object, Object> paramFunc12)
    {
      evictionPolicy = paramEvictionPolicy;
      enterTransform = paramFunc11;
      leaveTransform = paramFunc12;
    }
    
    public void accept(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode)
    {
      nl.accept(paramObserver, leaveTransform.call(value));
    }
    
    public void acceptTest(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode, long paramLong)
    {
      paramNode = value;
      if (!evictionPolicy.test(paramNode, paramLong)) {
        nl.accept(paramObserver, leaveTransform.call(paramNode));
      }
    }
    
    public void complete()
    {
      if (!terminated)
      {
        terminated = true;
        list.addLast(enterTransform.call(nl.completed()));
        evictionPolicy.evictFinal(list);
        tail = list.tail;
      }
    }
    
    public void error(Throwable paramThrowable)
    {
      if (!terminated)
      {
        terminated = true;
        list.addLast(enterTransform.call(nl.error(paramThrowable)));
        evictionPolicy.evictFinal(list);
        tail = list.tail;
      }
    }
    
    public ReplaySubject.NodeList.Node<Object> head()
    {
      return list.head;
    }
    
    public boolean isEmpty()
    {
      Object localObject = headnext;
      if (localObject == null) {}
      do
      {
        return true;
        localObject = leaveTransform.call(value);
      } while ((nl.isError(localObject)) || (nl.isCompleted(localObject)));
      return false;
    }
    
    public T latest()
    {
      Object localObject1 = headnext;
      if (localObject1 == null) {}
      Object localObject2;
      do
      {
        return null;
        localObject2 = null;
        while (localObject1 != tail())
        {
          localObject2 = localObject1;
          localObject1 = next;
        }
        localObject1 = leaveTransform.call(value);
        if ((!nl.isError(localObject1)) && (!nl.isCompleted(localObject1))) {
          break;
        }
      } while (localObject2 == null);
      localObject1 = leaveTransform.call(value);
      return (T)nl.getValue(localObject1);
      return (T)nl.getValue(localObject1);
    }
    
    public void next(T paramT)
    {
      if (!terminated)
      {
        list.addLast(enterTransform.call(nl.next(paramT)));
        evictionPolicy.evict(list);
        tail = list.tail;
      }
    }
    
    public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      try
      {
        first = false;
        if (emitting) {
          return false;
        }
        paramSubjectObserver.index(replayObserverFromIndex((ReplaySubject.NodeList.Node)paramSubjectObserver.index(), paramSubjectObserver));
        return true;
      }
      finally {}
    }
    
    public ReplaySubject.NodeList.Node<Object> replayObserverFromIndex(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      while (paramNode != tail())
      {
        accept(paramSubjectObserver, next);
        paramNode = next;
      }
      return paramNode;
    }
    
    public ReplaySubject.NodeList.Node<Object> replayObserverFromIndexTest(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
    {
      while (paramNode != tail())
      {
        acceptTest(paramSubjectObserver, next, paramLong);
        paramNode = next;
      }
      return paramNode;
    }
    
    public int size()
    {
      int i = 0;
      Object localObject2 = head();
      for (Object localObject1 = next; localObject1 != null; localObject1 = next)
      {
        i += 1;
        localObject2 = localObject1;
      }
      int j = i;
      if (value != null)
      {
        localObject1 = leaveTransform.call(value);
        j = i;
        if (localObject1 != null) {
          if (!nl.isError(localObject1))
          {
            j = i;
            if (!nl.isCompleted(localObject1)) {}
          }
          else
          {
            j = i - 1;
          }
        }
      }
      return j;
    }
    
    public ReplaySubject.NodeList.Node<Object> tail()
    {
      return tail;
    }
    
    public boolean terminated()
    {
      return terminated;
    }
    
    public T[] toArray(T[] paramArrayOfT)
    {
      ArrayList localArrayList = new ArrayList();
      for (ReplaySubject.NodeList.Node localNode = headnext;; localNode = next)
      {
        Object localObject;
        if (localNode != null)
        {
          localObject = leaveTransform.call(value);
          if ((next != null) || ((!nl.isError(localObject)) && (!nl.isCompleted(localObject)))) {}
        }
        else
        {
          return localArrayList.toArray(paramArrayOfT);
        }
        localArrayList.add(localObject);
      }
    }
  }
  
  static final class DefaultOnAdd<T>
    implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
  {
    final ReplaySubject.BoundedState<T> state;
    
    public DefaultOnAdd(ReplaySubject.BoundedState<T> paramBoundedState)
    {
      state = paramBoundedState;
    }
    
    public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
    {
      paramSubjectObserver.index(state.replayObserverFromIndex(state.head(), paramSubjectObserver));
    }
  }
  
  static final class EmptyEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    public void evict(ReplaySubject.NodeList<Object> paramNodeList) {}
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList) {}
    
    public boolean test(Object paramObject, long paramLong)
    {
      return true;
    }
  }
  
  static abstract interface EvictionPolicy
  {
    public abstract void evict(ReplaySubject.NodeList<Object> paramNodeList);
    
    public abstract void evictFinal(ReplaySubject.NodeList<Object> paramNodeList);
    
    public abstract boolean test(Object paramObject, long paramLong);
  }
  
  static final class NodeList<T>
  {
    final Node<T> head = new Node(null);
    int size;
    Node<T> tail = head;
    
    public void addLast(T paramT)
    {
      Node localNode = tail;
      paramT = new Node(paramT);
      next = paramT;
      tail = paramT;
      size += 1;
    }
    
    public void clear()
    {
      tail = head;
      size = 0;
    }
    
    public boolean isEmpty()
    {
      return size == 0;
    }
    
    public T removeFirst()
    {
      if (head.next == null) {
        throw new IllegalStateException("Empty!");
      }
      Node localNode = head.next;
      head.next = next;
      if (head.next == null) {
        tail = head;
      }
      size -= 1;
      return (T)value;
    }
    
    public int size()
    {
      return size;
    }
    
    static final class Node<T>
    {
      volatile Node<T> next;
      final T value;
      
      Node(T paramT)
      {
        value = paramT;
      }
    }
  }
  
  static final class PairEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final ReplaySubject.EvictionPolicy first;
    final ReplaySubject.EvictionPolicy second;
    
    public PairEvictionPolicy(ReplaySubject.EvictionPolicy paramEvictionPolicy1, ReplaySubject.EvictionPolicy paramEvictionPolicy2)
    {
      first = paramEvictionPolicy1;
      second = paramEvictionPolicy2;
    }
    
    public void evict(ReplaySubject.NodeList<Object> paramNodeList)
    {
      first.evict(paramNodeList);
      second.evict(paramNodeList);
    }
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
    {
      first.evictFinal(paramNodeList);
      second.evictFinal(paramNodeList);
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return (first.test(paramObject, paramLong)) || (second.test(paramObject, paramLong));
    }
  }
  
  static final class RemoveTimestamped
    implements Func1<Object, Object>
  {
    public Object call(Object paramObject)
    {
      return ((Timestamped)paramObject).getValue();
    }
  }
  
  static abstract interface ReplayState<T, I>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract boolean isEmpty();
    
    public abstract T latest();
    
    public abstract void next(T paramT);
    
    public abstract boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
    
    public abstract I replayObserverFromIndex(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
    
    public abstract I replayObserverFromIndexTest(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong);
    
    public abstract int size();
    
    public abstract boolean terminated();
    
    public abstract T[] toArray(T[] paramArrayOfT);
  }
  
  static final class SizeEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final int maxSize;
    
    public SizeEvictionPolicy(int paramInt)
    {
      maxSize = paramInt;
    }
    
    public void evict(ReplaySubject.NodeList<Object> paramNodeList)
    {
      while (paramNodeList.size() > maxSize) {
        paramNodeList.removeFirst();
      }
    }
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
    {
      while (paramNodeList.size() > maxSize + 1) {
        paramNodeList.removeFirst();
      }
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return false;
    }
  }
  
  static final class TimeEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final long maxAgeMillis;
    final Scheduler scheduler;
    
    public TimeEvictionPolicy(long paramLong, Scheduler paramScheduler)
    {
      maxAgeMillis = paramLong;
      scheduler = paramScheduler;
    }
    
    public void evict(ReplaySubject.NodeList<Object> paramNodeList)
    {
      long l = scheduler.now();
      while ((!paramNodeList.isEmpty()) && (test(head.next.value, l))) {
        paramNodeList.removeFirst();
      }
    }
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
    {
      long l = scheduler.now();
      while ((size > 1) && (test(head.next.value, l))) {
        paramNodeList.removeFirst();
      }
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return ((Timestamped)paramObject).getTimestampMillis() <= paramLong - maxAgeMillis;
    }
  }
  
  static final class TimedOnAdd<T>
    implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
  {
    final Scheduler scheduler;
    final ReplaySubject.BoundedState<T> state;
    
    public TimedOnAdd(ReplaySubject.BoundedState<T> paramBoundedState, Scheduler paramScheduler)
    {
      state = paramBoundedState;
      scheduler = paramScheduler;
    }
    
    public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
    {
      if (!state.terminated) {}
      for (ReplaySubject.NodeList.Node localNode = state.replayObserverFromIndexTest(state.head(), paramSubjectObserver, scheduler.now());; localNode = state.replayObserverFromIndex(state.head(), paramSubjectObserver))
      {
        paramSubjectObserver.index(localNode);
        return;
      }
    }
  }
  
  static final class UnboundedReplayState<T>
    implements ReplaySubject.ReplayState<T, Integer>
  {
    static final AtomicIntegerFieldUpdater<UnboundedReplayState> INDEX_UPDATER = AtomicIntegerFieldUpdater.newUpdater(UnboundedReplayState.class, "index");
    volatile int index;
    private final ArrayList<Object> list;
    private final NotificationLite<T> nl = NotificationLite.instance();
    private volatile boolean terminated;
    
    public UnboundedReplayState(int paramInt)
    {
      list = new ArrayList(paramInt);
    }
    
    public void accept(Observer<? super T> paramObserver, int paramInt)
    {
      nl.accept(paramObserver, list.get(paramInt));
    }
    
    public void complete()
    {
      if (!terminated)
      {
        terminated = true;
        list.add(nl.completed());
        INDEX_UPDATER.getAndIncrement(this);
      }
    }
    
    public void error(Throwable paramThrowable)
    {
      if (!terminated)
      {
        terminated = true;
        list.add(nl.error(paramThrowable));
        INDEX_UPDATER.getAndIncrement(this);
      }
    }
    
    public boolean isEmpty()
    {
      return size() == 0;
    }
    
    public T latest()
    {
      Object localObject2 = null;
      int i = index;
      Object localObject1 = localObject2;
      if (i > 0)
      {
        localObject1 = list.get(i - 1);
        if ((!nl.isCompleted(localObject1)) && (!nl.isError(localObject1))) {
          break label73;
        }
        localObject1 = localObject2;
        if (i > 1) {
          localObject1 = nl.getValue(list.get(i - 2));
        }
      }
      return (T)localObject1;
      label73:
      return (T)nl.getValue(localObject1);
    }
    
    public void next(T paramT)
    {
      if (!terminated)
      {
        list.add(nl.next(paramT));
        INDEX_UPDATER.getAndIncrement(this);
      }
    }
    
    public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      try
      {
        first = false;
        if (emitting) {
          return false;
        }
        Integer localInteger = (Integer)paramSubjectObserver.index();
        if (localInteger != null)
        {
          paramSubjectObserver.index(Integer.valueOf(replayObserverFromIndex(localInteger, paramSubjectObserver).intValue()));
          return true;
        }
      }
      finally {}
      throw new IllegalStateException("failed to find lastEmittedLink for: " + paramSubjectObserver);
    }
    
    public Integer replayObserverFromIndex(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      int i = paramInteger.intValue();
      while (i < index)
      {
        accept(paramSubjectObserver, i);
        i += 1;
      }
      return Integer.valueOf(i);
    }
    
    public Integer replayObserverFromIndexTest(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
    {
      return replayObserverFromIndex(paramInteger, paramSubjectObserver);
    }
    
    public int size()
    {
      int j = index;
      int i = j;
      if (j > 0)
      {
        Object localObject = list.get(j - 1);
        if (!nl.isCompleted(localObject))
        {
          i = j;
          if (!nl.isError(localObject)) {}
        }
        else
        {
          i = j - 1;
        }
      }
      return i;
    }
    
    public boolean terminated()
    {
      return terminated;
    }
    
    public T[] toArray(T[] paramArrayOfT)
    {
      int j = size();
      Object localObject2;
      if (j > 0)
      {
        Object localObject1 = paramArrayOfT;
        if (j > paramArrayOfT.length) {
          localObject1 = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
        }
        int i = 0;
        while (i < j)
        {
          localObject1[i] = list.get(i);
          i += 1;
        }
        localObject2 = localObject1;
        if (localObject1.length > j)
        {
          localObject1[j] = null;
          localObject2 = localObject1;
        }
      }
      do
      {
        return (T[])localObject2;
        localObject2 = paramArrayOfT;
      } while (paramArrayOfT.length <= 0);
      paramArrayOfT[0] = null;
      return paramArrayOfT;
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */