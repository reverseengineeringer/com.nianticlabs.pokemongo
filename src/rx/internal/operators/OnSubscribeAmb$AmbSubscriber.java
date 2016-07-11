package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

final class OnSubscribeAmb$AmbSubscriber<T>
  extends Subscriber<T>
{
  private boolean chosen;
  private final OnSubscribeAmb.Selection<T> selection;
  private final Subscriber<? super T> subscriber;
  
  private OnSubscribeAmb$AmbSubscriber(long paramLong, Subscriber<? super T> paramSubscriber, OnSubscribeAmb.Selection<T> paramSelection)
  {
    subscriber = paramSubscriber;
    selection = paramSelection;
    request(paramLong);
  }
  
  private boolean isSelected()
  {
    if (chosen) {
      return true;
    }
    if (selection.choice.get() == this)
    {
      chosen = true;
      return true;
    }
    if (selection.choice.compareAndSet(null, this))
    {
      selection.unsubscribeOthers(this);
      chosen = true;
      return true;
    }
    selection.unsubscribeLosers();
    return false;
  }
  
  private final void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  public void onCompleted()
  {
    if (!isSelected()) {
      return;
    }
    subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!isSelected()) {
      return;
    }
    subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!isSelected()) {
      return;
    }
    subscriber.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.AmbSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */