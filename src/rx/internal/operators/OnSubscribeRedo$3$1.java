package rx.internal.operators;

import rx.Notification;
import rx.Producer;
import rx.Subscriber;

class OnSubscribeRedo$3$1
  extends Subscriber<Notification<?>>
{
  OnSubscribeRedo$3$1(OnSubscribeRedo.3 param3, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$filteredTerminals.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$filteredTerminals.onError(paramThrowable);
  }
  
  public void onNext(Notification<?> paramNotification)
  {
    if ((paramNotification.isOnCompleted()) && (OnSubscribeRedo.access$300(this$1.this$0)))
    {
      val$filteredTerminals.onCompleted();
      return;
    }
    if ((paramNotification.isOnError()) && (OnSubscribeRedo.access$400(this$1.this$0)))
    {
      val$filteredTerminals.onError(paramNotification.getThrowable());
      return;
    }
    val$filteredTerminals.onNext(paramNotification);
  }
  
  public void setProducer(Producer paramProducer)
  {
    paramProducer.request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */