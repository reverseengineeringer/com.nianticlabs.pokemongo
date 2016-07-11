package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

class OperatorAny$1
  extends Subscriber<T>
{
  boolean done;
  boolean hasElements;
  
  OperatorAny$1(OperatorAny paramOperatorAny, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!done)
    {
      done = true;
      if (hasElements) {
        val$producer.setValue(Boolean.valueOf(false));
      }
    }
    else
    {
      return;
    }
    val$producer.setValue(Boolean.valueOf(OperatorAny.access$100(this$0)));
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    hasElements = true;
    for (;;)
    {
      try
      {
        bool = ((Boolean)OperatorAny.access$000(this$0).call(paramT)).booleanValue();
        if ((bool) && (!done))
        {
          done = true;
          paramT = val$producer;
          if (!OperatorAny.access$100(this$0))
          {
            bool = true;
            paramT.setValue(Boolean.valueOf(bool));
            unsubscribe();
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
        return;
      }
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorAny.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */