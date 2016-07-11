package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Func1;

class OperatorGroupBy$GroupBySubscriber$2
  implements Observable.OnSubscribe<R>
{
  OperatorGroupBy$GroupBySubscriber$2(OperatorGroupBy.GroupBySubscriber paramGroupBySubscriber, OperatorGroupBy.GroupBySubscriber.GroupState paramGroupState, Object paramObject) {}
  
  public void call(final Subscriber<? super R> paramSubscriber)
  {
    paramSubscriber.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        this$0.requestFromGroupedObservable(paramAnonymousLong, val$groupState);
      }
    });
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    val$groupState.getObservable().doOnUnsubscribe(new Action0()
    {
      public void call()
      {
        if (localAtomicBoolean.compareAndSet(false, true)) {
          OperatorGroupBy.GroupBySubscriber.access$400(this$0, val$key);
        }
      }
    }).unsafeSubscribe(new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
        if (localAtomicBoolean.compareAndSet(false, true)) {
          OperatorGroupBy.GroupBySubscriber.access$400(this$0, val$key);
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
        if (localAtomicBoolean.compareAndSet(false, true)) {
          OperatorGroupBy.GroupBySubscriber.access$400(this$0, val$key);
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        try
        {
          paramSubscriber.onNext(this$0.elementSelector.call(paramAnonymousT));
          return;
        }
        catch (Throwable localThrowable)
        {
          onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramAnonymousT));
        }
      }
      
      public void onStart() {}
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */