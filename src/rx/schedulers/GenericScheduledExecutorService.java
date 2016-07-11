package rx.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;

final class GenericScheduledExecutorService
{
  private static final GenericScheduledExecutorService INSTANCE = new GenericScheduledExecutorService();
  private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxScheduledExecutorPool-");
  private static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
  private final ScheduledExecutorService executor;
  
  private GenericScheduledExecutorService()
  {
    int j = Runtime.getRuntime().availableProcessors();
    int i = j;
    if (j > 4) {
      i = j / 2;
    }
    j = i;
    if (i > 8) {
      j = 8;
    }
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(j, THREAD_FACTORY);
    if ((!NewThreadWorker.tryEnableCancelPolicy(localScheduledExecutorService)) && ((localScheduledExecutorService instanceof ScheduledThreadPoolExecutor))) {
      NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor)localScheduledExecutorService);
    }
    executor = localScheduledExecutorService;
  }
  
  public static ScheduledExecutorService getInstance()
  {
    return INSTANCEexecutor;
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.GenericScheduledExecutorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */