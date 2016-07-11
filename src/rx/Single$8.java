package rx;

import rx.functions.Action1;

class Single$8
  extends Subscriber<T>
{
  Single$8(Single paramSingle, Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    val$onSuccess.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Single.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */