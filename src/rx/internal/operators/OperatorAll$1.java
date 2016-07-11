package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

class OperatorAll$1
  extends Subscriber<T>
{
  boolean done;
  
  OperatorAll$1(OperatorAll paramOperatorAll, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!done)
    {
      done = true;
      val$producer.setValue(Boolean.valueOf(true));
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Boolean localBoolean = (Boolean)OperatorAll.access$000(this$0).call(paramT);
      if ((!localBoolean.booleanValue()) && (!done))
      {
        done = true;
        val$producer.setValue(Boolean.valueOf(false));
        unsubscribe();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorAll.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */