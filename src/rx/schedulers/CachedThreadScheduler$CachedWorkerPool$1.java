package rx.schedulers;

class CachedThreadScheduler$CachedWorkerPool$1
  implements Runnable
{
  CachedThreadScheduler$CachedWorkerPool$1(CachedThreadScheduler.CachedWorkerPool paramCachedWorkerPool) {}
  
  public void run()
  {
    this$0.evictExpiredWorkers();
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.CachedWorkerPool.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */