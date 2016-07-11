package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

final class OperatorBufferWithTime$ExactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  List<T> chunk;
  boolean done;
  final Scheduler.Worker inner;
  
  public OperatorBufferWithTime$ExactSubscriber(Subscriber<? super List<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    child = paramWorker;
    Scheduler.Worker localWorker;
    inner = localWorker;
    chunk = new ArrayList();
  }
  
  /* Error */
  void emit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:done	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: getfield 38	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:chunk	Ljava/util/List;
    //   16: astore_1
    //   17: aload_0
    //   18: new 35	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 36	java/util/ArrayList:<init>	()V
    //   25: putfield 38	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:chunk	Ljava/util/List;
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_0
    //   31: getfield 31	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:child	Lrx/Subscriber;
    //   34: aload_1
    //   35: invokevirtual 50	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   38: return
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 54	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:onError	(Ljava/lang/Throwable;)V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	ExactSubscriber
    //   16	19	1	localList	List
    //   39	3	1	localThrowable	Throwable
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	38	39	java/lang/Throwable
    //   2	11	46	finally
    //   12	30	46	finally
    //   47	49	46	finally
  }
  
  public void onCompleted()
  {
    try
    {
      inner.unsubscribe();
      try
      {
        if (done) {
          return;
        }
        done = true;
        List localList = chunk;
        chunk = null;
        child.onNext(localList);
        child.onCompleted();
        unsubscribe();
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      child.onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      if (done) {
        return;
      }
      done = true;
      chunk = null;
      child.onError(paramThrowable);
      unsubscribe();
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    Object localObject = null;
    try
    {
      if (done) {
        return;
      }
      chunk.add(paramT);
      paramT = (T)localObject;
      if (chunk.size() == this$0.count)
      {
        paramT = chunk;
        chunk = new ArrayList();
      }
      if (paramT != null)
      {
        child.onNext(paramT);
        return;
      }
    }
    finally {}
  }
  
  void scheduleExact()
  {
    inner.schedulePeriodically(new Action0()
    {
      public void call()
      {
        emit();
      }
    }, this$0.timespan, this$0.timespan, this$0.unit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime.ExactSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */