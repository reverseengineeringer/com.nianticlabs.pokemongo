package rx.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.internal.schedulers.NewThreadWorker;

final class CachedThreadScheduler$ThreadWorker
  extends NewThreadWorker
{
  private long expirationTime = 0L;
  
  CachedThreadScheduler$ThreadWorker(ThreadFactory paramThreadFactory)
  {
    super(paramThreadFactory);
  }
  
  public long getExpirationTime()
  {
    return expirationTime;
  }
  
  public void setExpirationTime(long paramLong)
  {
    expirationTime = paramLong;
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.ThreadWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */