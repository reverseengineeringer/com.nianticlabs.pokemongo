package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;

class OperatorSkipTimed$2
  extends Subscriber<T>
{
  OperatorSkipTimed$2(OperatorSkipTimed paramOperatorSkipTimed, Subscriber paramSubscriber1, AtomicBoolean paramAtomicBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    try
    {
      val$child.onCompleted();
      return;
    }
    finally
    {
      unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      val$child.onError(paramThrowable);
      return;
    }
    finally
    {
      unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    if (val$gate.get()) {
      val$child.onNext(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipTimed.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */