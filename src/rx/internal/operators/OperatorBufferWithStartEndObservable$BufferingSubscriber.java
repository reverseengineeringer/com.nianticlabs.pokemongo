package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

final class OperatorBufferWithStartEndObservable$BufferingSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  final List<List<T>> chunks;
  final CompositeSubscription closingSubscriptions;
  boolean done;
  
  public OperatorBufferWithStartEndObservable$BufferingSubscriber(Subscriber<? super List<T>> paramSubscriber)
  {
    Subscriber localSubscriber;
    child = localSubscriber;
    chunks = new LinkedList();
    closingSubscriptions = new CompositeSubscription();
    add(closingSubscriptions);
  }
  
  void endBuffer(List<T> paramList)
  {
    int j = 0;
    try
    {
      if (done) {
        return;
      }
      Iterator localIterator = chunks.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while ((List)localIterator.next() != paramList);
      int i = 1;
      localIterator.remove();
      if (i != 0)
      {
        child.onNext(paramList);
        return;
      }
    }
    finally {}
  }
  
  /* Error */
  public void onCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:done	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 52	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:done	Z
    //   17: new 33	java/util/LinkedList
    //   20: dup
    //   21: aload_0
    //   22: getfield 36	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:chunks	Ljava/util/List;
    //   25: invokespecial 82	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 36	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:chunks	Ljava/util/List;
    //   33: invokeinterface 85 1 0
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: invokeinterface 58 1 0
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 64 1 0
    //   53: ifeq +39 -> 92
    //   56: aload_1
    //   57: invokeinterface 68 1 0
    //   62: checkcast 54	java/util/List
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 31	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:child	Lrx/Subscriber;
    //   70: aload_2
    //   71: invokevirtual 75	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   74: goto -27 -> 47
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 31	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:child	Lrx/Subscriber;
    //   82: aload_1
    //   83: invokevirtual 89	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: aload_0
    //   93: getfield 31	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:child	Lrx/Subscriber;
    //   96: invokevirtual 91	rx/Subscriber:onCompleted	()V
    //   99: aload_0
    //   100: invokevirtual 94	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:unsubscribe	()V
    //   103: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	BufferingSubscriber
    //   28	29	1	localObject1	Object
    //   77	6	1	localThrowable	Throwable
    //   87	4	1	localObject2	Object
    //   65	6	2	localList	List
    // Exception table:
    //   from	to	target	type
    //   0	2	77	java/lang/Throwable
    //   40	47	77	java/lang/Throwable
    //   47	74	77	java/lang/Throwable
    //   90	92	77	java/lang/Throwable
    //   2	11	87	finally
    //   12	40	87	finally
    //   88	90	87	finally
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      if (done) {
        return;
      }
      done = true;
      chunks.clear();
      child.onError(paramThrowable);
      unsubscribe();
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Iterator localIterator = chunks.iterator();
      while (localIterator.hasNext()) {
        ((List)localIterator.next()).add(paramT);
      }
    }
    finally {}
  }
  
  void startBuffer(TOpening paramTOpening)
  {
    final Object localObject = new ArrayList();
    try
    {
      if (done) {
        return;
      }
      chunks.add(localObject);
      return;
    }
    finally
    {
      try
      {
        paramTOpening = (Observable)this$0.bufferClosing.call(paramTOpening);
        localObject = new Subscriber()
        {
          public void onCompleted()
          {
            closingSubscriptions.remove(this);
            endBuffer(localObject);
          }
          
          public void onError(Throwable paramAnonymousThrowable)
          {
            OperatorBufferWithStartEndObservable.BufferingSubscriber.this.onError(paramAnonymousThrowable);
          }
          
          public void onNext(TClosing paramAnonymousTClosing)
          {
            closingSubscriptions.remove(this);
            endBuffer(localObject);
          }
        };
        closingSubscriptions.add((Subscription)localObject);
        paramTOpening.unsafeSubscribe((Subscriber)localObject);
        return;
      }
      catch (Throwable paramTOpening)
      {
        onError(paramTOpening);
      }
      paramTOpening = finally;
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */