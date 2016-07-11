package rx;

import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

class Single$7
  extends Subscriber<T>
{
  Single$7(Single paramSingle, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    val$onSuccess.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Single.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */