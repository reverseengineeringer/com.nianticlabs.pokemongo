package rx.internal.util;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;

class ScalarSynchronousObservable$2
  implements Observable.OnSubscribe<R>
{
  ScalarSynchronousObservable$2(ScalarSynchronousObservable paramScalarSynchronousObservable, Func1 paramFunc1) {}
  
  public void call(final Subscriber<? super R> paramSubscriber)
  {
    Observable localObservable = (Observable)val$func.call(ScalarSynchronousObservable.access$100(this$0));
    if (localObservable.getClass() == ScalarSynchronousObservable.class)
    {
      paramSubscriber.onNext(ScalarSynchronousObservable.access$100((ScalarSynchronousObservable)localObservable));
      paramSubscriber.onCompleted();
      return;
    }
    localObservable.unsafeSubscribe(new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(R paramAnonymousR)
      {
        paramSubscriber.onNext(paramAnonymousR);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */