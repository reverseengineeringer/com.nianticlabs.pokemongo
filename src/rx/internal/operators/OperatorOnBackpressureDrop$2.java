package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.functions.Action1;

class OperatorOnBackpressureDrop$2
  extends Subscriber<T>
{
  OperatorOnBackpressureDrop$2(OperatorOnBackpressureDrop paramOperatorOnBackpressureDrop, Subscriber paramSubscriber1, Subscriber paramSubscriber2, AtomicLong paramAtomicLong)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (val$requested.get() > 0L)
    {
      val$child.onNext(paramT);
      val$requested.decrementAndGet();
    }
    while (OperatorOnBackpressureDrop.access$100(this$0) == null) {
      return;
    }
    OperatorOnBackpressureDrop.access$100(this$0).call(paramT);
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */