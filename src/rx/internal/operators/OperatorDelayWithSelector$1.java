package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subjects.PublishSubject;

class OperatorDelayWithSelector$1
  extends Subscriber<T>
{
  OperatorDelayWithSelector$1(OperatorDelayWithSelector paramOperatorDelayWithSelector, Subscriber paramSubscriber, PublishSubject paramPublishSubject, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    val$delayedEmissions.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(final T paramT)
  {
    try
    {
      val$delayedEmissions.onNext(((Observable)this$0.itemDelay.call(paramT)).take(1).defaultIfEmpty(null).map(new Func1()
      {
        public T call(V paramAnonymousV)
        {
          return (T)paramT;
        }
      }));
      return;
    }
    catch (Throwable paramT)
    {
      onError(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDelayWithSelector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */