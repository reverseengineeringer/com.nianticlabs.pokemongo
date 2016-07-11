package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Func2;

class OperatorSkipWhile$1
  extends Subscriber<T>
{
  int index;
  boolean skipping = true;
  
  OperatorSkipWhile$1(OperatorSkipWhile paramOperatorSkipWhile, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    if (!skipping)
    {
      val$child.onNext(paramT);
      return;
    }
    Func2 localFunc2 = OperatorSkipWhile.access$000(this$0);
    int i = index;
    index = (i + 1);
    if (!((Boolean)localFunc2.call(paramT, Integer.valueOf(i))).booleanValue())
    {
      skipping = false;
      val$child.onNext(paramT);
      return;
    }
    request(1L);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipWhile.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */