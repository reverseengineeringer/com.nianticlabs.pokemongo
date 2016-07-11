package rx.internal.operators;

import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

class OperatorWindowWithStartEndObservable$SourceSubscriber$1
  extends Subscriber<V>
{
  boolean once = true;
  
  OperatorWindowWithStartEndObservable$SourceSubscriber$1(OperatorWindowWithStartEndObservable.SourceSubscriber paramSourceSubscriber, OperatorWindowWithStartEndObservable.SerializedSubject paramSerializedSubject) {}
  
  public void onCompleted()
  {
    if (once)
    {
      once = false;
      this$1.endWindow(val$s);
      this$1.csub.remove(this);
    }
  }
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(V paramV)
  {
    onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */