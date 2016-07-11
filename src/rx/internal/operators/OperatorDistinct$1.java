package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.Subscriber;
import rx.functions.Func1;

class OperatorDistinct$1
  extends Subscriber<T>
{
  Set<U> keyMemory = new HashSet();
  
  OperatorDistinct$1(OperatorDistinct paramOperatorDistinct, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    keyMemory = null;
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    keyMemory = null;
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject = this$0.keySelector.call(paramT);
    if (keyMemory.add(localObject))
    {
      val$child.onNext(paramT);
      return;
    }
    request(1L);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDistinct.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */