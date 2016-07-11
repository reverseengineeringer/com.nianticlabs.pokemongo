package rx.internal.operators;

import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;

class OperatorDoOnEach$1
  extends Subscriber<T>
{
  private boolean done = false;
  
  OperatorDoOnEach$1(OperatorDoOnEach paramOperatorDoOnEach, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    if (done) {
      return;
    }
    try
    {
      OperatorDoOnEach.access$000(this$0).onCompleted();
      done = true;
      val$observer.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    Exceptions.throwIfFatal(paramThrowable);
    if (done) {
      return;
    }
    done = true;
    try
    {
      OperatorDoOnEach.access$000(this$0).onError(paramThrowable);
      val$observer.onError(paramThrowable);
      return;
    }
    catch (Throwable paramThrowable)
    {
      val$observer.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if (done) {
      return;
    }
    try
    {
      OperatorDoOnEach.access$000(this$0).onNext(paramT);
      val$observer.onNext(paramT);
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDoOnEach.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */