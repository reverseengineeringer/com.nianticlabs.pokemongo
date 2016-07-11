package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

class OperatorMulticast$2
  implements Action0
{
  OperatorMulticast$2(OperatorMulticast paramOperatorMulticast, AtomicReference paramAtomicReference) {}
  
  public void call()
  {
    synchronized (this$0.guard)
    {
      if (OperatorMulticast.access$000(this$0) == val$gs.get())
      {
        Subscriber localSubscriber = OperatorMulticast.access$100(this$0);
        OperatorMulticast.access$102(this$0, null);
        OperatorMulticast.access$002(this$0, null);
        this$0.connectedSubject.set(null);
        if (localSubscriber != null) {
          localSubscriber.unsubscribe();
        }
        return;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMulticast.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */