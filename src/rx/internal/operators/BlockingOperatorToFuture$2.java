package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

final class BlockingOperatorToFuture$2
  implements Future<T>
{
  private volatile boolean cancelled = false;
  
  BlockingOperatorToFuture$2(CountDownLatch paramCountDownLatch, Subscription paramSubscription, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2) {}
  
  private T getValue()
    throws ExecutionException
  {
    if (val$error.get() != null) {
      throw new ExecutionException("Observable onError", (Throwable)val$error.get());
    }
    if (cancelled) {
      throw new CancellationException("Subscription unsubscribed");
    }
    return (T)val$value.get();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (val$finished.getCount() > 0L)
    {
      cancelled = true;
      val$s.unsubscribe();
      val$finished.countDown();
      return true;
    }
    return false;
  }
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    val$finished.await();
    return (T)getValue();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    if (val$finished.await(paramLong, paramTimeUnit)) {
      return (T)getValue();
    }
    throw new TimeoutException("Timed out after " + paramTimeUnit.toMillis(paramLong) + "ms waiting for underlying Observable.");
  }
  
  public boolean isCancelled()
  {
    return cancelled;
  }
  
  public boolean isDone()
  {
    return val$finished.getCount() == 0L;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorToFuture.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */