package rx;

import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaObservableExecutionHook;

class Single$2
  implements Observable.OnSubscribe<R>
{
  Single$2(Single paramSingle, Observable.Operator paramOperator) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    try
    {
      Subscriber localSubscriber = (Subscriber)Single.access$000().onLift(val$lift).call(paramSubscriber);
      try
      {
        localSubscriber.onStart();
        this$0.onSubscribe.call(localSubscriber);
        return;
      }
      catch (Throwable localThrowable2)
      {
        if (!(localThrowable2 instanceof OnErrorNotImplementedException)) {
          break label64;
        }
      }
      throw ((OnErrorNotImplementedException)localThrowable2);
    }
    catch (Throwable localThrowable1)
    {
      if ((localThrowable1 instanceof OnErrorNotImplementedException))
      {
        throw ((OnErrorNotImplementedException)localThrowable1);
        label64:
        localThrowable1.onError(localThrowable2);
        return;
      }
      paramSubscriber.onError(localThrowable1);
    }
  }
}

/* Location:
 * Qualified Name:     rx.Single.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */