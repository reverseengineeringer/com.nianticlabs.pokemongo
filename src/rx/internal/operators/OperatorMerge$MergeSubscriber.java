package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.subscriptions.CompositeSubscription;

final class OperatorMerge$MergeSubscriber<T>
  extends Subscriber<Observable<? extends T>>
{
  static final OperatorMerge.InnerSubscriber<?>[] EMPTY = new OperatorMerge.InnerSubscriber[0];
  final Subscriber<? super T> child;
  final boolean delayErrors;
  volatile boolean done;
  boolean emitting;
  volatile ConcurrentLinkedQueue<Throwable> errors;
  final Object innerGuard;
  volatile OperatorMerge.InnerSubscriber<?>[] innerSubscribers;
  long lastId;
  int lastIndex;
  final int maxConcurrent;
  boolean missed;
  final NotificationLite<T> nl;
  OperatorMerge.MergeProducer<T> producer;
  volatile RxRingBuffer queue;
  volatile CompositeSubscription subscriptions;
  long uniqueId;
  
  public OperatorMerge$MergeSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, int paramInt)
  {
    child = paramSubscriber;
    delayErrors = paramBoolean;
    maxConcurrent = paramInt;
    nl = NotificationLite.instance();
    innerGuard = new Object();
    innerSubscribers = EMPTY;
    request(Math.min(paramInt, RxRingBuffer.SIZE));
  }
  
  private void reportError()
  {
    ArrayList localArrayList = new ArrayList(errors);
    if (localArrayList.size() == 1)
    {
      child.onError((Throwable)localArrayList.get(0));
      return;
    }
    child.onError(new CompositeException(localArrayList));
  }
  
  void addInner(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber)
  {
    getOrCreateComposite().add(paramInnerSubscriber);
    synchronized (innerGuard)
    {
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber1 = innerSubscribers;
      int i = arrayOfInnerSubscriber1.length;
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber2 = new OperatorMerge.InnerSubscriber[i + 1];
      System.arraycopy(arrayOfInnerSubscriber1, 0, arrayOfInnerSubscriber2, 0, i);
      arrayOfInnerSubscriber2[i] = paramInnerSubscriber;
      innerSubscribers = arrayOfInnerSubscriber2;
      return;
    }
  }
  
  boolean checkTerminate()
  {
    if (child.isUnsubscribed()) {
      return true;
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = errors;
    if ((!delayErrors) && (localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty())) {
      try
      {
        reportError();
        return true;
      }
      finally
      {
        unsubscribe();
      }
    }
    return false;
  }
  
  void emit()
  {
    try
    {
      if (emitting)
      {
        missed = true;
        return;
      }
      emitting = true;
      emitLoop();
      return;
    }
    finally {}
  }
  
  void emitLoop()
  {
    i5 = 0;
    i4 = 0;
    j = i4;
    try
    {
      Subscriber localSubscriber = child;
      for (;;)
      {
        j = i4;
        boolean bool = checkTerminate();
        if (bool)
        {
          if (1 != 0) {
            break label1154;
          }
          try
          {
            emitting = false;
            return;
          }
          finally {}
        }
        j = i4;
        Object localObject19 = queue;
        j = i4;
        long l1 = producer.get();
        int i1;
        int i;
        label163:
        int k;
        long l2;
        label193:
        int i7;
        if (l1 == Long.MAX_VALUE) {
          i1 = 1;
        } else {
          for (;;)
          {
            if (l1 > 0L)
            {
              j = i4;
              Object localObject2 = ((RxRingBuffer)localObject19).poll();
              j = i4;
              bool = checkTerminate();
              if (bool)
              {
                if (1 != 0) {
                  break label1154;
                }
                try
                {
                  emitting = false;
                  return;
                }
                finally {}
                i1 = 0;
                break label1155;
              }
              if (localObject3 != null) {}
            }
            else
            {
              if (i > 0)
              {
                if (i1 == 0) {
                  break label458;
                }
                l1 = Long.MAX_VALUE;
              }
              i = k;
              l2 = l1;
              if (l1 != 0L)
              {
                i = k;
                l2 = l1;
                if (localObject3 != null) {
                  break label1174;
                }
                l2 = l1;
                i = k;
              }
              j = i4;
              bool = done;
              j = i4;
              RxRingBuffer localRxRingBuffer = queue;
              j = i4;
              localObject20 = innerSubscribers;
              j = i4;
              i7 = localObject20.length;
              if (!bool) {
                break label484;
              }
              if (localRxRingBuffer != null)
              {
                j = i4;
                if (!localRxRingBuffer.isEmpty()) {
                  break label484;
                }
              }
              if (i7 != 0) {
                break label484;
              }
              j = i4;
              localObject19 = errors;
              if (localObject19 != null)
              {
                j = i4;
                if (!((Queue)localObject19).isEmpty()) {
                  break label474;
                }
              }
              j = i4;
              localSubscriber.onCompleted();
              label289:
              if (localRxRingBuffer != null)
              {
                j = i4;
                localRxRingBuffer.release();
              }
              if (1 != 0) {
                break label1154;
              }
              try
              {
                emitting = false;
                return;
              }
              finally {}
            }
            j = i4;
            Object localObject20 = nl.getValue(localObject4);
            j = i4;
            try
            {
              localSubscriber.onNext(localObject20);
              k += 1;
              i += 1;
              l1 -= 1L;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                j = i4;
                if (!delayErrors)
                {
                  j = i4;
                  Exceptions.throwIfFatal(localThrowable2);
                  i = 1;
                  j = i;
                  unsubscribe();
                  j = i;
                  localSubscriber.onError(localThrowable2);
                  if (1 != 0) {
                    break;
                  }
                  try
                  {
                    emitting = false;
                    return;
                  }
                  finally {}
                }
                j = i4;
                getOrCreateErrorQueue().offer(localThrowable2);
              }
            }
          }
        }
        try
        {
          emitting = false;
          throw ((Throwable)localObject6);
          j = i4;
          l1 = producer.produced(i);
          break label163;
          j = i4;
          reportError();
          break label289;
          n = 0;
          i6 = 0;
          k = i;
          if (i7 > 0)
          {
            j = i4;
            l1 = lastId;
            j = i4;
            m = lastIndex;
            if (i7 > m)
            {
              j = i4;
              k = m;
              if (id == l1) {
                break label1210;
              }
              break label1190;
              for (;;)
              {
                if (m < i7)
                {
                  j = i4;
                  if (id != l1) {}
                }
                else
                {
                  m = k;
                  j = i4;
                  lastIndex = k;
                  j = i4;
                  lastId = id;
                  k = m;
                  break label1210;
                  n = k;
                  i = m;
                  if (i2 >= i7) {
                    break label998;
                  }
                  j = i4;
                  bool = checkTerminate();
                  if (!bool) {
                    break;
                  }
                  if (1 != 0) {
                    break label1154;
                  }
                  try
                  {
                    emitting = false;
                    return;
                  }
                  finally {}
                }
                j = k + 1;
                k = j;
                if (j == i7) {
                  k = 0;
                }
                m += 1;
              }
              OperatorMerge.InnerSubscriber localInnerSubscriber = localThrowable2[i3];
              localObject19 = null;
              l2 = l1;
              break label1229;
              for (;;)
              {
                Object localObject8 = localObject19;
                Object localObject10;
                if (l1 > 0L)
                {
                  j = i4;
                  bool = checkTerminate();
                  if (bool)
                  {
                    if (1 != 0) {
                      break label1154;
                    }
                    try
                    {
                      emitting = false;
                      return;
                    }
                    finally {}
                  }
                  j = i4;
                  localObject10 = queue;
                  if (localObject10 != null) {
                    break label884;
                  }
                  localObject10 = localObject19;
                }
                do
                {
                  if (i <= 0) {
                    break label1238;
                  }
                  if (i1 != 0) {
                    break label1261;
                  }
                  j = i4;
                  l1 = producer.produced(i);
                  j = i4;
                  localInnerSubscriber.requestMore(i);
                  break label1238;
                  j = i4;
                  bool = done;
                  j = i4;
                  localObject10 = queue;
                  n = k;
                  i = m;
                  if (!bool) {
                    break label1277;
                  }
                  if (localObject10 != null)
                  {
                    j = i4;
                    n = k;
                    i = m;
                    if (!((RxRingBuffer)localObject10).isEmpty()) {
                      break label1277;
                    }
                  }
                  j = i4;
                  removeInner(localInnerSubscriber);
                  j = i4;
                  bool = checkTerminate();
                  if (!bool) {
                    break label1269;
                  }
                  if (1 != 0) {
                    break;
                  }
                  try
                  {
                    emitting = false;
                    return;
                  }
                  finally {}
                  j = i4;
                  localObject19 = ((RxRingBuffer)localObject11).poll();
                  localObject12 = localObject19;
                } while (localObject19 == null);
                j = i4;
                Object localObject12 = nl.getValue(localObject19);
                j = i4;
                try
                {
                  localSubscriber.onNext(localObject12);
                  l1 -= 1L;
                  i += 1;
                }
                catch (Throwable localThrowable1)
                {
                  i = 1;
                  j = i;
                  Exceptions.throwIfFatal(localThrowable1);
                  try
                  {
                    localSubscriber.onError(localThrowable1);
                    j = i;
                    unsubscribe();
                    if (1 != 0) {
                      break label1154;
                    }
                    try
                    {
                      emitting = false;
                      return;
                    }
                    finally {}
                    j = i4;
                  }
                  finally
                  {
                    j = i;
                    unsubscribe();
                    j = i;
                  }
                }
              }
              lastIndex = i3;
              j = i4;
              lastId = id;
              k = i;
            }
          }
          else
          {
            if (k > 0)
            {
              j = i4;
              request(k);
            }
            if (n != 0) {
              continue;
            }
            j = i4;
            j = i5;
            try
            {
              if (!missed)
              {
                i = 1;
                j = i;
                emitting = false;
                j = i;
                if (1 != 0) {
                  break label1154;
                }
                try
                {
                  emitting = false;
                  return;
                }
                finally {}
                k = i3 + 1;
                j = k;
                if (k == i7) {
                  j = 0;
                }
                i2 += 1;
                k = n;
                i3 = j;
                m = i;
                break label599;
              }
              j = i5;
              missed = false;
              j = i5;
            }
            finally {}
          }
        }
        finally
        {
          int m;
          for (;;)
          {
            int i6;
            throw ((Throwable)localObject17);
            return;
            j = 0;
            i = 0;
            l2 = l1;
            if (localObject19 == null) {
              break label193;
            }
            l2 = l1;
            i = j;
            j = 0;
            Object localObject18 = null;
            k = i;
            l1 = l2;
            i = j;
            break;
            j = m;
            if (i7 <= m) {
              j = 0;
            }
            m = 0;
            k = j;
            continue;
            int i3 = k;
            int i2 = 0;
            k = i6;
            m = i;
            l1 = l2;
            continue;
            do
            {
              i = 0;
              l1 = l2;
              break;
              if (l1 == 0L) {
                break label787;
              }
              localObject19 = localObject18;
              l2 = l1;
            } while (localObject18 != null);
            continue;
            l1 = Long.MAX_VALUE;
          }
          i = m + 1;
          int n = 1;
        }
      }
    }
    finally
    {
      if (j != 0) {}
    }
  }
  
  /* Error */
  protected void emitScalar(T paramT, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iload 5
    //   5: istore 4
    //   7: aload_0
    //   8: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   11: aload_1
    //   12: invokevirtual 193	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   15: lload_2
    //   16: ldc2_w 171
    //   19: lcmp
    //   20: ifeq +16 -> 36
    //   23: iload 5
    //   25: istore 4
    //   27: aload_0
    //   28: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   31: iconst_1
    //   32: invokevirtual 210	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   35: pop2
    //   36: iload 5
    //   38: istore 4
    //   40: aload_0
    //   41: lconst_1
    //   42: invokevirtual 228	rx/internal/operators/OperatorMerge$MergeSubscriber:requestMore	(J)V
    //   45: iload 5
    //   47: istore 4
    //   49: aload_0
    //   50: monitorenter
    //   51: iconst_1
    //   52: istore 4
    //   54: aload_0
    //   55: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   58: ifne +123 -> 181
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   66: aload_0
    //   67: monitorexit
    //   68: iconst_1
    //   69: ifne +12 -> 81
    //   72: aload_0
    //   73: monitorenter
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_1
    //   83: iload 5
    //   85: istore 4
    //   87: aload_0
    //   88: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   91: ifne +50 -> 141
    //   94: iload 5
    //   96: istore 4
    //   98: aload_1
    //   99: invokestatic 198	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   102: iconst_1
    //   103: istore 5
    //   105: iload 5
    //   107: istore 4
    //   109: aload_0
    //   110: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   113: iload 5
    //   115: istore 4
    //   117: aload_0
    //   118: aload_1
    //   119: invokevirtual 229	rx/internal/operators/OperatorMerge$MergeSubscriber:onError	(Ljava/lang/Throwable;)V
    //   122: iconst_1
    //   123: ifne -42 -> 81
    //   126: aload_0
    //   127: monitorenter
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: iload 5
    //   143: istore 4
    //   145: aload_0
    //   146: invokevirtual 202	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   149: aload_1
    //   150: invokeinterface 206 2 0
    //   155: pop
    //   156: goto -141 -> 15
    //   159: astore_1
    //   160: iload 4
    //   162: ifne +12 -> 174
    //   165: aload_0
    //   166: monitorenter
    //   167: aload_0
    //   168: iconst_0
    //   169: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   186: aload_0
    //   187: monitorexit
    //   188: iconst_1
    //   189: ifne +12 -> 201
    //   192: aload_0
    //   193: monitorenter
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_0
    //   202: invokevirtual 159	rx/internal/operators/OperatorMerge$MergeSubscriber:emitLoop	()V
    //   205: return
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	MergeSubscriber
    //   0	221	1	paramT	T
    //   0	221	2	paramLong	long
    //   5	156	4	i	int
    //   1	141	5	j	int
    // Exception table:
    //   from	to	target	type
    //   7	15	82	java/lang/Throwable
    //   128	135	136	finally
    //   137	139	136	finally
    //   7	15	159	finally
    //   27	36	159	finally
    //   40	45	159	finally
    //   49	51	159	finally
    //   87	94	159	finally
    //   98	102	159	finally
    //   109	113	159	finally
    //   117	122	159	finally
    //   145	156	159	finally
    //   209	211	159	finally
    //   74	81	176	finally
    //   177	179	176	finally
    //   54	68	206	finally
    //   181	188	206	finally
    //   207	209	206	finally
    //   194	201	211	finally
    //   212	214	211	finally
    //   167	174	216	finally
    //   217	219	216	finally
  }
  
  /* Error */
  protected void emitScalar(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload 6
    //   5: istore 5
    //   7: aload_0
    //   8: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   11: aload_2
    //   12: invokevirtual 193	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   15: lload_3
    //   16: ldc2_w 171
    //   19: lcmp
    //   20: ifeq +16 -> 36
    //   23: iload 6
    //   25: istore 5
    //   27: aload_0
    //   28: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   31: iconst_1
    //   32: invokevirtual 210	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   35: pop2
    //   36: iload 6
    //   38: istore 5
    //   40: aload_1
    //   41: lconst_1
    //   42: invokevirtual 221	rx/internal/operators/OperatorMerge$InnerSubscriber:requestMore	(J)V
    //   45: iload 6
    //   47: istore 5
    //   49: aload_0
    //   50: monitorenter
    //   51: iconst_1
    //   52: istore 5
    //   54: aload_0
    //   55: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   58: ifne +123 -> 181
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   66: aload_0
    //   67: monitorexit
    //   68: iconst_1
    //   69: ifne +12 -> 81
    //   72: aload_0
    //   73: monitorenter
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: iload 6
    //   85: istore 5
    //   87: aload_0
    //   88: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   91: ifne +50 -> 141
    //   94: iload 6
    //   96: istore 5
    //   98: aload_2
    //   99: invokestatic 198	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   102: iconst_1
    //   103: istore 6
    //   105: iload 6
    //   107: istore 5
    //   109: aload_1
    //   110: invokevirtual 232	rx/internal/operators/OperatorMerge$InnerSubscriber:unsubscribe	()V
    //   113: iload 6
    //   115: istore 5
    //   117: aload_1
    //   118: aload_2
    //   119: invokevirtual 233	rx/internal/operators/OperatorMerge$InnerSubscriber:onError	(Ljava/lang/Throwable;)V
    //   122: iconst_1
    //   123: ifne -42 -> 81
    //   126: aload_0
    //   127: monitorenter
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: iload 6
    //   143: istore 5
    //   145: aload_0
    //   146: invokevirtual 202	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   149: aload_2
    //   150: invokeinterface 206 2 0
    //   155: pop
    //   156: goto -141 -> 15
    //   159: astore_1
    //   160: iload 5
    //   162: ifne +12 -> 174
    //   165: aload_0
    //   166: monitorenter
    //   167: aload_0
    //   168: iconst_0
    //   169: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   186: aload_0
    //   187: monitorexit
    //   188: iconst_1
    //   189: ifne +12 -> 201
    //   192: aload_0
    //   193: monitorenter
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_0
    //   202: invokevirtual 159	rx/internal/operators/OperatorMerge$MergeSubscriber:emitLoop	()V
    //   205: return
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	MergeSubscriber
    //   0	221	1	paramInnerSubscriber	OperatorMerge.InnerSubscriber<T>
    //   0	221	2	paramT	T
    //   0	221	3	paramLong	long
    //   5	156	5	i	int
    //   1	141	6	j	int
    // Exception table:
    //   from	to	target	type
    //   7	15	82	java/lang/Throwable
    //   128	135	136	finally
    //   137	139	136	finally
    //   7	15	159	finally
    //   27	36	159	finally
    //   40	45	159	finally
    //   49	51	159	finally
    //   87	94	159	finally
    //   98	102	159	finally
    //   109	113	159	finally
    //   117	122	159	finally
    //   145	156	159	finally
    //   209	211	159	finally
    //   74	81	176	finally
    //   177	179	176	finally
    //   54	68	206	finally
    //   181	188	206	finally
    //   207	209	206	finally
    //   194	201	211	finally
    //   212	214	211	finally
    //   167	174	216	finally
    //   217	219	216	finally
  }
  
  /* Error */
  CompositeSubscription getOrCreateComposite()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 236	rx/internal/operators/OperatorMerge$MergeSubscriber:subscriptions	Lrx/subscriptions/CompositeSubscription;
    //   4: astore_2
    //   5: aload_2
    //   6: astore_3
    //   7: aload_2
    //   8: ifnonnull +48 -> 56
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 236	rx/internal/operators/OperatorMerge$MergeSubscriber:subscriptions	Lrx/subscriptions/CompositeSubscription;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: ifnonnull +18 -> 41
    //   26: new 125	rx/subscriptions/CompositeSubscription
    //   29: dup
    //   30: invokespecial 237	rx/subscriptions/CompositeSubscription:<init>	()V
    //   33: astore_2
    //   34: aload_0
    //   35: aload_2
    //   36: putfield 236	rx/internal/operators/OperatorMerge$MergeSubscriber:subscriptions	Lrx/subscriptions/CompositeSubscription;
    //   39: iconst_1
    //   40: istore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: astore_3
    //   45: iload_1
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: aload_2
    //   51: invokevirtual 238	rx/internal/operators/OperatorMerge$MergeSubscriber:add	(Lrx/Subscription;)V
    //   54: aload_2
    //   55: astore_3
    //   56: aload_3
    //   57: areturn
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    //   63: astore_2
    //   64: goto -5 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	MergeSubscriber
    //   12	34	1	i	int
    //   4	51	2	localObject1	Object
    //   58	4	2	localObject2	Object
    //   63	1	2	localObject3	Object
    //   6	51	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	58	finally
    //   26	34	58	finally
    //   41	43	58	finally
    //   59	61	58	finally
    //   34	39	63	finally
  }
  
  Queue<Throwable> getOrCreateErrorQueue()
  {
    Object localObject1 = errors;
    if (localObject1 == null)
    {
      for (;;)
      {
        try
        {
          ConcurrentLinkedQueue localConcurrentLinkedQueue = errors;
          localObject1 = localConcurrentLinkedQueue;
          if (localConcurrentLinkedQueue == null) {
            localObject1 = new ConcurrentLinkedQueue();
          }
        }
        finally
        {
          continue;
        }
        try
        {
          errors = ((ConcurrentLinkedQueue)localObject1);
          return (Queue<Throwable>)localObject1;
        }
        finally {}
      }
      throw ((Throwable)localObject1);
    }
    return localQueue;
  }
  
  public void onCompleted()
  {
    done = true;
    emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    getOrCreateErrorQueue().offer(paramThrowable);
    done = true;
    emit();
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    if (paramObservable == null) {
      return;
    }
    if ((paramObservable instanceof ScalarSynchronousObservable))
    {
      tryEmit(((ScalarSynchronousObservable)paramObservable).get());
      return;
    }
    long l = uniqueId;
    uniqueId = (1L + l);
    OperatorMerge.InnerSubscriber localInnerSubscriber = new OperatorMerge.InnerSubscriber(this, l);
    addInner(localInnerSubscriber);
    paramObservable.unsafeSubscribe(localInnerSubscriber);
    emit();
  }
  
  protected void queueScalar(T paramT)
  {
    RxRingBuffer localRxRingBuffer2 = queue;
    RxRingBuffer localRxRingBuffer1 = localRxRingBuffer2;
    if (localRxRingBuffer2 == null)
    {
      localRxRingBuffer1 = RxRingBuffer.getSpscInstance();
      add(localRxRingBuffer1);
      queue = localRxRingBuffer1;
    }
    try
    {
      localRxRingBuffer1.onNext(nl.next(paramT));
      emit();
      return;
    }
    catch (MissingBackpressureException paramT)
    {
      unsubscribe();
      onError(paramT);
      return;
    }
    catch (IllegalStateException paramT)
    {
      while (isUnsubscribed()) {}
      unsubscribe();
      onError(paramT);
    }
  }
  
  protected void queueScalar(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT)
  {
    RxRingBuffer localRxRingBuffer2 = queue;
    RxRingBuffer localRxRingBuffer1 = localRxRingBuffer2;
    if (localRxRingBuffer2 == null)
    {
      localRxRingBuffer1 = RxRingBuffer.getSpscInstance();
      paramInnerSubscriber.add(localRxRingBuffer1);
      queue = localRxRingBuffer1;
    }
    try
    {
      localRxRingBuffer1.onNext(nl.next(paramT));
      emit();
      return;
    }
    catch (MissingBackpressureException paramT)
    {
      paramInnerSubscriber.unsubscribe();
      paramInnerSubscriber.onError(paramT);
      return;
    }
    catch (IllegalStateException paramT)
    {
      while (paramInnerSubscriber.isUnsubscribed()) {}
      paramInnerSubscriber.unsubscribe();
      paramInnerSubscriber.onError(paramT);
    }
  }
  
  void removeInner(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber)
  {
    ??? = queue;
    if (??? != null) {
      ((RxRingBuffer)???).release();
    }
    subscriptions.remove(paramInnerSubscriber);
    for (;;)
    {
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber;
      int m;
      int i;
      int j;
      synchronized (innerGuard)
      {
        arrayOfInnerSubscriber = innerSubscribers;
        m = arrayOfInnerSubscriber.length;
        int k = -1;
        i = 0;
        j = k;
        if (i < m)
        {
          if (!paramInnerSubscriber.equals(arrayOfInnerSubscriber[i])) {
            break label144;
          }
          j = i;
        }
        if (j < 0) {
          return;
        }
        if (m == 1)
        {
          innerSubscribers = EMPTY;
          return;
        }
      }
      paramInnerSubscriber = new OperatorMerge.InnerSubscriber[m - 1];
      System.arraycopy(arrayOfInnerSubscriber, 0, paramInnerSubscriber, 0, j);
      System.arraycopy(arrayOfInnerSubscriber, j + 1, paramInnerSubscriber, j, m - j - 1);
      innerSubscribers = paramInnerSubscriber;
      return;
      label144:
      i += 1;
    }
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  void tryEmit(T paramT)
  {
    int i = 0;
    int j = 0;
    long l = producer.get();
    if (l != 0L) {
      i = j;
    }
    try
    {
      if (!emitting)
      {
        emitting = true;
        i = 1;
      }
      if (i != 0)
      {
        emitScalar(paramT, l);
        return;
      }
    }
    finally {}
    queueScalar(paramT);
  }
  
  void tryEmit(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT)
  {
    int i = 0;
    int j = 0;
    long l = producer.get();
    if (l != 0L) {
      i = j;
    }
    try
    {
      if (!emitting)
      {
        emitting = true;
        i = 1;
      }
      if (i != 0)
      {
        emitScalar(paramInnerSubscriber, paramT, l);
        return;
      }
    }
    finally {}
    queueScalar(paramInnerSubscriber, paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMerge.MergeSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */