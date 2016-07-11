package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;
import rx.functions.Func1;

class OperatorMapNotification$1
  extends Subscriber<T>
{
  OperatorMapNotification.SingleEmitter<R> emitter;
  
  OperatorMapNotification$1(OperatorMapNotification paramOperatorMapNotification, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    try
    {
      emitter.offerAndComplete(OperatorMapNotification.access$000(this$0).call());
      return;
    }
    catch (Throwable localThrowable)
    {
      val$o.onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      emitter.offerAndComplete(OperatorMapNotification.access$100(this$0).call(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
      val$o.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      emitter.offer(OperatorMapNotification.access$200(this$0).call(paramT));
      return;
    }
    catch (Throwable localThrowable)
    {
      val$o.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    emitter = new OperatorMapNotification.SingleEmitter(val$o, paramProducer, this);
    val$o.setProducer(emitter);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMapNotification.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */