package rx.internal.operators;

import java.util.Map;
import rx.Observer;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeGroupJoin$ResultManager$LeftDurationObserver
  extends Subscriber<D1>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeGroupJoin$ResultManager$LeftDurationObserver(OnSubscribeGroupJoin.ResultManager paramResultManager, int paramInt)
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
      Observer localObserver = (Observer)this$1.leftMap.remove(Integer.valueOf(id));
      if (localObserver != null) {
        localObserver.onCompleted();
      }
      this$1.group.remove(this);
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.errorMain(paramThrowable);
  }
  
  public void onNext(D1 paramD1)
  {
    onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftDurationObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */