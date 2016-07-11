package rx.internal.operators;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

final class BlockingOperatorToFuture$1
  extends Subscriber<T>
{
  BlockingOperatorToFuture$1(CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2) {}
  
  public void onCompleted()
  {
    val$finished.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$error.compareAndSet(null, paramThrowable);
    val$finished.countDown();
  }
  
  public void onNext(T paramT)
  {
    val$value.set(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorToFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */