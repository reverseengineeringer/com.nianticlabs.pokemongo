package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

class OnSubscribeRefCount$1
  implements Action1<Subscription>
{
  OnSubscribeRefCount$1(OnSubscribeRefCount paramOnSubscribeRefCount, Subscriber paramSubscriber, AtomicBoolean paramAtomicBoolean) {}
  
  public void call(Subscription paramSubscription)
  {
    try
    {
      OnSubscribeRefCount.access$000(this$0).add(paramSubscription);
      this$0.doSubscribe(val$subscriber, OnSubscribeRefCount.access$000(this$0));
      return;
    }
    finally
    {
      OnSubscribeRefCount.access$100(this$0).unlock();
      val$writeLocked.set(false);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */