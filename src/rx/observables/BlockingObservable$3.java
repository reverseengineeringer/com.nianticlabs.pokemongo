package rx.observables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

class BlockingObservable$3
  extends Subscriber<T>
{
  BlockingObservable$3(BlockingObservable paramBlockingObservable, CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2) {}
  
  public void onCompleted()
  {
    val$latch.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$returnException.set(paramThrowable);
    val$latch.countDown();
  }
  
  public void onNext(T paramT)
  {
    val$returnItem.set(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.observables.BlockingObservable.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */