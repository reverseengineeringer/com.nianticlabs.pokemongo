package crittercism.android;

import android.os.ConditionVariable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

final class bg$6
  extends di
{
  bg$6(bg parambg1, bg parambg2) {}
  
  public final void a()
  {
    Object localObject;
    if (bg.a(a) != bg.a.c)
    {
      localObject = new Runnable()
      {
        public final void run() {}
      };
      ExecutorService localExecutorService = b.a.s;
      localObject = new FutureTask((Runnable)localObject, null);
      localExecutorService.execute((Runnable)localObject);
    }
    try
    {
      ((FutureTask)localObject).get();
      b.a.q.a.block();
      b.a.n.a(bg.c(b));
      b.a.o.a(a);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        dx.a(localInterruptedException);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        dx.a(localExecutionException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bg.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */