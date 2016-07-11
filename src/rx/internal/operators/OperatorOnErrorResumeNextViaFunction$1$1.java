package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

class OperatorOnErrorResumeNextViaFunction$1$1
  extends Subscriber<T>
{
  OperatorOnErrorResumeNextViaFunction$1$1(OperatorOnErrorResumeNextViaFunction.1 param1) {}
  
  public void onCompleted()
  {
    this$1.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this$1.val$child.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this$1.val$pa.setProducer(paramProducer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */