package rx.observers;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;

final class Observers$1
  implements Observer<Object>
{
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(Object paramObject) {}
}

/* Location:
 * Qualified Name:     rx.observers.Observers.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */