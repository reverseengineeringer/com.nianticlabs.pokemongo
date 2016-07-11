package rx.internal.operators;

import java.util.List;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

class OperatorBufferWithStartEndObservable$BufferingSubscriber$1
  extends Subscriber<TClosing>
{
  OperatorBufferWithStartEndObservable$BufferingSubscriber$1(OperatorBufferWithStartEndObservable.BufferingSubscriber paramBufferingSubscriber, List paramList) {}
  
  public void onCompleted()
  {
    this$1.closingSubscriptions.remove(this);
    this$1.endBuffer(val$chunk);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.onError(paramThrowable);
  }
  
  public void onNext(TClosing paramTClosing)
  {
    this$1.closingSubscriptions.remove(this);
    this$1.endBuffer(val$chunk);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */