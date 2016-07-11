package rx.internal.operators;

import java.util.concurrent.Future;
import rx.functions.Action0;

class OnSubscribeToObservableFuture$ToObservableFuture$1
  implements Action0
{
  OnSubscribeToObservableFuture$ToObservableFuture$1(OnSubscribeToObservableFuture.ToObservableFuture paramToObservableFuture) {}
  
  public void call()
  {
    OnSubscribeToObservableFuture.ToObservableFuture.access$000(this$0).cancel(true);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture.ToObservableFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */