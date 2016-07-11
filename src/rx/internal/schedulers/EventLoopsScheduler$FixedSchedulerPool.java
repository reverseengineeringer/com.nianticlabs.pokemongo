package rx.internal.schedulers;

final class EventLoopsScheduler$FixedSchedulerPool
{
  final int cores = EventLoopsScheduler.MAX_THREADS;
  final EventLoopsScheduler.PoolWorker[] eventLoops = new EventLoopsScheduler.PoolWorker[cores];
  long n;
  
  EventLoopsScheduler$FixedSchedulerPool()
  {
    int i = 0;
    while (i < cores)
    {
      eventLoops[i] = new EventLoopsScheduler.PoolWorker(EventLoopsScheduler.access$000());
      i += 1;
    }
  }
  
  public EventLoopsScheduler.PoolWorker getEventLoop()
  {
    EventLoopsScheduler.PoolWorker[] arrayOfPoolWorker = eventLoops;
    long l = n;
    n = (1L + l);
    return arrayOfPoolWorker[((int)(l % cores))];
  }
}

/* Location:
 * Qualified Name:     rx.internal.schedulers.EventLoopsScheduler.FixedSchedulerPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */