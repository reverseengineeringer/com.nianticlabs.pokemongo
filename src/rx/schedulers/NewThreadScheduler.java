package rx.schedulers;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;

public final class NewThreadScheduler
  extends Scheduler
{
  private static final NewThreadScheduler INSTANCE = new NewThreadScheduler();
  private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxNewThreadScheduler-");
  private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler-";
  
  static NewThreadScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new NewThreadWorker(THREAD_FACTORY);
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.NewThreadScheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */