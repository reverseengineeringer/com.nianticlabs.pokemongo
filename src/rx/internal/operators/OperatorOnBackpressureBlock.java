package rx.internal.operators;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.internal.util.BackpressureDrainManager;
import rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback;

public class OperatorOnBackpressureBlock<T>
  implements Observable.Operator<T, T>
{
  final int max;
  
  public OperatorOnBackpressureBlock(int paramInt)
  {
    max = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber = new BlockingSubscriber(max, paramSubscriber);
    paramSubscriber.init();
    return paramSubscriber;
  }
  
  static final class BlockingSubscriber<T>
    extends Subscriber<T>
    implements BackpressureDrainManager.BackpressureQueueCallback
  {
    final Subscriber<? super T> child;
    final BackpressureDrainManager manager;
    final NotificationLite<T> nl = NotificationLite.instance();
    final BlockingQueue<Object> queue;
    
    public BlockingSubscriber(int paramInt, Subscriber<? super T> paramSubscriber)
    {
      queue = new ArrayBlockingQueue(paramInt);
      child = paramSubscriber;
      manager = new BackpressureDrainManager(this);
    }
    
    public boolean accept(Object paramObject)
    {
      return nl.accept(child, paramObject);
    }
    
    public void complete(Throwable paramThrowable)
    {
      if (paramThrowable != null)
      {
        child.onError(paramThrowable);
        return;
      }
      child.onCompleted();
    }
    
    void init()
    {
      child.add(this);
      child.setProducer(manager);
    }
    
    public void onCompleted()
    {
      manager.terminateAndDrain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      manager.terminateAndDrain(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      try
      {
        queue.put(nl.next(paramT));
        manager.drain();
        return;
      }
      catch (InterruptedException paramT)
      {
        while (isUnsubscribed()) {}
        onError(paramT);
      }
    }
    
    public Object peek()
    {
      return queue.peek();
    }
    
    public Object poll()
    {
      return queue.poll();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBlock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */