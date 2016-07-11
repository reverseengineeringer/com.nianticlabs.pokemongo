package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

public final class OnSubscribeCache<T>
  implements Observable.OnSubscribe<T>
{
  static final AtomicIntegerFieldUpdater<OnSubscribeCache> SRC_SUBSCRIBED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(OnSubscribeCache.class, "sourceSubscribed");
  protected final Subject<? super T, ? extends T> cache;
  protected final Observable<? extends T> source;
  volatile int sourceSubscribed;
  
  public OnSubscribeCache(Observable<? extends T> paramObservable)
  {
    this(paramObservable, ReplaySubject.create());
  }
  
  public OnSubscribeCache(Observable<? extends T> paramObservable, int paramInt)
  {
    this(paramObservable, ReplaySubject.create(paramInt));
  }
  
  OnSubscribeCache(Observable<? extends T> paramObservable, Subject<? super T, ? extends T> paramSubject)
  {
    source = paramObservable;
    cache = paramSubject;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    if (SRC_SUBSCRIBED_UPDATER.compareAndSet(this, 0, 1)) {
      source.subscribe(cache);
    }
    cache.unsafeSubscribe(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */