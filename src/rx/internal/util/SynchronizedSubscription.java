package rx.internal.util;

import rx.Subscription;

public class SynchronizedSubscription
  implements Subscription
{
  private final Subscription s;
  
  public SynchronizedSubscription(Subscription paramSubscription)
  {
    s = paramSubscription;
  }
  
  public boolean isUnsubscribed()
  {
    try
    {
      boolean bool = s.isUnsubscribed();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void unsubscribe()
  {
    try
    {
      s.unsubscribe();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.SynchronizedSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */