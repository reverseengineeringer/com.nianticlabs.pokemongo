package rx.internal.operators;

import java.util.Iterator;
import rx.Subscriber;
import rx.functions.Func2;

class OperatorZipIterable$1
  extends Subscriber<T1>
{
  boolean once;
  
  OperatorZipIterable$1(OperatorZipIterable paramOperatorZipIterable, Subscriber paramSubscriber1, Subscriber paramSubscriber2, Iterator paramIterator)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    if (once) {
      return;
    }
    once = true;
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T1 paramT1)
  {
    try
    {
      val$subscriber.onNext(this$0.zipFunction.call(paramT1, val$iterator.next()));
      if (!val$iterator.hasNext()) {
        onCompleted();
      }
      return;
    }
    catch (Throwable paramT1)
    {
      onError(paramT1);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZipIterable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */