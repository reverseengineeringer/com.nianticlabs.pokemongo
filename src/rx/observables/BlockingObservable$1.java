package rx.observables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.functions.Action1;

class BlockingObservable$1
  extends Subscriber<T>
{
  BlockingObservable$1(BlockingObservable paramBlockingObservable, CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference, Action1 paramAction1) {}
  
  public void onCompleted()
  {
    val$latch.countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$exceptionFromOnError.set(paramThrowable);
    val$latch.countDown();
  }
  
  public void onNext(T paramT)
  {
    val$onNext.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.observables.BlockingObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */