package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithTime<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long timeout;
  final TimeUnit unit;
  
  public OperatorDebounceWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    timeout = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    final Scheduler.Worker localWorker = scheduler.createWorker();
    final SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber);
    final SerialSubscription localSerialSubscription = new SerialSubscription();
    localSerializedSubscriber.add(localWorker);
    localSerializedSubscriber.add(localSerialSubscription);
    new Subscriber(paramSubscriber)
    {
      final Subscriber<?> self = this;
      final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState();
      
      public void onCompleted()
      {
        state.emitAndComplete(localSerializedSubscriber, this);
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        localSerializedSubscriber.onError(paramAnonymousThrowable);
        unsubscribe();
        state.clear();
      }
      
      public void onNext(T paramAnonymousT)
      {
        final int i = state.next(paramAnonymousT);
        localSerialSubscription.set(localWorker.schedule(new Action0()
        {
          public void call()
          {
            state.emit(i, val$s, self);
          }
        }, timeout, unit));
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
  }
  
  static final class DebounceState<T>
  {
    boolean emitting;
    boolean hasValue;
    int index;
    boolean terminate;
    T value;
    
    public void clear()
    {
      try
      {
        index += 1;
        value = null;
        hasValue = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public void emit(int paramInt, Subscriber<T> paramSubscriber, Subscriber<?> paramSubscriber1)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 35	rx/internal/operators/OperatorDebounceWithTime$DebounceState:emitting	Z
      //   6: ifne +18 -> 24
      //   9: aload_0
      //   10: getfield 29	rx/internal/operators/OperatorDebounceWithTime$DebounceState:hasValue	Z
      //   13: ifeq +11 -> 24
      //   16: iload_1
      //   17: aload_0
      //   18: getfield 25	rx/internal/operators/OperatorDebounceWithTime$DebounceState:index	I
      //   21: if_icmpeq +6 -> 27
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: aload_0
      //   28: getfield 27	rx/internal/operators/OperatorDebounceWithTime$DebounceState:value	Ljava/lang/Object;
      //   31: astore 4
      //   33: aload_0
      //   34: aconst_null
      //   35: putfield 27	rx/internal/operators/OperatorDebounceWithTime$DebounceState:value	Ljava/lang/Object;
      //   38: aload_0
      //   39: iconst_0
      //   40: putfield 29	rx/internal/operators/OperatorDebounceWithTime$DebounceState:hasValue	Z
      //   43: aload_0
      //   44: iconst_1
      //   45: putfield 35	rx/internal/operators/OperatorDebounceWithTime$DebounceState:emitting	Z
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_2
      //   51: aload 4
      //   53: invokevirtual 41	rx/Subscriber:onNext	(Ljava/lang/Object;)V
      //   56: aload_0
      //   57: monitorenter
      //   58: aload_0
      //   59: getfield 43	rx/internal/operators/OperatorDebounceWithTime$DebounceState:terminate	Z
      //   62: ifne +28 -> 90
      //   65: aload_0
      //   66: iconst_0
      //   67: putfield 35	rx/internal/operators/OperatorDebounceWithTime$DebounceState:emitting	Z
      //   70: aload_0
      //   71: monitorexit
      //   72: return
      //   73: astore_2
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_2
      //   77: athrow
      //   78: astore_2
      //   79: aload_0
      //   80: monitorexit
      //   81: aload_2
      //   82: athrow
      //   83: astore_2
      //   84: aload_3
      //   85: aload_2
      //   86: invokevirtual 47	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
      //   89: return
      //   90: aload_0
      //   91: monitorexit
      //   92: aload_2
      //   93: invokevirtual 50	rx/Subscriber:onCompleted	()V
      //   96: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	97	0	this	DebounceState
      //   0	97	1	paramInt	int
      //   0	97	2	paramSubscriber	Subscriber<T>
      //   0	97	3	paramSubscriber1	Subscriber<?>
      //   31	21	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   58	72	73	finally
      //   74	76	73	finally
      //   90	92	73	finally
      //   2	24	78	finally
      //   24	26	78	finally
      //   27	50	78	finally
      //   79	81	78	finally
      //   50	56	83	java/lang/Throwable
    }
    
    /* Error */
    public void emitAndComplete(Subscriber<T> paramSubscriber, Subscriber<?> paramSubscriber1)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 35	rx/internal/operators/OperatorDebounceWithTime$DebounceState:emitting	Z
      //   6: ifeq +11 -> 17
      //   9: aload_0
      //   10: iconst_1
      //   11: putfield 43	rx/internal/operators/OperatorDebounceWithTime$DebounceState:terminate	Z
      //   14: aload_0
      //   15: monitorexit
      //   16: return
      //   17: aload_0
      //   18: getfield 27	rx/internal/operators/OperatorDebounceWithTime$DebounceState:value	Ljava/lang/Object;
      //   21: astore 4
      //   23: aload_0
      //   24: getfield 29	rx/internal/operators/OperatorDebounceWithTime$DebounceState:hasValue	Z
      //   27: istore_3
      //   28: aload_0
      //   29: aconst_null
      //   30: putfield 27	rx/internal/operators/OperatorDebounceWithTime$DebounceState:value	Ljava/lang/Object;
      //   33: aload_0
      //   34: iconst_0
      //   35: putfield 29	rx/internal/operators/OperatorDebounceWithTime$DebounceState:hasValue	Z
      //   38: aload_0
      //   39: iconst_1
      //   40: putfield 35	rx/internal/operators/OperatorDebounceWithTime$DebounceState:emitting	Z
      //   43: aload_0
      //   44: monitorexit
      //   45: iload_3
      //   46: ifeq +9 -> 55
      //   49: aload_1
      //   50: aload 4
      //   52: invokevirtual 41	rx/Subscriber:onNext	(Ljava/lang/Object;)V
      //   55: aload_1
      //   56: invokevirtual 50	rx/Subscriber:onCompleted	()V
      //   59: return
      //   60: astore_1
      //   61: aload_0
      //   62: monitorexit
      //   63: aload_1
      //   64: athrow
      //   65: astore_1
      //   66: aload_2
      //   67: aload_1
      //   68: invokevirtual 47	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
      //   71: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	72	0	this	DebounceState
      //   0	72	1	paramSubscriber	Subscriber<T>
      //   0	72	2	paramSubscriber1	Subscriber<?>
      //   27	19	3	bool	boolean
      //   21	30	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	16	60	finally
      //   17	45	60	finally
      //   61	63	60	finally
      //   49	55	65	java/lang/Throwable
    }
    
    public int next(T paramT)
    {
      try
      {
        value = paramT;
        hasValue = true;
        int i = index + 1;
        index = i;
        return i;
      }
      finally
      {
        paramT = finally;
        throw paramT;
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */