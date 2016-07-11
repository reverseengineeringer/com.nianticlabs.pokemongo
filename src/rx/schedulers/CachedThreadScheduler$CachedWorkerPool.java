package rx.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class CachedThreadScheduler$CachedWorkerPool
{
  private static CachedWorkerPool INSTANCE = new CachedWorkerPool(60L, TimeUnit.SECONDS);
  private final ScheduledExecutorService evictExpiredWorkerExecutor;
  private final ConcurrentLinkedQueue<CachedThreadScheduler.ThreadWorker> expiringWorkerQueue;
  private final long keepAliveTime;
  
  CachedThreadScheduler$CachedWorkerPool(long paramLong, TimeUnit paramTimeUnit)
  {
    keepAliveTime = paramTimeUnit.toNanos(paramLong);
    expiringWorkerQueue = new ConcurrentLinkedQueue();
    evictExpiredWorkerExecutor = Executors.newScheduledThreadPool(1, CachedThreadScheduler.access$000());
    evictExpiredWorkerExecutor.scheduleWithFixedDelay(new Runnable()
    {
      public void run()
      {
        evictExpiredWorkers();
      }
    }, keepAliveTime, keepAliveTime, TimeUnit.NANOSECONDS);
  }
  
  void evictExpiredWorkers()
  {
    if (!expiringWorkerQueue.isEmpty())
    {
      long l = now();
      Iterator localIterator = expiringWorkerQueue.iterator();
      while (localIterator.hasNext())
      {
        CachedThreadScheduler.ThreadWorker localThreadWorker = (CachedThreadScheduler.ThreadWorker)localIterator.next();
        if (localThreadWorker.getExpirationTime() > l) {
          break;
        }
        if (expiringWorkerQueue.remove(localThreadWorker)) {
          localThreadWorker.unsubscribe();
        }
      }
    }
  }
  
  CachedThreadScheduler.ThreadWorker get()
  {
    while (!expiringWorkerQueue.isEmpty())
    {
      CachedThreadScheduler.ThreadWorker localThreadWorker = (CachedThreadScheduler.ThreadWorker)expiringWorkerQueue.poll();
      if (localThreadWorker != null) {
        return localThreadWorker;
      }
    }
    return new CachedThreadScheduler.ThreadWorker(CachedThreadScheduler.access$100());
  }
  
  long now()
  {
    return System.nanoTime();
  }
  
  void release(CachedThreadScheduler.ThreadWorker paramThreadWorker)
  {
    paramThreadWorker.setExpirationTime(now() + keepAliveTime);
    expiringWorkerQueue.offer(paramThreadWorker);
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.CachedWorkerPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */