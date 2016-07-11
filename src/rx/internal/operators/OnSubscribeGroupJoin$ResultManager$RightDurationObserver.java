package rx.internal.operators;

import java.util.Map;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeGroupJoin$ResultManager$RightDurationObserver
  extends Subscriber<D2>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeGroupJoin$ResultManager$RightDurationObserver(OnSubscribeGroupJoin.ResultManager paramResultManager, int paramInt)
  {
    id = paramInt;
  }
  
  public void onCompleted()
  {
    if (once) {
      once = false;
    }
    synchronized (this$1.guard)
    {
      this$1.rightMap.remove(Integer.valueOf(id));
      this$1.group.remove(this);
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.errorMain(paramThrowable);
  }
  
  public void onNext(D2 paramD2)
  {
    onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.RightDurationObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */