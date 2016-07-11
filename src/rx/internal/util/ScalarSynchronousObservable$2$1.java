package rx.internal.util;

import rx.Subscriber;

class ScalarSynchronousObservable$2$1
  extends Subscriber<R>
{
  ScalarSynchronousObservable$2$1(ScalarSynchronousObservable.2 param2, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(R paramR)
  {
    val$child.onNext(paramR);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */