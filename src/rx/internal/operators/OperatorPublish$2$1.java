package rx.internal.operators;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

class OperatorPublish$2$1
  implements Action1<Subscription>
{
  OperatorPublish$2$1(OperatorPublish.2 param2, Subscriber paramSubscriber) {}
  
  public void call(Subscription paramSubscription)
  {
    val$child.add(paramSubscription);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */