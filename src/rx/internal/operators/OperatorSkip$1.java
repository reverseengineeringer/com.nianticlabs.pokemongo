package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

class OperatorSkip$1
  extends Subscriber<T>
{
  int skipped = 0;
  
  OperatorSkip$1(OperatorSkip paramOperatorSkip, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    if (skipped >= this$0.toSkip)
    {
      val$child.onNext(paramT);
      return;
    }
    skipped += 1;
  }
  
  public void setProducer(Producer paramProducer)
  {
    val$child.setProducer(paramProducer);
    paramProducer.request(this$0.toSkip);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkip.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */