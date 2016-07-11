package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.FuncN;

final class OnSubscribeCombineLatest$SingleSourceProducer<T, R>
  implements Producer
{
  final Subscriber<? super R> child;
  final FuncN<? extends R> combinator;
  final Observable<? extends T> source;
  final AtomicBoolean started = new AtomicBoolean();
  final OnSubscribeCombineLatest.SingleSourceRequestableSubscriber<T, R> subscriber;
  
  public OnSubscribeCombineLatest$SingleSourceProducer(Subscriber<? super R> paramSubscriber, Observable<? extends T> paramObservable, FuncN<? extends R> paramFuncN)
  {
    source = paramObservable;
    child = paramSubscriber;
    combinator = paramFuncN;
    subscriber = new OnSubscribeCombineLatest.SingleSourceRequestableSubscriber(paramSubscriber, paramFuncN);
  }
  
  public void request(long paramLong)
  {
    subscriber.requestMore(paramLong);
    if (started.compareAndSet(false, true)) {
      source.unsafeSubscribe(subscriber);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest.SingleSourceProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */