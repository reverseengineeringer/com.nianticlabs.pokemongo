package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

final class OnSubscribeUsing$DisposeAction<Resource>
  extends AtomicBoolean
  implements Action0, Subscription
{
  private static final long serialVersionUID = 4262875056400218316L;
  private Action1<? super Resource> dispose;
  private Resource resource;
  
  private OnSubscribeUsing$DisposeAction(Action1<? super Resource> paramAction1, Resource paramResource)
  {
    dispose = paramAction1;
    resource = paramResource;
    lazySet(false);
  }
  
  public void call()
  {
    if (compareAndSet(false, true)) {}
    try
    {
      dispose.call(resource);
      return;
    }
    finally
    {
      resource = null;
      dispose = null;
    }
  }
  
  public boolean isUnsubscribed()
  {
    return get();
  }
  
  public void unsubscribe()
  {
    call();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeUsing.DisposeAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */