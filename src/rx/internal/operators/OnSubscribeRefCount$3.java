package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

class OnSubscribeRefCount$3
  implements Action0
{
  OnSubscribeRefCount$3(OnSubscribeRefCount paramOnSubscribeRefCount, CompositeSubscription paramCompositeSubscription) {}
  
  public void call()
  {
    OnSubscribeRefCount.access$100(this$0).lock();
    try
    {
      if ((OnSubscribeRefCount.access$000(this$0) == val$current) && (OnSubscribeRefCount.access$200(this$0).decrementAndGet() == 0))
      {
        OnSubscribeRefCount.access$000(this$0).unsubscribe();
        OnSubscribeRefCount.access$002(this$0, new CompositeSubscription());
      }
      return;
    }
    finally
    {
      OnSubscribeRefCount.access$100(this$0).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */