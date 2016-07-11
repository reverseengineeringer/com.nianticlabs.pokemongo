package rx;

import rx.exceptions.OnErrorNotImplementedException;

class Single$6
  extends Subscriber<T>
{
  Single$6(Single paramSingle) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.Single.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */