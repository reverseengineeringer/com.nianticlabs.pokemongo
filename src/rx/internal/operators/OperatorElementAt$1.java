package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

class OperatorElementAt$1
  extends Subscriber<T>
{
  private int currentIndex = 0;
  
  OperatorElementAt$1(OperatorElementAt paramOperatorElementAt, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (currentIndex <= OperatorElementAt.access$000(this$0))
    {
      if (OperatorElementAt.access$100(this$0))
      {
        val$child.onNext(OperatorElementAt.access$200(this$0));
        val$child.onCompleted();
      }
    }
    else {
      return;
    }
    val$child.onError(new IndexOutOfBoundsException(OperatorElementAt.access$000(this$0) + " is out of bounds"));
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    int i = currentIndex;
    currentIndex = (i + 1);
    if (i == OperatorElementAt.access$000(this$0))
    {
      val$child.onNext(paramT);
      val$child.onCompleted();
      unsubscribe();
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    val$child.setProducer(new OperatorElementAt.InnerProducer(paramProducer));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorElementAt.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */