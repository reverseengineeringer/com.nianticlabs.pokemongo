package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

class OperatorGroupBy$GroupBySubscriber$2$2
  extends Subscriber<T>
{
  OperatorGroupBy$GroupBySubscriber$2$2(OperatorGroupBy.GroupBySubscriber.2 param2, Subscriber paramSubscriber1, Subscriber paramSubscriber2, AtomicBoolean paramAtomicBoolean)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$o.onCompleted();
    if (val$once.compareAndSet(false, true)) {
      OperatorGroupBy.GroupBySubscriber.access$400(this$1.this$0, this$1.val$key);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$o.onError(paramThrowable);
    if (val$once.compareAndSet(false, true)) {
      OperatorGroupBy.GroupBySubscriber.access$400(this$1.this$0, this$1.val$key);
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      val$o.onNext(this$1.this$0.elementSelector.call(paramT));
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
  
  public void onStart() {}
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */