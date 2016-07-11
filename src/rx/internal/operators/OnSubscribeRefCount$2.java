package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

class OnSubscribeRefCount$2
  extends Subscriber<T>
{
  OnSubscribeRefCount$2(OnSubscribeRefCount paramOnSubscribeRefCount, Subscriber paramSubscriber1, Subscriber paramSubscriber2, CompositeSubscription paramCompositeSubscription)
  {
    super(paramSubscriber1);
  }
  
  void cleanup()
  {
    OnSubscribeRefCount.access$100(this$0).lock();
    try
    {
      if (OnSubscribeRefCount.access$000(this$0) == val$currentBase)
      {
        OnSubscribeRefCount.access$000(this$0).unsubscribe();
        OnSubscribeRefCount.access$002(this$0, new CompositeSubscription());
        OnSubscribeRefCount.access$200(this$0).set(0);
      }
      return;
    }
    finally
    {
      OnSubscribeRefCount.access$100(this$0).unlock();
    }
  }
  
  public void onCompleted()
  {
    cleanup();
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    cleanup();
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$subscriber.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */