package rx.internal.producers;

import java.util.Iterator;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;

public final class ProducerObserverArbiter<T>
  implements Producer, Observer<T>
{
  static final Producer NULL_PRODUCER = new Producer()
  {
    public void request(long paramAnonymousLong) {}
  };
  final Subscriber<? super T> child;
  Producer currentProducer;
  boolean emitting;
  volatile boolean hasError;
  Producer missedProducer;
  long missedRequested;
  Object missedTerminal;
  List<T> queue;
  long requested;
  
  public ProducerObserverArbiter(Subscriber<? super T> paramSubscriber)
  {
    child = paramSubscriber;
  }
  
  void emitLoop()
  {
    Subscriber localSubscriber = child;
    for (;;)
    {
      long l4;
      Object localObject2;
      List localList;
      int i;
      for (;;)
      {
        try
        {
          l4 = missedRequested;
          Producer localProducer1 = missedProducer;
          localObject2 = missedTerminal;
          localList = queue;
          if ((l4 == 0L) && (localProducer1 == null) && (localList == null) && (localObject2 == null))
          {
            emitting = false;
            return;
          }
          missedRequested = 0L;
          missedProducer = null;
          queue = null;
          missedTerminal = null;
          if ((localList == null) || (localList.isEmpty()))
          {
            i = 1;
            if (localObject2 == null) {
              break label147;
            }
            if (localObject2 == Boolean.TRUE) {
              break;
            }
            localSubscriber.onError((Throwable)localObject2);
            return;
          }
        }
        finally {}
        i = 0;
      }
      if (i != 0)
      {
        ((Subscriber)localObject1).onCompleted();
        return;
      }
      label147:
      long l3 = 0L;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            if (((Subscriber)localObject1).isUnsubscribed()) {
              return;
            }
            if (hasError) {
              break;
            }
            try
            {
              ((Subscriber)localObject1).onNext(localObject2);
            }
            catch (Throwable localThrowable)
            {
              Exceptions.throwIfFatal(localThrowable);
              ((Subscriber)localObject1).onError(OnErrorThrowable.addValueAsLastCause(localThrowable, localObject2));
              return;
            }
          }
        }
        l3 = 0L + localList.size();
      }
      long l2 = requested;
      long l1 = l2;
      if (l2 != Long.MAX_VALUE)
      {
        l1 = l2;
        if (l4 != 0L)
        {
          l2 += l4;
          l1 = l2;
          if (l2 < 0L) {
            l1 = Long.MAX_VALUE;
          }
        }
        l2 = l1;
        if (l3 != 0L)
        {
          l2 = l1;
          if (l1 != Long.MAX_VALUE)
          {
            l2 = l1 - l3;
            if (l2 < 0L) {
              throw new IllegalStateException("More produced than requested");
            }
          }
        }
        requested = l2;
        l1 = l2;
      }
      if (localThrowable != null)
      {
        if (localThrowable == NULL_PRODUCER)
        {
          currentProducer = null;
        }
        else
        {
          currentProducer = localThrowable;
          if (l1 != 0L) {
            localThrowable.request(l1);
          }
        }
      }
      else
      {
        Producer localProducer2 = currentProducer;
        if ((localProducer2 != null) && (l4 != 0L)) {
          localProducer2.request(l4);
        }
      }
    }
  }
  
  public void onCompleted()
  {
    try
    {
      if (emitting)
      {
        missedTerminal = Boolean.valueOf(true);
        return;
      }
      emitting = true;
      child.onCompleted();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      if (emitting) {
        missedTerminal = paramThrowable;
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break;
        }
        child.onError(paramThrowable);
        return;
        emitting = true;
      }
      hasError = true;
    }
    finally {}
  }
  
  /* Error */
  public void onNext(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   6: ifeq +46 -> 52
    //   9: aload_0
    //   10: getfield 54	rx/internal/producers/ProducerObserverArbiter:queue	Ljava/util/List;
    //   13: astore 5
    //   15: aload 5
    //   17: astore 4
    //   19: aload 5
    //   21: ifnonnull +19 -> 40
    //   24: new 137	java/util/ArrayList
    //   27: dup
    //   28: iconst_4
    //   29: invokespecial 140	java/util/ArrayList:<init>	(I)V
    //   32: astore 4
    //   34: aload_0
    //   35: aload 4
    //   37: putfield 54	rx/internal/producers/ProducerObserverArbiter:queue	Ljava/util/List;
    //   40: aload 4
    //   42: aload_1
    //   43: invokeinterface 144 2 0
    //   48: pop
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 41	rx/internal/producers/ProducerObserverArbiter:child	Lrx/Subscriber;
    //   58: aload_1
    //   59: invokevirtual 99	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   62: aload_0
    //   63: getfield 116	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   66: lstore_2
    //   67: lload_2
    //   68: ldc2_w 117
    //   71: lcmp
    //   72: ifeq +10 -> 82
    //   75: aload_0
    //   76: lload_2
    //   77: lconst_1
    //   78: lsub
    //   79: putfield 116	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   82: aload_0
    //   83: invokevirtual 146	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   86: iconst_1
    //   87: ifne +44 -> 131
    //   90: aload_0
    //   91: monitorenter
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: iconst_0
    //   112: ifne +12 -> 124
    //   115: aload_0
    //   116: monitorenter
    //   117: aload_0
    //   118: iconst_0
    //   119: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    //   131: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ProducerObserverArbiter
    //   0	132	1	paramT	T
    //   66	11	2	l	long
    //   17	24	4	localObject	Object
    //   13	7	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   92	99	100	finally
    //   101	103	100	finally
    //   2	15	105	finally
    //   24	40	105	finally
    //   40	51	105	finally
    //   52	54	105	finally
    //   106	108	105	finally
    //   54	67	110	finally
    //   75	82	110	finally
    //   82	86	110	finally
    //   117	124	126	finally
    //   127	129	126	finally
  }
  
  /* Error */
  public void request(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifge +13 -> 16
    //   6: new 149	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc -105
    //   12: invokespecial 152	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   29: ifeq +23 -> 52
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 48	rx/internal/producers/ProducerObserverArbiter:missedRequested	J
    //   37: lload_1
    //   38: ladd
    //   39: putfield 48	rx/internal/producers/ProducerObserverArbiter:missedRequested	J
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore 7
    //   47: aload_0
    //   48: monitorexit
    //   49: aload 7
    //   51: athrow
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 116	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   63: lload_1
    //   64: ladd
    //   65: lstore 5
    //   67: lload 5
    //   69: lstore_3
    //   70: lload 5
    //   72: lconst_0
    //   73: lcmp
    //   74: ifge +7 -> 81
    //   77: ldc2_w 117
    //   80: lstore_3
    //   81: aload_0
    //   82: lload_3
    //   83: putfield 116	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   86: aload_0
    //   87: getfield 127	rx/internal/producers/ProducerObserverArbiter:currentProducer	Lrx/Producer;
    //   90: astore 7
    //   92: aload 7
    //   94: ifnull +11 -> 105
    //   97: aload 7
    //   99: lload_1
    //   100: invokeinterface 131 3 0
    //   105: aload_0
    //   106: invokevirtual 146	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   109: iconst_1
    //   110: ifne -88 -> 22
    //   113: aload_0
    //   114: monitorenter
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore 7
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 7
    //   129: athrow
    //   130: astore 7
    //   132: iconst_0
    //   133: ifne +12 -> 145
    //   136: aload_0
    //   137: monitorenter
    //   138: aload_0
    //   139: iconst_0
    //   140: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   143: aload_0
    //   144: monitorexit
    //   145: aload 7
    //   147: athrow
    //   148: astore 7
    //   150: aload_0
    //   151: monitorexit
    //   152: aload 7
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	ProducerObserverArbiter
    //   0	155	1	paramLong	long
    //   69	14	3	l1	long
    //   65	6	5	l2	long
    //   45	5	7	localObject1	Object
    //   90	8	7	localProducer	Producer
    //   123	5	7	localObject2	Object
    //   130	16	7	localObject3	Object
    //   148	5	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   25	44	45	finally
    //   47	49	45	finally
    //   52	59	45	finally
    //   115	122	123	finally
    //   125	127	123	finally
    //   59	67	130	finally
    //   81	92	130	finally
    //   97	105	130	finally
    //   105	109	130	finally
    //   138	145	148	finally
    //   150	152	148	finally
  }
  
  /* Error */
  public void setProducer(Producer paramProducer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   6: ifeq +22 -> 28
    //   9: aload_1
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: aload_1
    //   15: putfield 50	rx/internal/producers/ProducerObserverArbiter:missedProducer	Lrx/Producer;
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic 36	rx/internal/producers/ProducerObserverArbiter:NULL_PRODUCER	Lrx/Producer;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 127	rx/internal/producers/ProducerObserverArbiter:currentProducer	Lrx/Producer;
    //   40: aload_0
    //   41: getfield 116	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   44: lstore_2
    //   45: aload_1
    //   46: ifnull +16 -> 62
    //   49: lload_2
    //   50: lconst_0
    //   51: lcmp
    //   52: ifeq +10 -> 62
    //   55: aload_1
    //   56: lload_2
    //   57: invokeinterface 131 3 0
    //   62: aload_0
    //   63: invokevirtual 146	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   66: iconst_1
    //   67: ifne +44 -> 111
    //   70: aload_0
    //   71: monitorenter
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: iconst_0
    //   92: ifne +12 -> 104
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ProducerObserverArbiter
    //   0	112	1	paramProducer	Producer
    //   44	13	2	l	long
    // Exception table:
    //   from	to	target	type
    //   72	79	80	finally
    //   81	83	80	finally
    //   2	9	85	finally
    //   13	20	85	finally
    //   21	25	85	finally
    //   28	35	85	finally
    //   86	88	85	finally
    //   35	45	90	finally
    //   55	62	90	finally
    //   62	66	90	finally
    //   97	104	106	finally
    //   107	109	106	finally
  }
}

/* Location:
 * Qualified Name:     rx.internal.producers.ProducerObserverArbiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */