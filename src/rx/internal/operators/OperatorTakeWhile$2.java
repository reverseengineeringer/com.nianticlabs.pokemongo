package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func2;

class OperatorTakeWhile$2
  extends Subscriber<T>
{
  private int counter = 0;
  private boolean done = false;
  
  OperatorTakeWhile$2(OperatorTakeWhile paramOperatorTakeWhile, Subscriber paramSubscriber1, boolean paramBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1, paramBoolean);
  }
  
  public void onCompleted()
  {
    if (!done) {
      val$subscriber.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!done) {
      val$subscriber.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Func2 localFunc2 = OperatorTakeWhile.access$000(this$0);
      int i = counter;
      counter = (i + 1);
      boolean bool = ((Boolean)localFunc2.call(paramT, Integer.valueOf(i))).booleanValue();
      if (bool)
      {
        val$subscriber.onNext(paramT);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      done = true;
      Exceptions.throwIfFatal(localThrowable);
      val$subscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
      unsubscribe();
      return;
    }
    done = true;
    val$subscriber.onCompleted();
    unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeWhile.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */