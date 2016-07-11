package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;

final class EventLoopsScheduler$PoolWorker
  extends NewThreadWorker
{
  EventLoopsScheduler$PoolWorker(ThreadFactory paramThreadFactory)
  {
    super(paramThreadFactory);
  }
}

/* Location:
 * Qualified Name:     rx.internal.schedulers.EventLoopsScheduler.PoolWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */